package br.com.authentication.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.authentication.api.event.ResourceCreateEvent;
import br.com.authentication.api.model.User;
import br.com.authentication.api.repository.UserRepository;
import br.com.authentication.api.services.UserServices;

@RestController // Importando o Controlador REST
@RequestMapping("/users") // Mapeamento da requisição, uri padrão
public class UserController {

	@Autowired
	private UserRepository UserRepository;

	@Autowired
	private UserServices UserServices;

	@Autowired
	private ApplicationEventPublisher publisher;

	// Listando todos os Users
	@GetMapping
	public List<User> listUsers() {
		return UserRepository.findAll();

	}

	// Listando Users por ID
	@GetMapping("/{id}")
	public User searchUserId(@PathVariable(value = "id") Long id) {
		return UserRepository.findOne(id);
	}

	// Criando User
	@PostMapping
	public ResponseEntity<User> create(@Valid @RequestBody User User, HttpServletResponse response) {
		User UserSave = UserServices.save(User);
		publisher.publishEvent(new ResourceCreateEvent(this, response, UserSave.getId()));

		return ResponseEntity.status(HttpStatus.CREATED).body(UserSave);
	}

	// Atualizando User
	@PutMapping("/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @Valid @RequestBody User User) {
		User UserSave = UserServices.update(id, User);
		return ResponseEntity.ok(UserSave);

	}

	// Deletando User
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		UserRepository.delete(id);
	}

}
