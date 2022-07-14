package org.act.com.Dto.request;

import java.util.Date;

public class PurchaseRequestRequestDto {
    private String approved_by;
    private String productName;
    private Long employeeId;

    public PurchaseRequestRequestDto(String approved_by) {
        this.approved_by = approved_by;
    }

    public String getApproved_by() {
        return approved_by;
    }

    public void setApproved_by(String approved_by) {
        this.approved_by = approved_by;
    }

    public PurchaseRequestRequestDto() {
    }

    public PurchaseRequestRequestDto(String productName, Date createdOn, Date updatedOn, Long employeeId, String approvedBy) {
        this.productName = productName;

        this.employeeId = employeeId;

    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
}

