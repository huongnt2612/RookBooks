import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

	WebUI.callTestCase(
		findTestCase('Test Cases/User/LoginLogout/LO04_login_successfully'),
		[('username') : GlobalVariable.User_Email, ('password') : GlobalVariable.General_Password]
	)
	
	generalFunction fc = new generalFunction()
	dataFileUtil util = new dataFileUtil()
	String excelPath = 'Data Files/Data.xlsx'

	String expectedCode = util.getData(excelPath, 'Order_Code')
	String expectedDate = util.getData(excelPath, 'Order_Date')
	String expectedTotal = util.getData(excelPath, 'Order_Total')
	String expectedPayment = util.getData(excelPath, 'Order_Payment')
	String expectedStatus = util.getData(excelPath, 'Order_Status')
	
	WebUI.click(findTestObject('Object Repository/User/HomePage/icon_Accounts'))
	WebUI.delay(2)
	WebUI.click(findTestObject('Object Repository/User/HomePage/icon_Account_Btn_Order'))
	fc.scrollDown()
		
		// Lấy bảng đơn hàng
	TestObject orderTable = findTestObject('Object Repository/User/Order/Order_tableRows')
	List<WebElement> orderRows = WebUiCommonHelper.findWebElements(orderTable, 10)
	
	if (orderRows.size() > 0) {
		WebElement row = orderRows[0]
		List<WebElement> cols = row.findElements(By.tagName('td'))
	
		String orderCode = cols[0].getText().trim()
		String orderDate = cols[1].getText().trim()
		String totalPrice = cols[2].getText().trim()
		String paymentMethod = cols[3].getText().trim()
		String status = cols[4].getText().trim()
	
		// Ghi dữ liệu đơn hàng vào Excel nếu cần
		util.setData(excelPath, 'OrderVNPay_Code', orderCode)
		util.setData(excelPath, 'OrderVNPay_Date', orderDate)
		util.setData(excelPath, 'OrderVNPay_Total', totalPrice)
		util.setData(excelPath, 'OrderVNPay_Payment', paymentMethod)
		util.setData(excelPath, 'OrderVNPay_Status', status)
	
		// So sánh với dữ liệu kỳ vọng
		WebUI.verifyMatch(orderCode, expectedCode, false)
		WebUI.verifyMatch(orderDate, expectedDate, false)
		WebUI.verifyMatch(totalPrice, expectedTotal, false)
		WebUI.verifyMatch(paymentMethod.toUpperCase(), expectedPayment.toUpperCase(), false)
		WebUI.verifyMatch(status.toUpperCase(), expectedStatus.toUpperCase(), false)
	
	} else {
		assert false
	}