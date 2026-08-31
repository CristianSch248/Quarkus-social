package br.com.cristian.quarkussocial.mapper;

import br.com.cristian.quarkussocial.dto.post.PostRequestDTO;
import br.com.cristian.quarkussocial.dto.post.PostResponseDTO;
import br.com.cristian.quarkussocial.entity.Post;
import br.com.cristian.quarkussocial.entity.User;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PostMapper
{
    public Post toEntity( PostRequestDTO dto, User user )
    {
        Post post = new Post();
        post.setText( dto.getText() );
        post.setUser( user );
        return post;
    }

    public PostResponseDTO toResponse( Post post )
    {
        PostResponseDTO responseDTO = new PostResponseDTO();
        responseDTO.setText( post.getText() );
        responseDTO.setDate_time( post.getDate_time() );
        return responseDTO;
    }
}
