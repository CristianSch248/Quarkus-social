package br.com.cristian.quarkussocial.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table( name = "posts" )
public class Post
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;

    @Column( name = "post_text" )
    private String text;

    @Column( name = "date_time" )
    private LocalDateTime date_time;

    @ManyToOne
    @JoinColumn( name = "user_id")
    private User user;

    @PrePersist
    public void prePersist()
    {
        setDate_time( LocalDateTime.now() );
    }
}
