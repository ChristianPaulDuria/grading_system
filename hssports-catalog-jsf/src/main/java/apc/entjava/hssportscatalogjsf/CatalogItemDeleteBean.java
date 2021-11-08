package apc.entjava.hssportscatalogjsf;

import java.io.Serializable;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import apc.entjava.hssportscatalogejb.Grade_Entity;
import apc.entjava.hssportscatalogejb.Grade_Repository_local;

@Named
@ConversationScoped
public class CatalogItemDeleteBean implements Serializable{

	private long itemId;

	private Grade_Entity item;

	@Inject
	private CatalogItemFormBean catalogItemFormBean;

	/** test
	private ComputeGradesBean computeGradesBean;*/

	@Inject
	private Grade_Repository_local catalogBean;

	@Inject
	private Conversation conversation;

	public void fetchItem() {
		conversation.begin();
		this.item=catalogBean.findItem(this.itemId);
	}

	public String removeItem() {
		this.catalogBean.deleteItem(this.item);
		conversation.end();
		return "list?faces-redirect=true";
	}

	public String updateItem(){
		this.catalogBean.updateItem(this.item);
		conversation.end();
		return "list?faces-redirect=true";
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public Grade_Entity getItem() {
		return item;
	}

	public void setItem(Grade_Entity item) {
		this.item = item;
	}

	public CatalogItemFormBean getCatalogItemFormBean() {
		return catalogItemFormBean;
	}

	public void setCatalogItemFormBean(CatalogItemFormBean catalogItemFormBean) {
		this.catalogItemFormBean = catalogItemFormBean;
	}

	/** test
	public ComputeGradesBean getComputeGradesBean() {
		return computeGradesBean;
	}

	public void setComputeGradesBean(ComputeGradesBean computeGradesBean) {
		this.computeGradesBean = computeGradesBean;
	}*/


}
