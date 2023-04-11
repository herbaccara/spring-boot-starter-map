package herbaccara.boot.autoconfigure.map.naver

import herbaccara.map.naver.NaverMapService
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties(prefix = "map.naver")
@ConstructorBinding
data class NaverMapProperties(
    val enabled: Boolean = false,
    val rootUri: String = NaverMapService.BASE_URL,
    val failOnUnknownProperties: Boolean = false,
    val clientId: String,
    val clientSecret: String
)
