import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class RMIClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            StringService stub = (StringService) registry.lookup("StringService");

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter first string: ");
            String str1 = sc.nextLine();

            System.out.print("Enter second string: ");
            String str2 = sc.nextLine();

            String result = stub.concatenate(str1, str2);

            System.out.println("Concatenated String: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}