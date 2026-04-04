package emy.backend.lawapp50.route.contenu

import emy.backend.lawapp50.route.GlobalRoute

object ContenuScope{
    const val PUBLIC = "${GlobalRoute.PUBLIC}/${FeaturContenu.CONTENU}"
    const val PROTECTED = "${GlobalRoute.PROTECT}/${FeaturContenu.CONTENU}"
    const val PRIVATE = "${GlobalRoute.PRIVATE}/${FeaturContenu.CONTENU}"
}

object AvisContenuScope{
    const val PUBLIC = "${GlobalRoute.PUBLIC}/${FeaturContenu.AVIS}"
    const val PROTECTED = "${GlobalRoute.PROTECT}/${FeaturContenu.AVIS}"
    const val PRIVATE = "${GlobalRoute.PRIVATE}/${FeaturContenu.AVIS}"
}

object CategorieContenuScope{
    const val PUBLIC = "${GlobalRoute.PUBLIC}/${FeaturContenu.CATEGORICONTENU}"
    const val PROTECTED = "${GlobalRoute.PROTECT}/${FeaturContenu.CATEGORICONTENU}"
    const val PRIVATE = "${GlobalRoute.PRIVATE}/${FeaturContenu.CATEGORICONTENU}"
}


object CategorieScope{
    const val PUBLIC = "${GlobalRoute.PUBLIC}/${FeaturContenu.CATEGORIE}"
    const val PROTECTED = "${GlobalRoute.PROTECT}/${FeaturContenu.CATEGORIE}"
    const val PRIVATE = "${GlobalRoute.PRIVATE}/${FeaturContenu.CATEGORIE}"
}
object CommentaireScope{
    const val PUBLIC = "${GlobalRoute.PUBLIC}/${FeaturContenu.COMMENTAIRE}"
    const val PROTECTED = "${GlobalRoute.PROTECT}/${FeaturContenu.COMMENTAIRE}"
    const val PRIVATE = "${GlobalRoute.PRIVATE}/${FeaturContenu.COMMENTAIRE}"
}
object ResponseScope{
    const val PUBLIC = "${GlobalRoute.PUBLIC}/${FeaturContenu.RESPONSECOM}"
    const val PROTECTED = "${GlobalRoute.PROTECT}/${FeaturContenu.RESPONSECOM}"
    const val PRIVATE = "${GlobalRoute.PRIVATE}/${FeaturContenu.RESPONSECOM}"
}

object FavoriScope{
    const val PUBLIC = "${GlobalRoute.PUBLIC}/${FeaturContenu.FAVORI}"
    const val PROTECTED = "${GlobalRoute.PROTECT}/${FeaturContenu.FAVORI}"
    const val PRIVATE = "${GlobalRoute.PRIVATE}/${FeaturContenu.FAVORI}"
}
object LikeScope{
    const val PUBLIC = "${GlobalRoute.PUBLIC}/${FeaturContenu.LIKE}"
    const val PROTECTED = "${GlobalRoute.PROTECT}/${FeaturContenu.LIKE}"
    const val PRIVATE = "${GlobalRoute.PRIVATE}/${FeaturContenu.LIKE}"
}

object ScopeContenuScope{
    const val PUBLIC = "${GlobalRoute.PUBLIC}/${FeaturContenu.SCOPECONTENU}"
    const val PROTECTED = "${GlobalRoute.PROTECT}/${FeaturContenu.SCOPECONTENU}"
    const val PRIVATE = "${GlobalRoute.PRIVATE}/${FeaturContenu.SCOPECONTENU}"
}

object ScopeScope{
    const val PUBLIC = "${GlobalRoute.PUBLIC}/${FeaturContenu.SCOPE}"
    const val PROTECTED = "${GlobalRoute.PROTECT}/${FeaturContenu.SCOPE}"
    const val PRIVATE = "${GlobalRoute.PRIVATE}/${FeaturContenu.SCOPE}"
}

object TypeContenuScope{
    const val PUBLIC = "${GlobalRoute.PUBLIC}/${FeaturContenu.TYPECONTENU}"
    const val PROTECTED = "${GlobalRoute.PROTECT}/${FeaturContenu.TYPECONTENU}"
    const val PRIVATE = "${GlobalRoute.PRIVATE}/${FeaturContenu.TYPECONTENU}"
}


object FeaturContenu{
    const val CONTENU = "contenu"
    const val AVIS = "avis"
    const val CATEGORICONTENU ="categoriecontenu"
    const val CATEGORIE = "categorie"
    const val COMMENTAIRE = "commentaire"
    const val RESPONSECOM = "response"
    const val FAVORI = "favori"
    const val LIKE = "like"
    const val SCOPE = "scope"
    const val SCOPECONTENU = "scope-contenu"
    const val TYPECONTENU = "type-contenu"
}