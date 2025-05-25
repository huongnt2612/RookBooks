import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebDriver

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


	generalFunction fc = new generalFunction()
	dataFileUtil util = new dataFileUtil()
	String excelPath = 'Data Files/Data.xlsx'
	WebDriver driver = DriverFactory.getWebDriver()
	
	String email = util.getData(excelPath, 'register_email')
	String password = util.getData(excelPath, 'register_password')
	String name = util.getData(excelPath, 'register_name')
	String phone = util.getData(excelPath, 'register_phone')
	String address = util.getData(excelPath, 'register_address')
	String productName = util.getData(excelPath, 'AddToCard_Tittle1')
	String  productPrice = util.getData(excelPath, 'AddToCard_Price1')
	String productQuantity = util.getData(excelPath, 'AddToCard_Quantity1')
	
	WebUI.callTestCase('Test Cases/User/Cart/TC01_Add1ProductToCart', null)

	WebUI.click('Object Repository/Cart/btn_payment')
	WebUI.delay(2)
	fc.scrollDown()
	WebUI.verifyElementText(findTestObject('Object Repository/User/Order/title_order_detail'), 'Chi tiết đơn hàng')
	
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_name'), name )
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_phone_number'), phone)
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_email'), email)
	WebUI.setText(findTestObject('Object Repository/User/Order/order_addres'), address)
	
	WebUI.verifyEqual(productName , findTestObject('Object Repository/User/Order/order_detail_product_name'))
	WebUI.verifyEqual(productPrice, findTestObject('Object Repository/User/Order/order_detail_product_price'))
	WebUI.verifyEqual(productQuantity, findTestObject('Object Repository/User/Order/order_detail_product_quantity'))
	
	WebUI.verifyElementVisible(findTestObject('Object Repository/User/Order/order_COD'))
	WebUI.verifyElementVisible(findTestObject('Object Repository/User/Order/order_VNPay'))
	WebUI.delay(2)
	
	
	'2. Đặt hàng theo phương thức VNPay'
	WebUI.click(findTestObject('Object Repository/User/Order/order_VNPay'))
	fc.scrollDown()
	WebUI.setText(findTestObject('Object Repository/User/Order/order_blank_code'), "123456789")
	WebUI.setText(findTestObject('Object Repository/User/Order/order_addres'), address)
	WebUI.click(findTestObject('Object Repository/User/Order/order_now'))
	

	
	
	
	
	
	
	
	
	
	
	
