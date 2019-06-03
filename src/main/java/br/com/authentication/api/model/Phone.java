package br.com.authentication.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phone")
public class Phone {

	@Id
	@GeneratedValue()
	private Long id;
	private String dddPhone;
	private String numberPhone;

	/*
	 * @ManyToMany(mappedBy = "phones") private List<User> users;
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getdddPhone() {
		return dddPhone;
	}

	public void setdddPhone(String dddPhone) {
		this.dddPhone = dddPhone;
	}

	public String getnumberPhone() {
		return numberPhone;
	}

	public void setnumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}
}
