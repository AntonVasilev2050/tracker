package com.avvsoft2050;


import com.avvsoft2050.service.RoboTrackerBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {
        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new RoboTrackerBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
