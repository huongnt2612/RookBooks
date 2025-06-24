import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable
//
//		WebUI.callTestCase(
//		findTestCase('Test Cases/Admin/LoginLogout/LO02_login_successfully'),
//		[('username') : GlobalVariable.Admin_Email, ('password') : GlobalVariable.General_Password]
//	)
//	
	generalFunction fc = new generalFunction()
	dataFileUtil util = new dataFileUtil()
	String excelPath = 'Data Files/Data.xlsx'
	
//	WebUI.click(findTestObject('Object Repository/User/HomePage/icon_Accounts'))
//	
//	WebUI.verifyElementVisible(findTestObject('Object Repository/User/HomePage/icon_admin'))
//	
//	WebUI.click(findTestObject('Object Repository/User/HomePage/icon_admin'))
//	WebUI.delay(2)
//	
//	WebUI.waitForElementClickable(findTestObject('Object Repository/Admin/UserManagement/Button_User'), 3)
//	WebUI.click(findTestObject('Object Repository/Admin/UserManagement/Button_User'))
//	WebUI.waitForElementClickable(findTestObject('Object Repository/Admin/UserManagement/Button_User_Management'), 3)
//	WebUI.click(findTestObject('Object Repository/Admin/UserManagement/Button_User_Management'))
//	WebUI.delay(3)

	//Lấy email đầu tiên trước khi xóa 
	TestObject listCategoryEmail = findTestObject('Object Repository/Admin/UserManagement/List_User_Email')
	List<WebElement> emailElements = WebUiCommonHelper.findWebElements(listCategoryEmail, 10)
	String firstUserEmailBefore = emailElements.get(0).getText().trim()	
	util.setData(excelPath, 'FirstUserEmailBefore', firstUserEmailBefore)
	
	
	
	//Click button Xóa
	TestObject listButtonDelete = findTestObject('Object Repository/Admin/UserManagement/List_Button_Delete')
	List<WebElement> deleteButtons = WebUiCommonHelper.findWebElements(listButtonDelete, 10)
	
	// Click nút delete đầu tiên (user mới tạo)
	deleteButtons.get(0).click()
	WebUI.delay(2)
	
	//Chờ và kiểm tra Alert
	WebUI.waitForAlert(5)
	String alertText = WebUI.getAlertText()
   WebUI.verifyMatch(alertText, 'Bạn có chắc chắn muốn xóa người dùng này không?', false)
   
   '1. Click Hủy'
   WebUI.dismissAlert()
   WebUI.delay(2)
   
   '2. Click Xóa'

   deleteButtons.get(0).click()
   WebUI.delay(2)
   
   //Chờ và kiểm tra Alert
   WebUI.waitForAlert(5)
    alertText = WebUI.getAlertText()
  WebUI.verifyMatch(alertText, 'Bạn có chắc chắn muốn xóa người dùng này không?', false)
  WebUI.acceptAlert()
  WebUI.delay(2)
  
  //Lấy email user đầu tiên sau khi xóa 
  emailElements = WebUiCommonHelper.findWebElements(listCategoryEmail, 10)
  String firstUserEmailAfterDelete = emailElements.get(0).getText().trim()
  
  // Lấy email đã lưu trong Excel
  String savedFirstUserEmail = util.getData(excelPath, 'FirstUserEmailBefore')
  WebUI.verifyNotMatch(firstUserEmailAfterDelete, savedFirstUserEmail, false,FailureHandling.CONTINUE_ON_FAILURE )
  
  
   	