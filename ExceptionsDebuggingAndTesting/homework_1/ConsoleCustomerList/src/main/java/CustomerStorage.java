import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String regexPhoneNum = "\\+?[78]?[78\\s]?[\\s\\-(]?9[0-9]{2}[0-9\\s\\-)]{7,10}";
        String regexMail = "([a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.[a-zA-Z0-9_-]+)";

        String[] components = data.split("\\s+");

        if(components.length != 4){
            throw new IllegalArgumentException("Wrong format. Correct format: Василий Петров vasily.petrov@gmail.com +79215637722");
        }
        if (!components[3].matches(regexPhoneNum)){
            throw new IllegalArgumentException("Wrong format phone number. Correct format:+79215637722");
        }
        if(!components[2].matches(regexMail)){
            throw new IllegalArgumentException("Wrong format email. Correct format: vasily.petrov@gmail.com");
        }
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}