package herbaccara.map

interface Coordinate {
    /**
     * longtitue 경도
     */
    val x: Double

    /**
     * lattitue 위도
     */
    val y: Double

    companion object {

        @JvmStatic
        fun of(x: Double, y: Double): Coordinate {
            return DefaultCoordinate(x, y)
        }
    }
}
