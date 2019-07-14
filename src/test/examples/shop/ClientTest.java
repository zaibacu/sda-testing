package examples.shop;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ClientTest {
    @Test
    public void itemList(){
        Client client = new Client("https://sda-shop-server.herokuapp.com");
        List<Item> result = client.getItems();

        // Item1: 1) Milk 1.99
        Item item1 = result.get(0);
        assertEquals(1, item1.getId());
        assertEquals("Milk", item1.getName());
        assertTrue(Math.abs(1.99f - item1.getPrice()) < 0.0001);

        // Item2: 2) Coffee 1.79
        Item item2 = result.get(1);
        assertEquals(2, item2.getId());
        assertEquals("Coffee", item2.getName());
        assertTrue(Math.abs(1.79f - item2.getPrice()) < 0.0001);

        // Item3: 3) Muffin 0.49
        Item item3 = result.get(2);
        assertEquals(3, item3.getId());
        assertEquals("Muffin", item3.getName());
        assertTrue(Math.abs(0.49f - item3.getPrice()) < 0.0001);
    }

    @Test
    public void payForMilk(){
        Client client = new Client("https://sda-shop-server.herokuapp.com");
        assertTrue(client.buyRequest(1, 1.99f));
    }
}
