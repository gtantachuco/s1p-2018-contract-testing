package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class PersonService {

	@Autowired
	PersonRepository personRepository;
	
	public PersonService() {
	}
	
	Person findPersonById(Long id) {
		return personRepository.findById(id).get();
	}
}
