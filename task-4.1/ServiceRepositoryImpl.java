import java.util.*;

public class ServiceRepositoryImpl implements ServiceRepository {
    private final Map<Integer, Service> services = new HashMap<>();
    private final Comparator<Service> byPrice = Comparator.comparing(Service::getPrice);
    private final Comparator<Service> byPriceAndDate = Comparator.comparing(Service::getPrice).thenComparing(Service::getArrangedTime);

    @Override
    public List<Service> GetAllByPrice() {
        return services.values().stream().sorted(byPrice).toList();
    }

    @Override
    public Service findById(int id) {
        if (!services.containsKey(id)) {
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
        if (!services.containsKey(service.getId())) {
            services.put(service.getId(), service);
        } else {
            System.out.println("Сервис с таким идентификатором уже существует");
        }
    }

    @Override
    public void update(Service service) {
        if (!services.containsKey(service.getId())) {
            System.out.println("Сервиса с таким идентификатором не существует");
        } else {
            services.put(service.getId(), service);
        }
    }

    @Override
    public List<Service> GetByGuest(Guest guest) {
        List<Service> service = services.values().stream().toList();
        List<Service> result = new ArrayList<>();
        for (Service s : service) {
            if (guest.getId() == s.getGuestId()) {
                result.add(s);
            }
        }
        if (result.isEmpty()) {
            System.out.println("Постоялец не пользовался услугами отеля");
            return null;
        }
        result.sort(byPriceAndDate);
        return result;
    }
}
