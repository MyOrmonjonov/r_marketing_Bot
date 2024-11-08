package org.example;

import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.example.BotServis.telegramBot;

public class BotController {
    public static void start() {
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        telegramBot.setUpdatesListener((updates)->{
            for (Update update : updates) {
                executorService.execute(()->{
                    handleUpdate(update);
                });

            }
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });

    }

    private static void handleUpdate(Update update) {
        if(update.message()!=null){
            Message message = update.message();
            TgUser selectedUser=generikCreateUser(message.chat().id());
            if(message.text()!=null&&message.text().equals("/start")){
                BotServis.startAndLanguage(selectedUser);
            }else if(selectedUser.getState().equals(State.SAVE_NAME_AND_PHONE)){
                BotServis.saveNameAndPhone(selectedUser,message);
            }else if(message.contact()!=null){
                BotServis.saveContactAndXizmatlar(selectedUser,message.contact());
            }else if(selectedUser.getState().equals(State.XIZMAT_AND_TARIF)) {
                BotServis.showXizmat(selectedUser, message);
            }

        }if(update.callbackQuery()!=null){
            CallbackQuery callbackQuery = update.callbackQuery();
            Message message = update.message();
            String data = callbackQuery.data();
            TgUser selectedUser = generikCreateUser(callbackQuery.from().id());
            if (selectedUser.getState().equals(State.SAVE_LANGUAGE_AND_PHONE_NUMBER)) {
                BotServis.languageAndPhoneNumber(selectedUser, data);
            }else if(selectedUser.getState().equals(State.TARIF_IN)){
                BotServis.tarifInBasket(selectedUser,data,message);
            }else if(selectedUser.getState().equals(State.BASKET_SUCSECCTARIF)){
                BotServis.setAdminMessegeTarif(selectedUser,data);
            }

        }
    }



    private static TgUser generikCreateUser(Long id) {
        for (TgUser tgUser : DB.tgUser) {
            if(tgUser.getId().equals(id)){
                return tgUser;
            }
        }
        TgUser tgUser=new TgUser();
        tgUser.setId(id);
        DB.tgUser.add(tgUser);
        return tgUser;
    }
}
