package Practice;

import java.io.IOException;

import genericUtilities.ExcelSheetUtility;

public class GenericUtilityForExcelSheet {

	public static void main(String[] args) throws IOException {
		ExcelSheetUtility EGUT = new ExcelSheetUtility();
		String value = EGUT .readDataFromExcelSheet("Organisation", 4, 3);
		System.out.println(value);
	}

}
