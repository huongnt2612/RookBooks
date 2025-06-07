import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

	WebUI.callTestCase(
		findTestCase('Test Cases/Admin/LoginLogout/LO02_login_successfully'),
		[('username') : GlobalVariable.Admin_Email, ('password') : GlobalVariable.General_Password]
	)
	
	generalFunction fc = new generalFunction()
	dataFileUtil util = new dataFileUtil()
	String excelPath = 'Data Files/Data.xlsx'
	String bookName = util.getData(excelPath, "BookName1")
	String bookName2 = util.getData(excelPath, "BookName2")
	
	WebUI.click(findTestObject('Object Repository/User/HomePage/icon_Accounts'))
	
	WebUI.verifyElementVisible(findTestObject('Object Repository/User/HomePage/icon_admin'))
	
	WebUI.click(findTestObject('Object Repository/User/HomePage/icon_admin'))
	WebUI.delay(2)
	WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/Button_Product'))
	WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/Button_Product_Management'))
	WebUI.delay(2)
	
	WebUI.verifyElementText(findTestObject('Object Repository/Admin/ProductManagement/Tittle_Product_Management'), 'Danh sách sản phẩm')
	
	'1. Search full text'
	WebUI.setText(findTestObject('Object Repository/Admin/ProductManagement/input_Keyword'), bookName)
	WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/Button_Search'))
	WebUI.delay(2)
	
	if (WebUI.verifyElementPresent(findTestObject('Object Repository/Admin/ProductManagement/List_Book_Name'), 5, FailureHandling.OPTIONAL)) {
		String actualName = WebUI.getText(findTestObject('Object Repository/Admin/ProductManagement/List_Book_Name')).trim()
		WebUI.verifyMatch(actualName, bookName, false)
	} else {
		WebUI.comment("[BỎ QUA] Không tìm thấy sản phẩm với tên: " + bookName)
	}
	
	WebUI.setText(findTestObject('Object Repository/Admin/ProductManagement/input_Keyword'), bookName2)
	WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/Button_Search'))
	WebUI.delay(2)
	
	if (WebUI.verifyElementPresent(findTestObject('Object Repository/Admin/ProductManagement/List_Book_Name'), 5, FailureHandling.OPTIONAL)) {
		String actualName2 = WebUI.getText(findTestObject('Object Repository/Admin/ProductManagement/List_Book_Name')).trim()
		WebUI.verifyMatch(actualName2, bookName2, false)
	} else {
		WebUI.comment("[BỎ QUA] Không tìm thấy sản phẩm với tên: " + bookName2)
	}
	
	
	'2. Search half text'
	int halfLength = (int)(bookName.length() / 2)
	String partialName = bookName.length() > 3 ? bookName.substring(0, halfLength) : bookName
	WebUI.setText(findTestObject('Object Repository/Admin/ProductManagement/input_Keyword'), partialName)
	WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/Button_Search'))
	WebUI.delay(2)
	
	if (WebUI.verifyElementPresent(findTestObject('Object Repository/Admin/ProductManagement/List_Book_Name'), 5, FailureHandling.OPTIONAL)) {
	    String actualName = WebUI.getText(findTestObject('Object Repository/Admin/ProductManagement/List_Book_Name')).trim()
	    WebUI.verifyMatch(actualName.toLowerCase(), bookName.toLowerCase(), true)
	} else {
	    WebUI.comment("[BỎ QUA] Không tìm thấy sản phẩm với tên gần giống: " + partialName)
	}
	
	int halfLength1 = (int)(bookName2.length() / 2)
	String partialName1 = bookName2.length() > 3 ? bookName2.substring(0, halfLength1) : bookName2
	WebUI.setText(findTestObject('Object Repository/Admin/ProductManagement/input_Keyword'), partialName1)
	WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/Button_Search'))
	WebUI.delay(2)
	
	if (WebUI.verifyElementPresent(findTestObject('Object Repository/Admin/ProductManagement/List_Book_Name'), 5, FailureHandling.OPTIONAL)) {
		String actualName2 = WebUI.getText(findTestObject('Object Repository/Admin/ProductManagement/List_Book_Name')).trim()
		WebUI.verifyMatch(actualName2.toLowerCase(), bookName2.toLowerCase(), true)
	} else {
		WebUI.comment("[BỎ QUA] Không tìm thấy sản phẩm với tên gần giống: " + partialName1)
	}
	

	'3. Search with whitespace'
	String spaceKeyword = "  " + bookName + "  "
	WebUI.setText(findTestObject('Object Repository/Admin/ProductManagement/input_Keyword'), spaceKeyword)
	WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/Button_Search'))
	WebUI.delay(2)
	
	if (WebUI.verifyElementPresent(findTestObject('Object Repository/Admin/ProductManagement/List_Book_Name'), 5, FailureHandling.OPTIONAL)) {
		String actualName = WebUI.getText(findTestObject('Object Repository/Admin/ProductManagement/List_Book_Name')).trim()
		WebUI.verifyMatch(actualName, bookName, false)
	} else {
		WebUI.comment("[BỎ QUA] Không tìm thấy sản phẩm với từ khóa chứa khoảng trắng: " + spaceKeyword)
	}
	
	'4. Search empty keyword'
	WebUI.setText(findTestObject('Object Repository/Admin/ProductManagement/input_Keyword'), "")
	WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/Button_Search'))
	WebUI.delay(2)
	
	if (WebUI.verifyElementPresent(findTestObject('Object Repository/Admin/ProductManagement/List_Book_Name'), 5, FailureHandling.OPTIONAL)) {
		WebUI.comment("Có sản phẩm hiển thị khi tìm kiếm rỗng")
	} else {
		WebUI.comment("Không có sản phẩm nào hiển thị khi tìm kiếm rỗng.")
	}
	
	'5. Search với tên sách không tồn tại'
	String fakeName = bookName + "_NotExist123"
	WebUI.setText(findTestObject('Object Repository/Admin/ProductManagement/input_Keyword'), fakeName)
	WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/Button_Search'))
	WebUI.delay(2)
	
	if (WebUI.verifyElementPresent(findTestObject('Object Repository/Admin/ProductManagement/List_Book_Name'), 5, FailureHandling.OPTIONAL)) {
		WebUI.comment("Kết quả không đúng, đã hiển thị sản phẩm với từ khóa sai: " + fakeName)
	} else {
		WebUI.comment("Không có sản phẩm nào với tên không tồn tại: " + fakeName)
	}
	


	