import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.ObjectRepository as OR
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import internal.GlobalVariable
import generalFunction
import openLoginPage
import dataFileUtil

	new openLoginPage().navigateToLogin()
	dataFileUtil util = new dataFileUtil()
	String excelPath = 'Data Files/Data.xlsx'
	String email = util.getData(excelPath, 'register_email')
	String password = util.getData(excelPath, 'register_password')
	String name = util.getData(excelPath, 'register_name')

	WebUI.delay(3)
	
	WebUI.setText(findTestObject('Object Repository/User/Auth/Email'), email)
	WebUI.setText(findTestObject('Object Repository/User/Auth/Password'),password)
	
	WebUI.click(findTestObject('Object Repository/User/Auth/btn_login'))
	WebUI.delay(2)

	WebUI.click(findTestObject('Object Repository/User/HomePage/icon_Accounts'))
	WebUI.verifyElementText(findTestObject('Object Repository/User/wishlistAndContact/account_name'), name.toUpperCase())

