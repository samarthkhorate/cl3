import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.HashMap;

public class HotelServiceImpl extends UnicastRemoteObject implements HotelService {

    HashMap<String, String> bookings;

    protected HotelServiceImpl() throws RemoteException {
        bookings = new HashMap<>();
    }

    @Override
    public String bookRoom(String guestName) throws RemoteException {
        if (bookings.containsKey(guestName)) {
            return "Room already booked for " + guestName;
        }
        bookings.put(guestName, "Booked");
        return "Room successfully booked for " + guestName;
    }

    @Override
    public String cancelBooking(String guestName) throws RemoteException {
        if (!bookings.containsKey(guestName)) {
            return "No booking found for " + guestName;
        }
        bookings.remove(guestName);
        return "Booking cancelled for " + guestName;
    }
}