import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import dataFileUtil
import openPage
import generalFunction

	
//	new openPage().navigateToHomePage()
	generalFunction fc = new generalFunction()
	dataFileUtil util = new dataFileUtil()
	String excelPath = 'Data Files/Data.xlsx'

//	' Xác minh danh mục "BÁN CHẠY NHẤT" có hiển thị'
//	WebUI.verifyElementText(findTestObject('User/HomePage/tittle_category_1'), 'BÁN CHẠY NHẤT')
//	WebUI.verifyElementPresent(findTestObject('User/HomePage/category_item_1'), 10)
//	
//	fc.scrollDown()
//	WebUI.delay(1)
//	fc.scrollUp()
//	WebUI.delay(1)
//	
//	WebUI.verifyElementText(findTestObject('Object Repository/User/HomePage/tittle_category_2'), 'SÁCH MỚI')
	
	'Lấy phần tử đầu tiên trong danh sách sản phẩm "BÁN CHẠY NHẤT"'
	String listXpath = findTestObject('Object Repository/User/HomePage/list_tittle_books').findPropertyValue('xpath')
	WebDriver driver = DriverFactory.getWebDriver()
	List<WebElement> productList = driver.findElements(By.xpath(listXpath))
	WebElement firstProduct = productList.get(0)  // sản phẩm đầu tiên
	
	
	// Từ object repository, lấy xpath tương ứng
	String titleXpath0 = findTestObject('Object Repository/User/HomePage/tittle_category_item_1').findPropertyValue('xpath')
	String currentPriceXpath0 = findTestObject('User/HomePage/current_price_item_1').findPropertyValue('xpath')
	String oldPriceXpath0 = findTestObject('User/HomePage/old_price_item_1').findPropertyValue('xpath')
	
	// Trích xuất dữ liệu
	String title = driver.findElement(By.xpath(titleXpath0)).getText()
	String currentPrice = driver.findElement(By.xpath(currentPriceXpath0)).getText()
	List<WebElement> oldPriceElems = firstProduct.findElements(By.xpath(oldPriceXpath0))
	String oldPrice = oldPriceElems.size() > 0 ? oldPriceElems[0].getText() : ""

	util.setData(excelPath, 'book_title', title)
	util.setData(excelPath, 'book_price_current', currentPrice)
	util.setData(excelPath, 'book_price_old', oldPrice)
	
	'Lấy phần tử thứ 2 trong danh sách sản phẩm "BÁN CHẠY NHẤT'
	WebElement secondProduct = productList.get(1)  // sản phẩm thứ 2

	
	// Từ object repository, lấy xpath tương ứng
	String titleXpath1 = findTestObject('Object Repository/User/HomePage/tittle_category_item_2').findPropertyValue('xpath')
	String currentPriceXpath1 = findTestObject('Object Repository/User/HomePage/current_price_item_2').findPropertyValue('xpath')
	String oldPriceXpath1 = findTestObject('Object Repository/User/HomePage/old_price_item_2').findPropertyValue('xpath')
	
	// Trích xuất dữ liệu
	String title1 = driver.findElement(By.xpath(titleXpath1)).getText()
	String currentPrice1 = driver.findElement(By.xpath(currentPriceXpath1)).getText()
	List<WebElement> oldPriceElems1 = secondProduct.findElements(By.xpath(oldPriceXpath1))
	String oldPrice1 = oldPriceElems1.size() > 0 ? oldPriceElems1[0].getText() : ""
	
	// Lưu vào file Excel

	util.setData(excelPath, 'book_title1', title1)
	util.setData(excelPath, 'book_price_current1', currentPrice1)
	util.setData(excelPath, 'book_price_old1', oldPrice1)
	