package herbaccara.map

import herbaccara.boot.autoconfigure.map.kakao.KaKaoMapAutoConfiguration
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource

@SpringBootTest(
    classes = [
        KaKaoMapAutoConfiguration::class
    ]
)
@TestPropertySource(locations = ["classpath:application.yml"])
class KaKaoMapServiceTest {

    @Autowired
    lateinit var kaKaoMapService: KaKaoMapService

    @Test
    fun search() {
        val search = kaKaoMapService.search("송파구 송파동 86-17")
        val toLink = search.documents.first().toLink()
        println(toLink)
    }
}
