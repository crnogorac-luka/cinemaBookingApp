public interface DAO<T> {

    void fetch(int id);
    boolean create(T item);
    boolean update(int id, T item);
    boolean remove(int id);
    void fetchAll();
}
