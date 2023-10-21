package classes;

public class Menu {
    private String type;
    private String explain;

    public Menu(String type, String explain) {
        this.type = type;
        this.explain = explain;
    }

    public void printMenu() {
        System.out.printf("%-20s | %s\n", this.type, this.explain);
    }



    // Getter Setter
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public String getExplain() {
        return this.explain;
    }
    public void setExplain(String explain) {
        this.explain = explain;
    }
    
}
