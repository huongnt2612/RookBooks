import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

	
//	new openPage().navigateToHomePage()
	generalFunction fc = new generalFunction()
	dataFileUtil util = new dataFileUtil()
	String excelPath = 'Data Files/Data.xlsx'
	
	WebUI.delay(3)
	WebUI.click(findTestObject('Object Repository/HomePage/btn_search'))
	WebUI.delay(2)
	fc.scrollDown()
	
	String baseXpath = findTestObject('Object Repository/Search/list_search_categories').findPropertyValue('xpath')
	WebDriver driver = DriverFactory.getWebDriver()
	List<WebElement> ListCategoriesSearch = driver.findElements(By.xpath(baseXpath))
	
	'1. Search theo danh mục Sci-fi'
	WebUI.delay(2)
	ListCategoriesSearch[0].click()
	WebUI.delay(3)
	fc.scrollDown()
	WebUI.click(findTestObject('Object Repository/Search/btn_search'))
	WebUI.delay(5)
	fc.scrollDown()
	WebUI.verifyElementText(findTestObject('Object Repository/Search/tittle_categories_searched'), "Sci-Fi's Products", FailureHandling.CONTINUE_ON_FAILURE)
	
	String baseXpath1 = findTestObject('Object Repository/Search/list_product_searched').findPropertyValue('xpath')
	List<WebElement> ListSeached = driver.findElements(By.xpath(baseXpath1))
	if (ListSeached.size() > 0) {
		ListSeached[0].click()
		WebUI.delay(3)
		fc.scrollDown()
		fc.scrollDown()
		WebUI.verifyElementVisible(findTestObject('Object Repository/Search/categoriy_detai'), FailureHandling.CONTINUE_ON_FAILURE)
		String categoryScifi = WebUI.getText(findTestObject('Object Repository/Search/catgories_value'))
		
		util.setData(excelPath, 'categoryScifi', categoryScifi)
		
		String savedCategory = util.getData(excelPath, 'categoryScifi')
		WebUI.verifyMatch(savedCategory, categoryScifi, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/Search/catgories_value'))
		WebUI.delay(2)
		fc.scrollDown()
		WebUI.verifyElementText(findTestObject('Object Repository/Search/tittle_categories_searched'), "Sci-Fi's Products", FailureHandling.CONTINUE_ON_FAILURE)

	} else {
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/Search/list_product_searched'), 5, FailureHandling.CONTINUE_ON_FAILURE)
	}


	
	//2. Search theo danh mục Fiction's Products '
	WebUI.delay(2)
	baseXpath = findTestObject('Object Repository/Search/list_search_categories').findPropertyValue('xpath')
	ListCategoriesSearch = driver.findElements(By.xpath(baseXpath))
	ListCategoriesSearch[1].click()
	WebUI.delay(3)
	fc.scrollDown()
	WebUI.click(findTestObject('Object Repository/Search/btn_search'))
	WebUI.delay(2)
	fc.scrollDown()
	WebUI.verifyElementText(findTestObject('Object Repository/Search/tittle_categories_searched'), "Fiction's Products", FailureHandling.CONTINUE_ON_FAILURE)
	baseXpath1 = findTestObject('Object Repository/Search/list_product_searched').findPropertyValue('xpath')
	ListSeached = driver.findElements(By.xpath(baseXpath1))
	// Kiểm tra kết quả
	if (ListSeached.size() > 0) {
		ListSeached[0].click()
		WebUI.delay(3)
		fc.scrollDown()
		fc.scrollDown()
		WebUI.verifyElementVisible(findTestObject('Object Repository/Search/categoriy_detai'), FailureHandling.CONTINUE_ON_FAILURE)
	
		String categoryFiction = WebUI.getText(findTestObject('Object Repository/Search/catgories_value'))
	
		util.setData(excelPath, 'categoryFiction', categoryFiction)
		
		String savedCategory2 = util.getData(excelPath, 'categoryFiction')
		WebUI.verifyMatch(savedCategory2, categoryFiction, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/Search/catgories_value'))
		WebUI.delay(2)
		fc.scrollDown()
		WebUI.verifyElementText(findTestObject('Object Repository/Search/tittle_categories_searched'), "Fiction's Products", FailureHandling.CONTINUE_ON_FAILURE)
		
	
		
	} else {
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/Search/list_product_searched'), 5, FailureHandling.CONTINUE_ON_FAILURE)
	}
	

	
	'3. Search theo danh mục Romance '
	WebUI.delay(2)
	baseXpath = findTestObject('Object Repository/Search/list_search_categories').findPropertyValue('xpath')
	ListCategoriesSearch = driver.findElements(By.xpath(baseXpath))
	ListCategoriesSearch[2].click()
	fc.scrollDown()
	WebUI.click(findTestObject('Object Repository/Search/btn_search'))
	WebUI.delay(2)
	fc.scrollDown()
	WebUI.verifyElementText(findTestObject('Object Repository/Search/tittle_categories_searched'), "Romance's Products", FailureHandling.CONTINUE_ON_FAILURE)
	baseXpath1 = findTestObject('Object Repository/Search/list_product_searched').findPropertyValue('xpath')
	ListSeached = driver.findElements(By.xpath(baseXpath1))
	// Kiểm tra kết quả
	if (ListSeached.size() > 0) {
		ListSeached[0].click()
		WebUI.delay(3)
		fc.scrollDown()
		fc.scrollDown()
		WebUI.verifyElementVisible(findTestObject('Object Repository/Search/categoriy_detai'), FailureHandling.CONTINUE_ON_FAILURE)
	
		String categoryRomance = WebUI.getText(findTestObject('Object Repository/Search/catgories_value'))
	
		util.setData(excelPath, 'categoryRomance', categoryRomance)
		
		String savedCategory3 = util.getData(excelPath, 'categoryRomance')
		WebUI.verifyMatch(savedCategory3, categoryRomance, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/Search/catgories_value'))
		WebUI.delay(2)
		fc.scrollDown()
		WebUI.verifyElementText(findTestObject('Object Repository/Search/tittle_categories_searched'), "Romance's Products", FailureHandling.CONTINUE_ON_FAILURE)
		
	
	} else {
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/Search/list_product_searched'), 5, FailureHandling.CONTINUE_ON_FAILURE)
	}
	
	
	'4. Search theo danh mục Historical Fiction '
	WebUI.delay(2)
	baseXpath = findTestObject('Object Repository/Search/list_search_categories').findPropertyValue('xpath')
	ListCategoriesSearch = driver.findElements(By.xpath(baseXpath))
	ListCategoriesSearch[4].click()
	fc.scrollDown()
	WebUI.click(findTestObject('Object Repository/Search/btn_search'))
	WebUI.delay(2)
	fc.scrollDown()
	WebUI.verifyElementText(findTestObject('Object Repository/Search/tittle_categories_searched'), "Historical Fiction's Products", FailureHandling.CONTINUE_ON_FAILURE)
	baseXpath1 = findTestObject('Object Repository/Search/list_product_searched').findPropertyValue('xpath')
	ListSeached = driver.findElements(By.xpath(baseXpath1))
	// Kiểm tra kết quả
	if (ListSeached.size() > 0) {
		ListSeached[0].click()
		WebUI.delay(3)
		fc.scrollDown()
		fc.scrollDown()
		WebUI.verifyElementVisible(findTestObject('Object Repository/Search/categoriy_detai'), FailureHandling.CONTINUE_ON_FAILURE)
	
		String categoryHistoricalFiction = WebUI.getText(findTestObject('Object Repository/Search/catgories_value'))
	
		util.setData(excelPath, 'categoryHistoricalFiction', categoryHistoricalFiction)
		
		String savedCategory4 = util.getData(excelPath, 'categoryHistoricalFiction')
		WebUI.verifyMatch(savedCategory4, categoryHistoricalFiction, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/Search/catgories_value'))
		WebUI.delay(2)
		fc.scrollDown()
	WebUI.verifyElementText(findTestObject('Object Repository/Search/tittle_categories_searched'), "Historical Fiction's Products", FailureHandling.CONTINUE_ON_FAILURE)
	
	} else {
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/Search/list_product_searched'), 5, FailureHandling.CONTINUE_ON_FAILURE)
	}
	
	'5. Search theo danh mục Horror '
	WebUI.delay(2)
	baseXpath = findTestObject('Object Repository/Search/list_search_categories').findPropertyValue('xpath')
	ListCategoriesSearch = driver.findElements(By.xpath(baseXpath))
	ListCategoriesSearch[3].click()
	fc.scrollDown()
	WebUI.click(findTestObject('Object Repository/Search/btn_search'))
	WebUI.delay(2)
	fc.scrollDown()
	WebUI.verifyElementText(findTestObject('Object Repository/Search/tittle_categories_searched'), "Horror's Products", FailureHandling.CONTINUE_ON_FAILURE)
	baseXpath1 = findTestObject('Object Repository/Search/list_product_searched').findPropertyValue('xpath')
	ListSeached = driver.findElements(By.xpath(baseXpath1))
	// Kiểm tra kết quả
	if (ListSeached.size() > 0) {
		ListSeached[0].click()
		WebUI.delay(3)
		fc.scrollDown()
		fc.scrollDown()
		WebUI.verifyElementVisible(findTestObject('Object Repository/Search/categoriy_detai'), FailureHandling.CONTINUE_ON_FAILURE)
	
		String categoryHorror = WebUI.getText(findTestObject('Object Repository/Search/catgories_value'))
	
		util.setData(excelPath, 'categoryHorror', categoryHorror)
		
		String savedCategory5 = util.getData(excelPath, 'categoryHorror')
		WebUI.verifyMatch(savedCategory5, categoryHorror, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/Search/catgories_value'))
		WebUI.delay(2)
		fc.scrollDown()
		WebUI.verifyElementText(findTestObject('Object Repository/Search/tittle_categories_searched'), "Horror's Products", FailureHandling.CONTINUE_ON_FAILURE)
	
	} else {
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/Search/list_product_searched'), 5, FailureHandling.CONTINUE_ON_FAILURE)
	}
	
	
	'6. Search theo danh mục Fantasy '
	WebUI.delay(2)
	baseXpath = findTestObject('Object Repository/Search/list_search_categories').findPropertyValue('xpath')
	ListCategoriesSearch = driver.findElements(By.xpath(baseXpath))
	ListCategoriesSearch[5].click()
	fc.scrollDown()
	WebUI.click(findTestObject('Object Repository/Search/btn_search'))
	WebUI.delay(2)
	fc.scrollDown()
	WebUI.verifyElementText(findTestObject('Object Repository/Search/tittle_categories_searched'), "Fantasy's Products", FailureHandling.CONTINUE_ON_FAILURE)
	baseXpath1 = findTestObject('Object Repository/Search/list_product_searched').findPropertyValue('xpath')
	ListSeached = driver.findElements(By.xpath(baseXpath1))
	// Kiểm tra kết quả
	if (ListSeached.size() > 0) {
		ListSeached[0].click()
		WebUI.delay(3)
		fc.scrollDown()
		fc.scrollDown()
		WebUI.verifyElementVisible(findTestObject('Object Repository/Search/categoriy_detai'), FailureHandling.CONTINUE_ON_FAILURE)
	
		String categoryFantasy = WebUI.getText(findTestObject('Object Repository/Search/catgories_value'))
	
		util.setData(excelPath, 'categoryHorror', categoryFantasy)
		
		String savedCategory6 = util.getData(excelPath, 'categoryFantasy')
		WebUI.verifyMatch(savedCategory6, categoryFantasy, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/Search/catgories_value'))
		WebUI.delay(2)
		fc.scrollDown()
		WebUI.verifyElementText(findTestObject('Object Repository/Search/tittle_categories_searched'), "Fantasy's Products", FailureHandling.CONTINUE_ON_FAILURE)
	
	} else {
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/Search/list_product_searched'), 5, FailureHandling.CONTINUE_ON_FAILURE)
	}
	
	
	'7 Search theo danh mục Manga'
	WebUI.delay(2)
	baseXpath = findTestObject('Object Repository/Search/list_search_categories').findPropertyValue('xpath')
	ListCategoriesSearch = driver.findElements(By.xpath(baseXpath))
	ListCategoriesSearch[6].click()
	fc.scrollDown()
	WebUI.click(findTestObject('Object Repository/Search/btn_search'))
	WebUI.delay(2)
	fc.scrollDown()
	WebUI.verifyElementText(findTestObject('Object Repository/Search/tittle_categories_searched'), "Manga's Products", FailureHandling.CONTINUE_ON_FAILURE)
	baseXpath1 = findTestObject('Object Repository/Search/list_product_searched').findPropertyValue('xpath')
	ListSeached = driver.findElements(By.xpath(baseXpath1))
	// Kiểm tra kết quả
	if (ListSeached.size() > 0) {
		ListSeached[0].click()
		WebUI.delay(3)
		fc.scrollDown()
		fc.scrollDown()
		WebUI.verifyElementVisible(findTestObject('Object Repository/Search/categoriy_detai'), FailureHandling.CONTINUE_ON_FAILURE)
	
		String categoryManga= WebUI.getText(findTestObject('Object Repository/Search/catgories_value'))
	
		util.setData(excelPath, 'categoryManga', categoryManga)
		
		String savedCategory7 = util.getData(excelPath, 'categoryManga')
		WebUI.verifyMatch(savedCategory7, categoryManga, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/Search/catgories_value'))
		WebUI.delay(2)
		fc.scrollDown()
		WebUI.verifyElementText(findTestObject('Object Repository/Search/tittle_categories_searched'), "Manga's Products", FailureHandling.CONTINUE_ON_FAILURE)
	
	} else {
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/Search/list_product_searched'), 5, FailureHandling.CONTINUE_ON_FAILURE)
	}
	
	
	'8 Search theo danh mục Mystery'
	WebUI.delay(2)
	baseXpath = findTestObject('Object Repository/Search/list_search_categories').findPropertyValue('xpath')
	ListCategoriesSearch = driver.findElements(By.xpath(baseXpath))
	ListCategoriesSearch[7].click()
	fc.scrollDown()
	WebUI.click(findTestObject('Object Repository/Search/btn_search'))
	WebUI.delay(2)
	fc.scrollDown()
	WebUI.verifyElementText(findTestObject('Object Repository/Search/tittle_categories_searched'), "Mystery's Products", FailureHandling.CONTINUE_ON_FAILURE)
	baseXpath1 = findTestObject('Object Repository/Search/list_product_searched').findPropertyValue('xpath')
	ListSeached = driver.findElements(By.xpath(baseXpath1))
	// Kiểm tra kết quả
	if (ListSeached.size() > 0) {
		ListSeached[0].click()
		WebUI.delay(3)
		fc.scrollDown()
		fc.scrollDown()
		WebUI.verifyElementVisible(findTestObject('Object Repository/Search/categoriy_detai'), FailureHandling.CONTINUE_ON_FAILURE)
	
		String categoryMystery= WebUI.getText(findTestObject('Object Repository/Search/catgories_value'))
	
		util.setData(excelPath, 'categoryManga', categoryMystery)
		
		String savedCategory8 = util.getData(excelPath, 'categoryMystery')
		WebUI.verifyMatch(savedCategory8, categoryMystery, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/Search/catgories_value'))
		WebUI.delay(2)
		fc.scrollDown()
		WebUI.verifyElementText(findTestObject('Object Repository/Search/tittle_categories_searched'), "Mystery's Products", FailureHandling.CONTINUE_ON_FAILURE)
	
	} else {
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/Search/list_product_searched'), 5, FailureHandling.CONTINUE_ON_FAILURE)
	}
	
	'9 Search theo danh mục Adventure'
	WebUI.delay(2)
	baseXpath = findTestObject('Object Repository/Search/list_search_categories').findPropertyValue('xpath')
	ListCategoriesSearch = driver.findElements(By.xpath(baseXpath))
	ListCategoriesSearch[8].click()
	fc.scrollDown()
	WebUI.click(findTestObject('Object Repository/Search/btn_search'))
	WebUI.delay(2)
	fc.scrollDown()
	WebUI.verifyElementText(findTestObject('Object Repository/Search/tittle_categories_searched'), "Adventure's Products", FailureHandling.CONTINUE_ON_FAILURE)
	baseXpath1 = findTestObject('Object Repository/Search/list_product_searched').findPropertyValue('xpath')
	ListSeached = driver.findElements(By.xpath(baseXpath1))
	// Kiểm tra kết quả
	if (ListSeached.size() > 0) {
		ListSeached[0].click()
		WebUI.delay(3)
		fc.scrollDown()
		fc.scrollDown()
		WebUI.verifyElementVisible(findTestObject('Object Repository/Search/categoriy_detai'), FailureHandling.CONTINUE_ON_FAILURE)
	
		String categoryAdventure= WebUI.getText(findTestObject('Object Repository/Search/catgories_value'))
	
		util.setData(excelPath, 'categoryAdventure', categoryAdventure)
		
		String savedCategory9 = util.getData(excelPath, 'categoryAdventure')
		WebUI.verifyMatch(savedCategory9, categoryAdventure, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/Search/catgories_value'))
		WebUI.delay(2)
		fc.scrollDown()
		WebUI.verifyElementText(findTestObject('Object Repository/Search/tittle_categories_searched'), "Adventure's Products", FailureHandling.CONTINUE_ON_FAILURE)
	
	} else {
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/Search/list_product_searched'), 5, FailureHandling.CONTINUE_ON_FAILURE)
	}
	
	'10 Search theo danh mục Text book'
	WebUI.delay(2)
	baseXpath = findTestObject('Object Repository/Search/list_search_categories').findPropertyValue('xpath')
	ListCategoriesSearch = driver.findElements(By.xpath(baseXpath))
	ListCategoriesSearch[9].click()
	fc.scrollDown()
	WebUI.click(findTestObject('Object Repository/Search/btn_search'))
	WebUI.delay(2)
	fc.scrollDown()
	WebUI.verifyElementText(findTestObject('Object Repository/Search/tittle_categories_searched'), "Text book's Products", FailureHandling.CONTINUE_ON_FAILURE)
	baseXpath1 = findTestObject('Object Repository/Search/list_product_searched').findPropertyValue('xpath')
	ListSeached = driver.findElements(By.xpath(baseXpath1))
	// Kiểm tra kết quả
	if (ListSeached.size() > 0) {
		ListSeached[0].click()
		WebUI.delay(3)
		fc.scrollDown()
		fc.scrollDown()
		WebUI.verifyElementVisible(findTestObject('Object Repository/Search/categoriy_detai'), FailureHandling.CONTINUE_ON_FAILURE)
	
		String categoryTextbook= WebUI.getText(findTestObject('Object Repository/Search/catgories_value'))
	
		util.setData(excelPath, 'categoryTextbook', categoryTextbook)
		
		String savedCategory10 = util.getData(excelPath, 'categoryTextbook')
		WebUI.verifyMatch(savedCategory10, categoryTextbook, false, FailureHandling.CONTINUE_ON_FAILURE)
		WebUI.click(findTestObject('Object Repository/Search/catgories_value'))
		WebUI.delay(2)
		fc.scrollDown()
		WebUI.verifyElementText(findTestObject('Object Repository/Search/tittle_categories_searched'), "Text book's Products", FailureHandling.CONTINUE_ON_FAILURE)
	
	} else {
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/Search/list_product_searched'), 5, FailureHandling.CONTINUE_ON_FAILURE)
	}
	
	
	
	
	
	

