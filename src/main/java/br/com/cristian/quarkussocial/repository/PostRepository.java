package br.com.cristian.quarkussocial.repository;

import br.com.cristian.quarkussocial.entity.Post;
import br.com.cristian.quarkussocial.entity.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class PostRepository
    implements
        PanacheRepository<Post>
{
    public List<Post> findByUserId( User user )
    {
        return find( "user", user ).list();
    }
}
