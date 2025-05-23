import org.openqa.selenium.WebDriver

import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import generalFunction
import dataFileUtil

	generalFunction fc = new generalFunction()
	dataFileUtil util = new dataFileUtil()
	String excelPath = 'Data Files/Data.xlsx'
	WebDriver driver = DriverFactory.getWebDriver()
	
	WebUI.click('Object Repository/Cart/btn_payment')
	WebUI.delay(2)
	WebUI.verifyElementText(findTestObject('Object Repository/Order/title_order_detail'), 'Chi tiết đơn hàng')
	
	
