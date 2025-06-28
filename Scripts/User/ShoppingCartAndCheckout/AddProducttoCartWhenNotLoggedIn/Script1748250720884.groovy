import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

	generalFunction fc = new generalFunction()
	WebUI.openBrowser('')
	WebUI.navigateToUrl(GlobalVariable.HomePage_url)
	WebUI.maximizeWindow()
	WebUI.delay(2)
	WebUI.deleteAllCookies()
	fc.scrollDown()
	WebUI.delay(2)
	TestObject productBlock = findTestObject('User/Product/product_block')
	WebUI.mouseOver(productBlock)
	WebUI.delay(2)
	
	// click add to cart thi hover
	String baseXpath = findTestObject('User/HomePage/category_item_1').findPropertyValue('xpath')
	
	WebDriver driver = DriverFactory.getWebDriver()
	List<WebElement> productList = driver.findElements(By.xpath(baseXpath))
	productList[0].click()
	fc.scrollDown()
	
	// VERIFY trang chi tiết sản phẩm
	WebUI.verifyElementVisible(findTestObject('Object Repository/User/Product/product_detail_image'))
	WebUI.verifyElementPresent(findTestObject('Object Repository/User/Product/product_tittle'), 10)
	WebUI.verifyElementPresent(findTestObject('Object Repository/User/Product/product_detail_price'), 10)
	
	WebUI.waitForAlert(5)
	String alertText = WebUI.getAlertText()
	WebUI.verifyMatch(alertText, 'Bạn cần đăng nhập trước', false)
	WebUI.acceptAlert()
	WebUI.delay(2)
	fc.scrollDown()
	
	//Kiểm tra hệ thốngchuyển hướng đến trang đăng nhập
	String currentUrl = WebUI.getUrl()
	boolean matched = WebUI.verifyMatch(currentUrl.toLowerCase(), '.*login.*', true, FailureHandling.CONTINUE_ON_FAILURE)

