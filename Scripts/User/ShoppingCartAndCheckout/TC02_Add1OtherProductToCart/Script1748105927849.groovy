import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import generalFunction
import dataFileUtil

	generalFunction fc = new generalFunction()
	dataFileUtil util = new dataFileUtil()
	String excelPath = 'Data Files/Data.xlsx'
	WebDriver driver = DriverFactory.getWebDriver()
	
	'2. thêm 1p nữa vào giỏ hàng'
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
	String Title1 = WebUI.getText(findTestObject('Object Repository/User/Product/product_tittle'))
	String Price1 = WebUI.getText(findTestObject('Object Repository/User/Product/product_detail_price'))
	
	
	WebUI.setText(findTestObject('Object Repository/User/input_quantity'), '2')  // Đặt số lượng là 2
	String Quantity1 = WebUI.getText(findTestObject('Object Repository/User/input_quantity'))
	
	// lưu trong Excel
	util.setData(excelPath, 'AddToCard_Tittle2', Title1)
	util.setData(excelPath, 'AddToCard_Price2', Price1)
	util.setData(excelPath, 'AddToCard_Quantity2', Quantity1)
	
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
	
	String expectedTitle1 = util.getData(excelPath, 'AddToCard_Tittle2')
	String expectedPrice1 = util.getData(excelPath, 'AddToCard_Price2')
	String expectedQuantity1 = util.getData(excelPath, 'AddToCard_Quantity2')
	String actualTitle1 = WebUI.getText(findTestObject('Object Repository/User/Cart/cart_product_name'))
	String actualPrice1 = WebUI.getText(findTestObject('Object Repository/User/Cart/cart_product_price'))
	String actualQuantity1 = WebUI.getText(findTestObject('Object Repository/User/Cart/cart_product_quantity'))
	
	String actualTotal1 = WebUI.getText(findTestObject('Object Repository/User/Cart/cart_product_total_price'))
	
//	int expectedPriceInt = Integer.parseInt(expectedPrice)
//	int expectedQuantityInt = Integer.parseInt(expectedQuantity)
//	int expectedTotal = expectedPriceInt * expectedQuantityInt
	
	WebUI.verifyNotMatch(actualTitle1, expectedTitle1, false, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyNotMatch(actualPrice1, expectedPrice1, false, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyNotMatch(actualQuantity1, expectedQuantity1, false, FailureHandling.CONTINUE_ON_FAILURE)
//	WebUI.verifyMatch(actualTotal, expectedTotal, false, FailureHandling.CONTINUE_ON_FAILURE)
	
	WebUI.verifyElementVisible(findTestObject('Object Repository/User/Cart/cart_icon_x'), FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyElementVisible(findTestObject('Object Repository/User/Cart/btn_payment'), FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyElementVisible(findTestObject('Object Repository/User/Cart/btn_cart_total_amount'), FailureHandling.CONTINUE_ON_FAILURE)
	
	
	

	
	
	
