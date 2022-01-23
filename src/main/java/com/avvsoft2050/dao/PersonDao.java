package com.avvsoft2050.dao;

import com.avvsoft2050.model.Person;

import java.util.List;

public interface PersonDao {
    void addPerson(Person person);
    void deletePerson(int personId);
    void updatePerson(Person person);
    List<Person> getAllPeople();
    Person getPersonById(int personId);
}
