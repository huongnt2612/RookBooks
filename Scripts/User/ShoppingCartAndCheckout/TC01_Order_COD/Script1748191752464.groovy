import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


	generalFunction fc = new generalFunction()
	dataFileUtil util = new dataFileUtil()
	String excelPath = 'Data Files/Data.xlsx'

	
	String email = util.getData(excelPath, 'register_email')
	String password = util.getData(excelPath, 'register_password')
	String name = util.getData(excelPath, 'register_name')
	String phone = util.getData(excelPath, 'register_phone')
	String address = util.getData(excelPath, 'register_address')
	String productName = util.getData(excelPath, 'AddToCard_Tittle1')
	String  productPrice = util.getData(excelPath, 'AddToCard_Price1')
	String productQuantity = util.getData(excelPath, 'AddToCard_Quantity1')
	
	WebUI.callTestCase(
		findTestCase('Test Cases/User/ShoppingCartAndCheckout/TC01_Add1ProductToCart'),
		[:], 
		FailureHandling.STOP_ON_FAILURE 
	)

	WebDriver driver = DriverFactory.getWebDriver()
	WebUI.click(findTestObject('Object Repository/User/Cart/btn_payment'))
	
	WebUI.delay(2)
	fc.scrollDown()
	WebUI.verifyElementText(findTestObject('Object Repository/User/Order/title_order_detail'), 'Chi tiết đơn hàng')
	
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_name'), name )
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_phone_number'), phone)
	WebUI.setText(findTestObject('Object Repository/User/Auth/register_email'), email)
	WebUI.setText(findTestObject('Object Repository/User/Order/order_addres'), address)
	
	WebUI.verifyMatch(productName, WebUI.getText(findTestObject('Object Repository/User/Order/order_detail_product_name')), false)
//	WebUI.verifyMatch(productPrice, WebUI.getText(findTestObject('Object Repository/User/Order/order_detail_product_price')), false)
//	String actualQuantity = WebUI.getText(findTestObject('Object Repository/User/Order/order_detail_product_quantity'))
//	WebUI.verifyMatch(productQuantity,actualQuantity , false)
	
	WebUI.verifyElementVisible(findTestObject('Object Repository/User/Order/order_COD'))
	WebUI.verifyElementVisible(findTestObject('Object Repository/User/Order/order_VNPay'))
	WebUI.delay(2)
	'1. Đặt hàng theo phương thức thanh toán COD'
	WebUI.click(findTestObject('Object Repository/User/Order/order_COD'))
	WebUI.delay(2)
	fc.scrollDown()
	fc.scrollDown()
	WebUI.delay(2)
	WebUI.click(findTestObject('Object Repository/User/Order/order_now'))
	WebUI.delay(2)
	fc.scrollDown()
	
	
	// Đợi bảng đơn hàng hiển thị
	WebUI.waitForElementVisible(findTestObject('Object Repository/User/Order/order_result_table'), 10)
	
	// Lấy dữ liệu từ bảng đơn hàng
	TestObject orderTable = findTestObject('Object Repository/User/Order/order_result_table')
	List<WebElement> orderRows = WebUiCommonHelper.findWebElements(orderTable, 10)
	
	if (orderRows.size() > 0) {
		WebElement row = orderRows[0]
		List<WebElement> cols = row.findElements(By.tagName('td'))
	
		String orderCode = cols[0].getText().trim()
		String orderDate = cols[1].getText().trim()
		String totalPrice = cols[2].getText().trim()
		String paymentMethod = cols[3].getText().trim()
		String status = cols[4].getText().trim()
	
		// Ghi thông tin đơn hàng vào Excel
		util.setData(excelPath, 'Order_Code', orderCode)
		util.setData(excelPath, 'Order_Date', orderDate)
		util.setData(excelPath, 'Order_Total', totalPrice)
		util.setData(excelPath, 'Order_Payment', paymentMethod)
		util.setData(excelPath, 'Order_Status', status)
	
		// Kiểm tra trạng thái đơn hàng
		WebUI.verifyMatch(status.toUpperCase(), 'PENDING', false)

	} else {
		return false
	}
	
	String expectedCode = util.getData(excelPath, 'Order_Code')
	String expectedTotal = util.getData(excelPath, 'Order_Total')
	String expectedStatus = util.getData(excelPath, 'Order_Status')
	String expectedPayment = util.getData(excelPath, 'Order_Payment')
	
	// Lấy dữ liệu từ bảng đơn hàng
	TestObject ListDetail = findTestObject('Object Repository/User/Order/List_Button_View_Detail')
	List<WebElement> btnDetail = WebUiCommonHelper.findWebElements(ListDetail, 10)

	// Click vào nút "Xem chi tiết" đầu tiên nếu tồn tại
	if (btnDetail.size() > 0) {
		btnDetail[0].click()
		fc.scrollDown()
		WebUI.delay(2)
	
		// Lấy text hiển thị
	String actualCode = WebUI.getText(findTestObject('Object Repository/User/Order/Detail_Code')).trim()
	//String actualTotal = WebUI.getText(findTestObject('Object Repository/User/Order/Detail_Total')).trim()
	String actualStatus = WebUI.getText(findTestObject('Object Repository/User/Order/Detail_Status')).trim()
	String actualPayment = WebUI.getText(findTestObject('Object Repository/User/Order/Detail_Payment')).trim()
	
	// So sánh dữ liệu chi tiết đơn hàng
	WebUI.verifyMatch(actualCode.replace('#', ''), expectedCode.replace('#', ''), false)
//	WebUI.verifyMatch(actualTotal.replace('.0', ''), expectedTotal.replace('.0', ''), false)
	WebUI.verifyMatch(actualStatus.toUpperCase(), expectedStatus.toUpperCase(), false)
	WebUI.verifyMatch(actualPayment.toUpperCase(), expectedPayment.toUpperCase(), false)
	} else {
		assert false
	}
	
	
	
	
	


	
	
	
	
	
	
	
	
	
	
	
