package herbaccara.map

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import herbaccara.map.form.kakao.SearchCategoryForm
import herbaccara.map.form.kakao.SearchKeywordForm
import herbaccara.map.model.kakao.*
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.http.client.ClientHttpRequestInterceptor
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.client.getForObject
import org.springframework.web.util.UriComponentsBuilder

class KaKaoMapService(
    apiKey: String,
    baseUrl: String = BASE_URL,
    failOnUnknownProperties: Boolean = false
) {
    companion object {
        const val BASE_URL = "https://dapi.kakao.com"
    }

    protected val objectMapper = jacksonObjectMapper().apply {
        findAndRegisterModules()
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, failOnUnknownProperties)
    }

    protected val restTemplate = RestTemplateBuilder()
        .rootUri(baseUrl)
        .messageConverters(
            listOf(
                MappingJackson2HttpMessageConverter(objectMapper)
            )
        )
        .additionalInterceptors(
            ClientHttpRequestInterceptor { request, body, execution ->
                request.headers.apply {
                    add("Authorization", "KakaoAK $apiKey")
                }
                execution.execute(request, body)
            }
        )
        .build()

    fun linkTo(name: String, x: Double, y: Double): String {
        return "https://map.kakao.com/link/to/$name,$y,$x"
    }

    fun linkTo(doc: SearchAddressResult.Document): String {
        return linkTo(doc.addressName, doc.x, doc.y)
    }

    @JvmOverloads
    fun searchAddress(
        query: String,
        page: Int = 1,
        size: Int = 10,
        analyzeType: AnalyzeType? = null
    ): SearchAddressResult {
        val uri = UriComponentsBuilder
            .fromUriString("/v2/local/search/address.json")
            .apply {
//                queryParam("query", query)
                queryParam("page", page)
                queryParam("size", size)
                if (analyzeType != null) {
                    queryParam("analyze_type", analyzeType)
                }
            }
            .toUriString() + "&query=" + query

        return restTemplate.getForObject(uri)
    }

    @JvmOverloads
    fun coordToRegionCode(
        x: Double,
        y: Double,
        inputCoord: CoordType = CoordType.WGS84,
        outputCoord: CoordType = CoordType.WGS84
    ): CoordToRegionCodeResult {
        val uri = UriComponentsBuilder
            .fromUriString("/v2/local/geo/coord2regioncode.json")
            .queryParam("x", x)
            .queryParam("y", y)
            .queryParam("input_coord", inputCoord)
            .queryParam("output_coord", outputCoord)
            .toUriString()

        return restTemplate.getForObject(uri)
    }

    @JvmOverloads
    fun coordToAddress(
        x: Double,
        y: Double,
        inputCoord: CoordType = CoordType.WGS84
    ): CoordToAddressResult {
        val uri = UriComponentsBuilder
            .fromUriString("/v2/local/geo/coord2address.json")
            .queryParam("x", x)
            .queryParam("y", y)
            .queryParam("input_coord", inputCoord)
            .toUriString()

        return restTemplate.getForObject(uri)
    }

    @JvmOverloads
    fun transCoord(
        x: Double,
        y: Double,
        inputCoord: CoordType = CoordType.WGS84,
        outputCoord: CoordType = CoordType.WGS84
    ): TransCoordResult {
        val uri = UriComponentsBuilder
            .fromUriString("/v2/local/geo/transcoord.json")
            .queryParam("x", x)
            .queryParam("y", y)
            .queryParam("input_coord", inputCoord)
            .queryParam("output_coord", outputCoord)
            .toUriString()

        return restTemplate.getForObject(uri)
    }

    @JvmOverloads
    fun searchKeyword(query: String, page: Int = 1, size: Int = 15): SearchKeywordResult {
        return searchKeyword(SearchKeywordForm(query, page = page, size = size))
    }

    fun searchKeyword(form: SearchKeywordForm): SearchKeywordResult {
        val uri = UriComponentsBuilder
            .fromUriString("/v2/local/search/keyword.json")
            .queryParams(form.toMultiValueMap())
            .toUriString() + "&query=" + form.query

        return restTemplate.getForObject(uri)
    }

    @JvmOverloads
    fun searchCategory(categoryGroupCode: CategoryGroupCode, page: Int = 1, size: Int = 15): SearchCategoryResult {
        return searchCategory(SearchCategoryForm(categoryGroupCode, page = page, size = size))
    }

    fun searchCategory(form: SearchCategoryForm): SearchCategoryResult {
        val uri = UriComponentsBuilder
            .fromUriString("/v2/local/search/category.json")
            .queryParams(form.toMultiValueMap())
            .toUriString()

        return restTemplate.getForObject(uri)
    }
}
