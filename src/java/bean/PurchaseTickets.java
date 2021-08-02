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
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import java.util.Random;

/**
 *
 * @author Will
 */
@Named(value = "purchaseTickets")
@SessionScoped
public class PurchaseTickets implements Serializable {

    @EJB
    private TheaterEJB theaterEJB;
    private String card;
    private Listtimes time;
    private Movies movie;
    private Random ranNum = new Random();
    private String ticketNum;

    

    /**
     * Creates a new instance of PurchaseTicket
     */
    public PurchaseTickets() {
    }

    /**
     * Returns card number
     * @return 
     */
    public String getCard() {
        return card;
    }

    /**
     * Sets card number to given
     * @param card 
     */
    public void setCard(String card) {
        this.card = card;
    }

    /**
     * Returns current listtime object
     * @return 
     */
    public Listtimes getTime() {
        return time;
    }

    /**
     * Sets the current listtime object to the given one
     * @param time listtimes object given 
     */
    public void setTime(Listtimes time) {
        this.time = time;
    }

    /**
     * Returns current movie object
     * @return 
     */
    public Movies getMovie() {
        return movie;
    }

    /**
     * Sets the current movie object to the given
     * @param movie 
     */
    public void setMovie(Movies movie) {
        this.movie = movie;
    }
    
    /**
     * Returns the current number of tickets
     * @return 
     */
    public String getTicketNum() {
        return ticketNum;
    }

    /**
     * Sets the current ticket number to the given
     * @param ticketNum given number of tickets
     */
    public void setTicketNum(String ticketNum) {
        this.ticketNum = ticketNum;
    }
    
    /**
     * Validates that the given card string is a 16 digit number
     * @param context
     * @param toValidate
     * @param value
     * @throws ValidatorException 
     */
    public void validateCard(FacesContext context, UIComponent toValidate,
            Object value) throws ValidatorException {
        String cardNum = (String) value;
        cardNum = cardNum.replaceAll("\\D", "");
        String regex = "\\d{16}";
        if (cardNum.matches(regex)) {

        } else {
            FacesMessage message = new FacesMessage("Please enter a 16 digit card number");
            throw new ValidatorException(message);
        }
    }

    /**
     * Validates that the given ticketNum string is an Integer 
     * @param context
     * @param toValidate
     * @param value
     * @throws ValidatorException 
     */
    public void validateNum(FacesContext context, UIComponent toValidate,
            Object value) throws ValidatorException {
        String ticketsNum = (String) value;
        try { 
            Integer.parseInt(ticketsNum); 
            } catch(NumberFormatException e) { 
                FacesMessage message = new FacesMessage("Please enter an whole number");
            throw new ValidatorException(message);
            } catch(NullPointerException e) {
                FacesMessage message = new FacesMessage("Please enter a number");
            throw new ValidatorException(message);
            }

    }
    
    /**
     * Sets the current listtime object to the given and returns link to next page
     * @param listtime listtime object to be used on the next page
     * @return Link to the PurchaseTickets page
     */
    public String showPurchase(Listtimes listtime) {
        time = listtime;
        return "PurchaseTickets.xhtml?faces-redirect=true";
    }

    /**
     * Returns link to next page
     * @return Link to the ThankYou page
     */
    public String showThankYou() {
        return "ThankYou.xhtml?faces-redirect=true";
    }

    /**
     * Creates a string which is then returned as part of the display thanking the user for their purchase
     * @return Part 1 of string to be displayed on ThankYou.xhtml
     */
    public String displayThankYou() {
        String message = "Thank you for purchasing ticket(s) for ";
        message += time.getListtimesPK().getMoviename() + " at " + time.getListtimesPK().getListtime()
                + " at " + time.getMovies().getMoviesPK().getTheatername() 
                + " for $" + String.valueOf(Integer.parseInt(ticketNum) * 10);

        return message;
    }
    
    /**
     * Creates a string which is then returned as part of the display thanking the user for their purchase
     * @return Part 2 of string to be displayed on ThankYou.xhtml
     */
    public String displayThankYou2() {
        return "Please print this page and bring it to your theater with the ticket number below.";
    }

    /**
     * Creates a string which is then returned as part of the display thanking the user for their purchase
     * @return Part 3 of string to be displayed on ThankYou.xhtml
     */
    public String displayThankYou3() {
        int seatNum = ranNum.nextInt(100);
        String seatString = "Seat Number(s): " + String.valueOf(seatNum);
        int tempNum = Integer.parseInt(ticketNum);
        tempNum -= 1;
        while(tempNum  != 0){
            seatString += ", " + String.valueOf(seatNum += 1);
            tempNum -= 1;
        }
        return seatString;
    }

    /**
     * Creates a string which is then returned as part of the display thanking the user for their purchase
     * @return Part 4 of string to be displayed on ThankYou.xhtml
     */
    public String displayThankYou4() {
        int ticketId = ranNum.nextInt(1000000);
        String idString = "Ticket ID(s): " + String.valueOf(ticketId);
        int tempNum = Integer.parseInt(ticketNum);
        tempNum -= 1;
        while(tempNum != 0){
            idString += ", " + String.valueOf(ticketId += 1);
            tempNum -= 1;
        }
        return idString;
    }
}
