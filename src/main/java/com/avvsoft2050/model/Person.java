package com.avvsoft2050.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "people")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int personId;

    @Column(name = "telegram_login")
    private String telegramLogin;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "city")
    private String city;

    @Column(name = "role_id")
    private int roleId;

    @Column(name = "group_id")
    private int groupId;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> messages;

    public Person() {
    }

    public Person(String telegramLogin, String name, String surname,
                  String city, int roleId, int groupId) {
        this.telegramLogin = telegramLogin;
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.roleId = roleId;
        this.groupId = groupId;
    }

    public void addMessageToPerson(Message message){
        if (messages == null){
            messages = new ArrayList<>();
        }
        messages.add(message);
        message.setPerson(this);
    }

    public void removeMessage(Message message){
        messages.remove(message);
    }

    public int getPersonId() {
        return personId;
    }

//    public void setPersonId(int personId) {
//        this.personId = personId;
//    }

    public String getTelegramLogin() {
        return telegramLogin;
    }

    public void setTelegramLogin(String telegramLogin) {
        this.telegramLogin = telegramLogin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", telegramLogin='" + telegramLogin + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", city='" + city + '\'' +
                ", roleId='" + roleId + '\'' +
                ", groupId='" + groupId + '\'' +
                '}';
    }
}
