package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ProductNameRead {
	public static void main(String[] args) throws IOException {
		
		ProductNameRead read=new ProductNameRead();
		read.excelRead();
		
	}
	public void excelRead() throws IOException {
		FileInputStream files=null;
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		try
		{
			//File path=new File("C:\\Users\\user\\git\\MavenTestProject\\MavenTestProject\\src\\main\\resources\\productname.xlsx");
			files=new FileInputStream("C:\\Users\\user\\git\\MavenTestProject\\MavenTestProject\\src\\main\\resources\\productname.xlsx");
			workbook=new XSSFWorkbook(files);
			sheet=workbook.getSheet("Sheet1");
			int noOfRows=sheet.getPhysicalNumberOfRows();
			int noOfCol=sheet.getRow(0).getLastCellNum();
			System.out.println(noOfRows);
			System.out.println(noOfCol);
			
			
		}
		catch(Exception  e){
			e.printStackTrace();
		}
		finally {
			files.close();
		}

		
	}
	
}
