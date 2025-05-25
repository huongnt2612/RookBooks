import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

	new openLoginPage().navigateToLogin()
	generalFunction fc = new generalFunction()

	WebUI.delay(3)
	
	WebUI.click(findTestObject('Object Repository/User/Auth/btn_forget_pass'))
	fc.scrollDown()
	'1. De trong tat ca cac truong'
	fc.scrollDown()
	fc.scrollDown()
	WebUI.click(findTestObject('Object Repository/User/Auth/btn_register_1'))
	WebUI.waitForAlert(5)
	String alertText = WebUI.getAlertText()
	WebUI.verifyMatch(alertText, 'Vui lòng điền đủ thông tin', false)
	WebUI.acceptAlert()
	
	'2. Nhập dấu cách tất cả các trường '
	fc.scrollUp()
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_email'), " ")
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_name'), " ")
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_address'), " ")
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_phone_number'), " ")
	 
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_password'), " ")
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_re_password'), " ")
	fc.scrollDown()
	WebUI.click(findTestObject('Object Repository/User/Auth/btn_register_1'))
	WebUI.waitForAlert(5)
	alertText = WebUI.getAlertText()
	WebUI.verifyMatch(alertText, 'Vui lòng điền đủ thông tin', false)
	WebUI.acceptAlert()
	
	'3. Bỏ trống email'
	
//	WebUI.setText(findTestObject('Object Repository/User/Auth/register_email'), "huong@gmail.com")
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_name'), "Nguyen Thi Thannh Huong")
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_address'), "Ha Noi")
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_phone_number'), "0123456789")
	
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_password'), "123456")
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_re_password'), "123456")
	fc.scrollDown()
	WebUI.click(findTestObject('Object Repository/User/Auth/btn_register_1'))
	WebUI.waitForAlert(5)
	alertText = WebUI.getAlertText()
	WebUI.verifyMatch(alertText, 'Vui lòng điền đủ thông tin', false)
	WebUI.acceptAlert()
	
	'4. Bỏ trống tên'
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_email'), "huong@gmail.com")
	WebUI.clearText(findTestObject ('Object Repository/User/Auth/register_name'))
//	WebUI.setText(findTestObject('Object Repository/User/Auth/register_name'), "Nguyen Thi Thannh Huong")
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_address'), "Ha Noi")
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_phone_number'), "0123456789")
	
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_password'), "123456")
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_re_password'), "123456")
	fc.scrollDown()
	WebUI.click(findTestObject('Object Repository/User/Auth/btn_register_1'))
	WebUI.waitForAlert(5)
	WebUI.delay(2)
	 alertText = WebUI.getAlertText()
	WebUI.verifyMatch(alertText, 'Vui lòng điền đủ thông tin', false)
	WebUI.acceptAlert()
	
	'5. Bỏ trống địa chỉ'
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_email'), "huong@gmail.com")
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_name'), "Nguyen Thi Thannh Huong")
		//WebUI.setText(findTestObject('Object Repository/User/Auth/register_address'), "Ha Noi")
	WebUI.clearText(findTestObject ('Object Repository/User/Auth/register_address'))
	
		WebUI.setText(findTestObject('Object Repository/User/Auth/register_phone_number'), "0123456789")
		
		WebUI.setText(findTestObject('Object Repository/User/Auth/register_password'), "123456")
		WebUI.setText(findTestObject('Object Repository/User/Auth/register_re_password'), "123456")
		fc.scrollDown()
		WebUI.click(findTestObject('Object Repository/User/Auth/btn_register_1'))
		WebUI.waitForAlert(5)
		 alertText = WebUI.getAlertText()
		WebUI.verifyMatch(alertText, 'Vui lòng điền đủ thông tin', false)
		WebUI.acceptAlert()
	
	'6. Bỏ trống SDT'
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_email'), "huong@gmail.com")
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_name'), "Nguyen Thi Thannh Huong")
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_address'), "Ha Noi")
	//WebUI.setText(findTestObject('Object Repository/User/Auth/register_phone_number'), "0123456789")
	WebUI.clearText(findTestObject ('Object Repository/User/Auth/register_phone_number'))

	WebUI.setText(findTestObject('Object Repository/User/Auth/register_password'), "123456")
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_re_password'), "123456")
	fc.scrollDown()
	WebUI.click(findTestObject('Object Repository/User/Auth/btn_register_1'))
	WebUI.waitForAlert(5)
	 alertText = WebUI.getAlertText()
	WebUI.verifyMatch(alertText, 'Vui lòng điền đủ thông tin', false)
	WebUI.acceptAlert()
	
	
	'7. Bỏ trống password'
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_email'), "huong@gmail.com")
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_name'), "Nguyen Thi Thannh Huong")
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_address'), "Ha Noi")
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_phone_number'), "0123456789")
	
	//WebUI.setText(findTestObject('Object Repository/User/Auth/register_password'), "123456")
	//WebUI.setText(findTestObject('Object Repository/User/Auth/register_re_password'), "123456")
	WebUI.clearText(findTestObject ('Object Repository/User/Auth/register_password'))
	WebUI.clearText(findTestObject ('Object Repository/User/Auth/register_re_password'))
	fc.scrollDown()
	WebUI.click(findTestObject('Object Repository/User/Auth/btn_register_1'))
	WebUI.waitForAlert(5)
	 alertText = WebUI.getAlertText()
	WebUI.verifyMatch(alertText, 'Vui lòng điền đủ thông tin', false)
	WebUI.acceptAlert()
	
	'8. Nhập email đã đăng ký'
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_email'),GlobalVariable.User_Email)
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_name'), "Nguyen Thi Thannh Huong")
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_address'), "Ha Noi")
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_phone_number'), "0123456789")
		
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_password'), "123456")
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_re_password'), "123456")
	fc.scrollDown()
	WebUI.click(findTestObject('Object Repository/User/Auth/btn_register_1'))
	WebUI.delay(2)
	fc.scrollDown()
	WebUI.verifyElementText(findTestObject('Object Repository/User/Auth/msg_result_register'), "Có vẻ như email này đã được dùng trước đó, vui lòng thử lại")
	
	
	
		