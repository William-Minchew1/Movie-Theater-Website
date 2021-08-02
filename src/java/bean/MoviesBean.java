/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.TheaterEJB;
import entity.Listtimes;
import entity.Movies;
import entity.Theaters;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Will
 */
@Named(value = "moviesBean")
@SessionScoped
public class MoviesBean implements Serializable{

    @EJB
    private TheaterEJB theaterEJB;
    private Collection<Movies> movies;
    private Movies movie;
    private Theaters theater;

    /**
     * Creates a new instance of MoviesBean
     */
    public MoviesBean() {
    }

    /**
     * Returns a collection of movie objects 
     * @return 
     */
    public Collection<Movies> getMovies() {
        return movies;
    }
    
    /**
     * Returns the current movie object 
     * @return 
     */
    public Movies getCurrentMovie(){
        return movie;
    }

    /**
     * Sets the current collection to the given one
     * @param movies given collection of movie objects
     */
    public void setMovies(List<Movies> movies) {
        this.movies = movies;
    }

    /**
     * Sets the theater object to the given one and returns link to next page
     * @param theater Theaters object containing a collection of theaters
     * @return link to ShowMovies page
     */
    public String showMovies(Theaters theater) {
        this.theater = theater;
        return "ShowMovies.xhtml?faces-redirect=true";
    }
    
    /**
     * Returns the current movie name
     * @return 
     */
    public String getMovieName(){
        return movie.getMoviesPK().getMoviename();
    }
    
    /**
     * Returns collection of movies for the current theater
     * @return 
     */
    public Collection<Movies> getMovieList(){
            return theater.getMoviesCollection();
    }
    
    /**
     * Sets the current movie to the given one and returns link to next page
     * @param movie Movies object to be used on the next page
     * @return Link to ShowListTimes page
     */
    public String showListTimes(Movies movie){
        this.movie = movie;
        return "ShowListTimes.xhtml?faces-redirect=true";
    }
    
    /**
     * Returns collection of list times for the given movie
     * @return 
     */
    public Collection<Listtimes> getListTimesList(){          
            return movie.getListtimesCollection();
    }
    
}

