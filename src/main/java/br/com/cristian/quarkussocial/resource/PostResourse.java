package br.com.cristian.quarkussocial.resource;

import br.com.cristian.quarkussocial.dto.error.ResponseError;
import br.com.cristian.quarkussocial.dto.post.PostRequestDTO;
import br.com.cristian.quarkussocial.dto.post.PostResponseDTO;
import br.com.cristian.quarkussocial.dto.user.UserRequestDTO;
import br.com.cristian.quarkussocial.service.PostService;
import br.com.cristian.quarkussocial.service.UserService;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Set;

@Path("/users/{userId}/posts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PostResourse
{
    @Inject
    PostService postService;

    @Inject
    Validator validator;

    @POST
    public Response savePost( @PathParam( "userId" ) Long userId, PostRequestDTO postRequestDTO )
    {
        Set<ConstraintViolation<PostRequestDTO>> violationSet = validator.validate( postRequestDTO );

        if ( ! violationSet.isEmpty() )
        {
            return ResponseError.createFromValidation( violationSet ).withStatusCode( ResponseError.Unprocessable_Entity );
        }

        PostResponseDTO post = postService.savePost( userId, postRequestDTO );

        return Response.status( Response.Status.CREATED )
                       .entity( post )
                       .build();
    }

    @GET
    public Response listPosts( @PathParam( "userId" ) Long userId, @HeaderParam( "followerId" ) Long followerId )
    {
        List<PostResponseDTO> posts = postService.findByUser( userId, followerId );

        return Response.ok(posts).build();
    }
}
