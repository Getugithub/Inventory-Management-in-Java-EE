package org.act.com.service;
import org.act.com.Dto.request.HoldingsRequestDto;
import org.act.com.Dto.response.HoldingResponseDto;
import org.act.com.Dto.response.HoldingResponseDto;
import org.act.com.Dto.response.ListHoldingResponseDto;
import org.act.com.Dto.response.StatusDto;
import org.act.com.dao.EmployeeDao;
import org.act.com.dao.HoldingsDao;
import org.act.com.dao.ResourcesDao;
import org.act.com.model.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.QueryParam;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class HoldingsService {
    @EJB
    private HoldingsDao holdingsDao;
    @EJB
    private EmployeeDao employeeDao;
    @EJB
    private ResourcesDao resourcesDao;


        public StatusDto create(HoldingsRequestDto holdingsRequestDto) {
        Employee employeeModel = employeeDao.findById(holdingsRequestDto.getEmployeeId());
        Resources resourcesModel = resourcesDao.findById(holdingsRequestDto.getResourcesId());



        Holdings holdings = new Holdings();
        holdings.setIdholday(0);

        if(resourcesModel==null) {
            return new StatusDto(false,"there is not resource by this id"+holdingsRequestDto.getResourcesId());
        }

        if(employeeModel==null) {
            return new StatusDto(false,"there is not employee by this id"+holdingsRequestDto.getEmployeeId());
        }
        holdings.setEmployee(employeeModel);
        holdings.setResources(resourcesModel);
        holdings.setRestartstatus(true);
        holdings.setCreatedOn(new Date());
        holdings.setUpdatedOn(new Date());
        holdingsDao.create(holdings);
        System.out.println("****id***"+holdings.getIdholday());
        System.out.println("****resource***"+holdings.getResources());
        System.out.println("***employee****"+holdings.getEmployee());
        System.out.println("*******"+holdings.getIdholday());
        return new StatusDto(true, "sucsess");
    }

    public StatusDto update(HoldingsRequestDto holdingsRequestDto) {
        Holdings holdingModelOld = holdingsDao.findById(holdingsRequestDto.getEmployeeId());
        Resources holdingResource = resourcesDao.findById(holdingsRequestDto.getResourcesId());
        Employee employee = employeeDao.findById(holdingsRequestDto.getEmployeeId());
        if (employee == null) {
            return new StatusDto(false, "employee is not found by this id "+holdingsRequestDto.getEmployeeId());
        }

        if (holdingResource == null) {
            return new StatusDto(false, "holdingResource is not found"+holdingsRequestDto.getResourcesId());
        }
        holdingModelOld.setResources(holdingResource);
        holdingModelOld.setRestartstatus(true);
        holdingModelOld.setCreatedOn(new Date());
        holdingModelOld.setUpdatedOn(new Date());
        holdingModelOld.setEmployee(employee);
        holdingsDao.update(holdingModelOld);
        return new StatusDto(true, "update");

    }


    public StatusDto deleteById(Long id) {
       try{
           holdingsDao.deleteById(id);
           return new StatusDto(true, "success");
       }catch (Exception e){
          return new StatusDto(false,"unable to delete holding by id: "+id);
       }
    }


    public ListHoldingResponseDto listAllholding(Integer start ,Integer end) {
        ListHoldingResponseDto listHoldingResponseDto = new ListHoldingResponseDto();
        List<HoldingResponseDto> holdingsArryList = new ArrayList<>();
        List<Holdings> holdingsList = this.holdingsDao.listAll(start, end);

        if(holdingsList.isEmpty()){
            listHoldingResponseDto.setCount(0);
            listHoldingResponseDto.setHoldingResponseDtoList(new ArrayList<>());
            listHoldingResponseDto.setStatusDto(new StatusDto(false,"empty array list"));
            return listHoldingResponseDto;
        }
        holdingsList.forEach(holdings -> {

            HoldingResponseDto holdingResonseDto = new HoldingResponseDto();

                    holdingResonseDto.setEmployeeId(holdings.getEmployee());
                    holdingResonseDto.setResourcesId(holdings.getResources());
                    holdingResonseDto.setRestartstatus(holdings.getRestartstatus());
                    holdingResonseDto.setCreatedOn(holdings.getCreatedOn());
                    holdingResonseDto.setUpdatedOn(holdings.getUpdatedOn());
                    holdingsArryList.add(holdingResonseDto);
                }
        );
        listHoldingResponseDto.setHoldingResponseDtoList(holdingsArryList);
        listHoldingResponseDto.setCount(holdingsList.size());
        listHoldingResponseDto.setStatusDto(new StatusDto(true,"successful"));
    return listHoldingResponseDto;

    }
}
