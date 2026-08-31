package br.com.cristian.quarkussocial.mapper;

import br.com.cristian.quarkussocial.dto.user.UserRequestDTO;
import br.com.cristian.quarkussocial.dto.user.UserResponseDTO;
import br.com.cristian.quarkussocial.entity.User;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserMapper
{
    public User toEntity( UserRequestDTO dto )
    {
        User user = new User();
        user.setName( dto.getName() );
        user.setAge( dto.getAge() );
        return user;
    }

    public UserResponseDTO toResponse( User user )
    {
        UserResponseDTO responseDTO = new UserResponseDTO();
        responseDTO.setName( user.getName() );
        responseDTO.setAge( user.getAge() );
        return responseDTO;
    }
}
