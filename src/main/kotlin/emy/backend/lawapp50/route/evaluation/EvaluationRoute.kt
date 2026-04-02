package emy.backend.lawapp50.route.evaluation

import emy.backend.lawapp50.route.GlobalRoute

object EvaluationScope{
    const val PUBLIC = "${GlobalRoute.PUBLIC}/${EvaluationFeatures.TP}"
    const val PROTECTED = "${GlobalRoute.PROTECT}/${EvaluationFeatures.TP}"
    const val PRIVATE = "${GlobalRoute.PRIVATE}/${EvaluationFeatures.TP}"
}
object EvaluationFeatures {
    const val TP = "evaluations"
}