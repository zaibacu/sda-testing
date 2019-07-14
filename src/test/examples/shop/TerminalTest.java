package examples.shop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class TerminalTest {
    @Test
    public void terminalRegression(){
        InputStream input = new ByteArrayInputStream(
                "1 1.99".getBytes()
        );

        Terminal terminal = new Terminal(
                "https://sda-shop-server.herokuapp.com",
                input
        );

        terminal.run();

    }

    @Test
    public void terminalUnit01(){
        Client client = mock(Client.class);
        List<Item> resultList = new ArrayList<>();
        resultList.add(new Item(42, "Hitchiker's Guide to the Galaxy", 20.55f));

        when(client.getItems()).thenReturn(resultList);
        when(client.buyRequest(42, 20.55f)).thenReturn(true);

        InputStream input = new ByteArrayInputStream(
                "42 20.55".getBytes()
        );

        Terminal terminal = new Terminal(
                client,
                input
        );

        terminal.run();
    }

    @Test
    public void terminalUnit02(){
        Client client = mock(Client.class);
        List<Item> resultList = new ArrayList<>();
        resultList.add(new Item(42, "Hitchiker's Guide to the Galaxy", 20.55f));

        when(client.getItems()).thenReturn(resultList);
        when(client.buyRequest(42, 20.55f)).thenReturn(true);

        InputStream input = new ByteArrayInputStream(
                "42 19.55 1.00".getBytes()
        );

        Terminal terminal = new Terminal(
                client,
                input
        );

        terminal.run();
    }

    @Test
    public void terminalUnit03(){
        Client client = mock(Client.class);
        List<Item> resultList = new ArrayList<>();
        resultList.add(new Item(42, "Hitchiker's Guide to the Galaxy", 20.55f));

        when(client.getItems()).thenReturn(resultList);
        when(client.buyRequest(42, 20.55f)).thenReturn(true);

        InputStream input = new ByteArrayInputStream(
                "42 50".getBytes()
        );

        Terminal terminal = new Terminal(
                client,
                input
        );

        terminal.run();
    }
}
