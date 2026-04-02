package emy.backend.lawapp50.route.tp

import emy.backend.lawapp50.route.GlobalRoute

object TpScope{
    const val PUBLIC = "${GlobalRoute.PUBLIC}/${TpFeatures.TP}"
    const val PROTECTED = "${GlobalRoute.PROTECT}/${TpFeatures.TP}"
    const val PRIVATE = "${GlobalRoute.PRIVATE}/${TpFeatures.TP}"
}
object TpFeatures {
    const val TP = "travail/pratique"
}