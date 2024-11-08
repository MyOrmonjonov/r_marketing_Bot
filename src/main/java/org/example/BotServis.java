package org.example;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Contact;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.request.KeyboardButton;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import com.pengrad.telegrambot.request.DeleteMessage;
import com.pengrad.telegrambot.request.EditMessageReplyMarkup;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;

import java.util.ArrayList;
import java.util.List;

public class BotServis {

    public static TelegramBot telegramBot = new TelegramBot("8086274425:AAGD3vzCAo5u6ZjcwfXMTn0i3crqfpG7oxY");
    static List<Hizmatlar> basketXizmat = new ArrayList<>();
    static List<Tariflar> tarifBasket = new ArrayList<>();

    public static void startAndLanguage(TgUser selectedUser) {
        SendMessage sendMessage = new SendMessage(selectedUser.getId(), "Tilni tanlang/Выберите язык");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.addRow(new InlineKeyboardButton("uz\uD83C\uDDFA\uD83C\uDDFF").callbackData("uz"), new InlineKeyboardButton("ru\uD83C\uDDF7\uD83C\uDDFA").callbackData("ru"));
        sendMessage.replyMarkup(inlineKeyboardMarkup);
        telegramBot.execute(sendMessage);
        selectedUser.setState(State.SAVE_LANGUAGE_AND_PHONE_NUMBER);
    }

    public static void languageAndPhoneNumber(TgUser selectedUser, String data) {
        if (data.equals("uz")) {
            selectedUser.setLanguage("uz");
            languageCreator(selectedUser, "\uD83D\uDE4B\uD83C\uDFFB\u200D♂\uFE0F Assalomu aleykum  sizni botimizda ko'rib turganimizdan xursandmiz. To'liq ism sharifingizni kiriting");
        }
        if (data.equals("ru")) {
            selectedUser.setLanguage("ru");
            languageCreator(selectedUser, "\uD83D\uDE4B\uD83C\uDFFB\u200D♂\uFE0F Здравствуйте, мы рады видеть вас в нашем боте. Введите свое полное имя");
        }

    }

    public static void languageCreator(TgUser selectedUser, String s1) {
        SendMessage sendMessage = new SendMessage(selectedUser.getId(), s1);
        telegramBot.execute(sendMessage);
        selectedUser.setState(State.SAVE_NAME_AND_PHONE);
    }

    public static void saveNameAndPhone(TgUser selectedUser, Message message) {
        selectedUser.setName(message.text());
        if (selectedUser.getLanguage().equals("uz")) {
            phoneNumberSendMessege(selectedUser, "Telefon raqamingizni yuboring:", "Kontakt yuborish");
        }
        if (selectedUser.getLanguage().equals("ru")) {
            phoneNumberSendMessege(selectedUser, "Отправьте свой номер телефона", "Отправить контакт");
        }
    }

    public static void phoneNumberSendMessege(TgUser selectedUser, String s, String button) {
        SendMessage sendMessage = new SendMessage(selectedUser.getId(), s);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup(new KeyboardButton("☎️" + button).requestContact(true)).resizeKeyboard(true);
        sendMessage.replyMarkup(replyKeyboardMarkup);
        SendResponse execute = telegramBot.execute(sendMessage);
        selectedUser.setMessegeId(execute.message().messageId());
        selectedUser.setState(State.SAVE_CONTACT_AND_XIZMATLAR);
    }

    public static void saveContactAndXizmatlar(TgUser selectedUser, Contact contact) {
        selectedUser.setContact(contact);
        if (selectedUser.getLanguage().equals("uz")) {
            createButtonXizmatlarCategory(selectedUser, "📃Tariflar");
        }
       if (selectedUser.getLanguage().equals("ru")) {
            createButtonXizmatlarCategory(selectedUser, "📃Тарифы");
        }
    }

    private static void createButtonXizmatlarCategory(TgUser selectedUser, String s) {
       String messege="Выбирать";
        SendMessage sendMessage=null;
        if(selectedUser.getLanguage().equals("uz")){
         sendMessage = new SendMessage(selectedUser.getId(), "Tanlang:");
        }else {
            sendMessage = new SendMessage(selectedUser.getId(), messege);
        }
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup(new KeyboardButton(s)).resizeKeyboard(true);
        sendMessage.replyMarkup(replyKeyboardMarkup);
        SendResponse execute = telegramBot.execute(sendMessage);
        selectedUser.setMessegeId(execute.message().messageId());
        selectedUser.setState(State.XIZMAT_AND_TARIF);
    }

    public static void showXizmat(TgUser selectedUser, Message message) {
        selectedUser.setTgmessege(message);
        if (selectedUser.getLanguage().equals("uz")) {
            if (message.text().endsWith("Tariflar")) {
                tarifshowers(selectedUser, message, "📃Tariflar", "Tanlang", "Orqaga🔙");
            }
        }
        if (selectedUser.getLanguage().equals("ru")) {
            if (message.text().endsWith("Тарифы")) {
                tarifshowers(selectedUser, message, "📃Тарифы", "Выбирать", "Назад🔙");
            }
        }
    }


