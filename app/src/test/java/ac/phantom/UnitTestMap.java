package ac.phantom;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UnitTestMap {
    MapActivity map=new MapActivity();

    @Test
    public void latTest() throws Exception {
        assertEquals(MapActivity.AC_LAT, 45.352386, 1e-15);
    }
    @Test
    public void lngTest() throws Exception {
        assertEquals(MapActivity.AC_LNG, -75.754869, 1e-15);
    }
    public void serverTest()throws Exception{
        assertEquals(map.servicesOK(),true);
    }


}