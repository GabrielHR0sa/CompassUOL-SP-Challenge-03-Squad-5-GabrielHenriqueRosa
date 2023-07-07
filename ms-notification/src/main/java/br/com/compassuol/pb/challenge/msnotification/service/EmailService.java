package br.com.compassuol.pb.challenge.msnotification.service;

import br.com.compassuol.pb.challenge.msproducts.dto.RegisterDto;

public interface EmailService {

     void sendEmail(RegisterDto registerDto);
}
