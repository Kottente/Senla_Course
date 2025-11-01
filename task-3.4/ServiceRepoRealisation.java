import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceRepoRealisation implements ServiceRepository {
    private final Map<Integer, Service> services = new HashMap<>();

    @Override
    public Service findById(int id) {
        if(!services.containsKey(id)){
            System.out.println("Сервис не найден");
            return null;
        }
        return services.get(id);

    }

    @Override
    public List<Service> findAll() {
        return new ArrayList<>(services.values());
    }

    @Override
    public void add(Service service) {
        if(!services.containsKey(service.getId())){
            services.put(service.getId(), service);
        }
        else{
            System.out.println("Сервис с таким идентификатором уже существует");
        }
    }

    @Override
    public void update(Service service) {
        if(!services.containsKey(service.getId())){
            System.out.println("Сервиса с таким идентификатором не существует");
        }
        else{
            services.put(service.getId(), service);
        }
    }
}
