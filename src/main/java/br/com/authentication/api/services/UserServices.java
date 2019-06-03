package br.com.authentication.api.services;

import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.authentication.api.model.User;
import br.com.authentication.api.repository.UserRepository;

@Service
public class UserServices {

	@Autowired
	private UserRepository UserRepository;

	public User save(User User) {

		User.getEmailUser();
		User.setCreationDate(LocalDateTime.now());
		User.setLastLogin(LocalDateTime.now());
		return User = UserRepository.save(User);
	}

	public User update(Long id, User User) {
		User UserSave = UserRepository.findOne(id);
		if (UserSave == null) {
			throw new EmptyResultDataAccessException(1);
		}

		BeanUtils.copyProperties(User, UserSave, "id");
		return UserRepository.save(UserSave);
	}

	public void updatePropertyEmail(Long id, String emailUser) {
		User UserSave = UserRepository.findOne(id);
		UserSave.setEmailUser(emailUser);
		UserRepository.save(UserSave);

	}

}
