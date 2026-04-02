package server.web.casa.adaptater.provide.twilio

import com.twilio.rest.verify.v2.service.*
import org.springframework.beans.factory.annotation.*
import org.springframework.stereotype.*
import org.slf4j.*

@Service
class TwilioService(
    @Autowired private val twilioConfig: TwilioConfig
)  {
    private val log = LoggerFactory.getLogger(this::class.java)
    fun generateVerifyOTP(
        contact: String = "+243827824163",
        channel : String = "sms"
    ): String? {
      val verification = Verification
          .creator("AC4843f3ee6e7982e2bf638a3a8b70f5fb",contact, channel)
          .setLocale("fr")
          .create()
        log.info("Status :${verification.status}")
        log.info("Status :${verification.serviceSid}")
       return verification.status
    }

    fun checkVerify(
        code: String,
        contact: String = "+243827824163"
    ): String? {
        val verificationCheck = VerificationCheck
            .creator("AC4843f3ee6e7982e2bf638a3a8b70f5fb")
            .setCode(code)
            .setTo(contact)
            .create()
       return verificationCheck.status
    }
}