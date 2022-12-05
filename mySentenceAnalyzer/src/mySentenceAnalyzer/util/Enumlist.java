package myCampusTour.util;

/**
 * This class is used to define the enum types of the program
 */
public class Enumlist {
    public static enum BuildingE{
        SOM,
        WATSON;
    }

    public static enum TransportE{
        WALK,                                                           // 1USD
        BUS;                                                            // 3USD
    }

    public static enum GiftFromE{
        EVENT_CENTER,
        UU;
    }

    public static enum CafeE{
        CIW,                                                            // 0 surcharge
        MOUNTAIN_VIEW;                                                  // online, +5% surcharge
    }

    public static enum LectureE{
        CS542,                                                          // inclass +10% surcharge
        CS540;                                                          // 0 surcharge
    }
}
