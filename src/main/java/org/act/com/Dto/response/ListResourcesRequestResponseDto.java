package org.act.com.Dto.response;

import java.util.List;

public class ListResourcesRequestResponseDto {
    private List<ResourceRequestResponceDto> resourceRequestResponceDtoList;
    private Integer count;
    StatusDto statusDto;

    public ListResourcesRequestResponseDto() {
    }

    public ListResourcesRequestResponseDto(List<ResourceRequestResponceDto> resourceRequestResponceDtoList, Integer count, StatusDto statusDto) {
        this.resourceRequestResponceDtoList = resourceRequestResponceDtoList;
        this.count = count;
        this.statusDto = statusDto;
    }

    public List<ResourceRequestResponceDto> getResourceRequestResponceDtoList() {
        return resourceRequestResponceDtoList;
    }

    public void setResourceRequestResponceDtoList(List<ResourceRequestResponceDto> resourceRequestResponceDtoList) {
        this.resourceRequestResponceDtoList = resourceRequestResponceDtoList;
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
