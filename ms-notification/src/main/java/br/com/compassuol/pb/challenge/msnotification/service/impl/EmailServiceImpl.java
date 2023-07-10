package br.com.compassuol.pb.challenge.msnotification.service.impl;

        import br.com.compassuol.pb.challenge.msnotification.dto.EmailDto;
        import br.com.compassuol.pb.challenge.msnotification.enums.EmailStatus;
        import br.com.compassuol.pb.challenge.msnotification.entity.Email;
        import br.com.compassuol.pb.challenge.msnotification.repository.EmailRepository;
        import br.com.compassuol.pb.challenge.msnotification.service.EmailService;
        import br.com.compassuol.pb.challenge.msproducts.dto.RegisterDto;
        import org.springframework.mail.MailException;
        import org.springframework.mail.SimpleMailMessage;
        import org.springframework.mail.javamail.JavaMailSender;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;

@Service
public class EmailServiceImpl implements EmailService {


    private EmailRepository emailRepository;
    private JavaMailSender emailSender;

    public EmailServiceImpl(EmailRepository emailRepository, JavaMailSender emailSender) {
        this.emailRepository = emailRepository;
        this.emailSender = emailSender;
    }

    @Transactional
    public void sendEmail(RegisterDto registerDto) {

        Email email = new Email();

        email.setFromName("Ms-users");
        email.setFromEmail("rosahenriquegabriel@gmail.com");
        email.setToEmail(registerDto.getEmail());
        email.setReplyTo("gabriel.rosa.pb@compasso.com.br");
        email.setSubject("Alteração no Cadastro do Usuário");
        email.setBody("Seu cadastro foi atualizado com sucesso");
        email.setContentType("Text");

        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getFromEmail());
            message.setTo(email.getToEmail());
            message.setReplyTo(email.getReplyTo());
            message.setSubject(email.getSubject());
            message.setText(email.getBody());
            emailSender.send(message);

            email.setEmailStatus(EmailStatus.SENT);
        }catch(MailException e){
            email.setEmailStatus(EmailStatus.ERROR);
        }finally {
            emailRepository.save(email);
        }
    }
}
