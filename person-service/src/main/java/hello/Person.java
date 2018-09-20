package hello;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
class Person {

	Person(Long id, String name, String surname) {
		this.id = id;
		this.name = name;
		this.surname = surname;
	}

	protected Person() {}
		
	@Id
	private Long id;

	private String name;

	private String surname;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getsurname() {
		return surname;
	}

	public void setsurname(String surname) {
		this.surname = surname;
	}
}
