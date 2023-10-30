package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDatafromexcelfile {

	public static void main(String[] args) throws Throwable {
		//Step1:open the doc in java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\testdata.exe.xlsx");
		//step2:create workbook
	    Workbook book = WorkbookFactory.create(fis);
		//step3:Navigate to required sheet
	    Sheet sheet = book.getSheet("Contacts");
		//step4:Navigate to required row
	   Row row = sheet.getRow(1);
		//step5:Navigate to required cell
	   Cell cell = row.getCell(1);
		//step6:capture the value and print
	   String value = cell.getStringCellValue();
	   System.out.println(value );
	   
	   /*FileInputStream f1 = new FileInputStream(".\\src\\test\\resources\\testdata.exe.xlsx");
		Workbook workbook = WorkbookFactory.create(f1);
		Sheet sheet = workbook.getSheet("Organisation");
		Row row = sheet .getRow(7);
		Cell cell = row.getCell(3);
		String value = cell.getStringCellValue();
		System.out.println(value);*/
	

	}

}
