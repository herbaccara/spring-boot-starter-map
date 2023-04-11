package herbaccara.map.naver.form

import com.toasttab.ksp.builder.annotations.GenerateBuilder
import herbaccara.map.Coordinate

@GenerateBuilder
data class RasterForm @JvmOverloads constructor(
    val width: Int,
    val height: Int,
    val center: Coordinate? = null,
    val crs: String? = null,
    val level: Int? = null,
    val mapType: MapType? = null,
    val format: Format? = null,
    val scale: Scale? = null,
    val markers: List<Marker>? = null,
    val lang: Lang? = null,
    val publicTransit: Boolean? = null,
    val dataVersion: String? = null
) {
    companion object {

        @JvmStatic
        fun builder(): RasterFormBuilder = RasterFormBuilder()
    }

    enum class Format(val value: String) {
        JPG("jpg"),
        JPEG("jpeg"),
        PNG8("png8"),
        PNG("png")
    }

    enum class Lang(val value: String) {
        KO("ko"),
        EN("en"),
        JA("ja"),
        ZH("zh")
    }

    enum class MapType(val value: String) {
        BASIC("basic"),
        TRAFFIC("traffic"),
        SATELLITE("satellite"),
        SATELLITE_BASE("satellite_base"),
        TERRAIN("terrain")
    }

    enum class Scale(val value: Int) {
        LOW(1),
        HIGH(2)
    }

    data class Marker @JvmOverloads constructor(
        val pos: Coordinate,
        val type: Type = Type.DEFAULT,
        val size: Size = Size.MID,
        val viewSizeRatio: Double = 1.0,
        val color: String? = null,
        val label: String? = null
    ) {

        enum class Type(val value: String) {
            DEFAULT("d"),
            NUMBER("n"),
            ALPHABET("a"),
            TOOLTIP("t")
        }

        enum class Size(val value: String) {
            TINY("tiny"),
            SMALL("small"),
            MID("mid")
        }
    }
}
