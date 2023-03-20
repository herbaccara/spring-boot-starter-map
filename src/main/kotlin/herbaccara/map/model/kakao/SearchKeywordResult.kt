package herbaccara.map.model.kakao

import com.fasterxml.jackson.annotation.JsonProperty

data class SearchKeywordResult(
    val documents: List<Document>,
    val meta: Meta
) {
    data class Meta(
        @field:JsonProperty("total_count") val totalCount: Int,
        @field:JsonProperty("pageable_count") val pageableCount: Int,
        @field:JsonProperty("is_end") val isEnd: Boolean,
        @field:JsonProperty("same_name") val sameName: RegionInfo
    )

    data class Document(
        @field:JsonProperty("id") val id: Long,
        @field:JsonProperty("place_name") val placeName: String,
        @field:JsonProperty("category_name") val categoryName: String,
        @field:JsonProperty("category_group_code") val categoryGroupCode: CategoryGroupCode,
        @field:JsonProperty("category_group_name") val categoryGroupName: String,
        @field:JsonProperty("phone") val phone: String,
        @field:JsonProperty("address_name") val addressName: String,
        @field:JsonProperty("road_address_name") val roadAddressName: String,
        @field:JsonProperty("x") val x: Double,
        @field:JsonProperty("y") val y: Double,
        @field:JsonProperty("place_url") val placeUrl: String,
        @field:JsonProperty("distance") val distance: String
    )
}
