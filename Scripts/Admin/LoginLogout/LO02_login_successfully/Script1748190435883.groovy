import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.ObjectRepository as OR
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import internal.GlobalVariable
import generalFunction
import openLoginPage

	new openLoginPage().navigateToLogin()

	WebUI.delay(3)
	
	WebUI.setText(findTestObject('Object Repository/User/Auth/Email'), GlobalVariable.Admin_Email)
	WebUI.setText(findTestObject('Object Repository/User/Auth/Password'), GlobalVariable.General_Password)
	
	WebUI.click(findTestObject('Object Repository/User/Auth/btn_login'))
	WebUI.delay(2)

	WebUI.click(findTestObject('Object Repository/User/HomePage/icon_Accounts'))

