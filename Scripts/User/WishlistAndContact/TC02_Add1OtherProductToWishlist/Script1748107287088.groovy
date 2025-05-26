import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import dataFileUtil
import generalFunction

	generalFunction fc = new generalFunction()
	dataFileUtil util = new dataFileUtil()
	String excelPath = 'Data Files/Data.xlsx'
	WebDriver driver = DriverFactory.getWebDriver()

	'2. thêm 1p nữa vào wishlist'
	WebUI.click(findTestObject('Object Repository/User/HomePage/btn_homepage'))
	WebUI.delay(2)
	fc.scrollDown()
	String baseXpath = findTestObject('Object Repository/User/HomePage/category_item_2').findPropertyValue('xpath')
	List<WebElement> productList = driver.findElements(By.xpath(baseXpath))
	productList[0].click()
	fc.scrollDown()
	
	
	// VERIFY trang chi tiết sản phẩm
	WebUI.verifyElementVisible(findTestObject('Object Repository/User/Product/product_detail_image'))
	WebUI.verifyElementPresent(findTestObject('Object Repository/User/Product/product_tittle'), 10)
	WebUI.verifyElementPresent(findTestObject('Object Repository/User/Product/product_detail_price'), 10)
	
	// Lấy tên và giá sản phẩm thực tế
	String Title = WebUI.getText(findTestObject('Object Repository/User/Product/product_tittle'))
	String Price = WebUI.getText(findTestObject('Object Repository/User/Product/product_detail_price'))
	
	
	// lưu trong Excel
	util.setData(excelPath, 'AddToWishlist_Tittle2', Title)
	util.setData(excelPath, 'AddToWishlist_Price2', Price)
	
	// Thêm sản phẩm vào wishlist
	WebUI.click(findTestObject('Object Repository/User/Product/btn_add_to_wishlist'))
	
	//Chờ và kiểm tra Alert
	WebUI.waitForAlert(5)
	String alertText = WebUI.getAlertText()
   WebUI.verifyMatch(alertText, 'Đã thêm vào danh sách yêu thích !', false)
   WebUI.acceptAlert()
	
	WebUI.delay(3)
	WebUI.click(findTestObject('Object Repository/User/HomePage/icon_Accounts'))
	WebUI.click(findTestObject('Object Repository/User/wishlistAndContact/btn_wishlist'))
	WebUI.delay(2)
	fc.scrollDown()
	
	String expectedTitle = util.getData(excelPath, 'AddToWishlist_Tittle2')
	String expectedPrice = util.getData(excelPath, 'AddToWishlist_Price2')

	String actualTitle = WebUI.getText(findTestObject('Object Repository/User/wishlistAndContact/wishlist_product_name'))
	String actualPrice = WebUI.getText(findTestObject('Object Repository/User/wishlistAndContact/wishlist_product_price'))
	
	WebUI.verifyMatch(actualTitle, expectedTitle, false, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyMatch(actualPrice, expectedPrice, false, FailureHandling.CONTINUE_ON_FAILURE)
	
	WebUI.verifyElementVisible(findTestObject('Object Repository/User/wishlistAndContact/wishlist_btn_add_cart'), FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyElementVisible(findTestObject('Object Repository/User/wishlistAndContact/wishlist_x'), FailureHandling.CONTINUE_ON_FAILURE)
	
	
