import com.kms.katalon.core.annotation.Keyword
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.apache.poi.ss.usermodel.*


public class dataFileUtil {

	@Keyword
	def setData(String filePath, String key, def value) {
		String valueToWrite = ""

		if (value == null) {
			valueToWrite = ""
		} else if (value instanceof String) {
			valueToWrite = value
		} else if (value.hasProperty("getText")) {
			try {
				valueToWrite = value.getText()
			} catch (Exception e) {
				valueToWrite = value.toString()
			}
		} else {
			valueToWrite = value.toString()
		}

		File file = new File(filePath)
		XSSFWorkbook workbook
		Sheet sheet

		if (file.exists()) {
			FileInputStream fis = new FileInputStream(file)
			workbook = new XSSFWorkbook(fis)
			sheet = workbook.getSheet('Sheet1') ?: workbook.createSheet('Sheet1')
			fis.close()
		} else {
			workbook = new XSSFWorkbook()
			sheet = workbook.createSheet('Sheet1')
		}

		boolean found = false
		for (int i = 0; i <= sheet.getLastRowNum(); i++) {
			Row row = sheet.getRow(i)
			if (row != null && row.getCell(0)?.getStringCellValue() == key) {
				row.createCell(1).setCellValue(valueToWrite)
				found = true
				break
			}
		}

		if (!found) {
			Row newRow = sheet.createRow(sheet.getLastRowNum() + 1)
			newRow.createCell(0).setCellValue(key)
			newRow.createCell(1).setCellValue(valueToWrite)
		}

		FileOutputStream fos = new FileOutputStream(file)
		workbook.write(fos)
		fos.close()
		workbook.close()
	}

	@Keyword
	def String getData(String filePath, String key) {
		File file = new File(filePath)
		if (!file.exists()) return null

		FileInputStream fis = new FileInputStream(file)
		XSSFWorkbook workbook = new XSSFWorkbook(fis)
		Sheet sheet = workbook.getSheet('Sheet1')
		String result = null

		if (sheet != null) {
			for (int i = 0; i <= sheet.getLastRowNum(); i++) {
				Row row = sheet.getRow(i)
				if (row != null && row.getCell(0)?.getStringCellValue() == key) {
					result = row.getCell(1)?.getStringCellValue()
					break
				}
			}
		}

		fis.close()
		workbook.close()
		return result
	}
}
