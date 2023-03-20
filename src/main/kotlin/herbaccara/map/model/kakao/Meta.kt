package herbaccara.map.model.kakao

import com.fasterxml.jackson.annotation.JsonProperty

data class Meta(
    @field:JsonProperty("is_end") val isEnd: Boolean,
    @field:JsonProperty("pageable_count") val pageableCount: Int,
    @field:JsonProperty("total_count") val totalCount: Int
)
