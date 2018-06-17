package org.target.problem3.casestudy.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.target.problem3.casestudy.enums.AssetType;
import org.target.problem3.casestudy.enums.RequestStatus;
import org.target.problem3.casestudy.model.InventoryModel;
import org.target.problem3.casestudy.model.RequestModel;

public class ProcessRequests {

	public static void processRequests(List<RequestModel> listOfRequestModel,
			Map<AssetType, List<InventoryModel>> mapOfInvetory) throws IOException {

		for (RequestModel requestModel : listOfRequestModel) {
			List<InventoryModel> listOfInventoryModel = mapOfInvetory.get(requestModel.getAssetType());
			InventoryModel inventoryModel = listOfInventoryModel.stream()
					.filter(inventory -> inventory.getLocation().equals(requestModel.getLocation())).findFirst()
					.orElse(null);
			if (inventoryModel != null) {
				if (inventoryModel.getAvailable() >= 1) {
					updateInventory(inventoryModel);
					requestModel.setRequestStatus(RequestStatus.FULLFILLED);
					updateRequest(requestModel);
				} else {
					requestModel.setRequestStatus(RequestStatus.LOWINVERNTORY);
					updateRequest(requestModel);
				}
			} else {
				System.out.println("Request no" + requestModel.getRequestNumber() + "cannot be processed");
			}

		}

	}

	private static void updateRequest(RequestModel requestModel) throws IOException {

		try (FileInputStream fileInputStream = new FileInputStream("F://AssetRequest.xlsx");
				FileOutputStream fileOutputStream = new FileOutputStream("F://AssetRequest.xlsx");) {

			Workbook workbook = new XSSFWorkbook(fileInputStream);
			Sheet sheet = workbook.getSheetAt(0);
			Row row = sheet.getRow(requestModel.getRowNumber());
			Cell cell = row.getCell(3);
			cell.setCellValue(requestModel.getRequestStatus().name());

			workbook.write(fileOutputStream);
		}
	}

	private static void updateInventory(InventoryModel inventoryModel) throws IOException {

		try (FileInputStream fileInputStream = new FileInputStream("F://AssetRequest.xlsx");
				FileOutputStream fileOutputStream = new FileOutputStream("F://AssetRequest.xlsx");) {

			Workbook workbook = new XSSFWorkbook(fileInputStream);
			Sheet sheet = workbook.getSheetAt(1);
			Row row = sheet.getRow(inventoryModel.getRowNumber());
			Cell cell = row.createCell(1);
			cell.setCellValue(inventoryModel.getAvailable().doubleValue() - 1.0);

			workbook.write(fileOutputStream);

		}
	}

}
