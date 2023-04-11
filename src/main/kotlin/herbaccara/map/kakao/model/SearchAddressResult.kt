package herbaccara.map.kakao.model

import com.fasterxml.jackson.annotation.JsonProperty

data class SearchAddressResult(
    val documents: List<Document>,
    val meta: Meta
) {
    data class Meta(
        @field:JsonProperty("total_count") val totalCount: Int,
        @field:JsonProperty("pageable_count") val pageableCount: Int,
        @field:JsonProperty("is_end") val isEnd: Boolean
    )

    data class Document(
        @field:JsonProperty("address_name") val addressName: String,
        @field:JsonProperty("address_type") val addressType: AddressType,
        val x: Double,
        val y: Double,
        val address: Address,
        @field:JsonProperty("road_address") val roadAddress: RoadAddress
    ) {
        data class Address(
            @field:JsonProperty("address_name") val addressName: String,
            @field:JsonProperty("region_1depth_name") val region1depthName: String,
            @field:JsonProperty("region_2depth_name") val region2depthName: String,
            @field:JsonProperty("region_3depth_name") val region3depthName: String,
            @field:JsonProperty("region_3depth_h_name") val region3depthHName: String,
            @field:JsonProperty("h_code") val hCode: String,
            @field:JsonProperty("b_code") val bCode: String,
            @field:JsonProperty("mountain_yn") val mountainYn: String,
            @field:JsonProperty("main_address_no") val mainAddressNo: String,
            @field:JsonProperty("sub_address_no") val subAddressNo: String,
            val x: Double,
            val y: Double
        )
    }
}
