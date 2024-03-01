package ru.rasul.MyFirstSpringSecurityApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rasul.MyFirstSpringSecurityApp.models.Person;
import ru.rasul.MyFirstSpringSecurityApp.repositories.PersonRepositories;

@Service
@Transactional(readOnly = true)
public class PersonService {
    private final PersonRepositories personRepositories;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PersonService(PersonRepositories personRepositories, PasswordEncoder passwordEncoder) {
        this.personRepositories = personRepositories;
        this.passwordEncoder = passwordEncoder;
    }
    @Transactional
    public void save(Person person){

        String password=person.getPassword();
        person.setPassword(passwordEncoder.encode(password));
        System.out.println(password);

        personRepositories.save(person);
    }

}
