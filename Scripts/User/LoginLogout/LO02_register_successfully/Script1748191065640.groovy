import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import dataFileUtil

//	new openLoginPage().navigateToLogin()
	generalFunction fc = new generalFunction()
	dataFileUtil util = new dataFileUtil()
	String excelPath = 'Data Files/Data.xlsx'

	WebUI.delay(3)
	
//	WebUI.click(findTestObject('Object Repository/User/Auth/btn_forget_pass'))
//	fc.scrollDown()
	String email = "huong2@gmail.com"
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
	
	WebUI.verifyElementText(findTestObject('Object Repository/User/Auth/msg_result_register'), "Đăng ký thành công !")
	String 
	util.setData(excelPath, 'register_email', email)
	util.setData(excelPath, 'register_name', name)
	util.setData(excelPath, 'register_address', address)
	util.setData(excelPath, 'register_phone', phone)
	util.setData(excelPath, 'register_password', password)
	
	fc.scrollDown()
	WebUI.click(findTestObject('Object Repository/User/Auth/btn_forget_pass'))
	fc.scrollDown()
	
	
