import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.lowagie.text.Row as Row
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement

WebUI.delay(3)

// Lấy dữ liệu từ file Excel

def deleteData = TestDataFactory.findTestData("Admin_Category_Delete_Data")

String deleteId = deleteData.getValue('id', 1)

TestObject rowObject = new TestObject("dynamicRow_" + deleteId)
String xpath = "//a[@class='btn btn-danger btn-sm btn-delete' and @data-category-id='" + deleteId + "']"
rowObject.addProperty("xpath", ConditionType.EQUALS, xpath)

WebUI.click(rowObject)

WebUI.delay(3)

WebUI.verifyElementClickable(findTestObject("Admin_Category/Button_Category_Delete"))

WebUI.click(findTestObject("Admin_Category/Button_Category_Delete"))

WebUI.verifyElementText(findTestObject("Admin_Category/Div_Category_Delete_Successful"), "Xoá danh mục thành công")