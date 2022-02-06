package com.avvsoft2050.service;

import org.junit.jupiter.api.Test;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import static org.junit.jupiter.api.Assertions.*;

class RoboTrackerBotTest  {
    public RoboTrackerBot bot = new RoboTrackerBot();
    public Update update;

    @Test
    public void testBot(){
        bot.message.setText("Test10");
        bot.onUpdateReceived(update);
        update.getMessage().getText();
    }

}