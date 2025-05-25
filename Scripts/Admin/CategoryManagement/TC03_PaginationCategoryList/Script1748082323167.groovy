import com.kms.katalon.core.testdata.TestDataFactory

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.lowagie.text.Row
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testdata.TestDataFactory

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

//WebUI.waitForElementClickable(findTestObject("Admin_Category/Button_Category_Management"), 3)
//
//WebUI.click(findTestObject("Admin_Category/Button_Category_Management"))
//
//WebUI.waitForElementClickable(findTestObject("Admin_Category/Button_Category_List"), 3)
//
//WebUI.click(findTestObject("Admin_Category/Button_Category_List"))

WebUI.waitForElementClickable(findTestObject("Admin_Category/Button_Category_Pagination"), 3)

WebUI.click(findTestObject("Admin_Category/Button_Category_Pagination"))

WebUI.delay(3)

// Lấy dữ liệu từ file Excel
def testData = TestDataFactory.findTestData("Admin_Category_Data")

WebElement pageNumberElement = WebUI.findWebElement(findTestObject("Admin_Category/Button_Category_Pagination"))

int step = (int)pageNumberElement.getText()

int rowCount = testData.getRowNumbers()

for (int i = rowCount - 5 * (step - 1) ; i >= 1; i--) {
    String id = testData.getValue("id", i)?.trim()
    String name = testData.getValue("name", i)?.trim()
    String desc = testData.getValue("description", i)?.trim()

    // Bỏ qua nếu dữ liệu thiếu
    if (!id || !name || !desc) {
        WebUI.comment("Bỏ qua dòng $i vì thiếu dữ liệu")
        continue
    }

    // Tạo TestObject động cho dòng dữ liệu
    TestObject rowObject = new TestObject("Row_" + i)
    String xpath = "//tr[td[normalize-space(text())='" + id + "'] and td[normalize-space(text())='" + name + "'] and td[contains(normalize-space(),'" + desc + "')]]"
    rowObject.addProperty("xpath", ConditionType.EQUALS, xpath)

    WebUI.comment(">> Kiểm tra dòng $i: ID = $id, Name = $name")

    WebUI.verifyElementPresent(rowObject, 5, FailureHandling.CONTINUE_ON_FAILURE)
}
