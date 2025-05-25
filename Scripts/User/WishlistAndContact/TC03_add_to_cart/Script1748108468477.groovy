import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

	generalFunction fc = new generalFunction()
	dataFileUtil util = new dataFileUtil()
	String excelPath = 'Data Files/Data.xlsx'
	WebDriver driver = DriverFactory.getWebDriver()
	
	String baseXpath = findTestObject('Object Repository/User/Account/wishlist_btn_add_cart').findPropertyValue('xpath')
	List<WebElement> buttonList = driver.findElements(By.xpath(baseXpath))
	
	// Duyệt và click từng button
	for (int i = 0; i < buttonList.size(); i++) {
		buttonList[i].click()		
		// Chờ và xử lý alert
		WebUI.waitForAlert(5)
		String alertText = WebUI.getAlertText()
		WebUI.verifyMatch(alertText, 'Thêm sản phẩm vào giỏ thành công', false)
		WebUI.acceptAlert()
		WebUI.delay(1)
	}
	
	WebUI.click(findTestObject('Object Repository/User/HomePage/icon_cart'))
	fc.scrollDown()
	
	String cartNameListXpath = findTestObject('Object Repository/User/Cart/list_product_name').findPropertyValue('xpath')
	List<WebElement> cartNameList = driver.findElements(By.xpath(cartNameListXpath))
	
	String cartPriceListXpath = findTestObject('Object Repository/User/Cart/list_product_price').findPropertyValue('xpath')
	List<WebElement> cartPriceList = driver.findElements(By.xpath(cartPriceListXpath))
	
	for (int i = 0; i < cartNameList.size(); i++) {
	    int indexExcel = i + 1
	    String expectedTitle = util.getData(excelPath, "AddToWishlist_Tittle" + indexExcel)
	    String expectedPrice = util.getData(excelPath, "AddToWishlist_Price" + indexExcel)
	
	    String actualTitle = cartNameList.get(i).getText()
	    String actualPrice = cartPriceList.get(i).getText()
	
	    WebUI.verifyMatch(actualTitle, expectedTitle, false, FailureHandling.CONTINUE_ON_FAILURE)
	    WebUI.verifyMatch(actualPrice, expectedPrice, false, FailureHandling.CONTINUE_ON_FAILURE)
	}

	
	WebUI.verifyElementVisible(findTestObject('Object Repository/User/Cart/cart_icon_x'), FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyElementVisible(findTestObject('Object Repository/User/Cart/btn_payment'), FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyElementVisible(findTestObject('Object Repository/User/Cart/btn_cart_total_amount'), FailureHandling.CONTINUE_ON_FAILURE)
	
	
	
