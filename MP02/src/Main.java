import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        /*
        Each of the associations requires at least 1-* cardinality and automatic reverse connection.
        */

    }
}

/*
    Binary
        One shipment may have multiple packages (it is possible to ship without packages, a shipment involves a trailer,
        sometimes we need to move trailer between locations)

    Composition
        one charge group must have at least one charge and may have multiple charges

    Qualified
        One shipment may have multiple charge groups

    With Attribute
        Truck driver - from to


 */