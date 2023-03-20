package herbaccara.map.model.kakao

import com.fasterxml.jackson.annotation.JsonProperty

data class Document(
    val address: Address,
    @field:JsonProperty("address_name") val addressName: String,
    @field:JsonProperty("address_type") val addressType: AddressType,
    @field:JsonProperty("road_address") val roadAddress: RoadAddress,
    val x: Double,
    val y: Double
)
