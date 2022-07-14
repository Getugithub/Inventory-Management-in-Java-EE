package org.act.com.Dto.response;

import org.act.com.model.Employee;
import org.act.com.model.Resources;

import java.util.Date;

public class HoldingResponseDto {

     private Employee employeeId;
     private Resources resourcesId;
     private Date createdOn;
     private Date updatedOn;
     private Boolean restartstatus;

//     private Long value;

    public HoldingResponseDto() {
    }

    public HoldingResponseDto(Employee employeeId, Resources resourcesId, Date createdOn, Date updatedOn, Boolean restartstatus) {
        this.employeeId = employeeId;
        this.resourcesId = resourcesId;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.restartstatus = restartstatus;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Resources getResourcesId() {
        return resourcesId;
    }

    public void setResourcesId(Resources resourcesId) {
        this.resourcesId = resourcesId;
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

    public Boolean getRestartstatus() {
        return restartstatus;
    }

    public void setRestartstatus(Boolean restartstatus) {
        this.restartstatus = restartstatus;
    }
}
