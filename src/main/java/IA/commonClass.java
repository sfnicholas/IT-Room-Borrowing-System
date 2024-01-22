package IA;
public class commonClass {    
    public static String[] equipmentColumn = {"equipmentId","category","name","equipmentStatus","currentStatus"};
    public static String[] equipmentHiddenColumn = {"sourcebuying", "timeBought", "lastReview", "itRoom", 
                               "specificStoredLocation", "maxAllowDuration", "extensionTime", "timesOfExtension"};
    public static String[] borrowColumn = {"recordId","equipmentId","returnDate","lateOrNot","userId","isStudent",
                                            "name","class","classNumber"};
    public static String[] borrowHiddenColumn = {"timesOfExtensionUsed", "feedback", "transactionTime", "dateStart", 
                                                "dateEnd", "timesBorrowRecord", "gender", "lateRecord", "numberOfBorrowedItems"
                                                , "borrowAuthorization"};
    public static String[] addingequipmentColumn = {"category", "equipmentStatus", "itRoom"};
    public static String[] category = {"Book","Microbit","Airblock","Microbit","Microbit1"};
    public static String[] equipmentStatus = {"damaged","to be checked","not opened to borrow","open to borrow"};
    public static String[] itRoom = {"605","607A","607B"};
    public static String[] usermasterColumn = {"userId", "isStudent", "name", "class", "lateRecord", "borrowAuthorization"};
    public static String[] usermasterHiddenColumn = {"numberOfBorrowedItems", "timesBorrowRecord", "classNumber", "gender"};
}
