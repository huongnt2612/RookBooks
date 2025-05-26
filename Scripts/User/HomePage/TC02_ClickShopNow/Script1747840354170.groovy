import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject


	WebUI.scrollToElement(findTestObject('Homepage/Button_ShopNow'), 5)
	
	WebUI.waitForElementClickable(findTestObject('Homepage/Button_ShopNow'), 10)
	
	WebUI.click(findTestObject('Homepage/Button_ShopNow'))
	
	WebUI.verifyMatch(WebUI.getUrl(), '.*shop.*', true)
	
	WebUI.closeBrowser()