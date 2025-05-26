import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

	WebUI.callTestCase(
	    findTestCase('Test Cases/User/LoginLogout/LO04_login_successfully'),
	    [('username') : GlobalVariable.User_Email, ('password') : GlobalVariable.General_Password]
	)

	generalFunction fc = new generalFunction()
	dataFileUtil util = new dataFileUtil()
	String excelPath = 'Data Files/Data.xlsx'

	' Xác minh danh mục "BÁN CHẠY NHẤT" có hiển thị'
	fc.scrollDown()
	WebUI.verifyElementText(findTestObject('User/HomePage/tittle_category_1'), 'BÁN CHẠY NHẤT')
	WebUI.verifyElementPresent(findTestObject('User/HomePage/category_item_1'), 10)
	
	fc.scrollDown()
	WebUI.verifyElementText(findTestObject('Object Repository/User/HomePage/tittle_category_2'), 'SÁCH MỚI')
	fc.scrollUp()
	
	'1. Thêm 1 sp vào giỏ hàng'
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
	String Title = WebUI.getText(findTestObject('Object Repository/User/Product/product_tittle'))
	String Price = WebUI.getText(findTestObject('Object Repository/User/Product/product_detail_price'))
	
	
	// lưu trong Excel
	util.setData(excelPath, 'AddToWishlist_Tittle1', Title)
	util.setData(excelPath, 'AddToWishlist_Price1', Price)
	
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
	
	String expectedTitle = util.getData(excelPath, 'AddToWishlist_Tittle1')
	String expectedPrice = util.getData(excelPath, 'AddToWishlist_Price1')

	String actualTitle = WebUI.getText(findTestObject('Object Repository/User/wishlistAndContact/wishlist_product_name'))
	String actualPrice = WebUI.getText(findTestObject('Object Repository/User/wishlistAndContact/wishlist_product_price'))
	
	WebUI.verifyMatch(actualTitle, expectedTitle, false, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyMatch(actualPrice, expectedPrice, false, FailureHandling.CONTINUE_ON_FAILURE)
	
	WebUI.verifyElementVisible(findTestObject('Object Repository/User/wishlistAndContact/wishlist_btn_add_cart'), FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyElementVisible(findTestObject('Object Repository/User/wishlistAndContact/wishlist_x'), FailureHandling.CONTINUE_ON_FAILURE)
	
