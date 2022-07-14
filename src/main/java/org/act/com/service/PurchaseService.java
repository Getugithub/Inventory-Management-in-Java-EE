package org.act.com.service;

import org.act.com.Dto.request.PurchaseRequestDto;
import org.act.com.Dto.response.ListPurchaseResponsseDto;
import org.act.com.Dto.response.PurchaseResponceDto;
import org.act.com.Dto.response.StatusDto;
import org.act.com.dao.PurchaseDao;
import org.act.com.dao.PurchaseRequestDao;
import org.act.com.dao.ResourceRequestDao;
import org.act.com.dao.ResourcesDao;
import org.act.com.model.Purchase;
import org.act.com.model.PurchaseRequest;
import org.act.com.model.ResourceRequest;
import org.act.com.model.Resources;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Stateless
public class PurchaseService {

    @EJB
    private PurchaseRequestDao purchaseRequestDao;
    @EJB
    private ResourcesDao resourcesDao;
    @EJB
    private ResourceRequestDao resourceRequestDao;
    @EJB
    private PurchaseDao purchaseDao;

    public StatusDto create(PurchaseRequestDto purchaseRequestDto) {
        PurchaseRequest purchaseRequestModel = purchaseRequestDao.findById(purchaseRequestDto.getPurchaseRequestId());
        Resources resourcesModel = resourcesDao.findById(purchaseRequestDto.getResourcesId());
        Purchase purchase = new Purchase();
        purchase.setId(0);
        if (resourcesModel == null){
            return new StatusDto(false,"resources is not found by this id"+purchaseRequestDto.getResourcesId());
        }
        if (purchaseRequestModel == null){
            return new StatusDto( false," purchase request is not found by this id"+purchaseRequestDto.getPurchaseRequestId());
        }
        purchase.setAuthorizedBy(purchaseRequestDto.getAuthorizedBy());
        purchase.setDescription(purchaseRequestDto.getDescription());
        purchase.setPrice(purchaseRequestDto.getPrice());
        purchase.setResources(resourcesModel);
        purchase.setPurchaseRequest(purchaseRequestModel);
        purchaseDao.create(purchase);
        return new StatusDto(true, "sucess");
    }

    public StatusDto update(Long id, PurchaseRequestDto purchaseRequestDto) {
        Purchase purchaseModel = purchaseDao.findById(purchaseRequestDto.getPurchaseRequestId());
        PurchaseRequest purchaseRequestModel = purchaseRequestDao.findById(purchaseRequestDto.getPurchaseRequestId());
        Resources resourcesModel = resourcesDao.findById(purchaseRequestDto.getResourcesId());
        if (purchaseRequestModel == null) {
            return new StatusDto(false, "purchase request is not found by this id "+purchaseRequestDto.getPurchaseRequestId());
        }

        if (resourcesModel == null) {
            return new StatusDto(false, "resource is not found"+purchaseRequestDto.getResourcesId());
        }

        purchaseModel.setPurchaseRequest(purchaseRequestModel);
        purchaseModel.setResources(resourcesModel);
        purchaseModel.setPrice(purchaseRequestDto.getPrice());
        purchaseDao.update(purchaseModel);
        return new StatusDto(true,"update");
    }


    public StatusDto deleteById(Long id ) {
        try {
            purchaseDao.deleteById(id);
            return new StatusDto(true,"success");
        } catch (Exception e){
            return new StatusDto(false,"unable to delete purchase by id: "+id);
        }
    }


public ListPurchaseResponsseDto listAllpurchase(Integer start, Integer end) {

    ListPurchaseResponsseDto listPurchaseResponsseDto = new ListPurchaseResponsseDto();
    List<PurchaseResponceDto> purchaseArrayList = new ArrayList<>();
    List<Purchase> purchaseList = this.purchaseDao.listAll(start, end);

    if(purchaseList.isEmpty()){
        listPurchaseResponsseDto.setCount(0);
        listPurchaseResponsseDto.setPurchaseResponceDtoList(new ArrayList<>());
        listPurchaseResponsseDto.setStatusDto(new StatusDto(false,"empty array list"));
        return listPurchaseResponsseDto;
    }
    purchaseList.forEach(purchase -> {

                PurchaseResponceDto purchaseResponceDto = new PurchaseResponceDto();
                purchaseResponceDto.setAuthorizedBy(purchase.getAuthorizedBy());
                purchaseResponceDto.setDescription(purchase.getDescription());
                purchaseResponceDto.setPrice(purchase.getPrice());
                purchaseArrayList.add(purchaseResponceDto);
            }
    );

    listPurchaseResponsseDto.setPurchaseResponceDtoList(purchaseArrayList);
    listPurchaseResponsseDto.setCount(purchaseList.size());
    listPurchaseResponsseDto.setStatusDto(new StatusDto(true,"successful"));
    return listPurchaseResponsseDto;

}
  }



