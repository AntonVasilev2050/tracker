package com.avvsoft2050.dao;

import com.avvsoft2050.model.Message;
import com.avvsoft2050.model.Person;

import java.util.List;

public interface MessageDao {
    void addMessage(Message message);
    void deleteMessage(int messageId);
    void updateMessage(Message message);
    List<Message> getAllMessages();
    Message getMessageById(int messageId);
}
