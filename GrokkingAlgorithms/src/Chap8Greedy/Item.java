package Chap8Greedy;

public class Item {
    public int price;
    public int weight;

    public Item(int price, int weight) {
        this.price = price;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Item{" +
                "price=" + price +
                ", weight=" + weight +
                '}';
    }
}
