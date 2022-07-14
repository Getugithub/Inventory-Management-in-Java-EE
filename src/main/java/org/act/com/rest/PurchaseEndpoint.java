package org.act.com.rest;
import io.swagger.annotations.Api;
import org.act.com.Dto.request.PurchaseRequestDto;
import org.act.com.Dto.response.ListPurchaseResponsseDto;
import org.act.com.Dto.response.StatusDto;
import org.act.com.service.PurchaseService;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("purchase")
@Api(value = "purchase")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PurchaseEndpoint {
    @EJB
    private PurchaseService purchaseService;

    @POST
    @Path("/create")
    public StatusDto create(PurchaseRequestDto purchaseRequestDto) {
        return purchaseService.create(purchaseRequestDto);
    }

    @PUT
    @Path("/update")
    public StatusDto update(@QueryParam("id") long id, PurchaseRequestDto purchaseRequestDto) {
        return purchaseService.update(id, purchaseRequestDto);
    }


    @DELETE
    @Path("/delete")
    public StatusDto deleteById(@QueryParam("id") Long id) {
        return purchaseService.deleteById(id);

    }

    @GET
    @Path("/listAllpurchase")
    public ListPurchaseResponsseDto listAllholding(@QueryParam("start") Integer start, @QueryParam("end") Integer end) {
        return purchaseService.listAllpurchase(start, end);
    }
}


