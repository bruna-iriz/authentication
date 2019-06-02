package br.com.authentication.api.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Size(min = 3, max = 50)
	private String nameUser;

	private String passwordUser;

	private LocalDateTime creationDate;
	private LocalDateTime lastLogin;
	private LocalDateTime alterationDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getPasswordUser() {
		return passwordUser;
	}

	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	public LocalDateTime getAlterationDate() {
		return alterationDate;
	}

	public void setAlterationDate(LocalDateTime alterationDate) {
		this.alterationDate = alterationDate;
	}

}
