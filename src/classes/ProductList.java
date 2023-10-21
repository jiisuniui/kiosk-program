package classes;

import java.util.ArrayList;
import java.util.List;

public class ProductList extends Kiosk{
    private List<Product> products;
 
    public ProductList() {
        products = new ArrayList<>();
    }

    public void printKiosk() {
        System.out.println();
        System.out.println("SHAKESHACK BURGER 에 오신걸 환영합니다.");
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.");
        System.out.println();

        System.out.println("[ "+products.get(0).getType()+" MENU ]");
        printProductList();
        System.out.println();
    }

    public void printProductList() {
        for (int i = 0; i < this.products.size(); i++) {
            System.out.print((i + 1) + ". ");
            products.get(i).printMenu();
        }
    }

    public int getProductListSize() {
        return this.products.size();
    }

    public Product getProduct(int index) {
        return products.get(index-1);
    }


    public void addProduct(Product product) {
        products.add(product);
    }

    // Getter Setter
    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
}
