package helper;

public enum SenderFormData {

    NAME("bar"),
    EMAIL("bar@bar.pl"),
    PHONENO("666666666"),
    ZIPCODE("30-552"),
    TOWN("Kraków"),
    STREET("Wielicka"),
    STREETNO("28"),
    FLATNO("1"),
    NIPNO("6793087624");


    private String value;

    SenderFormData(String velue) {
        this.value = velue;
    }

    public String getValue() {
        return value;
    }
}
