package org.act.com.rest;
import io.swagger.annotations.Api;
import org.act.com.Dto.request.ResourceRequestRequestDto;
import org.act.com.Dto.response.ListPurchaseRequestResponseDto;
import org.act.com.Dto.response.ListResourcesRequestResponseDto;
import org.act.com.Dto.response.StatusDto;
import org.act.com.service.ResourceRequestService;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("ResourceRequest")
@Api(value = "ResourceRequest")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ResourcesRequestEndpoint {

    @EJB
    private ResourceRequestService resourcesRequestService;

    @POST
    @Path("/create")
    public StatusDto create(ResourceRequestRequestDto resourceRequestRequestDto) {
        return resourcesRequestService.create(resourceRequestRequestDto);
    }


    @PUT
    @Path("/update")
    public StatusDto update(@QueryParam("id") long id, ResourceRequestRequestDto resourceRequestRequestDto) {
        return resourcesRequestService.update(resourceRequestRequestDto);
    }
    @DELETE
    @Path("/delete")
    public StatusDto deleteById(@QueryParam("id") Long id){
        return resourcesRequestService.deleteById(id);
    }

    @GET
    @Path("/listALLResourcesRequest")
    public ListResourcesRequestResponseDto listAllholding(@QueryParam("start") Integer start, @QueryParam("end") Integer end){
        return resourcesRequestService.listAllresourceRequest(start, end);
    }

}

