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
public class ComputeGradesBean implements Serializable {
    @Inject
    private Grade_Repository_local gradeRepositoryBean;

    // Catalog = Grade
    // CatalogItem = Grade and student information
    // CatalogLocal = GradeLocal

    private Grade_Entity item = new Grade_Entity();

    private List<Grade_Entity> grades = new ArrayList<>();

    private Integer averageFinalGrading;


    public Integer computeGrades(){
        this.grades = this.gradeRepositoryBean.computeGrades(item.getFirstGrading(),item.getSecondGrading(),item.getThirdGrading(), item.getFourthGrading());
        // Grade_Entity
        Integer average = 0;
        Integer firstGrading = item.getFirstGrading();
        Integer secondGrading = item.getSecondGrading();
        Integer thirdGrading = item.getThirdGrading();
        Integer fourthGrading = item.getFourthGrading();

        // first grading + second  + third  + fourth / 4 = finalgrading
        average = (firstGrading + secondGrading + thirdGrading + fourthGrading) / 4;

        this.averageFinalGrading = average;

        return average;

    }

    /** test **/

    public void init() {
        this.grades = this.gradeRepositoryBean.computeGrades(item.getFirstGrading(),item.getSecondGrading(),item.getThirdGrading(), item.getFourthGrading());
    }

    public Grade_Repository_local getGradeRepositoryBean() {
        return gradeRepositoryBean;
    }

    public void setGradeRepositoryBean(Grade_Repository_local gradeRepositoryBean) {
        this.gradeRepositoryBean = gradeRepositoryBean;
    }


    /**public List<Grade_Entity> getComputeGrades() {
        return grades;
    }

    public void setComputeGrades(List<Grade_Entity> grades) {
        this.grades = grades;
    }*/

    public Integer getAverageFinalGrading() {
        return averageFinalGrading;
    }

    public void setAverageFinalGrading(Integer averageFinalGrading) {
        this.averageFinalGrading = averageFinalGrading;
    }


}