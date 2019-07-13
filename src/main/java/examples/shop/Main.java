package examples.shop;

public class Main {
    public static void main(String[] args){
        Terminal terminal = new Terminal("https://sda-shop-server.herokuapp.com");
        terminal.run();
    }
}
