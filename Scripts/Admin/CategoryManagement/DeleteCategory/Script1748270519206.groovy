import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

//	WebUI.callTestCase(
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
//	WebUI.waitForElementClickable(findTestObject('Object Repository/Admin/Admin_Category/Button_Category_Management'), 3)
//	WebUI.click(findTestObject('Object Repository/Admin/Admin_Category/Button_Category_Management'))
//	WebUI.waitForElementClickable(findTestObject('Object Repository/Admin/Admin_Category/Button_Category_List'), 3)
//	WebUI.click(findTestObject('Object Repository/Admin/Admin_Category/Button_Category_List'))
//	WebUI.delay(3)
//
//	//Đến trang cuối
//	WebUI.click(findTestObject('Object Repository/Admin/Admin_Category/paging_last'))
//	WebUI.delay(2)
	
	//Lấy tên danh mục cuối cùng trước khi xóa 
	TestObject listCategoryName = findTestObject('Object Repository/Admin/Admin_Category/List_Category_Name')
	List<WebElement> categoryElements = WebUiCommonHelper.findWebElements(listCategoryName, 10)
	
	String deletedCategoryName = categoryElements.get(categoryElements.size() - 1).getText().trim()
	
	//Click button Xóa
	TestObject listButtonDelete = findTestObject('Object Repository/Admin/Admin_Category/List_Button_Delete')
	List<WebElement> deleteButtons = WebUiCommonHelper.findWebElements(listButtonDelete, 10)
	
	// Click nút delete cuối cùng (danh mục mới tạo)
	WebElement lastDeleteButton = deleteButtons.get(deleteButtons.size() - 1)
	lastDeleteButton.click()
	WebUI.delay(2)
	
	WebUI.verifyElementVisible(findTestObject('Object Repository/Admin/Admin_Category/Popup_Verify_Delete'))
	WebUI.verifyElementText(findTestObject('Object Repository/Admin/Admin_Category/Popup_Delete_Tittle'), "Xác nhận xoá danh mục")
	
	'Click Hủy'
	WebUI.click(findTestObject('Object Repository/Admin/Admin_Category/Popup_Delete_Cancel'))
	
	lastDeleteButton.click()
	WebUI.delay(2)
	
	WebUI.verifyElementVisible(findTestObject('Object Repository/Admin/Admin_Category/Popup_Verify_Delete'))
	WebUI.verifyElementText(findTestObject('Object Repository/Admin/Admin_Category/Popup_Delete_Tittle'), "Xác nhận xoá danh mục")
	
	'Click Xóa'
	WebUI.click(findTestObject('Object Repository/Admin/Admin_Category/Popup_Delete_Accept'))
	WebUI.verifyElementText(findTestObject('Object Repository/Admin/Admin_Category/Div_Category_Delete_Successful'), "Xoá danh mục thành công")
	

	//Đến cuối trang
	//	WebUI.click(findTestObject('Object Repository/Admin/Admin_Category/paging_last'))

	WebUI.click(findTestObject('Object Repository/Admin/Admin_Category/paging_last'))
	
	WebUI.delay(2)
	
	//	 Lấy danh sách tên danh mục trên trang cuối
	listCategoryName = findTestObject('Object Repository/Admin/Admin_Category/List_Category_Name')
	categoryElements = WebUiCommonHelper.findWebElements(listCategoryName, 10)
	
	// Kiểm tra xem danh mục vừa xóa còn tồn tại không
	boolean isDeletedCategoryPresent = false
	
	for (WebElement category : categoryElements) {
		String categoryName = category.getText().trim()
		if (categoryName.equals(deletedCategoryName)) {
			isDeletedCategoryPresent = true
			break
		}
	}
	
	if (isDeletedCategoryPresent) {
		WebUI.verifyEqual("true", "false", FailureHandling.CONTINUE_ON_FAILURE) 
	} else {
		WebUI.verifyEqual("false", "false", FailureHandling.CONTINUE_ON_FAILURE) // Test case pass (không lỗi)
	}
	

	