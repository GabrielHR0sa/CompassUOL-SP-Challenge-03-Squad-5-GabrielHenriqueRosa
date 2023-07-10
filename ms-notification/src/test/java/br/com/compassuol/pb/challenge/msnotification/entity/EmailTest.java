package br.com.compassuol.pb.challenge.msnotification.entity;

import br.com.compassuol.pb.challenge.msnotification.enums.EmailStatus;
import jakarta.validation.constraints.NotNull;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailTest {

    @Test
    void getEmailId() {
        Email email = new Email();
        Long id = email.getEmailId();
        assertNull(id);
    }

    @Test
    void getFromName() {
        Email email = new Email();
        String fromName = email.getFromName();
        assertNull(fromName);
    }

    @Test
    void getFromEmail() {
        Email email = new Email();
        String fromEmail = email.getFromEmail();
        assertNull(fromEmail);
    }

    @Test
    void getReplyTo() {
        Email email = new Email();
        String replyTo = email.getReplyTo();
        assertNull(replyTo);
    }

    @Test
    void getToEmail() {
        Email email = new Email();
        String toEmail = email.getToEmail();
        assertNull(toEmail);
    }

    @Test
    void getSubject() {
        Email email = new Email();
        String subject = email.getSubject();
        assertNull(subject);
    }

    @Test
    void getBody() {
        Email email = new Email();
        String body = email.getBody();
        assertNull(body);
    }

    @Test
    void getContentType() {
        Email email = new Email();
        String content = email.getContentType();
        assertNull(content);
    }

    @Test
    void getEmailStatus() {
        Email email = new Email();
        @NotNull EmailStatus emailStatus = email.getEmailStatus();
        assertNull(emailStatus);
    }

    @Test
    void setEmailId() {
        Email email = new Email();
        Long id = 1L;
        email.setEmailId(id);
        assertEquals(1L, email.getEmailId());
    }

    @Test
    void setFromName() {
        Email email = new Email();
        String fromName = "teste";
        email.setFromName(fromName);
        assertEquals("teste", email.getFromName());
    }

    @Test
    void setFromEmail() {
        Email email = new Email();
        String fromEmail = "teste@teste.com";
        email.setFromEmail(fromEmail);
        assertEquals("teste@teste.com", email.getFromEmail());
    }

    @Test
    void setReplyTo() {
        Email email = new Email();
        String replyTo = "teste@teste.com";
        email.setReplyTo(replyTo);
        assertEquals("teste@teste.com", email.getReplyTo());
    }

    @Test
    void setToEmail() {
        Email email = new Email();
        String toEmail = "teste@teste.com";
        email.setToEmail(toEmail);
        assertEquals("teste@teste.com", email.getToEmail());
    }

    @Test
    void setSubject() {
        Email email = new Email();
        String subject = "teste";
        email.setSubject(subject);
        assertEquals("teste", email.getSubject());
    }

    @Test
    void setBody() {
        Email email = new Email();
        String body = "teste";
        email.setBody(body);
        assertEquals("teste", email.getBody());
    }

    @Test
    void setContentType() {
        Email email = new Email();
        String contentType = "teste";
        email.setContentType(contentType);
        assertEquals("teste", email.getContentType());
    }

    @Test
    void setEmailStatus() {
        Email email = new Email();
        Email emailMethod = email;
        email.setEmailStatus(EmailStatus.SENT);
        email.setEmailStatus(EmailStatus.ERROR);
        assertEquals(email, emailMethod);
    }

}