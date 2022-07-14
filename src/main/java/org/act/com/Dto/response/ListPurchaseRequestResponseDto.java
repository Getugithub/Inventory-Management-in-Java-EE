package org.act.com.Dto.response;

import java.util.List;

public class ListPurchaseRequestResponseDto {
    private List<PurchaseRequestResponseDto> purchaseRequestResponseDtoList;
    private Integer count;
    StatusDto statusDto;

    public ListPurchaseRequestResponseDto() {
    }

    public ListPurchaseRequestResponseDto(List<PurchaseRequestResponseDto> purchaseRequestResponseDtoList, Integer count, StatusDto statusDto) {
        this.purchaseRequestResponseDtoList = purchaseRequestResponseDtoList;
        this.count = count;
        this.statusDto = statusDto;
    }

    public List<PurchaseRequestResponseDto> getPurchaseRequestResponseDtoList() {
        return purchaseRequestResponseDtoList;
    }

    public void setPurchaseRequestResponseDtoList(List<PurchaseRequestResponseDto> purchaseRequestResponseDtoList) {
        this.purchaseRequestResponseDtoList = purchaseRequestResponseDtoList;
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
