package helper;

public enum Prices {
    APM_A_PL("12,99 zł"),
    APM_B_PL("13,99 zł"),
    APM_C_PL("15,49 zł"),
    APM_A_EN("PLN 12.99"),
    APM_B_EN("PLN 13.99"),
    APM_C_EN("PLN 15.49"),

    C2D_A_PL("12,99 zł"),
    C2D_B_PL("13,99 zł"),
    C2D_C_PL("15,49 zł"),
    C2D_A_EN("PLN 12.99"),
    C2D_B_EN("PLN 13.99"),
    C2D_C_EN("PLN 15.49");

    private String price;

    Prices(String velue) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }
}
