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

	// Mở trang chủ
//	new openPage().navigateToHomePage()
	
	// Khởi tạo hàm dữ liệu và file
	generalFunction fc = new generalFunction()
	String excelPath = 'Data Files/Data.xlsx'
	dataFileUtil util = new dataFileUtil()
	
	// Lấy dữ liệu từ Excel (dựng dữ liệu kỳ vọng)
	String expectedTitle = util.getData(excelPath, 'book_title')
	String expectedPrice = util.getData(excelPath, 'book_price_current')
	
	// Lấy danh sách sản phẩm và click vào sản phẩm đầu tiên
	String baseXpath = findTestObject('User/HomePage/category_item_1').findPropertyValue('xpath')
	WebDriver driver = DriverFactory.getWebDriver()
	List<WebElement> productList = driver.findElements(By.xpath(baseXpath))
	productList[0].click()
	fc.scrollDown()
	// VERIFY trang chi tiết sản phẩm
	WebUI.verifyElementVisible(findTestObject('Object Repository/User/Product/product_detail_image'))
	WebUI.verifyElementPresent(findTestObject('Object Repository/User/Product/product_tittle'), 10)
	WebUI.verifyElementPresent(findTestObject('Object Repository/User/Product/product_detail_price'), 10)

	// Lấy tên và giá sản phẩm thực tế
	String actualTitle = WebUI.getText(findTestObject('Object Repository/User/Product/product_tittle'))
	String actualPrice = WebUI.getText(findTestObject('Object Repository/User/Product/product_detail_price'))
	
	// So sánh tên và giá với dữ liệu đã lưu trong Excel
	WebUI.verifyMatch(actualTitle, expectedTitle, false, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyMatch(actualPrice, expectedPrice, false, FailureHandling.CONTINUE_ON_FAILURE)
	
	fc.scrollDown()
	
	WebUI.verifyElementText(findTestObject('Object Repository/User/Product/product_detail_info_tittle_code'), 'MÃ SẢN PHẨM', FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyElementText(findTestObject('Object Repository/User/Product/product_detail_info_tittle_author'), 'TÁC GIẢ', FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyElementText(findTestObject('Object Repository/User/Product/product_detail_info_tittle_NXB'), 'NHÀ XUẤT BẢN', FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyElementText(findTestObject('Object Repository/User/Product/product_detail_info_tittle_in_stock'), 'SỐ LƯỢNG TỒN KHO', FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyElementText(findTestObject('Object Repository/User/Product/product_detail_info_tittle_date'), 'NGÀY XUẤT BẢN', FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyElementText(findTestObject('Object Repository/User/Product/product_detail_info_tittle_page_number'), 'SỐ TRANG', FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyElementText(findTestObject('Object Repository/User/Product/product_detail_info_tittle_count'), 'SỐ LƯỢNG', FailureHandling.CONTINUE_ON_FAILURE)
	
	// Lấy XPath cho bảng thông tin chi tiết
	String tableXpath = findTestObject('Object Repository/User/Product/product_detail_info').findPropertyValue('xpath')
	List<WebElement> rows = driver.findElements(By.xpath(tableXpath))
	
	// Duyệt qua từng dòng trong bảng và lấy dữ liệu
	for (int i = 0; i < rows.size(); i++) {
	    String rowData = rows.get(i).getText().trim()
	    util.setData(excelPath, "1.product_detail_info_${i}", rowData)
	}
	
	// Xác minh xem các dữ liệu đã lấy có hợp lệ không
	for (int i = 0; i < rows.size(); i++) {
	    String expectedData = util.getData(excelPath, "1.product_detail_info_${i}")
	    String actualData = rows.get(i).getText().trim()
	    WebUI.verifyMatch(actualData, expectedData, false)
	}
	WebUI.back()
	

