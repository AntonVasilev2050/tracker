package com.avvsoft2050.service;

import com.avvsoft2050.dao.MessageDaoImpl;
import com.avvsoft2050.dao.PersonDaoImpl;
import com.avvsoft2050.model.Message;
import com.avvsoft2050.model.Person;

import java.util.List;

public class RoboService {
    private MessageDaoImpl messageDao = new MessageDaoImpl();
    private PersonDaoImpl personDao = new PersonDaoImpl();

    public RoboService(){
    }

    public void addMessage(Message message){
        messageDao.addMessage(message);
    }

    public void deleteMessage(int messageId) {
        messageDao.deleteMessage(messageId);
    }

    public void updateMessage(Message message){
        messageDao.updateMessage(message);
    }

    public List<Message> getAllMessages(){
        return messageDao.getAllMessages();
    }

    public Message getMessageById(int messageId){
        return messageDao.getMessageById(messageId);
    }

    public void addPerson(Person person){
        personDao.addPerson(person);
    }

    public void deletePerson(int personId){
        personDao.deletePerson(personId);
    }

    public void updatePerson(Person person){
        personDao.updatePerson(person);
    }

    public List<Person> getAllPeople(){
        return personDao.getAllPeople();
    }

    public Person getPersonById(int personId){
        return personDao.getPersonById(personId);
    }

    public int getPersonIdFromDB(String telegramUserName){
        int personId = 0;
        List<Person> list = getAllPeople();
        for (Person p: list){
            if(p.getTelegramLogin().equals(telegramUserName)){
                personId = p.getPersonId();
            }
        }
        return personId;
    }

//    public int getPersonIdFromDB(String telegramUserName){
//        return personDao.getIdByUserName(telegramUserName);
//    }
}
