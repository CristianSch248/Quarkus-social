package br.com.cristian.quarkussocial.repository;

import br.com.cristian.quarkussocial.entity.Follower;
import br.com.cristian.quarkussocial.entity.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Map;

@ApplicationScoped
public class FollowerRepository
    implements
        PanacheRepository<Follower>
{
    public boolean follower( User follower, User user )
    {
        return find( "follower = :follower and = :user ",
                     Parameters.with( "follower", follower )
                               .and( "user", user )
                               .map() ).firstResultOptional()
                                       .isPresent();
    }

    public List<Follower> findByUser( Long userId )
    {
        return find( "user.id", userId ).list();
    }

    public void deleteByFollowerAndUser( Long userId, Long followerId )
    {
        Map<String, Object> params = Parameters.with( "userId", userId )
                                               .and( "followerId", followerId )
                                               .map();

        delete( "follower.id = :followerId and user.id = :userId ", params );
    }
}
