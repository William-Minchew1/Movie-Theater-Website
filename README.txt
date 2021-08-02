
MainPageBean.java

Our bean for the Main page (index.html) which only has two methods. 
One to validate the zip and another which returns a list of all theaters in the database.


Theater.java

Our bean for displaying the theaters for a given zip.
It has methods for the zip, displaying theater(s) for the given zip, and redirecting to the ShowTheater.xhtml page.


MoviesBean.java

Our bean for displaying movies and listtimes.
This bean has methods for displaying movie names, their descriptions, their listtimes, and for redirecting to
ShowMovies.xhtml and ShowListTimes.xhtml.


PurchaseTickets.java

Our bean for displaying the ticket purchase screen and thank you/ticket print off screen.
This bean has methods for the user given card number, number of tickets, current movie and listtime, validating the card number,
validating the number of tickets, redirecting to PurchaseTickets.xhtml, redirecting to ThankYou.xhtml, and 4 methods for 
displaying the thank you message including seat numbers and ticket ids.


TheaterEJB.java

Our EJB file used for two named queries; getTheater(zip) which searches by zip code, and getAllTheaters() which returns every theater in our database.


Listtimes.java

The entity class for our listtimes table. 
Jointable columns for moviename and theatername for ListtimesPK.
Has methods for Movies and ListimesPK(moviename, listtime, theatername).
Movies being a single movies object (an individual movie)


ListtimesPK.java

The entity class that acts as a sub-table for Listtimes.
Stores a Listtimes moviename, listtime, and theatername for each listtime.


Movies.java

The entity class for our Movies table which holds each movie.
Has JoinColumn theatername for MoviesPK.
Has methods for MoviesPK, description string, and theaters objects.
Contains a collection of listtimes to each movie.


MoviesPK.java

The class that acts as a sub-table for Movies.
Stores a Movies moviename and theatername.


Theaters.java

The entity class for our Theaters table which holds each theater.
Has methods for zip int, theatername string, and theateraddress string.
Contains a collection of movies to each theater.


Index.xhtml

Our main web page. 
Asks the user for a zip code and lists out all the theaters available.


ShowTheater.xhtml

The page after Index, this displays all the theaters for a given zip code.


ShowMovies.xhtml

The page after ShowTheaters, this displays all the movies, their names, photos, and descriptions for a selected theater.


ShowListTimes.xhtml

The page after ShowMovies, this displays all the listtimes for a selected movie.


PurchaseTickets.xhtml

The page after ShowListTimes, the page asks the user for the amount of tickets informing them of the cost and 
for their card number with no security number.


ThankYou.xhtml

The page after PurchaseTickets, the page thanks the user for purchasing tickets, informs them of the location, movie, and time they purchased.
It also tells them their seat number and ticket id's required to enter.
Lastly it offers them the ability to print the page.


