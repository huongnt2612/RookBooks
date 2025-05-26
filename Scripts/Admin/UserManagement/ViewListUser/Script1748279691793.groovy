import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.TestObject

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
	
	WebUI.waitForElementClickable(findTestObject('Object Repository/Admin/UserManagement/Button_User'), 3)
	WebUI.click(findTestObject('Object Repository/Admin/UserManagement/Button_User'))
	WebUI.waitForElementClickable(findTestObject('Object Repository/Admin/UserManagement/Button_User_Management'), 3)
	WebUI.click(findTestObject('Object Repository/Admin/UserManagement/Button_User_Management'))
	WebUI.delay(3)
	
	//Lấy danh sách tên User
	TestObject listUserEmail = findTestObject('Object Repository/Admin/UserManagement/List_User_Email')
	List<WebElement> userElements = WebUiCommonHelper.findWebElements(listUserEmail, 10)
	
	int mail = Math.min(userElements.size(), 3)
	
	for (int i = 0; i < mail; i++) {
    String userEmail = userElements.get(i).getText().trim()
    String key = "User_Email_" + (i + 1)
    util.setData(excelPath, key, userEmail)
	}
	
	//Lấy danh sách name User
	TestObject listUserName = findTestObject('Object Repository/Admin/UserManagement/List_User_Name')
 userElements = WebUiCommonHelper.findWebElements(listUserName, 10)
	
	int name = Math.min(userElements.size(), 3)
	
	for (int i = 0; i < name; i++) {
	String userName = userElements.get(i).getText().trim()
	String key = "User_Name_" + (i + 1)
	util.setData(excelPath, key, userName)
	}
	
	//Lấy danh sách phone User
	TestObject listUserphone = findTestObject('Object Repository/Admin/UserManagement/List_User_Name')
	userElements = WebUiCommonHelper.findWebElements(listUserphone, 10)
	
	int phone = Math.min(userElements.size(), 3)
	
	for (int i = 0; i < phone; i++) {
	String userPhone = userElements.get(i).getText().trim()
	String key = "User_Phone_" + (i + 1)
	util.setData(excelPath, key, userPhone)
	}
	
	//Lấy danh sách address User
	TestObject listAddressName = findTestObject('Object Repository/Admin/UserManagement/List_User_Name')
	userElements = WebUiCommonHelper.findWebElements(listAddressName, 10)
	
	int address = Math.min(userElements.size(), 3)
	
	for (int i = 0; i < address; i++) {
	String userAddress = userElements.get(i).getText().trim()
	String key = "User_Address_" + (i + 1)
	util.setData(excelPath, key, userAddress)
	}
	
	
	
	
	
	
	