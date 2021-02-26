package com.wiredin.messaging.wiredinmessagingchallengebackend.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String messageFrom = "";

    private String messageTo = "";

    private String subject = "";

    @Column(columnDefinition = "TEXT")
    private String body = "";

    private Date date = new Date();

    @Override
    public String toString() {
        return "messageFrom: " + messageFrom + "messageTo: " + messageTo + "body: " + body;
    }

    /**
     * @return Integer return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return String return the messageFrom
     */
    public String getMessageFrom() {
        return messageFrom;
    }

    /**
     * @param messageFrom the messageFrom to set
     */
    public void setMessageFrom(String messageFrom) {
        this.messageFrom = messageFrom;
    }

    /**
     * @return String return the messageTo
     */
    public String getMessageTo() {
        return messageTo;
    }

    /**
     * @param messageTo the messageTo to set
     */
    public void setMessageTo(String messageTo) {
        this.messageTo = messageTo;
    }

    /**
     * @return String return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return String return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * @param body the body to set
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * @return Date return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

}
