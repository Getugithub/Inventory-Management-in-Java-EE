package org.act.com.service;
import org.act.com.Dto.request.ResourceRequestRequestDto;
import org.act.com.Dto.response.ListPurchaseRequestResponseDto;
import org.act.com.Dto.response.ListResourcesRequestResponseDto;
import org.act.com.Dto.response.ResourceRequestResponceDto;
import org.act.com.Dto.response.StatusDto;
import org.act.com.dao.EmployeeDao;
import org.act.com.dao.ResourceRequestDao;
import org.act.com.dao.ResourcesDao;
import org.act.com.model.Employee;
import org.act.com.model.Purchase;
import org.act.com.model.ResourceRequest;
import org.act.com.model.Resources;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class ResourceRequestService {
    @EJB
    private ResourceRequestDao resourceRequestDao;
    @EJB
    private ResourcesDao resourcesDao;
    @EJB
    private EmployeeDao employeeDao;

    public StatusDto create(ResourceRequestRequestDto resourceRequestRequestDto) {
       ResourceRequest resourceRequest = resourceRequestDao.findById(resourceRequestRequestDto.getResourceId() );
       Resources resourceModel = resourcesDao.findById( resourceRequestRequestDto.getResourceId() );
       Employee employeeModel = employeeDao.findById( resourceRequestRequestDto.getEmployeeId() );

       ResourceRequest resourceRequest1 = new ResourceRequest();
       resourceRequest1.setId(0);
        if(resourceModel==null) {
            return new StatusDto(false,"there is not resource by this id"+resourceRequestRequestDto.getResourceId());
        }

        if(employeeModel==null) {
            return new StatusDto(false,"there is not employee by this id"+resourceRequestRequestDto.getEmployeeId());
        }

       resourceRequest1.setResources(resourceModel);
       resourceRequest1.setEmployee(employeeModel);
       resourceRequestDao.create(resourceRequest);
       return  new StatusDto( true,"succes" );

    }

    public StatusDto update(ResourceRequestRequestDto resourceRequestRequestDto){
        ResourceRequest resourceRequestModel = resourceRequestDao.findById(resourceRequestRequestDto.getResourceId());
        Employee employeeModel = employeeDao.findById(resourceRequestRequestDto.getEmployeeId());
        Resources resourcesModel = resourcesDao.findById(resourceRequestRequestDto.getResourceId());
        if(resourceRequestModel == null){
            return new StatusDto(false , "resource request is not found");
        }
        if(employeeModel == null){
            return new StatusDto(false , "employee request is not found");
        }
        resourceRequestModel.setEmployee(employeeModel);
        resourceRequestModel.setResources(resourcesModel);
        return new StatusDto(true,"update");
    }

    public StatusDto deleteById(Long id) {
        try {
            resourceRequestDao.deleteById(id);
            return new StatusDto(true, "success");
        } catch (Exception e) {
            return new StatusDto(false, "unable to delete holding by id :" + id);
        }
    }

    public ListResourcesRequestResponseDto listAllresourceRequest(Integer start, Integer end) {

        ListResourcesRequestResponseDto listResourcesRequestResponseDto = new ListResourcesRequestResponseDto();
    List<ResourceRequestResponceDto> resourceRequestArryList = new ArrayList<>();
    List<ResourceRequest> resourceRequestList = this.resourceRequestDao.listAll(start,end);

         if (resourceRequestList.isEmpty()){
        listResourcesRequestResponseDto.setCount(0);
        listResourcesRequestResponseDto.setResourceRequestResponceDtoList(new ArrayList<>());
        listResourcesRequestResponseDto.setStatusDto(new StatusDto(false,"empty array list"));
        return listResourcesRequestResponseDto;
         }

        resourceRequestList.forEach(resourceRequest -> {

            ResourceRequestResponceDto resourceRequestResponceDto = new ResourceRequestResponceDto();

                    resourceRequestResponceDto.setDescription(resourceRequest.getDescription());
                    resourceRequestResponceDto.setEmployee(resourceRequest.getEmployee());
                    resourceRequestResponceDto.setResources(resourceRequest.getResources());
                    resourceRequestResponceDto.setUpdatedon(resourceRequest.getUpdatedon());
                    resourceRequestArryList.add(resourceRequestResponceDto);
                }
        );
    listResourcesRequestResponseDto.setResourceRequestResponceDtoList(resourceRequestArryList);
    listResourcesRequestResponseDto.setCount(resourceRequestList.size());
    listResourcesRequestResponseDto.setStatusDto(new StatusDto(true,"success"));
        return listResourcesRequestResponseDto;

    }

}
