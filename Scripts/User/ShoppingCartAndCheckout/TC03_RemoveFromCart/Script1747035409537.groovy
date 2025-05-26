import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebDriver

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import generalFunction
import dataFileUtil

	generalFunction fc = new generalFunction()
	dataFileUtil util = new dataFileUtil()
	String excelPath = 'Data Files/Data.xlsx'
	WebDriver driver = DriverFactory.getWebDriver()
	
	'1. Xoa sp đầu tiên'
	WebUI.delay(3)
	WebUI.click(findTestObject('Object Repository/User/Cart/cart_icon_x'))
	fc.scrollDown()
	String expectedTitle1 = util.getData(excelPath, 'AddToCard_Tittle1')
	WebUI.verifyTextNotPresent(expectedTitle1, false, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyElementVisible(findTestObject('Object Repository/User/Cart/btn_payment'), FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyElementVisible(findTestObject('Object Repository/User/Cart/btn_cart_total_amount'), FailureHandling.CONTINUE_ON_FAILURE)
	
	'1. Xoa sp thứ 2'
	WebUI.delay(3)
	WebUI.click(findTestObject('Object Repository/User/Cart/cart_icon_x'))
	fc.scrollDown()
	String expectedTitle2 = util.getData(excelPath, 'AddToCard_Tittle2')
	WebUI.verifyTextNotPresent(expectedTitle2, false, FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyElementVisible(findTestObject('Object Repository/User/Cart/btn_payment'), FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.verifyElementVisible(findTestObject('Object Repository/User/Cart/btn_cart_total_amount'), FailureHandling.CONTINUE_ON_FAILURE)
	
	
