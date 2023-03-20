package herbaccara.map.model.kakao

import com.fasterxml.jackson.annotation.JsonProperty

data class Address(
    @field:JsonProperty("address_name") val addressName: String,
    @field:JsonProperty("b_code") val bCode: String,
    @field:JsonProperty("h_code") val hCode: String,
    @field:JsonProperty("main_address_no") val mainAddressNo: String,
    @field:JsonProperty("mountain_yn") val mountainYn: String,
    @field:JsonProperty("region_1depth_name") val region1depthName: String,
    @field:JsonProperty("region_2depth_name") val region2depthName: String,
    @field:JsonProperty("region_3depth_h_name") val region3depthHName: String,
    @field:JsonProperty("region_3depth_name") val region3depthName: String,
    @field:JsonProperty("sub_address_no") val subAddressNo: String,
    val x: Double,
    val y: Double
)
