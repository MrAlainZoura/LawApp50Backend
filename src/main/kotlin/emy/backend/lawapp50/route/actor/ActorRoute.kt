package emy.backend.lawapp50.route.actor

import emy.backend.lawapp50.route.GlobalRoute

object StudentScope{
    const val PUBLIC = "${GlobalRoute.PUBLIC}/${FeatureActor.STUDENT}"
    const val PROTECTED = "${GlobalRoute.PROTECT}/${FeatureActor.STUDENT}"
    const val PRIVATE = "${GlobalRoute.PRIVATE}/${FeatureActor.STUDENT}"
}

object TeacherScope{
    const val PUBLIC = "${GlobalRoute.PUBLIC}/${FeatureActor.TEACHER}"
    const val PROTECTED = "${GlobalRoute.PROTECT}/${FeatureActor.TEACHER}"
    const val PRIVATE = "${GlobalRoute.PRIVATE}/${FeatureActor.TEACHER}"
}

object FeatureActor{
    const val STUDENT = "students"
    const val TEACHER = "teachers"
}