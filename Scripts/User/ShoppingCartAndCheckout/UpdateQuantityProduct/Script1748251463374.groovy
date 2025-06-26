import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

	generalFunction fc = new generalFunction()
//	WebUI.callTestCase(
//		findTestCase('Test Cases/User/LoginLogout/LO04_login_successfully'),
//		[('username') : GlobalVariable.User_Email, ('password') : GlobalVariable.General_Password]
//	)
//	
	// Mở trang giỏ hàng
	WebUI.delay(2)
		WebUI.click(findTestObject('Object Repository/User/HomePage/icon_cart'))


		fc.scrollDown()
		
	// Tạo TestObject cho list input số lượng (đã có sẵn)
	TestObject qtyInputs = findTestObject('User/Cart/cart_product_quantity_updown')
	
	// Lấy list WebElement tương ứng với TestObject list
	List<WebElement> qtyElements = WebUiCommonHelper.findWebElements(qtyInputs, 10)
	
	// Ví dụ thao tác với ô số lượng đầu tiên
	WebElement firstQtyInput = qtyElements.get(0)
	
	// Lấy giá trị hiện tại
	String qtyBefore = firstQtyInput.getAttribute('value')
	int quantityBefore = Integer.parseInt(qtyBefore)
	
	// Thay đổi số lượng trực tiếp (ví dụ set về 3)
	firstQtyInput.clear()
	firstQtyInput.sendKeys('3')
	
	// Chờ trang xử lý nếu có
	WebUI.delay(1)
	
	// Lấy lại số lượng để verify
	String qtyAfter = firstQtyInput.getAttribute('value')
	int quantityAfter = Integer.parseInt(qtyAfter)
	
	assert quantityAfter == 3 : "Số lượng chưa cập nhật đúng"
	

