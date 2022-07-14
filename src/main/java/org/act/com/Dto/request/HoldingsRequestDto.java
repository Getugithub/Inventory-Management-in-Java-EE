package org.act.com.Dto.request;

import org.act.com.model.Employee;
import org.act.com.model.Resources;

import javax.xml.crypto.Data;
import java.util.Date;

public class HoldingsRequestDto {

    private long employeeId;
    private long resourcesId;


    public HoldingsRequestDto() {
    }

    public HoldingsRequestDto(long employeeId, long resourcesId) {
        this.employeeId = employeeId;
        this.resourcesId = resourcesId;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public long getResourcesId() {
        return resourcesId;
    }

    public void setResourcesId(long resourcesId) {
        this.resourcesId = resourcesId;
    }
}
