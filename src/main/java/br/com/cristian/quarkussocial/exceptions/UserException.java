package br.com.cristian.quarkussocial.exceptions;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class UserException
    extends
        WebApplicationException
{
    private UserException( String message, Response.Status status )
    {
        super( message, status );
    }

    public static UserException notFound( String message )
    {
        return new UserException( message, Response.Status.NOT_FOUND );
    }

    public static UserException alreadyExists()
    {
        return new UserException( "Usuário já existe", Response.Status.CONFLICT );
    }

    public static UserException invalidUser()
    {
        return new UserException( "Usuário inválido", Response.Status.BAD_REQUEST );
    }

    public static UserException invalidLogin()
    {
        return new UserException( "nome inválido", Response.Status.BAD_REQUEST);
    }

    public static UserException cannotFollowYourself()
    {
        return new UserException( "O usuário não pode seguir a si mesmo", Response.Status.CONFLICT);
    }
}