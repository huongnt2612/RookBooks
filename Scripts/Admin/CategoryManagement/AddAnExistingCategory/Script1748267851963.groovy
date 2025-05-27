import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

	WebUI.callTestCase(
		findTestCase('Test Cases/Admin/LoginLogout/LO02_login_successfully'),
		[('username') : GlobalVariable.Admin_Email, ('password') : GlobalVariable.General_Password]
	)
	
	generalFunction fc = new generalFunction()
	dataFileUtil util = new dataFileUtil()
	String excelPath = 'Data Files/Data.xlsx'
	

	'1. Thêm danh mục đã tồn tại'
	// Tạo tên và mô tả danh mục
	String name = util.getData(excelPath, 'Category_1')
	String desc = "This is " + name
	
	WebUI.click(findTestObject('Object Repository/User/HomePage/icon_Accounts'))
	
	
	//	WebUI.verifyElementVisible(findTestObject('Object Repository/User/HomePage/icon_admin'))

	WebUI.verifyElementVisible(findTestObject('Object Repository/User/HomePage/icon_admin'))
	
	WebUI.click(findTestObject('Object Repository/User/HomePage/icon_admin'))
	WebUI.delay(2)
	
	WebUI.waitForElementClickable(findTestObject('Object Repository/Admin/Admin_Category/Button_Category_Management'), 3)
	WebUI.click(findTestObject('Object Repository/Admin/Admin_Category/Button_Category_Management'))
	WebUI.waitForElementClickable(findTestObject('Object Repository/Admin/Admin_Category/Button_Category_List'), 3)
	WebUI.click(findTestObject('Object Repository/Admin/Admin_Category/Button_Category_List'))
	WebUI.delay(3)
	
	WebUI.click(findTestObject('Object Repository/Admin/Admin_Category/Button_Category_Add'))
	
	WebUI.verifyMatch(WebUI.getUrl(), '.*categories_management.*', true)
	
	WebUI.verifyMatch(WebUI.getUrl(), '.*add.*', true)
	
	WebUI.setText(findTestObject('Object Repository/Admin/Admin_Category/Input_Category_Name'), name)
	WebUI.setText(findTestObject('Object Repository/Admin/Admin_Category/Input_Category_Description'), desc)
	
	WebUI.click(findTestObject('Object Repository/Admin/Admin_Category/Button_Category_Add_Submit'))
	WebUI.delay(2)
	WebUI.verifyElementText(findTestObject('Object Repository/Admin/Admin_Category/Div_Category_Add_Successful'), "Danh mục đã tồn tại", FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.takeScreenshot()
	

