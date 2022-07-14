package org.act.com.Dto.request;

import org.act.com.model.Employee;
import org.act.com.model.PurchaseRequest;
import org.act.com.model.Resources;

import java.util.Date;

public class PurchaseRequestDto {
    private long purchaseRequestId;
    private long resourcesId;
    private String authorizedBy;
    private String description;
    private double price;

    public PurchaseRequestDto() {
    }

    public PurchaseRequestDto( long purchaseRequest, long resources, String authorizedBy, String description, double price) {
        this.purchaseRequestId = purchaseRequest;
        this.resourcesId = resources;
        this.authorizedBy = authorizedBy;
        this.description = description;
        this.price = price;
    }


    public long getPurchaseRequestId() {
        return purchaseRequestId;
    }

    public void setPurchaseRequestId(long purchaseRequestId) {
        this.purchaseRequestId = purchaseRequestId;
    }

    public long getResourcesId() {
        return resourcesId;
    }

    public void setResources(long resources) {
        this.resourcesId = resources;
    }

    public String getAuthorizedBy() {
        return authorizedBy;
    }

    public void setAuthorizedBy(String authorizedBy) {
        this.authorizedBy = authorizedBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
