import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
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
	WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/Button_Product'))
	WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/Button_Product_Management'))
	WebUI.delay(2)
	WebUI.verifyElementText(findTestObject('Object Repository/Admin/ProductManagement/Tittle_Product_Management'), 'Danh sách sản phẩm')
	
	'1. Sửa thông tin sản phẩm thành công'
	// Lấy hàng đầu tiên trong bảng sản phẩm
	TestObject UpdateRows = findTestObject('Object Repository/Admin/ProductManagement/List_Button_Update')
	List<WebElement> btnUpdate = WebUiCommonHelper.findWebElements(UpdateRows, 10)
	if (btnUpdate.size() > 0) {
		btnUpdate.get(0).click()
		WebUI.waitForElementVisible(findTestObject('Object Repository/Admin/ProductManagement/Lable_Add_Product'), 5)
		
		WebUI.setText(findTestObject('Object Repository/Admin/ProductManagement/Form_Title'), 'The Ministry of Time (Updated)')
		WebUI.setText(findTestObject('Object Repository/Admin/ProductManagement/Form_bookAuthor'), 'Kaliene Bradley')
		WebUI.setText(findTestObject('Object Repository/Admin/ProductManagement/Form_bookPublisher'), 'NXB Kim Dong')
		WebUI.setText(findTestObject('Object Repository/Admin/ProductManagement/Form_PublishedDate'), '06/08/2025')
		WebUI.selectOptionByLabel(findTestObject('Object Repository/Admin/ProductManagement/Form_bookCategory'), 'Sci-Fi', false)
		WebUI.setText(findTestObject('Object Repository/Admin/ProductManagement/Form_originalPrice'), '120000')
		fc.scrollDown()
		WebUI.setText(findTestObject('Object Repository/Admin/ProductManagement/Form_salePrice'), '115000')
		WebUI.setText(findTestObject('Object Repository/Admin/ProductManagement/Form_Quantity'), '120')
		WebUI.setText(findTestObject('Object Repository/Admin/ProductManagement/Form_numberOfPage'), '210')
		WebUI.setText(findTestObject('Object Repository/Admin/ProductManagement/Form_description'), 'Cập nhật mô tả mới cho sách')
		
		WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/Button_Submit'))
		WebUI.delay(2)
		WebUI.verifyElementText(findTestObject('Object Repository/Admin/ProductManagement/Message_Add_Update_Product'), 'Sửa thông tin sách thành công!', FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.back()
		WebUI.back()
	} else {
		WebUI.comment("Khong co san pham trong bang")
	}

	WebUI.delay(2)
	
	// Lấy danh sách hàng trong bảng sản phẩm
	TestObject tableRows = findTestObject('Object Repository/Admin/ProductManagement/table_ProductRows')
	List<WebElement> productRows = WebUiCommonHelper.findWebElements(tableRows, 10)
	int maxRows = Math.min(productRows.size(), 1)
	
	for (int i = 0; i < maxRows; i++) {
		WebElement row = productRows.get(i)
		List<WebElement> cols = row.findElements(By.tagName("td"))
	
		String id = cols.get(0).getText().trim()
		String name = cols.get(1).getText().trim()
		String author = cols.get(2).getText().trim()
		String publisher = cols.get(3).getText().trim()
		String pubDate = cols.get(4).getText().trim()
		String price = cols.get(5).getText().trim()
		String salePrice = cols.get(6).getText().trim()
		String quantity = cols.get(7).getText().trim()
		String pages = cols.get(8).getText().trim()
	
		util.setData(excelPath, "BookID${i+1}", id)
		util.setData(excelPath, "BookNameUpdate${i+1}", name)
		util.setData(excelPath, "AuthorUpdate${i+1}", author)
		util.setData(excelPath, "PublisherUpdate${i+1}", publisher)
		util.setData(excelPath, "PubDateUpdate${i+1}", pubDate)
		util.setData(excelPath, "PriceUpdate${i+1}", price)
		util.setData(excelPath, "SalePriceUpdate${i+1}", salePrice)
		util.setData(excelPath, "QuantityUpdate${i+1}", quantity)
		util.setData(excelPath, "PagesUpdate${i+1}", pages)
	}

	
	'2. Sửa giá âm'
	btnUpdate = WebUiCommonHelper.findWebElements(UpdateRows, 10)
	if (btnUpdate.size() > 0) {
		btnUpdate.get(0).click()
		WebUI.waitForElementVisible(findTestObject('Object Repository/Admin/ProductManagement/Lable_Add_Product'), 5)
	
		WebUI.setText(findTestObject('Object Repository/Admin/ProductManagement/Form_Title'), 'The Ministry of Time (Negative Price)')
		WebUI.setText(findTestObject('Object Repository/Admin/ProductManagement/Form_bookAuthor'), 'Kaliene Bradley')
		WebUI.setText(findTestObject('Object Repository/Admin/ProductManagement/Form_bookPublisher'), 'NXB Kim Dong')
		WebUI.setText(findTestObject('Object Repository/Admin/ProductManagement/Form_PublishedDate'), '06/08/2025')
		WebUI.selectOptionByLabel(findTestObject('Object Repository/Admin/ProductManagement/Form_bookCategory'), 'Sci-Fi', false)
		WebUI.setText(findTestObject('Object Repository/Admin/ProductManagement/Form_originalPrice'), '120000')
		fc.scrollDown()
		// Nhập giá sale âm
		WebUI.setText(findTestObject('Object Repository/Admin/ProductManagement/Form_salePrice'), '-100000')
		WebUI.setText(findTestObject('Object Repository/Admin/ProductManagement/Form_Quantity'), '120')
		WebUI.setText(findTestObject('Object Repository/Admin/ProductManagement/Form_numberOfPage'), '210')
		WebUI.setText(findTestObject('Object Repository/Admin/ProductManagement/Form_description'), 'Test nhập giá âm')
	
		WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/Button_Submit'))
	
		// Kiểm tra có thông báo lỗi hiển thị hay không
		WebUI.verifyElementText(findTestObject('Object Repository/Admin/ProductManagement/Message_Add_Update_Product'), 'Vui lòng nhập thông tin hợp lệ!',FailureHandling.CONTINUE_ON_FAILURE )

		WebUI.back()
		WebUI.back()
	} else {
		WebUI.comment("Không có sản phẩm trong bảng để test giá âm.")
	}
	
	
	