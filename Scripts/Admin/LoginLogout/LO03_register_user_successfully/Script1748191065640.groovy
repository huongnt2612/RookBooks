import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


	dataFileUtil util = new dataFileUtil()
	String excelPath = 'Data Files/Data.xlsx'
	
	new openLoginPage().navigateToLogin()
	generalFunction fc = new generalFunction()
	

	WebUI.delay(3)
	
	WebUI.click(findTestObject('Object Repository/User/Auth/btn_forget_pass'))
	fc.scrollDown()

	WebUI.delay(3)
	
//	WebUI.click(findTestObject('Object Repository/User/Auth/btn_forget_pass'))
//	fc.scrollDown()
	
	String baseEmail = "huong2@gmail.com"
	int emailIndex = 1 
	
	// Tách local part và domain
	int atIndex = baseEmail.indexOf('@')
	String email = baseEmail.substring(0, atIndex) + "_" + emailIndex + baseEmail.substring(atIndex)

	String name = "Nguyen Thi Thanh Huong"
	String address = "Ha Noi"
	String phone = "0123456789"
	String password = "123456"
	
	// Điền form
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_email'), email)
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_name'), name)
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_address'), address)
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_phone_number'), phone)
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_password'), password)
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_re_password'), password)
	
	fc.scrollDown()
	
	WebUI.click(findTestObject('Object Repository/User/Auth/btn_register_1'))
	WebUI.delay(2)
	fc.scrollDown()
	
//	WebUI.verifyElementText(findTestObject('Object Repository/User/Auth/msg_result_register'), "Đăng ký thành công !")
	String 
	util.setData(excelPath, 'register_email_user', email)
	util.setData(excelPath, 'register_name_user', name)
	util.setData(excelPath, 'register_address_user', address)
	util.setData(excelPath, 'register_phone_user', phone)
	util.setData(excelPath, 'register_password_user', password)
	
	
	
