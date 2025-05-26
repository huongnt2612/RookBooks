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
	
	WebUI.click(findTestObject('Object Repository/User/HomePage/icon_Accounts'))
	
	WebUI.verifyElementVisible(findTestObject('Object Repository/User/HomePage/icon_admin'))
	
	WebUI.click(findTestObject('Object Repository/User/HomePage/icon_admin'))
	WebUI.delay(2)
	
	WebUI.waitForElementClickable(findTestObject('Object Repository/Admin/Admin_Category/Button_Category_Management'), 3)
	WebUI.click(findTestObject('Object Repository/Admin/Admin_Category/Button_Category_Management'))
	WebUI.waitForElementClickable(findTestObject('Object Repository/Admin/Admin_Category/Button_Category_List'), 3)
	WebUI.click(findTestObject('Object Repository/Admin/Admin_Category/Button_Category_List'))
	WebUI.delay(3)

	//Đến trang cuối
	WebUI.click(findTestObject('Object Repository/Admin/Admin_Category/paging_last'))
	WebUI.delay(2)
	
	TestObject listButtonUpdate = findTestObject('Object Repository/Admin/Admin_Category/List_Button_Update')
	List<WebElement> updateButtons = WebUiCommonHelper.findWebElements(listButtonUpdate, 10)
	
	// Click nút Update cuối cùng (danh mục mới tạo)
	WebElement lastUpdateButton = updateButtons.get(updateButtons.size() - 1)
	lastUpdateButton.click()
	WebUI.delay(2)
    
	String oldName = WebUI.getAttribute(findTestObject('Object Repository/Admin/Admin_Category/Input_Category_Name'), 'value')
	String oldDesc = WebUI.getAttribute(findTestObject('Object Repository/Admin/Admin_Category/Input_Category_Description'), 'value')
	
	// Tạo tên và description mới
	String newName = oldName + "_Updated"
	String newDesc = oldDesc + " (Updated)"
	
	WebUI.verifyElementText(findTestObject('Object Repository/Admin/Admin_Category/Tittle_Update_Form'), "Thêm - Cập nhật Danh Mục")
	WebUI.setText(findTestObject('Object Repository/Admin/Admin_Category/Input_Category_Name'), newName)
	WebUI.setText(findTestObject('Object Repository/Admin/Admin_Category/Input_Category_Description'), newDesc)
	
	WebUI.click(findTestObject('Object Repository/Admin/Admin_Category/Button_Update'))
	WebUI.delay(2)
	WebUI.verifyElementText(findTestObject('Object Repository/Admin/Admin_Category/Div_Category_Update_Successful'), "Cập nhật danh mục thành công")
	
	
	util.setData(excelPath, 'Category_Update_name', newName)
	util.setData(excelPath, 'Category_Update_desc', newDesc)
	
	//Đến cuối trang
	WebUI.click(findTestObject('Object Repository/Admin/Admin_Category/paging_last'))
	WebUI.delay(2)
	
	TestObject listCategoryName = findTestObject('Object Repository/Admin/Admin_Category/List_Category_Name')
	List<WebElement> categories = WebUiCommonHelper.findWebElements(listCategoryName, 10)
	WebElement lastCategory = categories.get(categories.size() - 1)
	String lastCategoryName = lastCategory.getText().trim()
	
	TestObject listCategoryDesc = findTestObject('Object Repository/Admin/Admin_Category/List_Category_Desc')
	categories = WebUiCommonHelper.findWebElements(listCategoryDesc, 10)
	lastCategory = categories.get(categories.size() - 1)
	String lastCategoryDesc = lastCategory.getText().trim()
	
	String expectedName = util.getData(excelPath, 'Category_Update_name')
	String expectedDesc = util.getData(excelPath, 'Category_Update_desc')
	
	WebUI.verifyMatch(lastCategoryName, expectedName, false, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyMatch(lastCategoryDesc, expectedDesc, false, FailureHandling.CONTINUE_ON_FAILURE)
	
	
	
	
	