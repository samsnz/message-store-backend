package com.wiredin.messaging.wiredinmessagingchallengebackend.controllers;

import java.net.URI;
import java.util.List;

import com.wiredin.messaging.wiredinmessagingchallengebackend.models.Message;
import com.wiredin.messaging.wiredinmessagingchallengebackend.repositories.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin
@RestController
public class MessageController {
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/api/messages")
    public List<Message> retrieveAllMessages() {
        System.out.println("Reach here");
        return messageRepository.findAll(); // 200
    }

    @PostMapping("/api/messages")
    public ResponseEntity<Object> insertMessage(@RequestBody Message message) {
        Message savedMessage = messageRepository.save(message);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedMessage.getId()).toUri();

        return ResponseEntity.created(location).body(savedMessage); // 201
    }

    @DeleteMapping("/api/messages/{id}")
    public ResponseEntity<Object> deleteMessage(@PathVariable(value = "id") Integer messageId) {
        try {
            messageRepository.deleteById(messageId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // 404
        }

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 204
    }
}
