package br.com.cristian.quarkussocial.resource;

import br.com.cristian.quarkussocial.dto.follower.FollowerPerUserResponseDTO;
import br.com.cristian.quarkussocial.service.FollowerService;
import br.com.cristian.quarkussocial.dto.follower.FollowerRequestDTO;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/users/{userId}/followers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FollowerResource
{
    @Inject
    FollowerService service;

    @PUT
    @Transactional
    public Response followUser( @PathParam( "userId" ) Long userId, FollowerRequestDTO followerRequestDTO )
    {
        service.followUser( userId, followerRequestDTO );

        return Response.status( Response.Status.NO_CONTENT ).build();
    }

    @GET
    public Response findByUser( @PathParam( "userId" ) Long userId )
    {
        FollowerPerUserResponseDTO followerPerUserResponseDTO = service.findByUser( userId );

        return Response.ok( followerPerUserResponseDTO ).build();
    }

    public Response unfollowUser( @PathParam("userId") Long userId, @QueryParam( "followerId" ) Long followerId )
    {
        service.unfollowUser( userId, followerId );

        return Response.status( Response.Status.NO_CONTENT ).build();
    }
}
