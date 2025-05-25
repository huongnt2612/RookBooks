import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import dataFileUtil
import openPage
import generalFunction

	
	new openPage().navigateToHomePage()
	generalFunction fc = new generalFunction()
	dataFileUtil util = new dataFileUtil()
	String excelPath = 'Data Files/Data.xlsx'
	
	WebUI.delay(3)
	WebUI.click(findTestObject('Object Repository/User/HomePage/btn_search'), 5)
	WebUI.delay(2)
	fc.scrollDown()
	
	
	
	
	

