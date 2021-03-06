package examples.shop;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Terminal {
    private Scanner sc;
    private final Client client;

    public Terminal(Client client, InputStream inputStream){
        sc = new Scanner(inputStream);
        this.client = client;
    }

    public Terminal(String url, InputStream inputStream){
        sc = new Scanner(inputStream);
        this.client = new Client(url);
    }

    public Terminal(String url, File inputFile) throws IOException{
        sc = new Scanner(inputFile);
        this.client = new Client(url);
    }

    public Terminal(String url){
        sc = new Scanner(System.in);
        this.client = new Client(url);
    }

    public void run(){

        List<Item> items = client.getItems();
        Map<Integer, Item> itemById = new HashMap<>();
        for(Item item : items){
            System.out.println(item);
            itemById.put(item.getId(), item);
        }

        System.out.print("Please select item: ");

        int selection = sc.nextInt();

        Item selectedItem = itemById.get(selection);

        buy(selectedItem);
    }

    public void buy(Item item){
        System.out.printf("That'll be %.2f EUR\n", item.getPrice());

        float sum = item.getPrice();
        float given = 0;

        while(given < sum){
            System.out.printf("Please give money (%.2f EUR): ", (given - sum));
            given += sc.nextFloat();
        }

        if((sum - given) < 0){
            System.out.printf("Your change: %.2f\n", (sum - given));
        }

        if(client.buyRequest(item.getId(), sum)){
            System.out.println("Payment accepted");
        }
        else {
            System.out.println("Sorry, payment rejected.");
        }
    }
}
