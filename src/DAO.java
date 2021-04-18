public interface DAO<T> {

    T getCurrentItem();

    void fetch(int id);
    boolean create(T item);
    boolean update(int id, T item);
    boolean remove(int id);
    void fetchAll();
}
