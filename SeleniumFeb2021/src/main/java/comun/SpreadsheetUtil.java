package comun;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class SpreadsheetUtil {
	
	 	private File spreadsheet;
	    private Sheet currentSheet;
	    private Map<String, Integer> columns;

	    
	    
		/**
		 * @author Sergio
		 * @Date 09-04-2021
		 * @Description inicialicia el arcivo 
		 * @param String
		 * **/
	    public SpreadsheetUtil(File file){
	        spreadsheet = file;
	        columns = new HashMap();
	    }
	    
		/**
		 * @author Sergio
		 * @Date 09-04-2021
		 * @Description cambia de sheet por nombre 
		 * @param String
		 * **/
	    public void switchToSheet(String name){
	        try(var workbooks = WorkbookFactory.create(spreadsheet)){
	            currentSheet = workbooks.getSheet(name);
	            currentSheet.getRow(0).forEach(cell ->{
	                columns.put(cell.getStringCellValue(), cell.getColumnIndex());
	            });
	        }catch(Exception e){
	            e.printStackTrace();
	        }
	    }
	    
		/**
		 * @author Sergio
		 * @Date 09-04-2021
		 * @Description toma el valor de una columna por nombre y el row por numero 
		 * @param String, Int
		 * **/
	    public String getCellData(String column, int row){
	        var dataRow = currentSheet.getRow(row);
	        return getCellDataAsString(dataRow.getCell(columns.get(column)));
	    }

		/**
		 * @author Sergio
		 * @Date 09-04-2021
		 * @Description toma todas las columnas y revisa que exista 
		 * @param String, Int
		 * **/
	    private String getCellDataAsString(Cell cell){
	        return  switch(cell.getCellType()){
	            case STRING -> cell.getStringCellValue();
	            case NUMERIC -> String.valueOf((int)cell.getNumericCellValue());
	            default -> "";
	        };
	    }

}
