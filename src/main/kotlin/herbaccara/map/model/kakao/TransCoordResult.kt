package herbaccara.map.model.kakao

import com.fasterxml.jackson.annotation.JsonProperty

data class TransCoordResult(
    val documents: List<Document>,
    val meta: Meta
) {
    data class Meta(
        @field:JsonProperty("total_count") val totalCount: Int
    )

    data class Document(
        val x: Double,
        val y: Double
    )
}
