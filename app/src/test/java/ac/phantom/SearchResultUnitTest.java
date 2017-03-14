package ac.phantom;

import org.junit.Test;

import static org.junit.Assert.*;


/**
 * Created by ron on 3/13/17.
 */

public class SearchResultUnitTest {
    @Test
    public void testSearch() {
        assertEquals(3, DummyDataSource.search(null, null).size());
    }

    @Test
    public void testSearchFish() {
        assertEquals(1, DummyDataSource.search("fish", null).size());
    }

    @Test
    public void testSearchWithRestrictions() {
        assertEquals(2, DummyDataSource.search("", "egg").size());
    }
}

//:)~
