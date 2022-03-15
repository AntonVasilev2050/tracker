package com.avvsoft2050.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

import static org.junit.jupiter.api.Assertions.*;

class RoboTrackerBotTest  {
    public com.avvsoft2050.service.RoboTrackerBot bot = new com.avvsoft2050.service.RoboTrackerBot();
    public Update update;

    @Test
    public void testBot(){
        Message message = new Message();

    }

}