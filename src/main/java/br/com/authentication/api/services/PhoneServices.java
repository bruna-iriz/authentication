package br.com.authentication.api.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.authentication.api.model.Phone;
import br.com.authentication.api.repository.PhoneRepository;

@Service
public class PhoneServices {

	@Autowired
	private PhoneRepository PhoneRepository;

	public Phone save(Phone Phone) {
		return PhoneRepository.save(Phone);
	}

	public Phone update(Long id, Phone Phone) {
		Phone PhoneSave = PhoneRepository.findOne(id);
		if (PhoneSave == null) {
			throw new EmptyResultDataAccessException(1);
		}

		BeanUtils.copyProperties(Phone, PhoneSave, "id");
		return PhoneRepository.save(PhoneSave);
	}

	public void updatePropertyEmail(Long id, String numberPhone) {
		Phone PhoneSave = PhoneRepository.findOne(id);
		PhoneSave.setnumberPhone(numberPhone);
		PhoneRepository.save(PhoneSave);

	}
}
