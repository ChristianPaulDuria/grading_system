package apc.entjava.hssportscatalogejb;

//import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name="CATALOG_ITEM")
public class Grade_Entity {
	@Id
	@Column(name="CATALOG_ITEM_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long itemId;

	@Column(name="STUDENT_NAME")
	private String student_name;

	@Column(name="MANUFACTURER")
	private Integer student_id;

	@Column(name = "FIRSTGRADING")
	private Integer first_grading;

	@Column(name = "SECONDGRADING")
	private Integer second_grading;

	@Column(name = "THIRDGRADING")
	private Integer third_grading;

	@Column(name = "FOURTHGRADING")
	private Integer fourth_grading;

	@Column(name = "AVERAGEFINALGRADING")
	private Integer averageFinalGrading;

	@Column(name = "REMARKS")
	private String remarks;



	
	public Grade_Entity(String student_name, Integer student_id, Integer first_grading, Integer second_grading, Integer third_grading, Integer fourth_grading, Integer averageFinalGrading, String remarks) {
		super();
		this.student_name = student_name;
		this.student_id = student_id;
		this.first_grading = first_grading;
		this.second_grading = second_grading;
		this.third_grading = third_grading;
		this.fourth_grading = fourth_grading;

		this.averageFinalGrading = averageFinalGrading;

		this.remarks = remarks;

	}

	public Grade_Entity() {

	}


	public Long getItemId() {
		return itemId;
	}


	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getStudentName() {
		return student_name;
	}

	public void setStudentName(String student_name) {
		this.student_name = student_name;
	}

	public Integer getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}

	public Integer getFirstGrading() {
		return first_grading;
	}

	public void setFirstGrading(Integer first_grading) {
		this.first_grading = first_grading;
	}

	public Integer getSecondGrading() {
		return second_grading;
	}

	public void setSecondGrading(Integer second_grading) {
		this.second_grading = second_grading;
	}

	public Integer getThirdGrading() {
		return third_grading;
	}

	public void setThirdGrading(Integer third_grading) {
		this.third_grading = third_grading;
	}

	public Integer getFourthGrading() {

		return fourth_grading;
	}

	public void setFourthGrading(Integer fourth_grading) {
		this.fourth_grading= fourth_grading;
	}

	public Integer getAverageFinalGrading() {
		return averageFinalGrading;
	}

	public void setAverageFinalGrading(Integer averageFinalGrading) {
		this.averageFinalGrading = averageFinalGrading;

	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks= remarks;

	}

	@Override
	public String toString() {
		return "CatalogItem [itemId=" + itemId + ", student_name=" + student_name + ", student_id=" + student_id + ", first_grading="
				+ first_grading + " +, second_grading=" + second_grading + ", third_grading=" + third_grading +", fourth_grading=" + fourth_grading +" +, averageFinalGrading=" + averageFinalGrading +" +, remarks=" + remarks +"]";
	}
}
