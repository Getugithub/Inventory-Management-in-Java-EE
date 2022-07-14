package org.act.com.rest;
import io.swagger.annotations.Api;
import org.act.com.Dto.request.HoldingsRequestDto;
import org.act.com.Dto.response.HoldingResponseDto;
import org.act.com.Dto.response.HoldingResponseDto;
import org.act.com.Dto.response.ListHoldingResponseDto;
import org.act.com.Dto.response.StatusDto;
import org.act.com.model.Holdings;
import org.act.com.service.HoldingsService;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("holding")
@Api(value = "holding")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class HoldingsEndpoint {
    @EJB
    private HoldingsService holdingService;

    @POST
    @Path("/create")
    public StatusDto create(HoldingsRequestDto holdingsRequestDto)
    {
        return holdingService.create(holdingsRequestDto);
    }

    @PUT
    @Path("/update")
    public StatusDto update(@QueryParam("id") long id, HoldingsRequestDto holdingRequestDto) {
        return holdingService.update(holdingRequestDto);
    }

    @DELETE
    @Path("/delete")
    public StatusDto deleteById(@QueryParam("id") Long id) {
        return holdingService.deleteById(id);
    }


    @GET
    @Path("/listAllholdings")
    public ListHoldingResponseDto listAllholding(@QueryParam("start") Integer start,@QueryParam("end") Integer end){
        return holdingService.listAllholding(start, end);
    }

}

