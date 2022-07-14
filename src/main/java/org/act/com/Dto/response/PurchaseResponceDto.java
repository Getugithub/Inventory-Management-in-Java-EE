package org.act.com.Dto.response;

import org.act.com.model.PurchaseRequest;
import org.act.com.model.Resources;

public class PurchaseResponceDto {
    private PurchaseRequest purchaseRequest;
    private Resources resources;
    private String authorizedBy;
    private String description;
    private double price;


    public PurchaseResponceDto() {
    }

    public PurchaseResponceDto(PurchaseRequest purchaseRequest, Resources resources, String authorizedBy, String description, double price) {
        this.purchaseRequest = purchaseRequest;
        this.resources = resources;
        this.authorizedBy = authorizedBy;
        this.description = description;
        this.price = price;
    }

    public PurchaseRequest getPurchaseRequest() {
        return purchaseRequest;
    }

    public void setPurchaseRequest(PurchaseRequest purchaseRequest) {
        this.purchaseRequest = purchaseRequest;
    }

    public Resources getResources() {
        return resources;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
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
