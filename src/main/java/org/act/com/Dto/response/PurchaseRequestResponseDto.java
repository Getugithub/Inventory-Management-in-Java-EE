package org.act.com.Dto.response;

import org.act.com.model.Employee;

import java.util.Date;

public class PurchaseRequestResponseDto {

    private String productName;
    private Date createdOn;
    private Date updatedOn;
    private Employee employeeId;
    private String approvedBy;

    public PurchaseRequestResponseDto() {
    }

    public PurchaseRequestResponseDto(String productName, Date createdOn, Date updatedOn, Employee employeeId, String approvedBy) {
        this.productName = productName;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.employeeId = employeeId;
        this.approvedBy = approvedBy;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }
}
