package org.act.com.Dto.response;

import java.util.List;

public class ListPurchaseResponsseDto {
    private List<PurchaseResponceDto> purchaseResponceDtoList;
    private Integer count;
    StatusDto statusDto;

    public ListPurchaseResponsseDto() {
    }

    public ListPurchaseResponsseDto(List<PurchaseResponceDto> purchaseResponceDtoList, Integer count, StatusDto statusDto) {
        this.purchaseResponceDtoList = purchaseResponceDtoList;
        this.count = count;
        this.statusDto = statusDto;
    }

    public List<PurchaseResponceDto> getPurchaseResponceDtoList() {
        return purchaseResponceDtoList;
    }

    public void setPurchaseResponceDtoList(List<PurchaseResponceDto> purchaseResponceDtoList) {
        this.purchaseResponceDtoList = purchaseResponceDtoList;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public StatusDto getStatusDto() {
        return statusDto;
    }

    public void setStatusDto(StatusDto statusDto) {
        this.statusDto = statusDto;
    }
}
