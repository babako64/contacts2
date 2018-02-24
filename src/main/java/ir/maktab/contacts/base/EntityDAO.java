package ir.maktab.contacts.base;

import java.util.List;

public interface EntityDAO<E> {

	void add(E e);

	void update(long id,E e);

	E getById(long id);

	boolean delete(long id);

	List<E> getAll();
}
