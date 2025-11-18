import java.util.List;

public interface ServiceRepository {
    Service findById(int id);
    List<Service> findAll();
    void add(Service service);
    void update(Service service);
    List<Service> GetAllByPrice();
    List<Service> GetByGuest(Guest guest);
}
