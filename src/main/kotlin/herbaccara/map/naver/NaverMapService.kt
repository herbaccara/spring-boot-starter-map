package herbaccara.map.naver

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import herbaccara.map.naver.form.GeocodeForm
import herbaccara.map.naver.form.RasterForm
import herbaccara.map.naver.model.GeocodeResult
import herbaccara.map.naver.model.LastVersion
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.http.client.ClientHttpRequestInterceptor
import org.springframework.http.converter.ByteArrayHttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.client.getForObject
import org.springframework.web.util.UriComponentsBuilder

class NaverMapService(
    clientId: String,
    clientSecret: String,
    baseUrl: String = BASE_URL,
    failOnUnknownProperties: Boolean = false
) {
    companion object {
        const val BASE_URL = "https://naveropenapi.apigw.ntruss.com"
    }

    protected val objectMapper = jacksonObjectMapper().apply {
        findAndRegisterModules()
        configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, failOnUnknownProperties)
    }

    protected val restTemplate = RestTemplateBuilder()
        .rootUri(baseUrl)
        .messageConverters(
            ByteArrayHttpMessageConverter(),
            MappingJackson2HttpMessageConverter(objectMapper)
        )
        .additionalInterceptors(
            ClientHttpRequestInterceptor { request, body, execution ->
                request.headers.apply {
                    add("X-NCP-APIGW-API-KEY-ID", clientId)
                    add("X-NCP-APIGW-API-KEY", clientSecret)
                }
                execution.execute(request, body)
            }
        )
        .build()

    fun staticLastVersion(): LastVersion {
        val url = "/map-static/v2/lastversion"
        return restTemplate.getForObject(url)
    }

    fun staticRaster(form: RasterForm): ByteArray {
        val url = UriComponentsBuilder
            .fromUriString("/map-static/v2/raster")
            .apply {
                queryParam("w", form.width)
                queryParam("h", form.height)
                if (!form.crs.isNullOrBlank()) {
                    queryParam("crs", form.crs)
                }
                if (form.center != null) {
                    queryParam("center", "${form.center.x},${form.center.y}")
                }
                if (form.level != null) {
                    queryParam("level", form.level)
                }
                if (form.mapType != null) {
                    queryParam("maptype", form.mapType.value)
                }
                if (form.format != null) {
                    queryParam("format", form.format.value)
                }
                if (form.scale != null) {
                    queryParam("scale", form.scale.value)
                }
                if (!form.markers.isNullOrEmpty()) {
                    queryParam(
                        "markers",
                        form.markers.map {
                            listOfNotNull(
                                "type:${it.type.value}",
                                "size:${it.size.value}",
                                if (it.color != null) "color:${it.color}" else null,
                                if (it.label != null) "label:${it.label}" else null,
                                "pos:${it.pos.x} ${it.pos.y}",
                                "viewSizeRatio:${it.viewSizeRatio}"
                            ).joinToString("|")
                        }
                    )
                }
                if (form.lang != null) {
                    queryParam("lang", form.lang.value)
                }
                if (form.publicTransit != null) {
                    queryParam("public_transit", form.publicTransit)
                }
                if (!form.dataVersion.isNullOrBlank()) {
                    queryParam("dataversion", form.dataVersion)
                }
            }
            .build(false)
            .toUriString()

        return restTemplate.getForObject(url)
    }

    fun geocode(form: GeocodeForm): GeocodeResult {
        val url = UriComponentsBuilder
            .fromUriString("/map-geocode/v2/geocode")
            .apply {
                queryParam("query", form.query)
                queryParam("page", form.page)
                queryParam("count", form.count)
                queryParam("language", form.language.value)
                if (form.coordinate != null) {
                    queryParam("coordinate", "${form.coordinate.x},${form.coordinate.y}")
                }
                if (form.filter != null) {
                    queryParam("filter", form.filter.let { "${it.type}@${it.codes.joinToString(";")}" })
                }
            }
            .build(false)
            .toUriString()

        return restTemplate.getForObject(url)
    }
}
