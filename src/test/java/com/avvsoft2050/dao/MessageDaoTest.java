package com.avvsoft2050.dao;

import com.avvsoft2050.dao.MessageDaoImpl;
import com.avvsoft2050.model.Message;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MessageDaoTest {
    MessageDaoImpl messageDao = new MessageDaoImpl();
    private final String TEST_MESSAGE = "Test message: ";

    /**
     * Добавляем 10 записей в таблицу Messages и проверяем, что
     * размер этой таблицы увеличился на 10.
     */
    @Test
    public void whenTenMessagesWasAddedThenSizeIncreasedTen() {
        int sizeBefore = messageDao.getAllMessages().size();
        addTenMessagesToDB();
        int sizeAfter = messageDao.getAllMessages().size();
        assertEquals(10, sizeAfter - sizeBefore);
    }

    /**
     * Добавляем 10 тестовых записей в таблицу,
     * изменяем текст в каждом тестовом сообщении и
     * проверяем, что текст изменился.
     */
    @Test
    public void updateTestMessage() {
        List<Integer> list = addTenMessagesToDB();
        for (int messageId : list) {
            Message messageById = messageDao.getMessageById(messageId);
            messageById.setMessageText(TEST_MESSAGE + "was updated");
            messageDao.updateMessage(messageById);
            assertEquals(TEST_MESSAGE + "was updated", messageDao.getMessageById(messageId).getMessageText());
        }
    }

    /**
     * Добавляем 10 тестовых сообщений в таблицу и
     * затем удаляем все тестовые сообщения из таблицы.
     * После этого проверяем что таблица не содержит тестовых сообщений.
     */
    @Test
    public void deleteAllTestMessages() {
        addTenMessagesToDB();
        List<Message> list = messageDao.getAllMessages();
        for (Message message : list) {
            if (message.getMessageText().contains(TEST_MESSAGE)) {
                messageDao.deleteMessage(message);
            }
        }
        list = messageDao.getAllMessages();
        boolean allTestMessagesAreDeleted = true;
        for (Message message : list) {
            if (message.getMessageText().contains(TEST_MESSAGE)) {
                allTestMessagesAreDeleted = false;
                break;
            }
        }
        assertTrue(allTestMessagesAreDeleted);
    }


    /**
     * Добавляет 10 тестовых сообщений в таблицу messages
     * @return вернет лист, состоящий из Id добавленных записей.
     */
    private List<Integer> addTenMessagesToDB() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Message message = new Message(new Date().getTime() / 1000, TEST_MESSAGE + i);
            messageDao.addMessage(message);
            list.add(message.getMessageId());
        }
        return list;
    }
}