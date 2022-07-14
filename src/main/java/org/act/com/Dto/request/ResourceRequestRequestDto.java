package org.act.com.Dto.request;

import javax.xml.crypto.Data;

public class ResourceRequestRequestDto {
    private Long employeeId;
    private Long resourceId;
    private Boolean status;

    public ResourceRequestRequestDto() {
    }

    public ResourceRequestRequestDto(long employeeId, long resourceId, boolean status) {
        this.employeeId = employeeId;
        this.resourceId = resourceId;
        this.status = status;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
