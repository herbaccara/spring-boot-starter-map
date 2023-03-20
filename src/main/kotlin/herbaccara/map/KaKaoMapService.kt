package herbaccara.map

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import herbaccara.map.model.kakao.AnalyzeType
import herbaccara.map.model.kakao.SearchResult
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.http.HttpRequest
import org.springframework.http.client.ClientHttpRequestExecution
import org.springframework.http.client.ClientHttpRequestInterceptor
import org.springframework.http.client.ClientHttpResponse
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
        .additionalInterceptors(object : ClientHttpRequestInterceptor {
            override fun intercept(
                request: HttpRequest,
                body: ByteArray,
                execution: ClientHttpRequestExecution
            ): ClientHttpResponse {
                request.headers.apply {
                    add("Authorization", "KakaoAK $apiKey")
                }
                return execution.execute(request, body)
            }
        })
        .build()

    @JvmOverloads
    fun search(query: String, page: Int = 1, size: Int = 10, analyzeType: AnalyzeType? = null): SearchResult {
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
}