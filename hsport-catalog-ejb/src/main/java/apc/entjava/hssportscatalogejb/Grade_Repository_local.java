package apc.entjava.hssportscatalogejb;

import java.util.List;

import javax.ejb.Local;

@Local
public interface Grade_Repository_local {

	public List<Grade_Entity> getItems();

	public void addItem(Grade_Entity item);

	public void deleteItem(Grade_Entity item);

	public void updateItem(Grade_Entity item);

	public Integer computeGrade(Integer id);

	Grade_Entity findItem(Long itemId);

	public List<Grade_Entity> searchByName(String name);



}
