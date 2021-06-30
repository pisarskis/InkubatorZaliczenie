package helper;

public enum ReceiverFormData {

    NAME("foo"),
    EMAIL("foo@foo.pl"),
    PHONENO("555555555"),
    ZIPCODE("02-677"),
    TOWN("Warszawa"),
    STREET("Cybernetyki"),
    STREETNO("10"),
    FLATNO("5"),
    APNNO("PAW04A");

    private String value;

    ReceiverFormData(String velue) {
        this.value = velue;
    }

    public String getValue() {
        return value;
    }
}
