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

	' Xác minh danh mục "BÁN CHẠY NHẤT" có hiển thị'
	WebUI.verifyElementText(findTestObject('HomePage/tittle_category_1'), 'BÁN CHẠY NHẤT')
	WebUI.verifyElementPresent(findTestObject('HomePage/category_item_1'), 10)
	
	fc.scrollDown()
	WebUI.verifyElementText(findTestObject('Object Repository/HomePage/tittle_category_2'), 'SÁCH MỚI')
	fc.scrollUp()
	
//	'Lấy danh sách sản phẩm'
//	String baseXpath = findTestObject('HomePage/category_item_1').findPropertyValue('xpath')
//	WebDriver driver = DriverFactory.getWebDriver()
//	List<WebElement> productList = driver.findElements(By.xpath(baseXpath))
//	
//	
//	for (int i = 0; i < productList.size(); i++) {
//		WebElement item = productList[i]
//	
//		String titleXpath = findTestObject('HomePage/list_tittle_books').findPropertyValue('xpath')
//		String currentPriceXpath = findTestObject('HomePage/current_price_item_1').findPropertyValue('xpath')
//		String oldPriceXpath = findTestObject('HomePage/old_price_item_1').findPropertyValue('xpath')
//	
//		// ✅ Verify
//		WebUI.verifyMatch(titleXpath, /.+/, false)
//		WebUI.verifyMatch(currentPriceXpath, /.+/, false)
//		WebUI.verifyMatch(oldPriceXpath, /.+/, false)
//		
//	
//	
//	}
	

