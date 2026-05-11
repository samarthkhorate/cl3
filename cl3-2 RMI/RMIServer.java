import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            StringServiceImpl obj = new StringServiceImpl();

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("StringService", obj);

            System.out.println("RMI Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}