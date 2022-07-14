package org.act.com.service;

import org.act.com.Dto.request.PurchaseRequestDto;
import org.act.com.Dto.request.PurchaseRequestRequestDto;
import org.act.com.Dto.request.ResourceRequestRequestDto;
import org.act.com.Dto.response.HoldingResponseDto;
import org.act.com.Dto.response.ListPurchaseRequestResponseDto;
import org.act.com.Dto.response.PurchaseRequestResponseDto;
import org.act.com.Dto.response.StatusDto;
import org.act.com.dao.EmployeeDao;
import org.act.com.dao.PurchaseRequestDao;
import org.act.com.model.Employee;
import org.act.com.model.Holdings;
import org.act.com.model.Purchase;
import org.act.com.model.PurchaseRequest;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
@Stateless
public class PurchaseRequestService {
    @EJB
    private PurchaseRequestDao purchaseRequestDao;
    @EJB
    private EmployeeDao employeeDao;

    public StatusDto create(PurchaseRequestRequestDto purchaseRequestRequestDto) {
        Employee employeeModel = employeeDao.findById(purchaseRequestRequestDto.getEmployeeId());
        PurchaseRequest purchaseRequest = new PurchaseRequest();
        purchaseRequest.setId(0);
        if (employeeModel == null) {
            return new StatusDto(false, "there is not employee by this id" + purchaseRequestRequestDto.getEmployeeId());
        }
        purchaseRequest.setEmployee(employeeModel);
        purchaseRequest.setProductName(purchaseRequestRequestDto.getProductName());
        purchaseRequest.setApprovedBy(purchaseRequestRequestDto.getApproved_by());
        purchaseRequest.setUpdatedOn(new Date());
        purchaseRequest.setCreatedOn(new Date());
        purchaseRequestDao.create(purchaseRequest);
        return new StatusDto(true, "success");

    }

    public StatusDto update(PurchaseRequestRequestDto purchaseRequestRequestDto) {
        PurchaseRequest purchaseRequestModel = purchaseRequestDao.findById(purchaseRequestRequestDto.getEmployeeId());
        Employee employeeModel = employeeDao.findById(purchaseRequestRequestDto.getEmployeeId());
        if (purchaseRequestModel == null) {
            return new StatusDto(false, "purchase is not found by this id " + purchaseRequestRequestDto.getEmployeeId());
        }

        if (employeeModel == null) {
            return new StatusDto(false, "employee is not found" + purchaseRequestRequestDto.getEmployeeId());
        }

        purchaseRequestModel.setEmployee(employeeModel);
        purchaseRequestModel.setProductName(purchaseRequestRequestDto.getProductName());
        purchaseRequestModel.setCreatedOn(new Date());
        purchaseRequestDao.update(purchaseRequestModel);
        return new StatusDto(true, "update");

    }


    public StatusDto deleteById(Long id) {
        try {
            purchaseRequestDao.deleteById(id);
            return new StatusDto(true, "sucess");
        } catch (Exception e) {
            return new StatusDto(false, "unable to delete by id:" + id);
        }
    }

    public ListPurchaseRequestResponseDto listAllPurchaseRequest(Integer start, Integer end) {
        ListPurchaseRequestResponseDto listPurchaseRequestResponseDto = new ListPurchaseRequestResponseDto();
        List<PurchaseRequestResponseDto> purchaseRequestArrayList = new ArrayList<>();
        List<PurchaseRequest> purchaseRequestList = this.purchaseRequestDao.listAll(start, end);

        if (purchaseRequestList.isEmpty()) {
            listPurchaseRequestResponseDto.setCount(0);
            listPurchaseRequestResponseDto.setPurchaseRequestResponseDtoList(new ArrayList<>());
            listPurchaseRequestResponseDto.setStatusDto(new StatusDto(false, "empty array list"));
            return listPurchaseRequestResponseDto;
        }
        purchaseRequestList.forEach(purchaseRequest -> {

                    PurchaseRequestResponseDto purchaseRequestResponseDto = new PurchaseRequestResponseDto();

                    purchaseRequestResponseDto.setApprovedBy(purchaseRequest.getApprovedBy());
                    purchaseRequestResponseDto.setCreatedOn(purchaseRequest.getCreatedOn());
                    purchaseRequestResponseDto.setProductName(purchaseRequest.getProductName());
                    purchaseRequestArrayList.add(purchaseRequestResponseDto);
                }
        );

        listPurchaseRequestResponseDto.setPurchaseRequestResponseDtoList(purchaseRequestArrayList);
        listPurchaseRequestResponseDto.setCount(purchaseRequestList.size());
        listPurchaseRequestResponseDto.setStatusDto(new StatusDto(true, "successful"));
        return listPurchaseRequestResponseDto;
    }
}
