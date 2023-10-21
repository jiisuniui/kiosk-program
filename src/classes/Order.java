package classes;

import java.util.List;
import java.util.ArrayList;

public class Order extends Kiosk{
    private List<Product> orders;

    public Order(){
        this.orders = new ArrayList<>();
    }
    
    public void order(Product product){
        this.orders.add(product);
    }

    public void cancel() {
        clear();
        System.out.println("진행하던 주문이 취소되었습니다.\n");
    }

    public void clear() {
        this.orders.clear();
    }

    public void printCheckCancel() {
        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1. 확인        2. 취소");
        System.out.println();
    }
    
    public void printCompleteCancel() {
        System.out.println("진행하던 주문이 취소되었습니다.");
        System.out.println();
    }

    public void printKiosk() {
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println();

        System.out.println("[ Orders ]");
        printMenu();
        System.out.println();

        System.out.println("[ Total ]");
        printTotal();
        System.out.println();

        System.out.println("1. 주문      2. 메뉴판");
    }

    public void printMenu() {
        for (int i = 0; i < getOrderSize(); i++) {
            orders.get(i).printMenu();
        }
    }
    
    public void printTotal() {
        System.out.printf("W %4.1f\n",getTotal());
    }
    
    public double getTotal() {
        double total=0;
        for(int i=0; i<getOrderSize(); i++){
            total += orders.get(i).getPrice();
        }
        return total;
    }

    public int getOrderSize() {
        return orders.size();
    }

    public void addOrder(Product product) {
        orders.add(product);
    }
}
