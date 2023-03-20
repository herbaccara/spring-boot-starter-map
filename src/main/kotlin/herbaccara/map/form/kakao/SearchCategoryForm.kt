package herbaccara.map.form.kakao

import herbaccara.map.model.kakao.CategoryGroupCode

data class SearchCategoryForm @JvmOverloads constructor(
    val categoryGroupCode: CategoryGroupCode,
    val x: Double? = null,
    val y: Double? = null,
    val radius: Int? = null,
    val rect: String? = null,
    val page: Int? = null,
    val size: Int? = null,
    val sort: Sort? = null
)
