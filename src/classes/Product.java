package classes;

public class Product extends Menu {
    private String name;
    private double price;

    public Product(String type, String name, String explain, double price) {
        // super.setType(type);
        // super.setName(name);
        // super.setExplain(explain);
        super(type, explain);
        this.name = name;
        this.price = price;
    }

    public void printMenu() {
        System.out.printf("%-20s | W %4.1f | %s\n", this.getName(), this.price, this.getExplain());
    }


    // Getter Setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public double getPrice() {
        return this.price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    
}
