package herbaccara.map

import herbaccara.boot.autoconfigure.map.naver.NaverMapAutoConfiguration
import herbaccara.map.naver.NaverMapService
import herbaccara.map.naver.form.GeocodeForm
import herbaccara.map.naver.form.RasterForm
import herbaccara.map.naver.form.RasterForm.Marker
import herbaccara.map.naver.form.RasterForm.Marker.Position
import herbaccara.map.naver.form.RasterForm.Marker.Type
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource
import java.io.File

@SpringBootTest(
    classes = [
        NaverMapAutoConfiguration::class
    ]
)
@TestPropertySource(locations = ["classpath:application.yml"])
class NaverMapServiceTest {

    @Autowired
    lateinit var naverMapService: NaverMapService

    @Test
    fun lastVersion() {
        val lastVersion = naverMapService.staticLastVersion()
        println(lastVersion)
    }

    @Test
    fun raster() {
        val form = RasterForm.builder()
            .width(300)
            .height(300)
            .addMarkers(
                Marker(
                    type = Type.NUMBER,
                    pos = Position(127.1054221, 37.3591614),
                    label = "9",
                    color = "Orange"
                )
            )
            .build()

        val raster = naverMapService.staticRaster(form)
        File("src/test/resources/raster_test.jpeg").writeBytes(raster)
    }

    @Test
    fun geocode() {
        val form = GeocodeForm.builder()
            .query("분당구 불정로 6")
            .build()
        val geocode = naverMapService.geocode(form)
        println()
    }
}
