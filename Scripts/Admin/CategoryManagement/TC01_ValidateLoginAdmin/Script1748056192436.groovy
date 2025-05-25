import com.kms.katalon.core.testdata.TestDataFactory

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testdata.TestDataFactory

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

WebUI.openBrowser('http://localhost:8080/login')
//WebUI.maximizeWindow()

// Lấy dữ liệu từ file Excel
def testData = TestDataFactory.findTestData("Admin_Account_Data") // Tên bạn tạo ở bước 2

// Lấy giá trị username và password từ dòng đầu tiên
String username = testData.getValue('Username', 1)
String password = testData.getValue('Password', 1)


WebUI.setText(findTestObject("Page_Login/Input_Username"), username)
WebUI.setText(findTestObject("Page_Login/Input_Password"), password)

WebUI.waitForElementClickable(findTestObject("Page_Login/Button_Login"), 5)

WebUI.click(findTestObject("Page_Login/Button_Login"))

WebUI.delay(3)

WebUI.click(findTestObject("Homepage/Button_User"))
WebUI.delay(3)

try {
	WebUI.verifyElementClickable(findTestObject("Homepage/Button_Admin"))
	
	WebUI.click(findTestObject("Homepage/Button_Admin"))
	
	WebUI.verifyMatch(WebUI.getUrl(), '.*admin.*', true)
	
} catch(Exception ex) {
	WebUI.comment("Đây không phải tài khoản admin. Lỗi: " + ex.getMessage())
}
