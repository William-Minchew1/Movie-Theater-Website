/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.SurveyEJB;
import entity.Survey;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Will
 */
@Named(value = "surveyBean")
@RequestScoped
public class SurveyBean {

    @EJB
    private SurveyEJB surveyEJB;
    private Survey survey = new Survey();
    private String result;
    
    /**
     * Creates a new instance of SurveyBean
     */
    public SurveyBean() {
    }

    public SurveyEJB getSurveyEJB() {
        return surveyEJB;
    }

    public void setSurveyEJB(SurveyEJB surveyEJB) {
        this.surveyEJB = surveyEJB;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    
    public void validateDate(FacesContext context, UIComponent toValidate,
            Object value) throws ValidatorException {
        String date = (String) value;
        String[] tokens = date.split("-");
        int month = Integer.parseInt(tokens[0]);
        int day = Integer.parseInt(tokens[1]);
        String year = tokens[2];
        date = new SimpleDateFormat("MM-dd-yy").format(new Date());
        tokens = date.split("-");
        if(!year.equals(tokens[2])){
            FacesMessage message = new FacesMessage("Sorry, wrong year.");
            throw new ValidatorException(message);
        }
        else if (month != Integer.parseInt(tokens[0])){
            if((Integer.parseInt(tokens[0]) - month) != 1 || (Integer.parseInt(tokens[0]) - month) != -11){
                FacesMessage message = new FacesMessage("Sorry, wrong month.");
                throw new ValidatorException(message);
            }  
        }
        else if ((Integer.parseInt(tokens[1]) - day) > 7){
            FacesMessage message = new FacesMessage("Sorry, not within a week.");
            throw new ValidatorException(message);
        }
    }
    public String addSurvey(){
        surveyEJB.persist(survey);
        result = "Thank you for completing the survey.";
        return "thankYou.xhtml";
    }
}
