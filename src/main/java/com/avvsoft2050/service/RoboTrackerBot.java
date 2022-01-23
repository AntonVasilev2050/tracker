package com.avvsoft2050.service;

import com.avvsoft2050.model.Message;
import com.avvsoft2050.model.Person;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoboTrackerBot extends TelegramLongPollingBot {
    RoboService roboService = new RoboService();
    static String message_text;
    static String chat_id;
    static String name;
    static String surname;
    static String userName;
    static int dateMSec;
    SendMessage message = new SendMessage(); // Create a message object object
    static boolean readyToGetMessage;

    @Override
    public String getBotUsername() {
        return "RoboTracker";
    }

    @Override
    public String getBotToken() {
        return "5004013720:AAFTs_DU2lobaljozzwPHsq4PrNIvRu93kM";
    }

    @Override
    public void onUpdateReceived(Update update) {
        checkMessage(update);
        message.setChatId(chat_id);
        message.setText("Привет " + name + "! Я RoboTracker. Выбирай команду ");
        setWelcomeButtons(message);
        try {
            switch (message_text) {
                case ("Администрирование"):
                    message.setText(name + ", извини, опция в разработке");
                    execute(message); // Sending our message object to user
                    break;
                case ("Передать трекинг"):
                    message.setText("Напиши чем занимаешься сейчас ");
                    hideWelcomeButtons(message);
                    readyToGetMessage = true;
                    execute(message);
                    break;
            }
            if (!(message_text.equals("Передать трекинг") || message_text.equals("Администрирование"))
                    && readyToGetMessage) {
                checkMessage(update);
                DateFormat simple = new SimpleDateFormat("dd MMM yyyy HH:mm Z");
                Date resultDate = new Date((long) dateMSec * 1000);
                System.out.println(name + "--" + userName);
                System.out.println(simple.format(resultDate));
                System.out.println(message_text);
                message.setText("Дата и время: " + resultDate
                        + "\n" + "Сообщение: " + "\n" + message_text
                        + "\n" + "---------------" + "\n" + "Отправлено!");

                execute(message);
                int personIdFromDB = roboService.getPersonIdFromDB(userName);
                Person person = new Person(userName, name, surname, "City", 1, 3);
                System.out.println(person);
                if (personIdFromDB == 0) {
                    roboService.addPerson(person);

                }
                //                    Получаем ID присвоенный новому person
                personIdFromDB = roboService.getPersonIdFromDB(userName);
                person = roboService.getPersonById(personIdFromDB);
                Message trackMessage = new Message(dateMSec, message_text);
                trackMessage.setPerson(person);
                roboService.addMessage(trackMessage);
                readyToGetMessage = false;
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }


    private static void checkMessage(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            // Set variables
            message_text = update.getMessage().getText();
            chat_id = String.valueOf(update.getMessage().getChatId());
            name = update.getMessage().getChat().getFirstName();
            surname = update.getMessage().getChat().getLastName();
            userName = update.getMessage().getChat().getUserName();
            dateMSec = update.getMessage().getDate();
        }
    }


    public synchronized void setWelcomeButtons(SendMessage sendMessage) {
        // Создаем клавиатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(true);

        // Создаем список строк клавиатуры
        List<KeyboardRow> keyboard = new ArrayList<>();

        // Первая строчка клавиатуры
        KeyboardRow keyboardFirstRow = new KeyboardRow();
        // Добавляем кнопки в первую строчку клавиатуры
        keyboardFirstRow.add(new KeyboardButton("Передать трекинг"));

        // Вторая строчка клавиатуры
        KeyboardRow keyboardSecondRow = new KeyboardRow();
        // Добавляем кнопки во вторую строчку клавиатуры
        keyboardSecondRow.add(new KeyboardButton("Администрирование"));

        // Добавляем все строчки клавиатуры в список
        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);
        // и устанавливаем этот список нашей клавиатуре
        replyKeyboardMarkup.setKeyboard(keyboard);
    }

    public synchronized void hideWelcomeButtons(SendMessage sendMessage) {
        // Создаем клавиатуру
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        // Создаем список строк клавиатуры
        List<KeyboardRow> keyboard = new ArrayList<>();

//        // Первая строчка клавиатуры
//        KeyboardRow keyboardFirstRow = new KeyboardRow();
//        // Добавляем кнопки в первую строчку клавиатуры
//        keyboardFirstRow.add(new KeyboardButton("Передать трекинг"));
//
//        // Вторая строчка клавиатуры
//        KeyboardRow keyboardSecondRow = new KeyboardRow();
//        // Добавляем кнопки во вторую строчку клавиатуры
//        keyboardSecondRow.add(new KeyboardButton("Администрирование"));

//        // Добавляем все строчки клавиатуры в список
//        keyboard.add(keyboardFirstRow);
//        keyboard.add(keyboardSecondRow);
//        // и устанавливаем этот список нашей клавиатуре
        replyKeyboardMarkup.setKeyboard(keyboard);
    }

    private void setInline() {
        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
        List<InlineKeyboardButton> buttons1 = new ArrayList<>();
//        buttons1.add(1, new InlineKeyboardButton().setText("Button"));
        buttons.add(buttons1);

        InlineKeyboardMarkup markupKeyboard = new InlineKeyboardMarkup();
        markupKeyboard.setKeyboard(buttons);
    }
}
