package herbaccara.boot.autoconfigure.map.kakao

import herbaccara.map.kakao.KaKaoMapService
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties(prefix = "map.kakao")
@ConstructorBinding
data class KaKaoMapProperties(
    val enabled: Boolean = false,
    val rootUri: String = KaKaoMapService.BASE_URL,
    val failOnUnknownProperties: Boolean = false,
    val apiKey: String
)
