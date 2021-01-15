package constant;

public enum Color {
    BLACK("#000000"),
    WHITE("#FFFFFF"),
    RED("#FF0000"),
    GREEN("#008000"),
    BLUE("#0000FF"),
    YELLOW("#FFFF00");

    private String colorHex;

    Color(String colorHex) {
        this.colorHex = colorHex;
    }

    public String getHex(){
        return colorHex;
    }
}
