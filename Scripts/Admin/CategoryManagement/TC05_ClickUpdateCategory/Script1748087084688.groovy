import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.lowagie.text.Row as Row
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement

//WebUI.waitForElementClickable(findTestObject("Admin_Category/Button_Category_Management"), 3)
//
//WebUI.click(findTestObject("Admin_Category/Button_Category_Management"))
//
//WebUI.waitForElementClickable(findTestObject("Admin_Category/Button_Category_List"), 3)
//
//WebUI.click(findTestObject("Admin_Category/Button_Category_List"))

//WebUI.waitForElementClickable(findTestObject('Admin_Category/Button_Category_Add'), 3)

WebUI.delay(3)

// Lấy dữ liệu từ file Excel
def testData = TestDataFactory.findTestData('Admin_Category_Data')

def updateData = TestDataFactory.findTestData("Admin_Category_Update_Data")

int rowCount = testData.getRowNumbers()

String updateId = updateData.getValue('id', 1)

TestObject rowObject = new TestObject("dynamicRow_" + updateId)
String xpath = "//tr[td[normalize-space(text())='" + updateId + "']]//a[contains(text(),'Cập nhật')]"
rowObject.addProperty("xpath", ConditionType.EQUALS, xpath)
WebUI.click(rowObject)

WebUI.delay(3)

WebUI.verifyMatch(WebUI.getUrl(), '.*categories_management.*', true)

WebUI.verifyMatch(WebUI.getUrl(), '.*edit.*', true)

String updateName = updateData.getValue('name', 1)
String updateDesc = updateData.getValue('description', 1)

WebUI.setText(findTestObject("Admin_Category/Input_Category_Name"), updateName)
WebUI.setText(findTestObject("Admin_Category/Input_Category_Description"), updateDesc)

WebUI.delay(3)

WebUI.scrollToElement(findTestObject("Admin_Category/Button_Category_Add_Submit"), 3)

WebUI.click(findTestObject("Admin_Category/Button_Category_Add_Submit"))

WebUI.delay(3)

//WebUI.scrollToElement(findTestObject("Admin_Category/Button_Category_FirstPage"), 3)
//
//WebUI.click(findTestObject("Admin_Category/Button_Category_LastPage"))

//WebElement pageNumberElement = WebUI.findWebElement(findTestObject("Admin_Category/Button_Category_Pagination"))
//
//int step = (int)pageNumberElement.getText()

WebUI.verifyElementText(findTestObject("Admin_Category/Div_Category_Update_Successful"), "Cập nhật danh mục thành công")

TestObject updateRowObject = new TestObject("Row_" + updateId)
String updateXPath = "//tr[td[normalize-space(text())='" + updateName + "'] and td[contains(normalize-space(),'" + updateDesc + "')]]"
updateRowObject.addProperty("xpath", ConditionType.EQUALS, updateXPath)

WebUI.verifyElementPresent(updateRowObject, 5, FailureHandling.CONTINUE_ON_FAILURE)


