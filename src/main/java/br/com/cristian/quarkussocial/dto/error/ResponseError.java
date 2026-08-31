package br.com.cristian.quarkussocial.dto.error;

import jakarta.validation.ConstraintViolation;
import jakarta.ws.rs.core.Response;
import lombok.Data;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
public class ResponseError
{
    public static int Unprocessable_Entity = 422;

    private String message;
    private Collection<FieldError> errors;

    public ResponseError( String message, List<FieldError> errors )
    {
        this.message = message;
        this.errors = errors;
    }

    public static <T> ResponseError createFromValidation( Set<ConstraintViolation<T>> violationSet )
    {
        List<FieldError> errors = violationSet.stream().map( tConstraintViolation ->
                new FieldError( tConstraintViolation.getPropertyPath().toString(),
                                tConstraintViolation.getMessage() ) ).toList();

        String message = "Validation error";

        return new ResponseError( message, errors );
    }

    public Response withStatusCode( int code )
    {
        return Response.status( code ).entity( this ).build();
    }
}
