package com.mirego.cschat.controller;

import com.mirego.cschat.models.User;
import com.mirego.cschat.models.request.RegisterRequest;
import com.mirego.cschat.services.CSChatService;
import com.mirego.cschat.services.StorageService;

import io.reactivex.Flowable;

/**
 * Created by mahad on 25/03/17.
 */

public class RegisterController {
    private final CSChatService chatService;
    private final StorageService storageService;

    public RegisterController(CSChatService chatService, StorageService storageService) {
        this.chatService = chatService;
        this.storageService = storageService;
    }

    public Flowable<User> registerPhoto(String username, String password, String photoURL) {
        return chatService.registerPhoto(new RegisterRequest(username, password, photoURL));
    }

    public Flowable<User> registerNoPhoto(String username, String password) {
        return chatService.registerNoPhoto(new RegisterRequest(username, password));
    }

    public void saveUserId(String userId) {
        storageService.storeUserId(userId);
    }
}
