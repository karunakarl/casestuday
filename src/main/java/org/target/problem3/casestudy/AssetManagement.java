package org.target.problem3.casestudy;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.target.problem3.casestudy.enums.AssetType;
import org.target.problem3.casestudy.model.InventoryModel;
import org.target.problem3.casestudy.model.RequestModel;
import org.target.problem3.casestudy.service.ProcessRequests;
import org.target.problem3.casestudy.service.ReadAllRequests;

public class AssetManagement {

    public static void main(String[] args) throws IOException {
	List<RequestModel> listOfRequestModels = ReadAllRequests.getAllRequests();
	System.out.println(listOfRequestModels);
	List<InventoryModel> listOfInventory = ReadAllRequests.getAllInventory();
	System.out.println(listOfInventory);
	Map<AssetType, List<InventoryModel>> mapOfInvetory = listOfInventory.stream()
		.collect(Collectors.groupingBy(inventory -> inventory.getInventoryType()));
	ProcessRequests.processRequests(listOfRequestModels, mapOfInvetory);
    }
}
