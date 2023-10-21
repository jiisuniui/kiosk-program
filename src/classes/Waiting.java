package classes;

import java.util.ArrayList;
import java.util.List;

public class Waiting {
    private List<Order> waiting;

    public Waiting() {
        waiting = new ArrayList<>();
    }

    public void printKiosk() {
        System.out.println("주문이 완료되었습니다!");
        System.out.println();

        System.out.println("대기번호는 [ " + getWaitingNum() + " ] 번 입니다.");
        System.out.println("(3초후 메뉴판으로 돌아갑니다.)");
        System.out.println();
    }
    
    public void addWaiting(Order order) {
        waiting.add(order);
    }

    public int getWaitingNum() {
        return waiting.size();
    }

    public List<Order> getWaiting() {
        return waiting;
    }
    public void setWaiting(List<Order> waiting) {
        this.waiting = waiting;
    }
}
