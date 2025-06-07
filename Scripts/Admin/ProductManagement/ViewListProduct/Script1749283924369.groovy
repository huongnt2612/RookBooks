import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

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
	
	// Lấy danh sách hàng trong bảng sản phẩm
	TestObject tableRows = findTestObject('Object Repository/Admin/ProductManagement/table_ProductRows')
	List<WebElement> productRows = WebUiCommonHelper.findWebElements(tableRows, 10)
	int maxRows = Math.min(productRows.size(), 3)
	
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
		util.setData(excelPath, "BookName${i+1}", name)
		util.setData(excelPath, "Author${i+1}", author)
		util.setData(excelPath, "Publisher${i+1}", publisher)
		util.setData(excelPath, "PubDate${i+1}", pubDate)
		util.setData(excelPath, "Price${i+1}", price)
		util.setData(excelPath, "SalePrice${i+1}", salePrice)
		util.setData(excelPath, "Quantity${i+1}", quantity)
		util.setData(excelPath, "Pages${i+1}", pages)
	}
	
	WebUI.verifyElementVisible(findTestObject('Object Repository/Admin/ProductManagement/List_Button_Update'))
	
	WebUI.verifyElementVisible(findTestObject('Object Repository/Admin/ProductManagement/List_Button_Product_NotForSale'))
	
	