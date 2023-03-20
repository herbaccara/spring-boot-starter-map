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
        return LinkedMultiValueMap<String, String>().also { map ->
            if (x != null) map.add("x", x.toString())
            if (y != null) map.add("y", y.toString())
            if (radius != null) map.add("radius", radius.toString())
            if (rect != null) map.add("rect", rect.toString())
            if (page != null) map.add("page", page.toString())
            if (size != null) map.add("size", size.toString())
            if (sort != null) map.add("sort", sort.toString())
        }
    }
}
