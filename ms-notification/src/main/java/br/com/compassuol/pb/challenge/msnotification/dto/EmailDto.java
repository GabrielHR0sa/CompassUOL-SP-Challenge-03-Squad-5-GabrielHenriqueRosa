package br.com.compassuol.pb.challenge.msnotification.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmailDto {

    @NotBlank
    private String fromName;

    @NotBlank
    @Email
    private String fromEmail;

    @NotBlank
    @Email
    private String replyTo;

    @NotBlank
    @Email
    private String toEmail;

    @NotBlank
    private String subject;

    @NotBlank
    private String body;

    @NotBlank
    private String contentType;

}
