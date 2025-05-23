import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.ObjectRepository as OR
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import internal.GlobalVariable
import generalFunction
import openLoginPage

	new openLoginPage().navigateToLogin()

	WebUI.delay(3)
	
	WebUI.setText(findTestObject('Object Repository/Auth/Email'), GlobalVariable.User_Email)
	WebUI.setText(findTestObject('Object Repository/Auth/Password'), GlobalVariable.General_Password)
	
	WebUI.click(findTestObject('Object Repository/Auth/btn_login'))
	WebUI.delay(2)

	WebUI.click(findTestObject('Object Repository/HomePage/icon_Accounts'))
	WebUI.verifyElementText(findTestObject('Object Repository/Account/account_name'), "NGUYEN DUY LINH")
