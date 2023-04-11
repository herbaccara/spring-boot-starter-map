package herbaccara.boot.autoconfigure.map.naver

import herbaccara.map.naver.NaverMapService
import org.springframework.boot.autoconfigure.AutoConfiguration
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import java.util.*

@AutoConfiguration
@EnableConfigurationProperties(NaverMapProperties::class)
@ConditionalOnProperty(prefix = "map.naver", value = ["enabled"], havingValue = "true")
class NaverMapAutoConfiguration {

    @Bean
    fun naverMapService(properties: NaverMapProperties): NaverMapService {
        if (properties.clientId.isEmpty()) throw NullPointerException()
        if (properties.clientSecret.isEmpty()) throw NullPointerException()

        return NaverMapService(
            properties.clientId,
            properties.clientSecret,
            properties.rootUri,
            properties.failOnUnknownProperties
        )
    }
}
