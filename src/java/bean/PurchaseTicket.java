/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.TheaterEJB;
import entity.Listtimes;
import entity.Movies;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import java.util.Random;
import static javax.ws.rs.client.Entity.html;

/**
 *
 * @author Will
 */
@Named(value = "purchaseTicket")
@SessionScoped
public class PurchaseTicket implements Serializable{

    @EJB
    private TheaterEJB theaterEJB;
    private String card;
    private Listtimes time;
    private Movies movie;
    private Random ranNum = new Random();
    
    /**
     * Creates a new instance of PurchaseTicket
     */
    public PurchaseTicket() {
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public Listtimes getTime() {
        return time;
    }

    public void setTime(Listtimes time) {
        this.time = time;
    }

    public Movies getMovie() {
        return movie;
    }

    public void setMovie(Movies movie) {
        this.movie = movie;
    }
    
    public void validateCard(FacesContext context, UIComponent toValidate,
        Object value) throws ValidatorException {
        String cardNum = (String) value;
        cardNum = cardNum.replaceAll("\\D", "");
        String regex = "\\d{16}";
        if(cardNum.matches(regex)){
            
        }
        else{
            FacesMessage message = new FacesMessage("Please enter a 16 digit card number");
            throw new ValidatorException(message);
        }
    }
    
    public String showPurchase(Listtimes listtime){
        time = listtime;
        return "PurchaseTicket.xhtml?faces-redirect=true";
    }
    
    public String showThankYou(){
        return "ThankYou.xhtml?faces-redirect=true";
    }
    public String displayThankYou(){
        String message = "Thank you for purchasing a ticket for ";
        message += time.getListtimesPK().getMoviename() + " at " + time.getListtimesPK().getListtime() 
                + " at " + time.getMovies().getTheatername().getTheatername();
      
        return message;
    }
    
    public String displayThankYou2(){
        return "Please print this page and bring it to your theater with the ticket number below.";
    }
    
    public String displayThankYou3(){
        return "Seat Number: " + String.valueOf(ranNum.nextInt(100));
    }
    
    public String displayThankYou4(){
        return "Ticket ID: "+ String.valueOf(ranNum.nextInt(1000000)); 
    }
}
