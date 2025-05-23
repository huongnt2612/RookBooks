import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.util.KeywordUtil

class ContinueOnFailureListener {

    @AfterTestCase
    def continueOnFailure(TestCaseContext testCaseContext) {
        if (testCaseContext.getTestCaseStatus() == 'FAILED') {
            KeywordUtil.markWarning("⚠️ Test Case thất bại nhưng vẫn tiếp tục chạy Suite.")
        }
    }
}
