package classes;

import java.util.ArrayList;
import java.util.List;

public class MenuList extends Kiosk{
    private List<Menu> menuList;
 

    public MenuList() {
        menuList = new ArrayList<>();
    }

    public void printKiosk() {
        System.out.println();
        System.out.println("SHAKESHACK BURGER 에 오신걸 환영합니다.");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
        System.out.println();

        System.out.println("[ SHAKESHACK MENU ]");
        printMenuList();
        System.out.println();

        int i = getMenuListSize();
        System.out.println("[ ORDER MENU ]");
        System.out.println((i+1) + ". Order                | 장바구니를 확인 후 주문합니다.");
        System.out.println((i+2) + ". Cancel               | 진행중인 주문을 취소합니다.");
        System.out.println();
    }

    public void printMenuList() {
        for (int i = 0; i < getMenuListSize(); i++) {
            System.out.print((i + 1) + ". ");
            menuList.get(i).printMenu();
        }
    }

    public int getMenuListSize() {
        return this.menuList.size();
    }

    public Menu getMenu(int index) {
        return menuList.get(index-1);
    }


    public void addMenu(Menu menu) {
        this.menuList.add(menu);
    }

    // Getter Setter
    public List<Menu> getMenuList() {
        return menuList;
    }
    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }
    
}
