package herbaccara.map.naver.form

import com.toasttab.ksp.builder.annotations.GenerateBuilder
import herbaccara.map.Coordinate

@GenerateBuilder
data class GeocodeForm @JvmOverloads constructor(
    val query: String,
    @GenerateBuilder.Default("1")
    val page: Int = 1,
    @GenerateBuilder.Default("10")
    val count: Int = 10,
    @GenerateBuilder.Default("GeocodeForm.Language.KOR")
    val language: Language = Language.KOR,
    val coordinate: Coordinate? = null,
    val filter: Filter? = null
) {
    companion object {

        @JvmStatic
        fun builder(): GeocodeFormBuilder = GeocodeFormBuilder()
    }

    enum class Language(val value: String) {
        KOR("kor"),
        ENG("eng")
    }

    data class Filter(val type: Type, val codes: List<String>) {

        enum class Type {
            /**
             * 행정동 코드
             */
            HCODE,

            /**
             * 법정동 코드
             */
            BCODE
        }
    }
}
