package br.com.cristian.quarkussocial.exceptions;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class FollowerException
    extends
        WebApplicationException
{
    public FollowerException( String message, Response.Status status )
    {
        super( message, status );
    }

    public static FollowerException forbidden( String message )
    {
        return new FollowerException( message, Response.Status.FORBIDDEN );
    }
}
