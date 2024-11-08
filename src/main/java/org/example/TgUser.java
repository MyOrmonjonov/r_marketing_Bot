package org.example;

import com.pengrad.telegrambot.model.Contact;
import com.pengrad.telegrambot.model.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static org.example.State.START;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TgUser {

    private Long id;
    private String name;
    private Contact contact;
    private String language;
    private Integer messegeId;
    private Message tgmessege;
    private Long tariflar;
    private Long hizmatlar;
    private State state=START;
}
