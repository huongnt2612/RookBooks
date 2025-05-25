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
WebUI.waitForElementClickable(findTestObject('Admin_Category/Button_Category_Add'), 3)

WebUI.click(findTestObject('Admin_Category/Button_Category_Add'))

WebUI.delay(3)

// Lấy dữ liệu từ file Excel
def testData = TestDataFactory.findTestData('Admin_Category_Add_Data')

int rowCount = testData.getRowNumbers()

String name = testData.getValue('name', 1)

String desc = testData.getValue('description', 1)

WebUI.verifyMatch(WebUI.getUrl(), '.*categories_management.*', true)

WebUI.verifyMatch(WebUI.getUrl(), '.*add.*', true)

WebUI.setText(findTestObject("Admin_Category/Input_Category_Name"), name)
WebUI.setText(findTestObject("Admin_Category/Input_Category_Description"), desc)

WebUI.delay(3)

WebUI.scrollToElement(findTestObject("Admin_Category/Button_Category_Add_Submit"), 3)

WebUI.click(findTestObject("Admin_Category/Button_Category_Add_Submit"))

WebUI.delay(3)

//WebUI.scrollToElement(findTestObject("Admin_Category/Button_Category_FirstPage"), 3)
//
//WebUI.click(findTestObject("Admin_Category/Button_Category_LastPage"))

String newName = testData.getValue("name", 1)
String newDesc = testData.getValue("description", 1)

//WebElement pageNumberElement = WebUI.findWebElement(findTestObject("Admin_Category/Button_Category_Pagination"))
//
//int step = (int)pageNumberElement.getText()
//
//for (int i = rowCount - 5 * (step - 1) ; i >= 1; i--) {
//
//
//	// Tạo TestObject động cho dòng dữ liệu
//	TestObject rowObject = new TestObject("Row_" + i)
//	String xpath = "//tr[td[normalize-space(text())='" + newName + "'] and td[contains(normalize-space(),'" + newDesc + "')]]"
//	rowObject.addProperty("xpath", ConditionType.EQUALS, xpath)
//
//	WebUI.comment(">> Kiểm tra dòng $i: Name = $newName, Description = $newDesc")
//
//	WebUI.verifyElementPresent(rowObject, 5, FailureHandling.CONTINUE_ON_FAILURE)
//}

TestObject rowObject = new TestObject()
String xpath = "//tr[td[normalize-space(text())='" + newName + "'] and td[contains(normalize-space(),'" + newDesc + "')]]"
rowObject.addProperty("xpath", ConditionType.EQUALS, xpath)

WebUI.verifyElementPresent(rowObject, 5, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject("Admin_Category/Div_Category_Add_Successful"), "Thêm mới danh mục thành công")

