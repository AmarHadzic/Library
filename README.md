# Library
This is a project that simulates a library and library catalog searcher. The point of this project is to accept a file (.txt, .csv, etc.) and load the books and movies in those files into a holder which can be searched and accessed. The program was made so that anytime a book/movie is added, it generates a completely new library id so that all ids are different.
# How to Use
* To use this, please download the .java files and the optional .txt file
* Make sure they are all in the same directory
* Compile the java files using javac *.java
* Now, run this by using the Driver.java file (enter "Java Driver file_name_that_contains_the_books_and_movies")
  * example: Java Driver demo.txt
* The program should be running
* In the current Program, it allows the user to search and find movie(s) and/or book(s) with a search term:
  * title
  * author's first name
  * author's last name
  * producer's first name
  * producer's last name
  * rating
  * publisher
  * ISBN
# Note
The Driver file is an example of how one might use this program to stimulate a library and is a prototype with basic funtionality. To use the other methods (e.g. adding a book), you can create a new Driver file that implements this functionality.
# Important Notice
The current .txt file is just a basic example file that includes different books and movies
* You may add different files that contain movies and books of your choice
* Make sure these files you add are in the same directory as the .java files
* You must follow the following formats of movies and books as the program was designed to reject any other movie or book that does not follow the formats
  * For a Book: id, availability, title, year, book, firstName, lastName, publisher, isbn
  * For a movie: id, availability, title, year, movie, firstName, lastName, rating
* If you need to see what these may look like, refer to the demo.txt file
