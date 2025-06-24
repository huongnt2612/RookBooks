import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

//	WebUI.callTestCase(
//		findTestCase('Test Cases/Admin/LoginLogout/LO02_login_successfully'),
//		[('username') : GlobalVariable.Admin_Email, ('password') : GlobalVariable.General_Password]
//	)
//	
	generalFunction fc = new generalFunction()
	dataFileUtil util = new dataFileUtil()
	String excelPath = 'Data Files/Data.xlsx'
	
//	WebUI.click(findTestObject('Object Repository/User/HomePage/icon_Accounts'))
//	
//	WebUI.verifyElementVisible(findTestObject('Object Repository/User/HomePage/icon_admin'))
//	
//	WebUI.click(findTestObject('Object Repository/User/HomePage/icon_admin'))
//	WebUI.delay(2)
//	WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/Button_Product'))
//	WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/Button_Product_Management'))
//	WebUI.delay(2)
//	
//	WebUI.verifyElementText(findTestObject('Object Repository/Admin/ProductManagement/Tittle_Product_Management'), 'Danh sách sản phẩm')
	
	
	'1. Tim kiem theo danh mục Sci-Fi'
	// Chọn danh mục từ dropdown
	WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/select_Category'))
	String selectedCategory = 'Sci-Fi'
//	WebUI.selectOptionByLabel(findTestObject('Object Repository/Admin/ProductManagement/List_Category_Option'), selectedCategory, false)
	WebUI.selectOptionByLabel(findTestObject('Object Repository/Admin/ProductManagement/select_Category'), selectedCategory, false)
	
	WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/Button_Search'))
	WebUI.delay(2)
	
	// Lấy hàng đầu tiên trong bảng sản phẩm
	TestObject UpdateRows = findTestObject('Object Repository/Admin/ProductManagement/List_Button_Update')
	List<WebElement> btnUpdate = WebUiCommonHelper.findWebElements(UpdateRows, 10)
	if (btnUpdate.size() > 0) {
		btnUpdate.get(0).click()
		WebUI.waitForElementVisible(findTestObject('Object Repository/Admin/ProductManagement/Lable_Add_Product'), 5)
			// Kiểm tra danh mục đúng với lựa chọn tìm kiếm ban đầu
			TestObject dropdown = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//select[@id='categoryId']")
			WebElement dropdownElem = WebUiCommonHelper.findWebElement(dropdown, 10)
			List<WebElement> options = dropdownElem.findElements(By.tagName("option"))
		
	
			String selectedLabel = ""
			for (WebElement opt : options) {
				if (opt.isSelected()) {
					selectedLabel = opt.getText().trim()
					break
				}
			}
			WebUI.verifyMatch(selectedLabel, selectedCategory, false)
		
	} else {
		WebUI.comment("Khong co san pham trong bang")
	}
	
	WebUI.back()
	WebUI.delay(2)
	
	'2. Tìm kiếm danh mục Fiction'
	
	WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/select_Category'))
	 selectedCategory = 'Fiction'
	WebUI.selectOptionByLabel(findTestObject('Object Repository/Admin/ProductManagement/select_Category'), selectedCategory, false)
	
	WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/Button_Search'))
	WebUI.delay(2)
	
		// Lấy hàng đầu tiên trong bảng sản phẩm
	UpdateRows = findTestObject('Object Repository/Admin/ProductManagement/List_Button_Update')
	btnUpdate = WebUiCommonHelper.findWebElements(UpdateRows, 10)
	if (btnUpdate.size() > 0) {
		btnUpdate.get(0).click()
		WebUI.waitForElementVisible(findTestObject('Object Repository/Admin/ProductManagement/Lable_Add_Product'), 5)
			// Kiểm tra danh mục đúng với lựa chọn tìm kiếm ban đầu
			TestObject dropdown = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//select[@id='categoryId']")
			dropdownElem = WebUiCommonHelper.findWebElement(dropdown, 10)
			options = dropdownElem.findElements(By.tagName("option"))
		
	
			String selectedLabel = ""
			for (WebElement opt : options) {
				if (opt.isSelected()) {
					selectedLabel = opt.getText().trim()
					break
				}
			}
			WebUI.verifyMatch(selectedLabel, selectedCategory, false)
		
	} else {
		WebUI.comment("Khong co san pham trong bang")
	}
	
	WebUI.back()
	WebUI.delay(2)
	
	'3. Tìm kiếm danh mục Romance'
	
	WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/select_Category'))
	selectedCategory = 'Romance'
	WebUI.selectOptionByLabel(findTestObject('Object Repository/Admin/ProductManagement/select_Category'), selectedCategory, false)
	
	WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/Button_Search'))
	WebUI.delay(2)
	
	// Lấy hàng đầu tiên trong bảng sản phẩm
	UpdateRows = findTestObject('Object Repository/Admin/ProductManagement/List_Button_Update')
	btnUpdate = WebUiCommonHelper.findWebElements(UpdateRows, 10)
	if (btnUpdate.size() > 0) {
		btnUpdate.get(0).click()
		WebUI.waitForElementVisible(findTestObject('Object Repository/Admin/ProductManagement/Lable_Add_Product'), 5)
			// Kiểm tra danh mục đúng với lựa chọn tìm kiếm ban đầu
			TestObject dropdown = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//select[@id='categoryId']")
			dropdownElem = WebUiCommonHelper.findWebElement(dropdown, 10)
			options = dropdownElem.findElements(By.tagName("option"))
		
	
			String selectedLabel = ""
			for (WebElement opt : options) {
				if (opt.isSelected()) {
					selectedLabel = opt.getText().trim()
					break
				}
			}
			WebUI.verifyMatch(selectedLabel, selectedCategory, false)
		
	} else {
		WebUI.comment("Khong co san pham trong bang")
	}
	
	WebUI.back()
	WebUI.delay(2)
	
	'4. Tìm kiếm danh mục Horror'
	
	WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/select_Category'))
	selectedCategory = 'Horror'
	WebUI.selectOptionByLabel(findTestObject('Object Repository/Admin/ProductManagement/select_Category'), selectedCategory, false)
	
	WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/Button_Search'))
	WebUI.delay(2)
	
		// Lấy hàng đầu tiên trong bảng sản phẩm
	UpdateRows = findTestObject('Object Repository/Admin/ProductManagement/List_Button_Update')
	btnUpdate = WebUiCommonHelper.findWebElements(UpdateRows, 10)
	if (btnUpdate.size() > 0) {
		btnUpdate.get(0).click()
		WebUI.waitForElementVisible(findTestObject('Object Repository/Admin/ProductManagement/Lable_Add_Product'), 5)
			// Kiểm tra danh mục đúng với lựa chọn tìm kiếm ban đầu
			TestObject dropdown = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//select[@id='categoryId']")
			dropdownElem = WebUiCommonHelper.findWebElement(dropdown, 10)
			options = dropdownElem.findElements(By.tagName("option"))
		
	
			String selectedLabel = ""
			for (WebElement opt : options) {
				if (opt.isSelected()) {
					selectedLabel = opt.getText().trim()
					break
				}
			}
			WebUI.verifyMatch(selectedLabel, selectedCategory, false)
		
	} else {
		WebUI.comment("Khong co san pham trong bang")
	}
	
	WebUI.back()
	WebUI.delay(2)
	
	
	'5. Tìm kiếm danh mục Historical Fiction'
	
	WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/select_Category'))
	selectedCategory = 'Historical Fiction'
	WebUI.selectOptionByLabel(findTestObject('Object Repository/Admin/ProductManagement/select_Category'), selectedCategory, false)
	
	WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/Button_Search'))
	WebUI.delay(2)
	
		// Lấy hàng đầu tiên trong bảng sản phẩm
	UpdateRows = findTestObject('Object Repository/Admin/ProductManagement/List_Button_Update')
	btnUpdate = WebUiCommonHelper.findWebElements(UpdateRows, 10)
	if (btnUpdate.size() > 0) {
		btnUpdate.get(0).click()
		WebUI.waitForElementVisible(findTestObject('Object Repository/Admin/ProductManagement/Lable_Add_Product'), 5)
			// Kiểm tra danh mục đúng với lựa chọn tìm kiếm ban đầu
			TestObject dropdown = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//select[@id='categoryId']")
			dropdownElem = WebUiCommonHelper.findWebElement(dropdown, 10)
			options = dropdownElem.findElements(By.tagName("option"))
		
	
			String selectedLabel = ""
			for (WebElement opt : options) {
				if (opt.isSelected()) {
					selectedLabel = opt.getText().trim()
					break
				}
			}
			WebUI.verifyMatch(selectedLabel, selectedCategory, false)
		
	} else {
		WebUI.comment("Khong co san pham trong bang")
	}
	
	WebUI.back()
	WebUI.delay(2)
	
	
	'6. Tìm kiếm danh mục Fantasy'
	
	WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/select_Category'))
	selectedCategory = 'Fantasy'
	WebUI.selectOptionByLabel(findTestObject('Object Repository/Admin/ProductManagement/select_Category'), selectedCategory, false)
	
	WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/Button_Search'))
	WebUI.delay(2)
	
		// Lấy hàng đầu tiên trong bảng sản phẩm
	UpdateRows = findTestObject('Object Repository/Admin/ProductManagement/List_Button_Update')
	btnUpdate = WebUiCommonHelper.findWebElements(UpdateRows, 10)
	if (btnUpdate.size() > 0) {
		btnUpdate.get(0).click()
		WebUI.waitForElementVisible(findTestObject('Object Repository/Admin/ProductManagement/Lable_Add_Product'), 5)
			// Kiểm tra danh mục đúng với lựa chọn tìm kiếm ban đầu
			TestObject dropdown = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//select[@id='categoryId']")
			dropdownElem = WebUiCommonHelper.findWebElement(dropdown, 10)
			options = dropdownElem.findElements(By.tagName("option"))
		
	
			String selectedLabel = ""
			for (WebElement opt : options) {
				if (opt.isSelected()) {
					selectedLabel = opt.getText().trim()
					break
				}
			}
			WebUI.verifyMatch(selectedLabel, selectedCategory, false)
		
	} else {
		WebUI.comment("Khong co san pham trong bang")
	}
	
	WebUI.back()
	WebUI.delay(2)
	
	'7. Tìm kiếm danh mục Manga'
	
	WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/select_Category'))
	selectedCategory = 'Manga'
	WebUI.selectOptionByLabel(findTestObject('Object Repository/Admin/ProductManagement/select_Category'), selectedCategory, false)
	
	WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/Button_Search'))
	WebUI.delay(2)
	
		// Lấy hàng đầu tiên trong bảng sản phẩm
	UpdateRows = findTestObject('Object Repository/Admin/ProductManagement/List_Button_Update')
	btnUpdate = WebUiCommonHelper.findWebElements(UpdateRows, 10)
	if (btnUpdate.size() > 0) {
		btnUpdate.get(0).click()
		WebUI.waitForElementVisible(findTestObject('Object Repository/Admin/ProductManagement/Lable_Add_Product'), 5)
			// Kiểm tra danh mục đúng với lựa chọn tìm kiếm ban đầu
			TestObject dropdown = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//select[@id='categoryId']")
			dropdownElem = WebUiCommonHelper.findWebElement(dropdown, 10)
			options = dropdownElem.findElements(By.tagName("option"))
		
	
			String selectedLabel = ""
			for (WebElement opt : options) {
				if (opt.isSelected()) {
					selectedLabel = opt.getText().trim()
					break
				}
			}
			WebUI.verifyMatch(selectedLabel, selectedCategory, false)
		
	} else {
		WebUI.comment("Khong co san pham trong bang")
	}
	
	WebUI.back()
	WebUI.delay(2)
	
	'8. Tìm kiếm danh mục Mystery'
	
	WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/select_Category'))
	selectedCategory = 'Mystery'
	WebUI.selectOptionByLabel(findTestObject('Object Repository/Admin/ProductManagement/select_Category'), selectedCategory, false)
	
	WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/Button_Search'))
	WebUI.delay(2)
	
		// Lấy hàng đầu tiên trong bảng sản phẩm
	UpdateRows = findTestObject('Object Repository/Admin/ProductManagement/List_Button_Update')
	btnUpdate = WebUiCommonHelper.findWebElements(UpdateRows, 10)
	if (btnUpdate.size() > 0) {
		btnUpdate.get(0).click()
		WebUI.waitForElementVisible(findTestObject('Object Repository/Admin/ProductManagement/Lable_Add_Product'), 5)
			// Kiểm tra danh mục đúng với lựa chọn tìm kiếm ban đầu
			TestObject dropdown = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//select[@id='categoryId']")
			dropdownElem = WebUiCommonHelper.findWebElement(dropdown, 10)
			options = dropdownElem.findElements(By.tagName("option"))
		
	
			String selectedLabel = ""
			for (WebElement opt : options) {
				if (opt.isSelected()) {
					selectedLabel = opt.getText().trim()
					break
				}
			}
			WebUI.verifyMatch(selectedLabel, selectedCategory, false)
		
	} else {
		WebUI.comment("Khong co san pham trong bang")
	}
	
	WebUI.back()
	WebUI.delay(2)
	
	'9. Tìm kiếm danh mục Adventure'
	
	WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/select_Category'))
	selectedCategory = 'Adventure'
	WebUI.selectOptionByLabel(findTestObject('Object Repository/Admin/ProductManagement/select_Category'), selectedCategory, false)
	
	WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/Button_Search'))
	WebUI.delay(2)
	
		// Lấy hàng đầu tiên trong bảng sản phẩm
	UpdateRows = findTestObject('Object Repository/Admin/ProductManagement/List_Button_Update')
	btnUpdate = WebUiCommonHelper.findWebElements(UpdateRows, 10)
	if (btnUpdate.size() > 0) {
		btnUpdate.get(0).click()
		WebUI.waitForElementVisible(findTestObject('Object Repository/Admin/ProductManagement/Lable_Add_Product'), 5)
			// Kiểm tra danh mục đúng với lựa chọn tìm kiếm ban đầu
			TestObject dropdown = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//select[@id='categoryId']")
			dropdownElem = WebUiCommonHelper.findWebElement(dropdown, 10)
			options = dropdownElem.findElements(By.tagName("option"))
		
	
			String selectedLabel = ""
			for (WebElement opt : options) {
				if (opt.isSelected()) {
					selectedLabel = opt.getText().trim()
					break
				}
			}
			WebUI.verifyMatch(selectedLabel, selectedCategory, false)
		
	} else {
		WebUI.comment("Khong co san pham trong bang")
	}
	
	WebUI.back()
	WebUI.delay(2)
	
	'10. Tìm kiếm danh mục Text book'
	
	WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/select_Category'))
	selectedCategory = 'Text book'
	WebUI.selectOptionByLabel(findTestObject('Object Repository/Admin/ProductManagement/select_Category'), selectedCategory, false)
	
	WebUI.click(findTestObject('Object Repository/Admin/ProductManagement/Button_Search'))
	WebUI.delay(2)
	
		// Lấy hàng đầu tiên trong bảng sản phẩm
	UpdateRows = findTestObject('Object Repository/Admin/ProductManagement/List_Button_Update')
	btnUpdate = WebUiCommonHelper.findWebElements(UpdateRows, 10)
	if (btnUpdate.size() > 0) {
		btnUpdate.get(0).click()
		WebUI.waitForElementVisible(findTestObject('Object Repository/Admin/ProductManagement/Lable_Add_Product'), 5)
			// Kiểm tra danh mục đúng với lựa chọn tìm kiếm ban đầu
			TestObject dropdown = new TestObject().addProperty("xpath", ConditionType.EQUALS, "//select[@id='categoryId']")
			dropdownElem = WebUiCommonHelper.findWebElement(dropdown, 10)
			options = dropdownElem.findElements(By.tagName("option"))
		
	
			String selectedLabel = ""
			for (WebElement opt : options) {
				if (opt.isSelected()) {
					selectedLabel = opt.getText().trim()
					break
				}
			}
			WebUI.verifyMatch(selectedLabel, selectedCategory, false)
		
	} else {
		WebUI.comment("Khong co san pham trong bang")
	}
	
	WebUI.back()
	WebUI.delay(2)
	
	