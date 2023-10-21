import java.util.List;
import java.util.Scanner;

import classes.Kiosk;
import classes.Menu;
import classes.MenuList;
import classes.Order;
import classes.Product;
import classes.ProductList;
import classes.Waiting;

public class App {

    static MenuList mainMenus = new MenuList();
    static ProductList burgers = new ProductList();
    static ProductList frozenCustards = new ProductList();
    static ProductList drinks = new ProductList();
    static ProductList beers = new ProductList();
    
    static Order order = new Order();
    static Waiting waiting = new Waiting();
    static Kiosk kiosk = new Kiosk();

    public static void main(String[] args) throws Exception {
        Scanner scann = new Scanner(System.in);
        inputMenu();
        int input = 0;

        for (;;) {
            mainMenus.printKiosk();
            do {
                kiosk.printInputGuide();
                input = scann.nextInt();
            } while(input<=0 || mainMenus.getMenuListSize()+2 < input);
            
            if (0 < input && input <= mainMenus.getMenuListSize()) {
                switch (input) {
                    case 1: 
                        burgers.printKiosk();
                        do {
                            kiosk.printInputGuide();
                            input = scann.nextInt();
                        } while (input <= 0 || burgers.getProductListSize() < input);
                        order.addOrder(burgers.getProduct(input));
                        continue;

                    case 2:
                        frozenCustards.printKiosk();
                        do {
                            kiosk.printInputGuide();
                            input = scann.nextInt();
                        } while (input <= 0 || frozenCustards.getProductListSize() < input);
                        order.addOrder(frozenCustards.getProduct(input));
                        continue;

                    case 3:
                        drinks.printKiosk();
                        do {
                            kiosk.printInputGuide();
                            input = scann.nextInt();
                        } while (input <= 0 || drinks.getProductListSize() < input);
                        order.addOrder(drinks.getProduct(input));
                        continue;

                    case 4:
                        beers.printKiosk();
                        do {
                            kiosk.printInputGuide();
                            input = scann.nextInt();
                        } while (input <= 0 || beers.getProductListSize() < input);
                        order.addOrder(beers.getProduct(input));
                        continue;

                    default:
                        continue;
                }
            }
            
            // Order 메뉴
            else if (input == mainMenus.getMenuListSize() + 1) {
                if (order.getOrderSize() == 0) {
                    System.out.println("nothing\n");
                    continue;
                }

                order.printKiosk();
                do {
                    kiosk.printInputGuide();
                    input = scann.nextInt();
                } while (input != 1 && input != 2);

                if (input == 1) {
                    waiting.addWaiting(order);
                    waiting.printKiosk();
                    order.clear();
                    continue;
                } else if (input == 2) {
                    continue;
                }
            }
            
            // Cancel 메뉴
            else if (input == mainMenus.getMenuListSize() + 2) {
                order.printCheckCancel();
                do {
                    kiosk.printInputGuide();
                    input = scann.nextInt();
                } while (input != 1 && input != 2);

                if (input == 1) {
                    order.cancel();
                    continue;
                } else if (input == 2) {
                    continue;
                }
            } 

        }

        //scann.close();
    }
    
    public static void inputMenu() {
        mainMenus.setMenuList(List.of(
                new Menu("Burgers", "앵거스 비프 통살을 다져만든 버거"),
                new Menu("Frozen Custard", "매장에서 신선하게 만드는 아이스크림"),
                new Menu("Drinks", "매장에서 직접 만드는 음료"),
                new Menu("Beer", "뉴욕 브루클린 브루어리에서 양조한 맥주")));

        burgers.setProducts(List.of(
                new Product("Burgers", "ShackBurger", "토마토 양상추", 10.9),
                new Product("Burgers", "SmokeShack", "애플 우드 칩", 12.9),
                new Product("Burgers", "ShroomBurger", "몬스터 치즈", 9.4),
                new Product("Burgers", "ShackStack", "슈룸 버거와 쉑버거", 12.4),
                new Product("Burgers", "CheeseBurger", "치즈버거", 10.9),
                new Product("Burgers", "HamBurger", "취향에 따라 선택하는 버거", 9.0)));

        frozenCustards.setProducts(List.of(
                new Product("Frozen Custard", "Shakes", "쉐이크", 5.9),
                new Product("Frozen Custard", "Cups & Cones", "아이스크림", 4.9),
                new Product("Frozen Custard", "Custards", "커스터드", 8.9)));

        drinks.setProducts(List.of(
                new Product("Drinks", "Lemonade", "레몬에이드", 4.5),
                new Product("Drinks", "Iced Tea", "아이스티", 3.9),
                new Product("Drinks", "Fifty Fifty", "레몬에이드와 아이스티", 4.4),
                new Product("Drinks", "Fountain Soda", "탄산음료", 3.3),
                new Product("Drinks", "Abita Root Beer", "무알콜 맥주", 4.4),
                new Product("Drinks", "Bottled Water", "생수", 1.0)));

        beers.setProducts(List.of(
                new Product("Beer", "ShackMeister Ale", "뉴욕 에일 맥주", 9.8),
                new Product("Beer", "Magpie Brewing Co.", "페일에일 맥주", 6.8)));

    }
}
