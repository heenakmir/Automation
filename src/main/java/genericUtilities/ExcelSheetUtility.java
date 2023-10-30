package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This file is used to read data from excel sheet
 * @author Heena
 *
 */

public class ExcelSheetUtility 
/**
 * THis method will read data from excel file and return the value to caller
 * @param SheetName
 * @param rownum
 * @param cellno
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
{
public String readDataFromExcelSheet(String SheetName,int rownum,int cellno) throws IOException
{
	FileInputStream file = new FileInputStream(".\\src\\test\\resources\\testdata.exe.xlsx");
	Workbook workboook = WorkbookFactory.create(file);
	String value = workboook.getSheet(SheetName).getRow(rownum).getCell(cellno).getStringCellValue();
	return value;
}
/**
 * This Method will read multiple data from excel sheet at time
 * used for DataProvider
 * @param sheetName
 * @return
 * @throws IOException
 */

public Object[][] readMultipleData(String sheetName) throws IOException 
{
	FileInputStream file = new FileInputStream(".\\src\\test\\resources\\testdata.exe.xlsx");
	Workbook workboook = WorkbookFactory.create(file);
	Sheet sh = workboook.getSheet(sheetName);
	int lastRow = sh.getLastRowNum();
	int lastCell = sh.getRow(0).getLastCellNum();
	Object[][] data = new Object[lastRow][lastCell];
	for (int i=0;i<lastRow;i++)
	{
		for(int j=0;j<lastCell;j++)
		{
			data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();//i+1 becoz 1st row is header i.e 0 is header so 0+1 will be first data
		}
		
	}
	return data;
}

}
