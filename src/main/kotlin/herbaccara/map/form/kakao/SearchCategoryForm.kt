package herbaccara.map.form.kakao

import herbaccara.map.model.kakao.CategoryGroupCode
import org.springframework.util.MultiValueMap

data class SearchCategoryForm @JvmOverloads constructor(
    val categoryGroupCode: CategoryGroupCode,
    override val x: Double? = null,
    override val y: Double? = null,
    override val radius: Int? = null,
    override val rect: String? = null,
    override val page: Int? = null,
    override val size: Int? = null,
    override val sort: Sort? = null
) : SearchForm {

    override fun toMultiValueMap(): MultiValueMap<String, String> {
        return super.toMultiValueMap().apply {
            add("category_group_code", categoryGroupCode.name)
        }
    }
}
