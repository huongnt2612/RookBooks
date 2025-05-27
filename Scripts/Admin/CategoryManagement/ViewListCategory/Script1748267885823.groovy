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
	
	//Lấy danh sách tên danh mục
	TestObject listCategoryName = findTestObject('Object Repository/Admin/Admin_Category/List_Category_Name')
	List<WebElement> categoryElements = WebUiCommonHelper.findWebElements(listCategoryName, 10)
	
	int maxCategories = Math.min(categoryElements.size(), 2)
	
	for (int i = 0; i < maxCategories; i++) {
    String categoryName = categoryElements.get(i).getText().trim()
    String key = "Category_" + (i + 1)
    util.setData(excelPath, key, categoryName)
	}
	
//	TestObject pagingFirstButton = findTestObject('Object Repository/Admin/Admin_Category/Paging_First')
//	TestObject pagingSecondButton = findTestObject('Object Repository/Admin/Admin_Category/Paging_Second')
//	TestObject pagingLastButton = findTestObject('Object Repository/Admin/Admin_Category/paging_last')
//	
//	// Hàm kiểm tra nút disable
//	def isDisabled(TestObject to) {
//		String disabledAttr = WebUI.getAttribute(to, 'disabled')
//		String classAttr = WebUI.getAttribute(to, 'class')
//		return (disabledAttr != null) || (classAttr != null && classAttr.toLowerCase().contains('disabled'))
//	}
//	
//	// Kiểm tra trạng thái nút phân trang trên từng trang
//	
//	assert isDisabled(pagingFirstButton) == true
//	
//	String classFirst = WebUI.getAttribute(pagingFirstButton, 'class')
//	boolean firstIsActive = classFirst != null && classFirst.toLowerCase().contains('active')
//	assert firstIsActive == false
//	
//	String classLast = WebUI.getAttribute(pagingLastButton, 'class')
//	boolean lastIsActive = classLast != null && classLast.toLowerCase().contains('active')
//	assert lastIsActive == false
//	
//	String classSecond = WebUI.getAttribute(pagingSecondButton, 'class')
//	boolean secondIsActive = classSecond != null && classSecond.toLowerCase().contains('active')
//	assert secondIsActive == false
//	
//	// Chuyển sang trang 2 (page 2)
//	WebUI.click(pagingSecondButton)
//	WebUI.delay(2)
//	
//	// Kiểm tra nút phân trang ở trang 2
//	assert isDisabled(pagingFirstButton) == false
//	
//	classSecond = WebUI.getAttribute(pagingSecondButton, 'class')
//	secondIsActive = classSecond != null && classSecond.toLowerCase().contains('active')
//	secondIsActive == true  // trang 2 active
//	
//	assert isDisabled(pagingLastButton) == false
//	
//	// Chuyển sang trang cuối (page 3)
//	WebUI.click(pagingLastButton)
//	WebUI.delay(2)
//	
//	// Kiểm tra nút phân trang ở trang cuối
//	assert isDisabled(pagingFirstButton) == false
//	
//	 classLast = WebUI.getAttribute(pagingLastButton, 'class')
//	 lastIsActive = classLast != null && classLast.toLowerCase().contains('active')
//	 lastIsActive == true  // trang cuối active
//	
//	classSecondAgain = WebUI.getAttribute(pagingSecondButton, 'class')
//	 secondIsActiveAgain = classSecondAgain != null && classSecondAgain.toLowerCase().contains('active')
//	 secondIsActiveAgain == false  // trang 2 không active nữa
//	
//	assert isDisabled(pagingLastButton) == true
//
//	
//	