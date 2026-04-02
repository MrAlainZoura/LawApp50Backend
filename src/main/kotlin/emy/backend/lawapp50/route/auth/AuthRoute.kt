package emy.backend.lawapp50.route.auth

import emy.backend.lawapp50.route.GlobalRoute

object AuthRoute {
    const val REGISTER = "${GlobalRoute.AUTH}/${AuthFeatures.REGISTER_PATH}"
    const val LOGIN = "${GlobalRoute.AUTH}/${AuthFeatures.LOGIN_PATH}"
    const val LOGIN_AUTH_GOOGLE = "${GlobalRoute.AUTH}/${AuthFeatures.LOGIN_AUTH_GOOGLE_PATH}"
    const val RESET_PASSWORD = "${GlobalRoute.AUTH}/${AuthFeatures.PASSWORD_RESET_PATH}"
}

object AuthFeatures{
   const val REGISTER_PATH = "register"
   const val LOGIN_PATH = "login"
    const val LOGIN_AUTH_GOOGLE_PATH = "/login/oauth2/code/google"
   const val PASSWORD_RESET_PATH = "password/reset"
}