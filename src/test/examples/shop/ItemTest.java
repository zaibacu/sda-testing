package examples.shop;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ItemTest {
    @Test
    public void itemCreationFromText(){
        String line = "42;Hitchhiker's guide to the galaxy;20.55";
        Item item = new Item(line);

        assertEquals(42, item.getId());
        assertEquals("Hitchhiker's guide to the galaxy", item.getName());
        assertTrue(Math.abs(20.55f - item.getPrice()) < 0.0001);
    }

    @Test
    public void itemPrint(){
        Item item = new Item(1, "Test", 123.456f);
        assertEquals("1) Test 123.46", item.toString());
    }
}
