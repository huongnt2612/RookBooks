import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

	// Đăng nhập
	WebUI.callTestCase(findTestCase('Test Cases/Admin/LoginLogout/LO02_login_successfully'),
		[('username') : GlobalVariable.Admin_Email, ('password') : GlobalVariable.General_Password])
	
	// Truy cập Quản lý sản phẩm
	WebUI.click(findTestObject('Object Repository/User/HomePage/icon_Accounts'))
	WebUI.verifyElementVisible(findTestObject('Object Repository/User/HomePage/icon_admin'))
	WebUI.click(findTestObject('Object Repository/User/HomePage/icon_admin'))
	WebUI.delay(2)
	WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/Button_Product'))
	WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/Button_Product_Management'))
	WebUI.verifyElementText(findTestObject('Object Repository/Admin/ProductManagement/Tittle_Product_Management'), 'Danh sách sản phẩm')
	
	// Đến trang cuối
	WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/Paging_Last'))
	WebUI.delay(1)
	
	// === CLICK NÚT "KHÔNG BÁN" CUỐI CÙNG ===
	TestObject btnStopSelling = findTestObject('Object Repository/Admin/ProductManagement/List_Button_Product_NotForSale')
	List<WebElement> stopButtons = WebUiCommonHelper.findWebElements(btnStopSelling, 10)
	
	if (stopButtons.size() > 0) {
		WebElement lastStopButton = stopButtons.get(stopButtons.size() - 1)
		WebUI.executeJavaScript("arguments[0].scrollIntoView(true);", Arrays.asList(lastStopButton))
		WebUI.delay(1)
		WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(lastStopButton))
	
		// Xác nhận popup – Hủy lần 1
		WebUI.waitForElementVisible(findTestObject('Object Repository/Admin/ProductManagement/Popup_NotForSale_Confirm'), 5)
		WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/Popup_btn_Cancel'))
	
		// Click lại nút "Không bán"
		stopButtons = WebUiCommonHelper.findWebElements(btnStopSelling, 10)
		lastStopButton = stopButtons.get(stopButtons.size() - 1)
		WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(lastStopButton))
	
		WebUI.waitForElementVisible(findTestObject('Object Repository/Admin/ProductManagement/Popup_NotForSale_Confirm'), 5)
		WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/Popup_btn_update'))
		WebUI.delay(2)
	
		// Kiểm tra lại trạng thái là "Kích hoạt"
		WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/Paging_Last'))
		WebUI.delay(1)
		stopButtons = WebUiCommonHelper.findWebElements(btnStopSelling, 10)
		String statusText = stopButtons.get(stopButtons.size() - 1).getText().trim()
	
		if (statusText.equalsIgnoreCase("Kích hoạt")) {
			WebUI.comment("Sản phẩm đã chuyển sang trạng thái KHÔNG BÁN thành công.")
		} else {
			WebUI.comment("Trạng thái không đúng sau khi Không bán: " + statusText)
		}
	
	
	
	} else {
		WebUI.comment("Không tìm thấy nút 'Không bán' hoặc 'Kích hoạt'.")
	}
	
	if (stopButtons.size() > 0) {
		// === CLICK NÚT "KÍCH HOẠT" CUỐI CÙNG ===
		WebElement lastReactivateButton = stopButtons.get(stopButtons.size() - 1)
		WebUI.executeJavaScript("arguments[0].scrollIntoView(true);", Arrays.asList(lastReactivateButton))
		WebUI.delay(1)
		WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(lastReactivateButton))
	
		WebUI.waitForElementVisible(findTestObject('Object Repository/Admin/ProductManagement/Popup_NotForSale_Confirm'), 5)
		WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/Popup_btn_Cancel'))
	
		// Click lại lần 2
		stopButtons = WebUiCommonHelper.findWebElements(btnStopSelling, 10)
		lastReactivateButton = stopButtons.get(stopButtons.size() - 1)
		WebUI.executeJavaScript("arguments[0].click();", Arrays.asList(lastReactivateButton))
	
		WebUI.waitForElementVisible(findTestObject('Object Repository/Admin/ProductManagement/Popup_NotForSale_Confirm'), 5)
		WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/Popup_btn_update'))
		WebUI.delay(2)
	
		// Kiểm tra lại trạng thái là "Không bán"
		WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/Paging_Last'))
		WebUI.delay(1)
		stopButtons = WebUiCommonHelper.findWebElements(btnStopSelling, 10)
		statusText = stopButtons.get(stopButtons.size() - 1).getText().trim()
	
		if (statusText.equalsIgnoreCase("Không bán")) {
			WebUI.comment("Sản phẩm đã KÍCH HOẠT lại thành công.")
		} else {
			WebUI.comment("Trạng thái không đúng sau khi Kích hoạt: " + statusText)
		}
	
	
	
	} else {
		WebUI.comment("Không tìm thấy nút 'Không bán' hoặc 'Kích hoạt'.")
	}
	