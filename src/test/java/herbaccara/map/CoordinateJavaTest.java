package herbaccara.map;

import org.junit.jupiter.api.Test;

public class CoordinateJavaTest {

    @Test
    public void test() {
        final Coordinate of = Coordinate.of(1.1, 1.2);
        System.out.println(of);
    }
}
