import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys


	new openPage().navigateToHomePage()
	generalFunction fc = new generalFunction()
	dataFileUtil util = new dataFileUtil()
	String excelPath = 'Data Files/Data.xlsx'
	
	String fullName = "Thanh Hường"
	String email = "huong@gmail.com"
	String subject = "send contact"
	String message = "send contact message"
	
	WebUI.click(findTestObject('Object Repository/User/HomePage/nav_contact'))
	WebUI.delay(2)
	fc.scrollDown()
	
	'1. full content'
	// Điền form Contact - bạn thay đúng TestObject tên các trường
	WebUI.setText(findTestObject('Object Repository/User/wishlistAndContact/textbox_fullname'), fullName)
	WebUI.setText(findTestObject('Object Repository/User/wishlistAndContact/textbox_email'), email)
	WebUI.setText(findTestObject('Object Repository/User/wishlistAndContact/textbox_tittle'), subject)
	WebUI.setText(findTestObject('Object Repository/User/wishlistAndContact/textbox_msg'), message)
	
	WebUI.click(findTestObject('Object Repository/User/wishlistAndContact/btn_send_contact'))
	fc.scrollDown()
	
	WebUI.verifyEqual(findTestObject('Object Repository/User/wishlistAndContact/contact_message'), 'Cảm ơn bạn đã liên hệ')
	

	

	
	
	
	
	