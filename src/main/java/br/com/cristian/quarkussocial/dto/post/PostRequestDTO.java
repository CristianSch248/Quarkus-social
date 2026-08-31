package br.com.cristian.quarkussocial.dto.post;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PostRequestDTO
{
    @NotNull( message = "O texto do post é obrigatório" )
    private String text;
}
