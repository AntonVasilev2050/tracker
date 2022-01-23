package com.avvsoft2050.model;


import javax.persistence.*;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int messageId;

    @Column(name = "date_time")
    private long dateTime;

    @Column(name = "message")
    private String messageText;

//    @Column(name = "person_id")
//    private int personId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    public Message() {
    }

    public Message(long dateTime, String message) {
        this.dateTime = dateTime;
        this.messageText = message;
    }

    public int getMessageId() {
        return messageId;
    }

    public long getDateTime() {
        return dateTime;
    }

    public void setDateTime(long dateTime) {
        this.dateTime = dateTime;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String message) {
        this.messageText = message;
    }

//    public int getPersonId() {
//        return personId;
//    }
//
//    public void setPersonId(int person_id) {
//        this.personId = person_id;
//    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", dateTime=" + dateTime +
                ", message='" + messageText + '\'' +
                ", person=" + person +
                '}';
    }
}
