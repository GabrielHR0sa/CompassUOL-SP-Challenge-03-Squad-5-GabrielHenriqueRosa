package br.com.compassuol.pb.challenge.msnotification.controller;

import br.com.compassuol.pb.challenge.msnotification.dto.EmailDto;
import br.com.compassuol.pb.challenge.msnotification.entity.Email;
import br.com.compassuol.pb.challenge.msnotification.service.EmailService;
import br.com.compassuol.pb.challenge.msnotification.service.impl.EmailServiceImpl;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
public class EmailController {

    @Autowired
    EmailServiceImpl emailService;

    @PostMapping("send-email")
    public ResponseEntity<Email> sendEmail(@RequestBody @Valid EmailDto emailDto){
        Email email = new Email();
        BeanUtils.copyProperties(emailDto, email);
        emailService.sendEmail(email);
        return new ResponseEntity<>(email, HttpStatus.CREATED);
    }
}
