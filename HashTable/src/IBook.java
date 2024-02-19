public class IBook {

     String title;
     String author;
     String ISBN;
  
    /**
     * Returns the title of the book.
     * @return title of the book
     */
    String getTitle() {
      return title;
    }

    /**
     * Returns a string that contains the authors of the book
     * as a single string with different authors separated by /.
     * @return author names as single string
     */
    String getAuthors() {
      return author;
    }
    /**
     * Returns the 13 digit ISBN (ISBN13) that uniquely identifies this book.
     * @return ISBN number of book
     */
    String getISBN13() {
      return ISBN;
    }
}