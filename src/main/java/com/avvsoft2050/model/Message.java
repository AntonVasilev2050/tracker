package com.avvsoft2050.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private int messageID;

    @Column(name = "date_time")
    private Date dateTime;

    @Column(name = "message")
    private String message;

    @Column(name = "person_id")
    private int person_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    public Message() {
    }

    public Message(int messageID, Date dateTime, String message, int person_id) {
        this.messageID = messageID;
        this.dateTime = dateTime;
        this.message = message;
        this.person_id = person_id;
    }

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageID=" + messageID +
                ", dateTime=" + dateTime +
                ", message='" + message + '\'' +
                ", person_id=" + person_id +
                '}';
    }
}
