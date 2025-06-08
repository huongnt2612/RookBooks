import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable


	WebUI.callTestCase(
		findTestCase('Test Cases/Admin/LoginLogout/LO02_login_successfully'),
		[('username') : GlobalVariable.Admin_Email, ('password') : GlobalVariable.General_Password]
	)
	
	generalFunction fc = new generalFunction()
	dataFileUtil util = new dataFileUtil()
	String excelPath = 'Data Files/Data.xlsx'
	
	WebUI.click(findTestObject('Object Repository/User/HomePage/icon_Accounts'))
	
	WebUI.verifyElementVisible(findTestObject('Object Repository/User/HomePage/icon_admin'))
	
	WebUI.click(findTestObject('Object Repository/User/HomePage/icon_admin'))
	WebUI.delay(2)
	WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/Button_Product'))
	WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/Button_Product_Management'))
	WebUI.delay(2)
	WebUI.verifyElementText(findTestObject('Object Repository/Admin/ProductManagement/Tittle_Product_Management'), 'Danh sách sản phẩm')
	
	WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/Button_Add_Product'))
	WebUI.verifyElementText(findTestObject('Object Repository/Admin/ProductManagement/Lable_Form_Add_Product'), 'Thêm/Cập nhật Sản phẩm')
	WebUI.delay(2)
	
	'1. Để trống tất cả các trường'
	fc.scrollDown()
	
	WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/Button_Submit'))
	
	
	
	