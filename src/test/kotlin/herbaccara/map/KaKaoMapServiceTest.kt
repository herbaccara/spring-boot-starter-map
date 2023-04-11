package herbaccara.map

import herbaccara.boot.autoconfigure.map.kakao.KaKaoMapAutoConfiguration
import herbaccara.map.kakao.KaKaoMapService
import herbaccara.map.kakao.form.SearchCategoryForm
import herbaccara.map.kakao.model.CategoryGroupCode
import org.junit.jupiter.api.Assertions
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
        val search = kaKaoMapService.searchAddress("영등포구 63로 50")
        if (search.documents.isNotEmpty()) {
            val toLink = kaKaoMapService.linkTo(search.documents.first())
            println(toLink)
        }
    }

    @Test
    fun searchAddress2() {
        val search = kaKaoMapService.searchAddress("전북 삼성동 100")
        Assertions.assertNull(search.documents.first().roadAddress)
    }

    @Test
    fun searchAddress3() {
        val search = kaKaoMapService.searchAddress("영동대로 513")
        Assertions.assertNotNull(search.documents.first().roadAddress)
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
        val searchKeyword = kaKaoMapService.searchKeyword("경희도선한의원")
        println()
    }

    @Test
    fun searchCategory() {
        val searchCategory = kaKaoMapService.searchCategory(
            SearchCategoryForm(CategoryGroupCode.PM9, radius = 2000)
        )
        println()
    }
}
