package com.example.SpringHomework11.service;

import com.example.SpringHomework11.model.Person;
import com.example.SpringHomework11.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public List<Person> findAllPerson(){
        return personRepository.findAll();
    }

    public Person createPerson(Person person){
        return personRepository.save(person);
    }

    public void deletePersonById(Long id) {
        personRepository.deleteById(id);
    }

    public Person updatePersonById(Long id, Person personToUpdate) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isPresent()) {
            Person person = optionalPerson.get();
            person.setFirstName(personToUpdate.getFirstName());
            person.setLastName(personToUpdate.getLastName());
            person.setAge(personToUpdate.getAge());
            person.setCity(personToUpdate.getCity());
            person.setEmail(personToUpdate.getEmail());
            return personRepository.save(person);
        } else {
            throw new IllegalArgumentException("Task not found with id: " + id);
        }
    }

}
