package br.com.cristian.quarkussocial.resource;

import br.com.cristian.quarkussocial.dto.error.ResponseError;
import br.com.cristian.quarkussocial.dto.user.UserResponseDTO;
import br.com.cristian.quarkussocial.dto.user.UserRequestDTO;
import br.com.cristian.quarkussocial.service.UserService;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Set;

@Path( "/users" )
@Consumes( MediaType.APPLICATION_JSON )
@Produces( MediaType.APPLICATION_JSON )
public class UserResource
{
    @Inject
    UserService userService;

    @Inject
    Validator validator;

    @GET
    public List<UserResponseDTO> findAll()
    {
        return userService.findAll();
    }

    @GET
    @Path("/{id}")
    public UserResponseDTO findById( @PathParam( "id" ) Long id )
    {
        return userService.findById( id );
    }

    @POST
    public Response create( UserRequestDTO dto )
    {
        Set<ConstraintViolation<UserRequestDTO>> violationSet = validator.validate( dto );

        if ( ! violationSet.isEmpty() )
        {
            return ResponseError.createFromValidation( violationSet ).withStatusCode( ResponseError.Unprocessable_Entity );
        }

        UserResponseDTO userResponseDTO = userService.create( dto );
        return Response.status( Response.Status.CREATED ).entity( userResponseDTO ).build();
    }

    @PUT
    @Path( "/{id}" )
    public Response update( @PathParam( "id" ) Long id, UserRequestDTO dto )
    {
        userService.update( id, dto );
        return Response.noContent().build();
    }

    @DELETE
    @Path( "/{id}" )
    public Response delete( @PathParam( "id" ) Long id )
    {
        userService.delete( id );
        return Response.noContent().build();
    }
}
