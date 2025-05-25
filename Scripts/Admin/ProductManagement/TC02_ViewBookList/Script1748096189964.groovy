import com.kms.katalon.core.testdata.TestDataFactory

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.lowagie.text.Row
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testdata.TestDataFactory

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.WebElement

WebUI.waitForElementClickable(findTestObject("Admin_Book/Button_Book_Management"), 3)

WebUI.click(findTestObject("Admin_Book/Button_Book_Management"))

WebUI.waitForElementClickable(findTestObject("Admin_Book/Button_Book_List"), 3)

WebUI.click(findTestObject("Admin_Book/Button_Book_List"))

WebUI.delay(3)

// Lấy dữ liệu từ file Excel
def testData = TestDataFactory.findTestData("Admin_Book_Data")

int rowCount = testData.getRowNumbers()

for (int i = rowCount; i >= rowCount - 3; i--) {
    String id = testData.getValue("id", i)?.trim()
    String title = testData.getValue("title", i)?.trim()
    // Bỏ qua dòng nếu dữ liệu bị null
    if (id == null || title == null) {
        WebUI.comment("Bỏ qua dòng $i vì thiếu dữ liệu")
        continue
    }

    // Tạo một TestObject động
    TestObject rowObject = new TestObject("dynamicRow_" + i)
    String xpath = "//tr[td[normalize-space(text())='" + id + "'] and td[normalize-space(text())='" + title + "']]"
    rowObject.addProperty("xpath", ConditionType.EQUALS, xpath)

    WebUI.comment("Đang kiểm tra dòng $i với ID = $id, Name = $title")

    // Xác minh phần tử có tồn tại trên trang
    WebUI.verifyElementPresent(rowObject, 5, FailureHandling.CONTINUE_ON_FAILURE)
}

WebUI.delay(3)
