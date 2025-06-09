package LibrarySystem;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Repo<T> {
    private Map<String, T> storage = new HashMap<>();

    public void add(String id, T item) {
        storage.put(id, item);
    }

    public void remove(String id) {
        storage.remove(id);
    }

    public T get(String id) {
        return storage.get(id);
    }

    public Collection<T> getAll() {
        return storage.values();
    }
}
