import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.*;
import java.util.*;

public class dataDriven {
	
	public static void main(String[] args) throws IOException {
		
		//identify the testcases column by scanning the entire first row
		//scan testcases column to find purchase row
		//then grab the row data and feed to the test
		
		//fileInputStream argument
	}
		
		public ArrayList<String> getData(String testcasename) throws IOException
		{
			ArrayList<String> a = new ArrayList<String>();
			
			FileInputStream fisFileInputStream = new FileInputStream("C:\\Users\\DELL\\Desktop\\data\\Book1.xlsx");
			
			
			XSSFWorkbook  workbook = new XSSFWorkbook(fisFileInputStream);
			int sheets=workbook.getNumberOfSheets();
			
			for(int i=0;i<sheets;i++)
			{
				if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
				{
					XSSFSheet sheet = workbook.getSheetAt(i);
					Iterator<Row> rows=sheet.iterator();
					//saving the first row
					Row firstrow = rows.next();
					//iterating through the cells of first row
					Iterator<Cell>ce = firstrow.cellIterator();
					//to get the coloumn number by getting the index of the cell
					int k=0;
					int coloumn=0;
					while(ce.hasNext())
					{
						Cell value = ce.next();
						//checking the cell value for desired string
						if(value.getStringCellValue().equalsIgnoreCase("TestCases"))
						{
							//desired column
							coloumn=k;
						}
						k++;
					}
					System.out.println(coloumn);
					
					//once coloumn is identified then scan the entire testcase column to identify purchase testcase row
					
					while(rows.hasNext())
					{
						Row r =rows.next();
						
						//getting the cell value of every row at 0th index
						
						if(r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testcasename))
						{
							//grab all the cells of the purchase row
							
							Iterator<Cell> cv = r.cellIterator();
							while(cv.hasNext())
							{
								//printing all the data of the purchase row
								Cell c = cv.next();
								if(c.getCellType()==CellType.STRING)
								{
								a.add(c.getStringCellValue());
								}
								else
								{
								    	
									a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
								}
							}
							
							
						}
							
					}	
				}
			}
			return a;
		}
	

}
