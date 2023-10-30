package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteTheDataIntoExcel {

	public static void main(String[] args) throws Throwable {
		FileInputStream file = new FileInputStream(".\\src\\test\\resources\\testdata.exe.xlsx");
		Workbook book = WorkbookFactory.create(file);
		Sheet sheet = book.getSheet("Contacts");
		Row row = sheet.createRow(1);
		Cell cell = row.createCell(3);
		cell.setCellValue("HEENA");
		FileOutputStream file1 = new FileOutputStream(".\\src\\test\\resources\\testdata.exe.xlsx");
		book.write(file1);
		book.close();
	}

}