package ru.rasul.MyFirstSpringSecurityApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rasul.MyFirstSpringSecurityApp.models.Person;

import java.util.Optional;

@Repository
public interface PersonRepositories extends JpaRepository<Person,Integer> {

    Optional<Person> findByUserName(String name);
}
