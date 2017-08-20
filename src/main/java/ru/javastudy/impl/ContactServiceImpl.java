package ru.javastudy.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javastudy.entities.ContactEntity;
import ru.javastudy.intf.ContactService;
import ru.javastudy.repository.ContactRepository;

import java.util.List;

@Service("jpaContactService")
@Repository
@Transactional
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<ContactEntity> findAll() {
        return Lists.newArrayList(contactRepository.findAll());
    }

    public List<ContactEntity> findByFirstName(String firstName) {
        return contactRepository.findByFirstName(firstName);
    }

    public List<ContactEntity> findByFirstNameAndLastName(String firstName, String lastName) {
        return contactRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public Integer contactsByHobby(String hobby) {
        return contactRepository.getContactsByHobby(hobby);
    }

}
