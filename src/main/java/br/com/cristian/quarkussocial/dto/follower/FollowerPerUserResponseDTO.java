package br.com.cristian.quarkussocial.dto.follower;

import lombok.Data;

import java.util.List;

@Data
public class FollowerPerUserResponseDTO
{
    private Integer followersCount;
    private List<FollowerResponseDTO> content;
}
