import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Dimensions dim1 = new Dimensions(1, 2, 3);
        Dimensions dim2 = new Dimensions(2, 3, 4);
        Dimensions dim3 = new Dimensions(3, 4, 5);

        Package pkg1 = new Package(dim1, 4);
        Package pkg2 = new Package(dim2, 5);
        Package pkg3 = new Package(dim3, 6);

        List<Package> pkgs = new ArrayList<>();
        pkgs.add(pkg1);

        Shipment shipment = new Shipment(LocalDate.now(), pkgs);
        shipment.addPackage(pkg2);
        shipment.addPackage(pkg3);

        Shipment.showExtent();

        File file = new File("extent");
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            Shipment.saveExtent(out);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            Shipment.loadExtent(in);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}