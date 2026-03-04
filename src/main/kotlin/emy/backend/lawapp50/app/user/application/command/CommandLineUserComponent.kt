package emy.backend.lawapp50.app.user.application.command

import emy.backend.lawapp50.app.user.application.service.*
import emy.backend.lawapp50.app.user.infrastructure.persistance.entity.AccountEntity
import emy.backend.lawapp50.app.user.infrastructure.persistance.entity.TypeAccountEntity
import emy.backend.lawapp50.app.user.infrastructure.persistance.repository.*
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.*
import org.slf4j.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Profile
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component


@Component
@Order(4)
@Profile("dev")
class CommandLineUserComponent(
    @Value("\${spring.application.version}")  private val version: String,
    val typeAccountRepository: TypeAccountRepository,
    val accountRepository: AccountRepository,
    private val authService: AuthService,
    private val typeAccountService: TypeAccountService
) : CommandLineRunner {
    private val log = LoggerFactory.getLogger(this::class.java)

    override fun run(vararg args: String) {
        log.info("commande executor **User")
        log.info(this::class.simpleName)
        log.info(version)
        try {
            runBlocking {
//                createAccount()
//                createTypeAccountAll()
            }
        }
        catch (e : Exception){
            log.info(e.message)
        }

    }
    suspend fun createTypeAccountAll(){
      val data = typeAccountRepository.saveAll<TypeAccountEntity>(
          listOf(
              TypeAccountEntity(name = "AcademicUser"),
              TypeAccountEntity(name = "PrivilegedUser"),
              TypeAccountEntity(name = "Professional"),
          )
        ).toList()
        log.info("save type account all ${data.size}")
    }
    suspend fun createAccount(){
            val store = accountRepository.saveAll<AccountEntity>(
            listOf(
                AccountEntity(name = "student", typeAccountId = 1),//1
                AccountEntity(name = "teacher", typeAccountId = 1),//2
                AccountEntity(name = "admin", typeAccountId = 2),//3
                AccountEntity(name = "superadmin", typeAccountId = 2),//4
                AccountEntity(name = "moderator", typeAccountId = 2),//5
            )
        ).toList()
        log.info("Enregistrement réussi avec succès ${store.size}")
//        log.info("Enregistrement réussi avec succès")
    }
//
//    fun getAllTypeAccount(){
//        typeAccountRepository.findAll().forEach { accountEntity ->
//            log.info("${accountEntity.name} | ${accountEntity.typeAccountId}")
//        }
//    }
//
//suspend fun createUser(){
//       val account = typeAccountService.findByIdTypeAccount(1)
////       val city = cityService.findByIdCity(1)
//       val userSystem = User(
//            password = "1234",
//            typeAccount = account,
//            email = "elieoko100@gmail.com",
//            phone = "0827824163",
//            city = "Kinshasa",
//           country = "CD"
//           )
//        val data = authService.register(userSystem, accountItems)
//        log.info("Enregistrement réussi avec succès***${data.first?.phone}")
//    }
}