package herbaccara.map.model.kakao

import com.fasterxml.jackson.annotation.JsonProperty

data class RegionInfo(
    val region: List<String>,
    val keyword: String,
    @field:JsonProperty("selected_region") val selectedRegion: String
)
