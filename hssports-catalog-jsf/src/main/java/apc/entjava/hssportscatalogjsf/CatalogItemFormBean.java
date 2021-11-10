package apc.entjava.hssportscatalogjsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import apc.entjava.hssportscatalogejb.Grade_Entity;
import apc.entjava.hssportscatalogejb.Grade_Repository_local;


@RequestScoped
@Named
public class CatalogItemFormBean implements Serializable {

	@Inject
	private Grade_Repository_local catalogBean;

	private Grade_Entity item = new Grade_Entity();

	private List<Grade_Entity> items = new ArrayList<>();

	private String searchText;

	/** private Integer averageFinalGrading; */
	private Integer averageFinalGrading;


	public void searchByName() {
		this.items = this.catalogBean.searchByName(this.searchText);
	}

	public String addItem() {
//		long itemId = this.catalogBean.getItems().size() + 1;


		this.catalogBean.addItem(new Grade_Entity(this.item.getStudentName(), this.item.getStudent_id(),
				this.item.getFirstGrading(), this.item.getSecondGrading(), this.item.getThirdGrading(), this.item.getFourthGrading(),
				this.item.getAverageFinalGrading(), this.item.getRemarks()));

		return "list?faces-redirect=true";
	}

	   /** compute grades / get items / remarks */
		public void init() {
		this.items = this.catalogBean.getItems();
		this.items.forEach(item-> item.setAverageFinalGrading(this.catalogBean.computeGrade(item.getStudent_id())));
		this.items.forEach(item-> item.setRemarks(item.getAverageFinalGrading()>75?"Passed":"Failed"));
	}


	public Grade_Repository_local getCatalogBean() {
		return catalogBean;
	}

	public void setCatalogBean(Grade_Repository_local catalogBean) {
		this.catalogBean = catalogBean;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public Grade_Entity getItem() {
		return item;
	}

	public void setItem(Grade_Entity item) {
		this.item = item;
	}

	public List<Grade_Entity> getItems() {
		return items;
	}

	public void setItems(List<Grade_Entity> items) {
		this.items = items;
	}






}
