package org.act.com.rest;

import io.swagger.annotations.Api;
import org.act.com.Dto.request.PurchaseRequestDto;
import org.act.com.Dto.request.PurchaseRequestRequestDto;
import org.act.com.Dto.response.ListPurchaseRequestResponseDto;
import org.act.com.Dto.response.StatusDto;
import org.act.com.service.PurchaseRequestService;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
@Path("purchaseRequest")
@Api(value = "PurchaseRequest")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class purchaseRequestEndpont {
    @EJB
    private PurchaseRequestService purchaseRequestService;

    @POST
    @Path("/create")
    public StatusDto create(PurchaseRequestRequestDto PurchaseRequestRequestDto){
        return purchaseRequestService.create(PurchaseRequestRequestDto);
    }

    @PUT
    @Path("/update")
    public StatusDto update(@QueryParam( "id" ) long id, PurchaseRequestRequestDto purchaseRequestRequestDto){
        return purchaseRequestService.update(purchaseRequestRequestDto);
    }

    @DELETE
    @Path("/delete")
    public StatusDto deleteById(@QueryParam("id") Long id){
        return purchaseRequestService.deleteById(id);}



    @GET
    @Path("/listAllpurchaseRequest")
    public ListPurchaseRequestResponseDto listAllpurchaseRequest(@QueryParam("start") Integer start, @QueryParam("end") Integer end){
        return purchaseRequestService.listAllPurchaseRequest(start, end);
    }
}
