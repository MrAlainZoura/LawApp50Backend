package emy.backend.lawapp50.utils.mail

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.JavaMailSenderImpl
import java.util.Properties

@Configuration
class MailConfig(
    @Value("\${spring.mail.username}")
    private val usernameMail: String,
    @Value("\${spring.mail.password}")
    private val passwordMail: String
) {

//    @Value("\${spring.mail.host}")
//    private lateinit var host: String
//    @Value("\${spring.mail.port}")
//    private var port: Int = 465
    @Bean
    fun javaMailSender(): JavaMailSender {
        return JavaMailSenderImpl().apply {
            this.host = "smtp.hostinger.com"
            this.port = 587
            this.username = usernameMail
            this.password = passwordMail
            this.javaMailProperties = Properties().apply {
                setProperty("mail.smtp.auth", "true")
                setProperty("mail.smtp.starttls.enable", "true")
            }
        }
    }
//    @Bean
//    fun emailServiceImpl(javaMailSender: JavaMailSender) = EmailServiceImpl().apply {
//        this.javaMailSender = javaMailSender
//    }

    @Bean
    fun mailSender(): JavaMailSender {
        return JavaMailSenderImpl().apply {
            host = "smtp.hostinger.com"
        }
    }
    @Bean
    fun templateMessage(): SimpleMailMessage {
        return SimpleMailMessage().apply {
            from = "contact@casanayo.com"
            subject = "Code de vérification"
        }
    }

    @Bean
    fun senderMailAuth(javaMailSender: JavaMailSender, simpleTemplateMessage: SimpleMailMessage) = SenderMailAuth().apply {
        mailSender = javaMailSender
        templateMessage = simpleTemplateMessage
    }
}