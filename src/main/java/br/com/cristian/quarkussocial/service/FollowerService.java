package br.com.cristian.quarkussocial.service;

import br.com.cristian.quarkussocial.dto.follower.FollowerPerUserResponseDTO;
import br.com.cristian.quarkussocial.dto.follower.FollowerRequestDTO;
import br.com.cristian.quarkussocial.dto.follower.FollowerResponseDTO;
import br.com.cristian.quarkussocial.entity.Follower;
import br.com.cristian.quarkussocial.entity.User;
import br.com.cristian.quarkussocial.exceptions.UserException;
import br.com.cristian.quarkussocial.repository.FollowerRepository;
import br.com.cristian.quarkussocial.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class FollowerService
{
    @Inject
    FollowerRepository followerRepository;

    @Inject
    UserRepository userRepository;

    public void followUser( Long userId, FollowerRequestDTO followerRequestDTO )
    {
        if ( userId.equals( followerRequestDTO.getFollower() ) )
        {
            throw UserException.cannotFollowYourself();
        }

        User user = userRepository.findById(userId);

        if ( user == null )
        {
            throw UserException.notFound( "Usuário não encontrado" );
        }

        User followerUser = userRepository.findById( followerRequestDTO.getFollower() );

        if ( followerUser == null )
        {
            throw UserException.notFound( "Seguidor não encontrado" );
        }

        boolean follow = followerRepository.follower( followerUser, user );

        if ( !follow )
        {
            Follower follower = new Follower();

            follower.setUser( user );
            follower.setFollower( followerUser );

            followerRepository.persist( follower );
        }
    }

    public FollowerPerUserResponseDTO findByUser( Long userId )
    {
        User user = userRepository.findById( userId );

        if ( user == null )
        {
            throw UserException.notFound( "Usuário não encontrado" );
        }

        List<Follower> followers = followerRepository.findByUser( user.getId() );

        List<FollowerResponseDTO> followerResponsDTOS = new ArrayList<>();

        for ( Follower follower : followers )
        {
            FollowerResponseDTO followerResponseDTO = new FollowerResponseDTO();
            followerResponseDTO.setId( follower.getId() );
            followerResponseDTO.setName( follower.getFollower().getName() );
            followerResponsDTOS.add( followerResponseDTO );
        }

        FollowerPerUserResponseDTO followerPerUserResponseDTO = new FollowerPerUserResponseDTO();

        followerPerUserResponseDTO.setFollowersCount( followers.size() );
        followerPerUserResponseDTO.setContent( followerResponsDTOS );

        return followerPerUserResponseDTO;
    }

    public void unfollowUser( Long userId, Long followerId )
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

        followerRepository.deleteByFollowerAndUser( user.getId(), follower.getId() );

    }
}
