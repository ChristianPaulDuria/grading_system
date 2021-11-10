package apc.entjava.hssportscatalogejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class Catalog
 */
@Singleton
@LocalBean
public class Grade_Repository implements Grade_Repository_local {

	/* private List<CatalogItem> items = new ArrayList<>();*/
	@PersistenceContext
	private EntityManager entityManager;

	/**
     * Default constructor. 
     */
    public Grade_Repository() {
    }

	@Override
	public List<Grade_Entity> getItems() {
		return this.entityManager.createQuery("select c from Grade_Entity c", Grade_Entity.class).getResultList();
	}



	@Override
	public void addItem(Grade_Entity item) {
		this.entityManager.persist(item);
	}

	@Override
	public void deleteItem(Grade_Entity item) {
		/*this.entityManager.createQuery("delete from CatalogItem p where p.itemId=:id")
				.setParameter("id", item.getItemId())
				.executeUpdate();
*/
		this.entityManager.remove(this.entityManager.contains(item) ? item:this.entityManager.merge(item));
	}

	@Override
	public void updateItem(Grade_Entity item) {
		this.entityManager.createQuery("update Grade_Entity c set c.student_name=:StudentName, c.student_id=:StudentID, c.first_grading=:firstGrading, c.second_grading=:secondGrading, c.third_grading=:thirdGrading, c.fourth_grading=:fourthGrading, c.remarks=: remarks where c.itemId=:id")
				.setParameter("id", item.getItemId())
				.setParameter("StudentName", item.getStudentName())
				.setParameter("StudentID", item.getStudent_id())
				.setParameter("firstGrading",item.getFirstGrading())
				.setParameter("secondGrading",item.getSecondGrading())
				.setParameter("thirdGrading",item.getThirdGrading())
				.setParameter("fourthGrading",item.getFourthGrading())
				.setParameter("remarks",item.getRemarks())
				.executeUpdate();
	}

	@Override
	public Integer computeGrade(Integer id) {
		return (Integer) this.entityManager.createQuery("select (c.first_grading + c.second_grading + c.third_grading + c.fourth_grading)/4 as averageFinalGrading from Grade_Entity c where c.student_id=:id").setParameter("id", id).getSingleResult();
	}


	@Override
	public Grade_Entity findItem(Long itemId) {
		return this.entityManager.find(Grade_Entity.class, itemId);
	}

	@Override
	public List<Grade_Entity> searchByName(String name) {
		return this.entityManager.createQuery("select c from Grade_Entity c " +
				" where c.student_name like :name", Grade_Entity.class).setParameter("name", "%" + name + "%").getResultList();
	}









}
