package examples.shop;

public class Item {
    private int id;
    private String name;
    private float price;

    public Item(String data){
        String[] parts = data.split(";");
        this.id = Integer.parseInt(parts[0]);
        this.name = parts[1];
        this.price = Float.parseFloat(parts[2]);
    }

    public Item(int id, String name, float price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }

    public float getPrice(){
        return price;
    }

    public String toString(){
        return String.format("%d) %s %.2f", id, name, price);
    }
}