    private static void tarifshowers(TgUser selectedUser, Message message, String s, String tanlang, String s1) {
        if (message.text() != null && message.text().startsWith(s)) {
            DeleteMessage deleteMessage = new DeleteMessage(selectedUser.getId(), selectedUser.getMessegeId());
            telegramBot.execute(deleteMessage);
            InlineKeyboardMarkup inlineKeyboardMarkup=new InlineKeyboardMarkup();
            for (Tariflar tariflar : DB.tariflar) {
                inlineKeyboardMarkup.addRow(new InlineKeyboardButton("➖➖➖➖"+tariflar.getTitle()+"➖➖➖➖ ").callbackData(tariflar.getId()+""));
            }
            String messege="Тарифы";
            SendMessage sendMessage=null;
            if(selectedUser.getLanguage().equals("uz")){
             sendMessage=new SendMessage(selectedUser.getId(),"Tariflar");
            }
            else sendMessage=new SendMessage(selectedUser.getId(),messege);
            SendMessage sendMessage1 = sendMessage.replyMarkup(inlineKeyboardMarkup);
            SendResponse execute = telegramBot.execute(sendMessage);
            selectedUser.setMessegeId(execute.message().messageId());
            selectedUser.setState(State.TARIF_IN);
        }
    }

    public static void tarifInBasket(TgUser selectedUser, String data, Message message) {
        for (Tariflar tariflar : DB.tariflar) {
            if (data.equals(tariflar.getId() + "")) {
                tarifBasket.add(tariflar);
            }
        }

        DeleteMessage deleteMessage=new DeleteMessage(selectedUser.getId(),selectedUser.getMessegeId());
        telegramBot.execute(deleteMessage);
        EditMessageReplyMarkup editMessageReplyMarkup=new EditMessageReplyMarkup(selectedUser.getId(),selectedUser.getMessegeId());
        telegramBot.execute(editMessageReplyMarkup);
        if (data.equals("back")){
            saveContactAndXizmatlar(selectedUser,selectedUser.getContact());
        }

        if(selectedUser.getLanguage().equals("uz")){
            basketAddedTarif(selectedUser, data,"Kelishuvni imzolash🤝","Orqaga⬅️","\n","\uD83D\uDCC3Nimalarni o'z ichiga oladi?","💵Narxi:$");
        }
        if(selectedUser.getLanguage().equals("ru")){
            basketAddedTarif(selectedUser,data,"Покупка🤝","Назад⬅️","\n","📃Что это включает в себя?","💵Цена:$");
        }
    }

    private static void basketAddedTarif(TgUser selectedUser, String data, String buttonName, String back, String name, String about, String price) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        SendMessage sendMessage = null;

        for (Tariflar tariflar : DB.tariflar) {
            if (data.equals(String.valueOf(tariflar.getId()))) {
                if (selectedUser.getLanguage().equals("ru")) {
                    if (tariflar.getPrice() != null) {
                        sendMessage = new SendMessage(selectedUser.getId(), name + tariflar.getTitleRu() + "\n\n" + about + tariflar.getMalumotRu() + "\n" + price + tariflar.getPrice());
                    } else {
                        sendMessage = new SendMessage(selectedUser.getId(), name + tariflar.getTitleRu() + "\n\n" + about + tariflar.getMalumotRu() + "\n" +"\uD83D\uDCB5Narxi:" + "Договорились");
                    }
                } else if (selectedUser.getLanguage().equals("uz")) {
                    if (tariflar.getPrice() != null) {
                        sendMessage = new SendMessage(selectedUser.getId(), name + tariflar.getTitle() + "\n\n" + about + tariflar.getMalumot() + "\n" + price + tariflar.getPrice());
                    } else {
                        sendMessage = new SendMessage(selectedUser.getId(), name + tariflar.getTitle() + "\n\n" + about + tariflar.getMalumot() + "\n" + "\uD83D\uDCB5Narxi:" + "Kelishamiz");
                    }
                }
            }
        }

        if (sendMessage != null) {
            inlineKeyboardMarkup.addRow(new InlineKeyboardButton(buttonName).callbackData("savat"));
            inlineKeyboardMarkup.addRow(new InlineKeyboardButton(back).callbackData("back1"));
            sendMessage.replyMarkup(inlineKeyboardMarkup);

            SendResponse execute = telegramBot.execute(sendMessage);
            selectedUser.setMessegeId(execute.message().messageId());
            selectedUser.setState(State.BASKET_SUCSECCTARIF);
        }
    }


    public static void setAdminMessegeTarif(TgUser selectedUser, String data) {
        if (data.equals("back1")){
            showXizmat(selectedUser,selectedUser.getTgmessege());

        }
        if (data.endsWith("savat")){
            if (selectedUser.getLanguage().equals("uz")) {
                SendMessage sendMessage = new SendMessage(selectedUser.getId(), "✅ So'rovingiz qabul qilindi. Siz bilan tez orada bog'lanamiz.");
                telegramBot.execute(sendMessage);
            }
            if (selectedUser.getLanguage().equals("ru")){
                SendMessage sendMessage = new SendMessage(selectedUser.getId(), "✅Ваша заявка принята. Мы скоро свяжемся с вами.");
                telegramBot.execute(sendMessage);
            }

            Long id=363106474L;
            SendMessage sendMessage1=null;
            for (Tariflar tariflar : tarifBasket) {
                if(tariflar.getPrice()!=null) {
                    sendMessage1 = new SendMessage(id, "🧑‍💼Ismi: " + selectedUser.getName() + "\n" + "📞Telefon raqam:" + selectedUser.getContact().phoneNumber() + "\nXarid qilgan hizmat:" + tariflar.getTitle() + "\n💵Narxi:" + tariflar.getPrice());
                }else {

                }
            }
            telegramBot.execute(sendMessage1);
            saveContactAndXizmatlar(selectedUser,selectedUser.getContact());
        }
    }
}