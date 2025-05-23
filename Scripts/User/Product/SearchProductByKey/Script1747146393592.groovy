import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

//	WebUI.openBrowser('http://localhost:8080/shop')
//	WebUI.maximizeWindow()
	generalFunction fc = new generalFunction()
	dataFileUtil util = new dataFileUtil()
	WebDriver driver = DriverFactory.getWebDriver()
	String excelPath = 'Data Files/Data.xlsx'
	
	fc.scrollDown()
	fc.scrollDown()
	String dataSearch = util.getData(excelPath, 'book_title_1')
	'1. Search full text'
	WebUI.setText(findTestObject('Object Repository/Search/input_search'), dataSearch)
	
	WebUI.click(findTestObject('Object Repository/Search/btn_search'))
	WebUI.delay(3)
	fc.scrollDown()

	String baseXpath1 = findTestObject('Object Repository/Search/list_product_searched').findPropertyValue('xpath')
	List<WebElement> ListSeached = driver.findElements(By.xpath(baseXpath1))
	if(ListSeached.size() > 0) {
		ListSeached[0].click()
		fc.scrollDown()
		
		// VERIFY trang chi tiết sản phẩm
		WebUI.verifyElementVisible(findTestObject('Object Repository/Product/product_detail_image'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product/product_tittle'), 10)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product/product_detail_price'), 10)
		
		// Lấy tên và giá sản phẩm thực tế
		String actualTitle = WebUI.getText(findTestObject('Object Repository/Product/product_tittle'))
		 String actualPrice = WebUI.getText(findTestObject('Object Repository/Product/product_detail_price'))
		
		 String expectedPrice = util.getData(excelPath, 'book_price_current_1')
		
		// So sánh tên và giá với dữ liệu đã lưu trong Excel
		WebUI.verifyMatch(actualTitle, dataSearch, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(actualPrice, expectedPrice, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.back()
	}
	else {
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/Search/list_product_searched'), 5, FailureHandling.CONTINUE_ON_FAILURE)
	}
	
	
	'2. Search half text'
	fc.scrollDown()
	fc.scrollDown()
	WebUI.setText(findTestObject('Object Repository/Search/input_search'), "The Family")
	WebUI.click(findTestObject('Object Repository/Search/btn_search'))
	WebUI.delay(3)
	fc.scrollDown()

	baseXpath1 = findTestObject('Object Repository/Search/list_product_searched').findPropertyValue('xpath')
	ListSeached = driver.findElements(By.xpath(baseXpath1))
	if(ListSeached.size() > 0) {
		ListSeached[0].click()
		fc.scrollDown()
		
		// VERIFY trang chi tiết sản phẩm
		WebUI.verifyElementVisible(findTestObject('Object Repository/Product/product_detail_image'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product/product_tittle'), 10)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product/product_detail_price'), 10)
		
		// Lấy tên và giá sản phẩm thực tế
		actualTitle = WebUI.getText(findTestObject('Object Repository/Product/product_tittle'))
		 actualPrice = WebUI.getText(findTestObject('Object Repository/Product/product_detail_price'))
		
		 expectedPrice = util.getData(excelPath, 'book_price_current_1')
		
		// So sánh tên và giá với dữ liệu đã lưu trong Excel
		WebUI.verifyMatch(actualTitle, dataSearch, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(actualPrice, expectedPrice, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.back()
	}
	else {
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/Search/list_product_searched'), 5, FailureHandling.CONTINUE_ON_FAILURE)
	}
	
	
	'3. Search aaa'
	fc.scrollDown()
	fc.scrollDown()
	WebUI.setText(findTestObject('Object Repository/Search/input_search'), "aaa")
	WebUI.click(findTestObject('Object Repository/Search/btn_search'))
	WebUI.delay(3)
	fc.scrollDown()

	baseXpath1 = findTestObject('Object Repository/Search/list_product_searched').findPropertyValue('xpath')
	ListSeached = driver.findElements(By.xpath(baseXpath1))
	if(ListSeached.size() > 0) {
		ListSeached[0].click()
		fc.scrollDown()
		
		// VERIFY trang chi tiết sản phẩm
		WebUI.verifyElementVisible(findTestObject('Object Repository/Product/product_detail_image'))
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product/product_tittle'), 10)
		WebUI.verifyElementPresent(findTestObject('Object Repository/Product/product_detail_price'), 10)
		
		// Lấy tên và giá sản phẩm thực tế
		actualTitle = WebUI.getText(findTestObject('Object Repository/Product/product_tittle'))
		actualPrice = WebUI.getText(findTestObject('Object Repository/Product/product_detail_price'))
		
		expectedPrice = util.getData(excelPath, 'book_price_current_1')
		
		// So sánh tên và giá với dữ liệu đã lưu trong Excel
		WebUI.verifyMatch(actualTitle, dataSearch, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.verifyMatch(actualPrice, expectedPrice, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.back()
	}
	else {
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/Search/list_product_searched'), 5, FailureHandling.CONTINUE_ON_FAILURE)
	}
	
	

	
	

