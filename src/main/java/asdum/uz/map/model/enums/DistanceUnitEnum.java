package asdum.uz.map.model.enums;

public enum DistanceUnitEnum {
    BUS_STOP(0, ""),
    KILOMETERS(1, "km"),
    NAUTICAL_MILES(2, "nmi"),
    MILES(3, "mi");

    private int value;
    private String strValue;

    DistanceUnitEnum(int value, String strValue) {
        this.value = value;
        this.strValue = strValue;
    }

    public int getValue() {
        return value;
    }

    public String getStrValue() {
        return strValue;
    }

    public static DistanceUnitEnum getFromStringValue(String inpStrVal) {
        if (inpStrVal == null) {
            return BUS_STOP;
        } else {
            if (inpStrVal.compareToIgnoreCase(KILOMETERS.strValue) == 0) {
                return KILOMETERS   ;
            } else if (inpStrVal.compareToIgnoreCase(NAUTICAL_MILES.strValue) == 0) {
                return NAUTICAL_MILES;
            } else if (inpStrVal.compareToIgnoreCase(MILES.strValue) == 0) {
                return MILES;
            } else {
                return BUS_STOP;
            }
        }
    }
}
