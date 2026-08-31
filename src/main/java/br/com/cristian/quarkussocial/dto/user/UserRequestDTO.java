package br.com.cristian.quarkussocial.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRequestDTO
{
    @NotBlank( message = "O Nome é obrigatório" )
    private String name;

    @NotNull( message = "A idade é obrigatória" )
    private int age;
}
