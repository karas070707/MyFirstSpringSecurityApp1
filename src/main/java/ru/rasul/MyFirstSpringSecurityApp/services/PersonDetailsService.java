package ru.rasul.MyFirstSpringSecurityApp.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.rasul.MyFirstSpringSecurityApp.models.Person;
import ru.rasul.MyFirstSpringSecurityApp.repositories.PersonRepositories;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {
    @Autowired
    private  PersonRepositories personRepositories;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person= personRepositories.findByUserName(username);
        if (person.isEmpty()){

            throw new UsernameNotFoundException("user not found");
        }
            else{
            Person personDetails=person.get();

            System.out.println(personDetails.getUserName()+personDetails.getPassword());
            return User.builder()
                    .username(personDetails.getUserName())
                    .password(personDetails.getPassword())

                    .roles("USER")
                    .build();
        }

    }
}
