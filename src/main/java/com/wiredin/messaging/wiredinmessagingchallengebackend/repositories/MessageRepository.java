package com.wiredin.messaging.wiredinmessagingchallengebackend.repositories;

import com.wiredin.messaging.wiredinmessagingchallengebackend.models.Message;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Integer> {

}
