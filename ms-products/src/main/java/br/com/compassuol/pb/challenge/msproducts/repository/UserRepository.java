package br.com.compassuol.pb.challenge.msproducts.repository;

import br.com.compassuol.pb.challenge.msproducts.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    Optional<User> findByFirstNameOrEmail(String firstName, String email);

    Optional<User> findByFirstName(String firstName);

    Boolean existsByFirstName(String firstName);

    Boolean existsByEmail(String email);
}
