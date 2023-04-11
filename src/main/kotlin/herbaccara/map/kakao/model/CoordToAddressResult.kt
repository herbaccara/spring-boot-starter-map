package herbaccara.map.kakao.model

import com.fasterxml.jackson.annotation.JsonProperty

data class CoordToAddressResult(
    val documents: List<Document>,
    val meta: Meta
) {
    data class Meta(
        @field:JsonProperty("total_count") val totalCount: Int
    )

    data class Document(
        @field:JsonProperty("address") val address: Address,
        @field:JsonProperty("road_address") val roadAddress: RoadAddress
    ) {
        data class Address(
            @field:JsonProperty("address_name") val addressName: String,
            @field:JsonProperty("region_1depth_name") val region1depthName: String,
            @field:JsonProperty("region_2depth_name") val region2depthName: String,
            @field:JsonProperty("region_3depth_name") val region3depthName: String,
            @field:JsonProperty("mountain_yn") val mountainYn: String,
            @field:JsonProperty("main_address_no") val mainAddressNo: String,
            @field:JsonProperty("sub_address_no") val subAddressNo: String,
            @Deprecated("https://devtalk.kakao.com/t/api-6/93000")
            @field:JsonProperty("zip_code")
            val zipCode: String
        )
    }
}
