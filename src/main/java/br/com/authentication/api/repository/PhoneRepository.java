package br.com.authentication.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.authentication.api.model.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {
	List<Phone> findAll();
}
