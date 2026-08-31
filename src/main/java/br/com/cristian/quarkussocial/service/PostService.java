package br.com.cristian.quarkussocial.service;

import br.com.cristian.quarkussocial.dto.post.PostRequestDTO;
import br.com.cristian.quarkussocial.dto.post.PostResponseDTO;
import br.com.cristian.quarkussocial.dto.user.UserResponseDTO;
import br.com.cristian.quarkussocial.entity.Post;
import br.com.cristian.quarkussocial.entity.User;
import br.com.cristian.quarkussocial.exceptions.FollowerException;
import br.com.cristian.quarkussocial.exceptions.UserException;
import br.com.cristian.quarkussocial.mapper.PostMapper;
import br.com.cristian.quarkussocial.repository.FollowerRepository;
import br.com.cristian.quarkussocial.repository.PostRepository;
import br.com.cristian.quarkussocial.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class PostService
{
    @Inject
    UserRepository userRepository;

    @Inject
    PostRepository postRepository;

    @Inject
    FollowerRepository followerRepository;

    @Inject
    PostMapper postMapper;

    public PostResponseDTO savePost( Long userId, PostRequestDTO postRequestDTO )
    {
        User user = userRepository.findById( userId );

        if ( user == null )
        {
            throw UserException.notFound( "Usuário não encontrado" );
        }

        Post post = postMapper.toEntity( postRequestDTO, user );

        postRepository.persist( post );

        return postMapper.toResponse( post );
    }

    public List<PostResponseDTO> findByUser( Long userId, Long followerId )
    {
        User user = userRepository.findById( userId );

        if ( user == null )
        {
            throw UserException.notFound( "Usuário não encontrado" );
        }

        User follower = userRepository.findById( followerId );

        if ( follower == null )
        {
            throw UserException.notFound( "Seguidor não encontrado" );
        }

        boolean follows = followerRepository.follower( user, follower );

        if ( ! follows )
        {
            throw FollowerException.forbidden( "você não tem permissão para ver esta página" );
        }

        return postRepository.findByUserId( user ).stream().map( postMapper::toResponse ).toList();
    }
}
