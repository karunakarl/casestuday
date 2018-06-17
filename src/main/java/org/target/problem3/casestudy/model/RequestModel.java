package org.target.problem3.casestudy.model;

import org.target.problem3.casestudy.enums.AssetType;
import org.target.problem3.casestudy.enums.RequestStatus;

public class RequestModel {

    private Long employeeNumber;
    
    private AssetType assetType;
    
    private Long requestNumber;
    
    private RequestStatus requestStatus;
    
    private String location;
    
    private int rowNumber;
    
    public RequestModel() {
	// TODO Auto-generated constructor stub
    }

    public RequestModel(Long employeeNumber, AssetType assetType, Long requestNumber, RequestStatus requestStatus,
	    String location,int rowNumber) {
	super();
	this.employeeNumber = employeeNumber;
	this.assetType = assetType;
	this.requestNumber = requestNumber;
	this.requestStatus = requestStatus;
	this.location = location;
	this.rowNumber = rowNumber;
    }

    /**
     * @return the employeeNumber
     */
    public Long getEmployeeNumber() {
        return employeeNumber;
    }

    /**
     * @param employeeNumber the employeeNumber to set
     */
    public void setEmployeeNumber(Long employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    /**
     * @return the assetType
     */
    public AssetType getAssetType() {
        return assetType;
    }

    /**
     * @param assetType the assetType to set
     */
    public void setAssetType(AssetType assetType) {
        this.assetType = assetType;
    }

    /**
     * @return the requestNumber
     */
    public Long getRequestNumber() {
        return requestNumber;
    }

    /**
     * @param requestNumber the requestNumber to set
     */
    public void setRequestNumber(Long requestNumber) {
        this.requestNumber = requestNumber;
    }

    /**
     * @return the requestStatus
     */
    public RequestStatus getRequestStatus() {
        return requestStatus;
    }

    /**
     * @param requestStatus the requestStatus to set
     */
    public void setRequestStatus(RequestStatus requestStatus) {
        this.requestStatus = requestStatus;
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
	return "RequestModel [employeeNumber=" + employeeNumber + ", assetType=" + assetType + ", requestNumber="
		+ requestNumber + ", requestStatus=" + requestStatus + ", location=" + location + ", rowNumber="
		+ rowNumber + "]";
    }

   
    
    
    
}
