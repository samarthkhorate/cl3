import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HotelServer {
    public static void main(String[] args) {
        try {
            HotelServiceImpl obj = new HotelServiceImpl();

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("HotelService", obj);

            System.out.println("Hotel RMI Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}