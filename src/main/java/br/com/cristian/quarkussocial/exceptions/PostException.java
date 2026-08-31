package br.com.cristian.quarkussocial.exceptions;

import jakarta.ws.rs.WebApplicationException;

public class PostException
     extends
        WebApplicationException
{

    private PostException( String message )
    {
        super( message );
    }

    public static PostException notFound()
    {
        return new PostException( "Post não encontrado" );
    }

    public static PostException invalidLogin()
    {
        return new PostException( "Post inválido" );
    }
}
