package org.act.com.Dto.request;

import javax.xml.crypto.Data;

public class ResourceTypeRequestDto {
    private String name;
private Data created_on;
private Data updated_on;

    public ResourceTypeRequestDto(Data created_on, Data updated_on) {
        this.created_on = created_on;
        this.updated_on = updated_on;
    }

    public Data getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Data created_on) {
        this.created_on = created_on;
    }

    public Data getUpdated_on() {
        return updated_on;
    }

    public void setUpdated_on(Data updated_on) {
        this.updated_on = updated_on;
    }

    public ResourceTypeRequestDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ResourceTypeRequestDto(String name) {
        this.name = name;
    }
}
