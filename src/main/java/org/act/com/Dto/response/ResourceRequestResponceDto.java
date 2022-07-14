package org.act.com.Dto.response;

import org.act.com.model.Employee;
import org.act.com.model.Resources;

import java.util.Date;

public class ResourceRequestResponceDto {
    private Employee employee;
    private Resources resources;
    private String description;
    private Date updatedon;

    public ResourceRequestResponceDto() {
    }

    public ResourceRequestResponceDto(Employee employee, Resources resources, String description, Date updatedon) {
        this.employee = employee;
        this.resources = resources;
        this.description = description;
        this.updatedon = updatedon;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Resources getResources() {
        return resources;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getUpdatedon() {
        return updatedon;
    }

    public void setUpdatedon(Date updatedon) {
        this.updatedon = updatedon;
    }
}
