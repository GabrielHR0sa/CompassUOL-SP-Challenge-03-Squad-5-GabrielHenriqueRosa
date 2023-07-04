package br.com.compassuol.pb.challenge.msnotification.entity;

import br.com.compassuol.pb.challenge.msnotification.enums.EmailStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "TB_EMAIL")
public class Email implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long emailId;
    private String fromName;
    private String fromEmail;
    private String replyTo;
    private String toEmail;
    private String subject;
    private String body;
    private String contentType;
    private EmailStatus emailStatus;
}
