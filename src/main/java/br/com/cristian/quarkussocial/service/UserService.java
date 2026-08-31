package br.com.cristian.quarkussocial.service;

import br.com.cristian.quarkussocial.dto.user.UserRequestDTO;
import br.com.cristian.quarkussocial.dto.user.UserResponseDTO;
import br.com.cristian.quarkussocial.entity.User;
import br.com.cristian.quarkussocial.exceptions.UserException;
import br.com.cristian.quarkussocial.mapper.UserMapper;
import br.com.cristian.quarkussocial.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class UserService
{
    @Inject
    UserRepository userRepository;

    @Inject
    UserMapper userMapper;

    public List<UserResponseDTO> findAll()
    {
        return userRepository.listAll().stream().map( userMapper::toResponse ).toList();
    }

    public UserResponseDTO findById( Long id )
    {
        User user = userRepository.findById( id );

        if ( user == null )
        {
            throw UserException.notFound( "Usuário não encontrado" );
        }

        return userMapper.toResponse( user );
    }

    @Transactional
    public UserResponseDTO create( UserRequestDTO dto )
    {
        User user = userMapper.toEntity( dto );

        userRepository.persist( user );

        return userMapper.toResponse( user );
    }

    @Transactional
    public void update( Long id, UserRequestDTO dto )
    {
        User user = userRepository.findById( id );

        if ( user == null )
        {
            throw UserException.notFound( "Usuário não encontrado" );
        }

        user.setName( dto.getName() );
        user.setAge( dto.getAge() );
    }

    @Transactional
    public void delete( Long id )
    {
        User user = userRepository.findById( id );

        if ( user == null )
        {
            throw UserException.notFound( "Usuário não encontrado" );
        }

        userRepository.delete( user );
    }
}
