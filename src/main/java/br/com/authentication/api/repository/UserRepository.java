package br.com.authentication.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.authentication.api.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findAll();
}
