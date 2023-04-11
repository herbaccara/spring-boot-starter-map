package herbaccara.map.kakao.model

import com.fasterxml.jackson.annotation.JsonProperty
import herbaccara.map.Coordinate

data class TransCoordResult(
    val documents: List<Document>,
    val meta: Meta
) {
    data class Meta(
        @field:JsonProperty("total_count") val totalCount: Int
    )

    data class Document(
        override val x: Double,
        override val y: Double
    ) : Coordinate
}
