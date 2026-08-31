package br.com.cristian.quarkussocial.dto.post;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostResponseDTO
{
    private String text;
    private LocalDateTime date_time;
}
