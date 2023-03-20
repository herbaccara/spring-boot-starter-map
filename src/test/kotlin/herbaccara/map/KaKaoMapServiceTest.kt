package herbaccara.map

import herbaccara.boot.autoconfigure.map.kakao.KaKaoMapAutoConfiguration
import herbaccara.map.form.kakao.SearchCategoryForm
import herbaccara.map.model.kakao.CategoryGroupCode
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
    fun searchAddress() {
        val search = kaKaoMapService.searchAddress("송파구 송파동 86-17")
        val toLink = kaKaoMapService.linkTo(search.documents.first())
        println(toLink)
    }

    @Test
    fun coordToRegionCode() {
        val coordToRegionCode = kaKaoMapService.coordToRegionCode(127.108689005256, 37.504798638625)
        println()
    }

    @Test
    fun coordToAddress() {
        val coordToAddress = kaKaoMapService.coordToAddress(127.423084873712, 37.078956155887)
        println()
    }

    @Test
    fun transCoord() {
        val coordToAddress = kaKaoMapService.transCoord(127.423084873712, 37.078956155887)
        println()
    }

    @Test
    fun searchKeyword() {
        val searchKeyword = kaKaoMapService.searchKeyword("카카오프렌즈")
        println()
    }

    @Test
    fun searchCategory() {
        val searchCategory = kaKaoMapService.searchCategory(SearchCategoryForm(CategoryGroupCode.PM9))
        println()
    }
}
