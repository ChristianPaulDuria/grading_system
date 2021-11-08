package apc.entjava.hssportscatalogejb;

import java.util.List;

import javax.ejb.Local;

@Local
public interface Grade_Repository_local {

	public List<Grade_Entity> getItems();

	public List<Grade_Entity> computeGrades(Integer first_grading, Integer second_grading, Integer third_grading, Integer fourth_grading);

	/**
	 * public void getGrades(CatalogItem item);
	 */

	public void addItem(Grade_Entity item);

	public void deleteItem(Grade_Entity item);

	public void updateItem(Grade_Entity item);

	/**public List<Grade_Entity> getGrades(Grade_Entity item); **/

	/** public void getGrade(Grade_Entity item); */

	public void computeGrade(Grade_Entity item);

	Grade_Entity findItem(Long itemId);

	public List<Grade_Entity> searchByName(String name);



}
