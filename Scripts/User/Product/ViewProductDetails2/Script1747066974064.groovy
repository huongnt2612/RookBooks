import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import dataFileUtil
import generalFunction
import openPage
//	new openPage().navigateToHomePage()

	// Khởi tạo hàm dữ liệu và file
	generalFunction fc = new generalFunction()
	String excelPath = 'Data Files/Data.xlsx'
	dataFileUtil util = new dataFileUtil()
	WebDriver driver = DriverFactory.getWebDriver()
	WebUI.delay(10)
	fc.scrollDown()

	// Lấy dữ liệu từ Excel (dựng dữ liệu kỳ vọng)
	String expectedTitle = util.getData(excelPath, 'book_title_1')
	String expectedPrice = util.getData(excelPath, 'book_price_current_1')
//	
//	// Xác minh danh mục "BÁN CHẠY NHẤT"
//	WebUI.verifyElementText(findTestObject('HomePage/tittle_category_1'), 'BÁN CHẠY NHẤT')
//	WebUI.verifyElementPresent(findTestObject('HomePage/category_item_2'), 10)
	
	// Lấy danh sách sản phẩm và click vào sản phẩm thứ 2
	String baseXpath = findTestObject('HomePage/category_item_2').findPropertyValue('xpath')
	List<WebElement> productList = driver.findElements(By.xpath(baseXpath))
	productList[0].click()
	WebUI.delay(10)
	
	fc.scrollDown()
	
	// VERIFY trang chi tiết sản phẩm
	WebUI.verifyElementVisible(findTestObject('Object Repository/Product/product_detail_image'))
	WebUI.verifyElementPresent(findTestObject('Object Repository/Product/product_tittle'), 10)
	WebUI.verifyElementPresent(findTestObject('Object Repository/Product/product_detail_price'), 10)
	
	// Lấy tên và giá sản phẩm thực tế
	String actualTitle = WebUI.getText(findTestObject('Object Repository/Product/product_tittle'))
	String actualPrice = WebUI.getText(findTestObject('Object Repository/Product/product_detail_price'))
	
	// So sánh tên và giá với dữ liệu đã lưu trong Excel
	WebUI.verifyMatch(actualTitle, expectedTitle, false, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyMatch(actualPrice, expectedPrice, false, FailureHandling.CONTINUE_ON_FAILURE)
	
	fc.scrollDown()
	
	WebUI.verifyElementText(findTestObject('Object Repository/Product/product_detail_info_tittle_code'), 'MÃ SẢN PHẨM', FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyElementText(findTestObject('Object Repository/Product/product_detail_info_tittle_author'), 'TÁC GIẢ', FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyElementText(findTestObject('Object Repository/Product/product_detail_info_tittle_NXB'), 'NHÀ XUẤT BẢN', FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyElementText(findTestObject('Object Repository/Product/product_detail_info_tittle_in_stock'), 'SỐ LƯỢNG TỒN KHO', FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyElementText(findTestObject('Object Repository/Product/product_detail_info_tittle_date'), 'NGÀY XUẤT BẢN', FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyElementText(findTestObject('Object Repository/Product/product_detail_info_tittle_page_number'), 'SỐ TRANG', FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyElementText(findTestObject('Object Repository/Product/product_detail_info_tittle_count'), 'SỐ LƯỢNG', FailureHandling.CONTINUE_ON_FAILURE)
	
	// Lấy XPath cho bảng thông tin chi tiết
	String tableXpath = findTestObject('Object Repository/Product/product_detail_info').findPropertyValue('xpath')
	List<WebElement> rows = driver.findElements(By.xpath(tableXpath))
	
	// Duyệt qua từng dòng trong bảng và lấy dữ liệu
	for (int i = 0; i < rows.size(); i++) {
	    // Lấy giá trị từng dòng từ bảng
	    String rowData = rows.get(i).getText().trim()
	    // Ghi vào Excel
	    util.setData(excelPath, "2.product_detail_info_${i}", rowData)
	}
	
	// Xác minh xem các dữ liệu đã lấy có hợp lệ không
	for (int i = 0; i < rows.size(); i++) {
	    String expectedData = util.getData(excelPath, "2.product_detail_info_${i}")
	    String actualData = rows.get(i).getText().trim()
	    
	    // Kiểm tra xem giá trị đã lấy có khớp với dữ liệu trong bảng không
	    WebUI.verifyMatch(actualData, expectedData, false)
	}
	WebUI.back()
	

