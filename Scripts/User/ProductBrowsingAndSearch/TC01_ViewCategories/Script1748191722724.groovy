import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

	
	new openPage().navigateToHomePage()
	generalFunction fc = new generalFunction()
	dataFileUtil util = new dataFileUtil()
	String excelPath = 'Data Files/Data.xlsx'

	' Xác minh danh mục "BÁN CHẠY NHẤT" có hiển thị'
	WebUI.verifyElementText(findTestObject('User/HomePage/tittle_category_1'), 'BÁN CHẠY NHẤT')
	WebUI.verifyElementPresent(findTestObject('User/HomePage/category_item_1'), 10)
	
	fc.scrollDown()
	' Xác minh danh mục "Sách mới" có hiển thị'
	WebUI.verifyElementText(findTestObject('Object Repository/User/HomePage/tittle_category_2'), 'SÁCH MỚI')
	WebUI.verifyElementPresent(findTestObject('User/HomePage/category_item_2'), 10)
	fc.scrollUp()
	
	// Hover chuột vào block sản phẩm
	
	WebUI.delay(2)
	TestObject productBlock = findTestObject('User/Product/product_block')
	WebUI.mouseOver(productBlock)
	WebUI.delay(1)
	
//	// Kiểm tra các nút hiển thị khi hover
//	WebUI.verifyElementVisible(findTestObject('Object Repository/User/Product/btn_add_to_cart'),  FailureHandling.CONTINUE_ON_FAILURE)
//	WebUI.verifyElementVisible(findTestObject('Object Repository/User/Product/btn_add_to_wishlist_1'), FailureHandling.CONTINUE_ON_FAILURE)
//	WebUI.verifyElementVisible(findTestObject('Object Repository/User/Product/btn_quick_view'),  FailureHandling.CONTINUE_ON_FAILURE)
//	WebUI.verifyElementVisible(findTestObject('Object Repository/User/Product/btn_auto_voice'),  FailureHandling.CONTINUE_ON_FAILURE)
//		



