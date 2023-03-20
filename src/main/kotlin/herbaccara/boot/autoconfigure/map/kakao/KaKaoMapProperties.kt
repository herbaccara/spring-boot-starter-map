package herbaccara.boot.autoconfigure.map.kakao

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties(prefix = "map.kakao")
@ConstructorBinding
data class KaKaoMapProperties(
    val enabled: Boolean = true,
    val rootUri: String = "https://dapi.kakao.com",
    val failOnUnknownProperties: Boolean = false,
    val apiKey: String
)
