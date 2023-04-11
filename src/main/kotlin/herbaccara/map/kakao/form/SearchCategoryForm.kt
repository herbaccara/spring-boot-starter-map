package herbaccara.map.kakao.form

import com.toasttab.ksp.builder.annotations.GenerateBuilder
import herbaccara.map.kakao.model.CategoryGroupCode
import org.springframework.util.MultiValueMap

@GenerateBuilder
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

    companion object {

        @JvmStatic
        fun builder(): SearchCategoryFormBuilder = SearchCategoryFormBuilder()
    }

    override fun toMultiValueMap(): MultiValueMap<String, String> {
        return super.toMultiValueMap().apply {
            add("category_group_code", categoryGroupCode.name)
        }
    }
}
