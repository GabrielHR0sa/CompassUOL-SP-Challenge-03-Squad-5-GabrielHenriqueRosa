package br.com.compassuol.pb.challenge.msnotification.service;

        import br.com.compassuol.pb.challenge.msnotification.enums.EmailStatus;
        import br.com.compassuol.pb.challenge.msnotification.entity.Email;
        import br.com.compassuol.pb.challenge.msnotification.repository.EmailRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.mail.MailException;
        import org.springframework.mail.SimpleMailMessage;
        import org.springframework.mail.javamail.JavaMailSender;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;

@Service
public class EmailService {

    @Autowired
    private EmailRepository emailRepository;
    @Autowired
    private JavaMailSender emailSender;

    @Transactional
    public Email sendEmail(Email email) {

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
            return emailRepository.save(email);
        }
    }
}

