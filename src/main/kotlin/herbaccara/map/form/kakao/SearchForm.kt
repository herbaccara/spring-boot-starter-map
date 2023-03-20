package herbaccara.map.form.kakao

import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap

interface SearchForm {
    val x: Double?
    val y: Double?
    val radius: Int?
    val rect: String?
    val page: Int?
    val size: Int?
    val sort: Sort?

    fun toMultiValueMap(): MultiValueMap<String, String> {
        return LinkedMultiValueMap<String, String>().apply {
            if (x != null) add("x", x.toString())
            if (y != null) add("y", y.toString())
            if (radius != null) add("radius", radius.toString())
            if (rect != null) add("rect", rect.toString())
            if (page != null) add("page", page.toString())
            if (size != null) add("size", size.toString())
            if (sort != null) add("sort", sort.toString())
        }
    }
}
