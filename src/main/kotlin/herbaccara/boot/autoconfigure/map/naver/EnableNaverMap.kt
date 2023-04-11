package herbaccara.boot.autoconfigure.map.naver

import org.springframework.context.annotation.Import
import java.lang.annotation.*

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Import(NaverMapAutoConfiguration::class)
annotation class EnableNaverMap
