package herbaccara.boot.autoconfigure.map.kakao

import herbaccara.map.KaKaoMapService
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import java.util.*

@AutoConfiguration
@EnableConfigurationProperties(KaKaoMapProperties::class)
@ConditionalOnProperty(prefix = "map.kakao", value = ["enabled"], havingValue = "true", matchIfMissing = true)
class KaKaoMapAutoConfiguration {

    @Bean
    fun kaKaoMapService(properties: KaKaoMapProperties): KaKaoMapService {
        if (properties.apiKey.isEmpty()) throw NullPointerException()

        return KaKaoMapService(
            properties.apiKey,
            properties.rootUri,
            properties.failOnUnknownProperties
        )
    }
}
