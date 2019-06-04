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
import br.com.authentication.api.model.Phone;
import br.com.authentication.api.repository.PhoneRepository;
import br.com.authentication.api.services.PhoneServices;

@RestController // Importando o Controlador REST
@RequestMapping("/phones") // Mapeamento da requisição, uri padrão
public class PhoneController {

	@Autowired
	private PhoneRepository PhoneRepository;

	@Autowired
	private PhoneServices PhoneServices;

	@Autowired
	private ApplicationEventPublisher publisher;

	// Listando todos os Phones
	@GetMapping
	public List<Phone> listPhones() {
		return PhoneRepository.findAll();

	}

	// Listando Phones por ID
	@GetMapping("/{id}")
	public Phone searchPhoneId(@PathVariable(value = "id") Long id) {
		return PhoneRepository.findOne(id);
	}

	// Criando Phone
	@PostMapping
	public ResponseEntity<Phone> create(@Valid @RequestBody Phone Phone, HttpServletResponse response) {
		Phone PhoneSave = PhoneServices.save(Phone);
		publisher.publishEvent(new ResourceCreateEvent(this, response, PhoneSave.getId()));

		return ResponseEntity.status(HttpStatus.CREATED).body(PhoneSave);
	}

	// Atualizando Phone
	@PutMapping("/{id}")
	public ResponseEntity<Phone> update(@PathVariable Long id, @Valid @RequestBody Phone Phone) {
		Phone PhoneSave = PhoneServices.update(id, Phone);
		return ResponseEntity.ok(PhoneSave);

	}

	// Deletando Phone
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		PhoneRepository.delete(id);
	}

}
