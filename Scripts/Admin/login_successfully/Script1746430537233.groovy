import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable


	WebUI.openBrowser('')
	WebUI.navigateToUrl('http://localhost:8080/login') 
	
	WebUI.setText('Object Repository/Login/Email', GlobalVariable.Admin_Email) 
	WebUI.setText('Object Repository/Login/Password', GlobalVariable.General_Password)
	WebUI.click('Object Repository/Login/btn_login')
	WebUI.delay(3)
	
	WebUI.click('Object Repository/HomePage/icon_Accounts')
//	WebUI.verifyEqual('Object Repository/Account/account_name', "")
