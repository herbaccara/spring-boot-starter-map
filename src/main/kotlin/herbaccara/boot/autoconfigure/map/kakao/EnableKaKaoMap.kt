package herbaccara.boot.autoconfigure.map.kakao

import org.springframework.context.annotation.Import
import java.lang.annotation.*

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Import(KaKaoMapAutoConfiguration::class)
annotation class EnableKaKaoMap
