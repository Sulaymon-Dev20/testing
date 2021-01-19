package asdum.uz.map.model.enums;

public enum BusStopStatusEnum {
    BUS_STOP(0, "NO STATEMENT"),
    METRO(1, "METRO"),
//    METRO_FOR_MAP(2, "METRO_FOR_MAP"),
    ALL(7, "ALL");

    private final int value;
    private final String strValue;

    BusStopStatusEnum(int value, String strValue) {
        this.value = value;
        this.strValue = strValue;
    }

    public int getValue() {
        return value;
    }

    public String getStrValue() {
        return strValue;
    }

    public static BusStopStatusEnum getFromStringValue(String inpStrVal) {
        if (inpStrVal == null) {
            return BUS_STOP;
        } else {
            if (inpStrVal.compareToIgnoreCase(BUS_STOP.strValue) == 0) {
                return BUS_STOP;
            } else if (inpStrVal.compareToIgnoreCase(METRO.strValue) == 0) {
                return METRO;
//            } else if (inpStrVal.compareToIgnoreCase(METRO_FOR_MAP.strValue) == 0) {
//                return METRO_FOR_MAP;
            } else if (inpStrVal.compareToIgnoreCase(ALL.strValue) == 0) {
                return ALL;
            } else {
                return BUS_STOP;
            }
        }
    }
}
