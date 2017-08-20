package ru.javastudy.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.javastudy.entities.ContactEntity;

import java.util.List;

public interface ContactRepository extends CrudRepository<ContactEntity, Integer> {

    List<ContactEntity> findByFirstName(String firstName);

    List<ContactEntity> findByFirstNameAndLastName(String firstName, String lastName);

    @Procedure
    Integer getContactsByHobby(String hobby);

}
