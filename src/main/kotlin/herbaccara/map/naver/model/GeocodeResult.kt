package herbaccara.map.naver.model

data class GeocodeResult(
    val status: String,
    val meta: Meta,
    val addresses: List<Address>,
    val errorMessage: String
) {
    data class Meta(
        val totalCount: Int,
        val page: Int,
        val count: Int
    )

    data class Address(
        val roadAddress: String,
        val jibunAddress: String,
        val englishAddress: String,
        val addressElements: List<AddressElement>,
        val x: String,
        val y: String,
        val distance: Double
    ) {
        data class AddressElement(
            val types: List<String>,
            val longName: String,
            val shortName: String,
            val code: String
        ) {
            enum class Type {
                SIDO,
                SIGUGUN,
                DONGMYUN,
                RI,
                ROAD_NAME,
                BUILDING_NUMBER,
                BUILDING_NAME,
                LAND_NUMBER,
                POSTAL_CODE
            }
        }
    }
}
