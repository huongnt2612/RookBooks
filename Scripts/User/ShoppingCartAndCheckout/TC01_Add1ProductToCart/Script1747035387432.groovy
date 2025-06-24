import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
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
	
//	WebElement element = productList[0]
//	JavascriptExecutor js = (JavascriptExecutor) driver
//	js.executeScript("arguments[0].scrollIntoView(true);", element)
//	WebUI.delay(1)
//	js.executeScript("arguments[0].click();", element)
	fc.scrollDown()
	
	// VERIFY trang chi tiết sản phẩm
	WebUI.verifyElementVisible(findTestObject('Object Repository/User/Product/product_detail_image'))
	WebUI.verifyElementPresent(findTestObject('Object Repository/User/Product/product_tittle'), 10)
	WebUI.verifyElementPresent(findTestObject('Object Repository/User/Product/product_detail_price'), 10)
	
	// Lấy tên và giá sản phẩm thực tế
	String Title = WebUI.getText(findTestObject('Object Repository/User/Product/product_tittle'))
	String Price = WebUI.getText(findTestObject('Object Repository/User/Product/product_detail_price'))
	
	
	WebUI.setText(findTestObject('Object Repository/User/Cart/input_quantity'), '2')  // Đặt số lượng là 2
	String Quantity = WebUI.getText(findTestObject('Object Repository/User/Cart/input_quantity'))
	
	// lưu trong Excel
	util.setData(excelPath, 'AddToCard_Tittle1', Title)
	util.setData(excelPath, 'AddToCard_Price1', Price)
	util.setData(excelPath, 'AddToCard_Quantity1', Quantity)
	
	// Thêm sản phẩm vào giỏ hàng
	WebUI.click(findTestObject('Object Repository/User/Cart/btn_add_to_card'))
	
	//Chờ và kiểm tra Alert
	WebUI.waitForAlert(2)  // Chờ Alert xuất hiện
//	WebUI.verifyAlertPresent()  // Kiểm tra xem Alert có xuất hiện hay không
	//Chấp nhận Alert (Nhấn OK)
	WebUI.acceptAlert()
	
	WebUI.delay(3)
	WebUI.click(findTestObject('Object Repository/User/HomePage/icon_cart'))
	fc.scrollDown()
	
	String expectedTitle = util.getData(excelPath, 'AddToCard_Tittle1')
	String expectedPrice = util.getData(excelPath, 'AddToCard_Price1')
	String expectedQuantity = util.getData(excelPath, 'AddToCard_Quantity1')
	String actualTitle = WebUI.getText(findTestObject('Object Repository/User/Cart/cart_product_name'))
	String actualPrice = WebUI.getText(findTestObject('Object Repository/User/Cart/cart_product_price'))
	String actualQuantity = WebUI.getText(findTestObject('Object Repository/User/Cart/cart_product_quantity'))
	
	String actualTotal = WebUI.getText(findTestObject('Object Repository/User/Cart/cart_product_total_price'))
	
//	int expectedPriceInt = Integer.parseInt(expectedPrice)
//	int expectedQuantityInt = Integer.parseInt(expectedQuantity)
//	int expectedTotal = expectedPriceInt * expectedQuantityInt	
	
	WebUI.verifyMatch(actualTitle, expectedTitle, false, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyMatch(actualPrice, expectedPrice, false, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyMatch(actualQuantity, expectedQuantity, false, FailureHandling.CONTINUE_ON_FAILURE)
//	WebUI.verifyMatch(actualTotal, expectedTotal, false, FailureHandling.CONTINUE_ON_FAILURE)
	
	WebUI.verifyElementVisible(findTestObject('Object Repository/User/Cart/cart_icon_x'), FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyElementVisible(findTestObject('Object Repository/User/Cart/btn_payment'), FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyElementVisible(findTestObject('Object Repository/User/Cart/btn_cart_total_amount'), FailureHandling.CONTINUE_ON_FAILURE)
	
