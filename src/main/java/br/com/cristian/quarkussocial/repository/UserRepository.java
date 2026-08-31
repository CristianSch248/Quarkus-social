package br.com.cristian.quarkussocial.repository;

import br.com.cristian.quarkussocial.entity.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepository
    implements
        PanacheRepository<User>
{ }
