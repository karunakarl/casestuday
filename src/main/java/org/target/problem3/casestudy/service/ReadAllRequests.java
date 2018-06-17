package org.target.problem3.casestudy.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.target.problem3.casestudy.enums.AssetType;
import org.target.problem3.casestudy.enums.RequestStatus;
import org.target.problem3.casestudy.model.InventoryModel;
import org.target.problem3.casestudy.model.RequestModel;

public class ReadAllRequests {

    
    public static List<RequestModel> getAllRequests() throws IOException {
	List<RequestModel> listOfRequestModels = new ArrayList<>();
	FileInputStream fileInputStream =null;
	try{
	fileInputStream= new FileInputStream("F://AssetRequest.xlsx");
	Workbook workbook = new XSSFWorkbook(fileInputStream);
	Sheet sheet = workbook.getSheetAt(0);
	Iterator<Row> iterator = sheet.rowIterator();
	iterator.next();
	while (iterator.hasNext()) {
	    String[] data = new String[5];
	    Row row = iterator.next();
	    Iterator<Cell> cellIterator = row.cellIterator();
	    int i = 0;
	    while (cellIterator.hasNext()) {
		Cell cell = cellIterator.next();
		if (cell.getCellType() == Cell.CELL_TYPE_STRING)
		    data[i] = cell.getStringCellValue();
		else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC)
		    data[i] = Double.valueOf(cell.getNumericCellValue()).toString();
		i++;
	    }
	    RequestModel requestModel = new RequestModel(Double.valueOf(data[0]).longValue(),
		    AssetType.valueOf(data[1]), Double.valueOf(data[2]).longValue(), RequestStatus.valueOf(data[3]), data[4],row.getRowNum());
	    listOfRequestModels.add(requestModel);
	}
	}finally{
	    if(fileInputStream!=null)
	fileInputStream.close();
	}
	return listOfRequestModels;

    }
    
    
    public static List<InventoryModel> getAllInventory() throws IOException{
	List<InventoryModel> listOfInventoryModel = new ArrayList<>();
	FileInputStream fileInputStream =null;
	try{
	fileInputStream= new FileInputStream("F://AssetRequest.xlsx");
	Workbook workbook = new XSSFWorkbook(fileInputStream);
	Sheet sheet = workbook.getSheetAt(1);
	Iterator<Row> iterator = sheet.rowIterator();
	iterator.next();
	while(iterator.hasNext()){
	    String[] data = new String[3];
	    Row row = iterator.next();
	    Iterator<Cell> cellIterator = row.cellIterator();
	    int i = 0;
	    while(cellIterator.hasNext()){
		Cell cell = cellIterator.next();
		if(cell.getCellType()==Cell.CELL_TYPE_STRING)
		data[i] = cell.getStringCellValue();
		else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC)
		    data[i] = Double.valueOf(cell.getNumericCellValue()).toString();
		i++;
	    }
	    InventoryModel inventoryModel = new InventoryModel(AssetType.valueOf(data[0]), Double.valueOf(data[1]).longValue(), data[2],row.getRowNum());
	    listOfInventoryModel.add(inventoryModel);
	}
	}finally{
	fileInputStream.close();
	}
	return listOfInventoryModel;
    }
}
