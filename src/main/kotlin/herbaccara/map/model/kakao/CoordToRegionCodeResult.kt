package herbaccara.map.model.kakao

import com.fasterxml.jackson.annotation.JsonProperty

data class CoordToRegionCodeResult(
    val documents: List<Document>,
    val meta: Meta
) {
    data class Meta(
        @field:JsonProperty("total_count") val totalCount: Int
    )

    data class Document(
        @field:JsonProperty("region_type") val regionType: RegionType,
        @field:JsonProperty("address_name") val addressName: String,
        @field:JsonProperty("region_1depth_name") val region1depthName: String,
        @field:JsonProperty("region_2depth_name") val region2depthName: String,
        @field:JsonProperty("region_3depth_name") val region3depthName: String,
        @field:JsonProperty("region_4depth_name") val region4depthName: String,
        val code: String,
        val x: Double,
        val y: Double
    )
}
