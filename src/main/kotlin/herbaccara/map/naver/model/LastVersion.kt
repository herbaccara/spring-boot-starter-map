package herbaccara.map.naver.model

data class LastVersion(
    val version: String,
    /**
     * 권장 업데이트 주기 (초)
     */
    val interval: Int
)
