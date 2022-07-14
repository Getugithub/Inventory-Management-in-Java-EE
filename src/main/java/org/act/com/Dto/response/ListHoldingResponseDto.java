package org.act.com.Dto.response;

import java.util.List;

public class ListHoldingResponseDto {
  private List<HoldingResponseDto> holdingResponseDtoList;
  private Integer count;
  StatusDto statusDto;


    public ListHoldingResponseDto() {
    }

    public List<HoldingResponseDto> getHoldingResponseDtoList() {
        return holdingResponseDtoList;
    }

    public void setHoldingResponseDtoList(List<HoldingResponseDto> holdingResponseDtoList) {
        this.holdingResponseDtoList = holdingResponseDtoList;
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
