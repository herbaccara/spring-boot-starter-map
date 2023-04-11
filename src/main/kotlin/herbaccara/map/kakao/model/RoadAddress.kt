package herbaccara.map.kakao.model

import com.fasterxml.jackson.annotation.JsonProperty

data class RoadAddress(
    @field:JsonProperty("address_name") val addressName: String,
    @field:JsonProperty("region_1depth_name") val region1depthName: String,
    @field:JsonProperty("region_2depth_name") val region2depthName: String,
    @field:JsonProperty("region_3depth_name") val region3depthName: String,
    @field:JsonProperty("road_name") val roadName: String,
    @field:JsonProperty("underground_yn") val undergroundYn: String,
    @field:JsonProperty("main_building_no") val mainBuildingNo: String,
    @field:JsonProperty("sub_building_no") val subBuildingNo: String,
    @field:JsonProperty("building_name") val buildingName: String,
    @field:JsonProperty("zone_no") val zoneNo: String,
    val x: Double,
    val y: Double
)
