//package assistenbot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
//import org.apache.log4j.*;

public class AssistantBot extends TelegramLongPollingBot {

    private static MessageHandler messageHandler;
    //example Start
    public static void main(String[] args) {
        messageHandler = new MessageHandler();
        ApiContextInitializer.init();
        TelegramBotsApi botapi = new TelegramBotsApi();
        try {
            botapi.registerBot(new AssistantBot());
        } catch (TelegramApiException e) {
            //write error massage
        }
    }

    //example answer TEXT
    private void sendTextMsg(Message msg, String text) {
        try {
            execute(new SendMessage().setChatId(msg.getChatId()).setText(text));
        } catch (Exception e) {
//            LOG.error("Can't send Text message: ", e);
        }
    }

    //example answer GIF
    public void sendGIFMsg(Message msg, String gif) {
        try {
            execute(new SendDocument().setChatId(msg.getChatId()).setDocument(gif));
        } catch (Exception e) {
//            LOG.error("Can't send GIF message: ", e);
        }
    }

    //example answer IMAGE
    public void sendImageMsg(Message msg, String image) {
        try {
            execute(new SendPhoto().setChatId(msg.getChatId()).setPhoto(image));
        } catch (Exception e) {
//            LOG.error("Can't send Photo message: ", e);
        }
    }

    @Override
    public void onUpdateReceived(Update update) {
        //Bot reads message here

        Message message = update.getMessage();

        if (message != null && message.hasText()){
            /*if (message.getText().contains("Hello"))
                sendTextMsg(message, "Hello world");
            else
                sendTextMsg(message, "Brave new world!!!");*/
            try {
                sendTextMsg(message, messageHandler.textToText(message.getText()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "KPIStudentAssistantBot";
    }

    @Override
    public String getBotToken() {
        return "671085580:AAFs9dTaGNubXMp04Ep8JxnR-UCS7dmLQf4";
    }
}