package org.target.problem3.casestudy.model;

import org.target.problem3.casestudy.enums.AssetType;

public class InventoryModel {

    private AssetType inventoryType;
    
    private Long available;
    
    private String location;
    
    private int rowNumber;
    public InventoryModel() {
	// TODO Auto-generated constructor stub
    }

    public InventoryModel(AssetType inventoryType, Long available, String location,int rowNumber) {
	super();
	this.inventoryType = inventoryType;
	this.available = available;
	this.location = location;
	this.rowNumber = rowNumber;
    }

    /**
     * @return the inventoryType
     */
    public AssetType getInventoryType() {
        return inventoryType;
    }

    /**
     * @param inventoryType the inventoryType to set
     */
    public void setInventoryType(AssetType inventoryType) {
        this.inventoryType = inventoryType;
    }

    /**
     * @return the available
     */
    public Long getAvailable() {
        return available;
    }

    /**
     * @param available the available to set
     */
    public void setAvailable(Long available) {
        this.available = available;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the rowNumber
     */
    public int getRowNumber() {
        return rowNumber;
    }

    /**
     * @param rowNumber the rowNumber to set
     */
    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "InventoryModel [inventoryType=" + inventoryType + ", available=" + available + ", location=" + location
		+ ", rowNumber=" + rowNumber + "]";
    }

   
    
    
}
