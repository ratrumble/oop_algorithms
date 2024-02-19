import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BookMapperBackend  implements IBookMapperBackend{
  
  protected  HashtableMap hashtable = new HashtableMap<String, IBook>();
  protected  String filterBy;
  
  //I have this as "static" because the AE is doing the hashtable and I'm only using this ArrayList as a placeholder
  //and I need to share the object between this class and my placeholder IterableMapADT to create an iterator
  
  //StoreKeyValue<KeyType, ValueType> is my "combined" class so I can store both in one element
  protected static ArrayList<StoreKeyValue<String, IBook>> aList = new ArrayList<StoreKeyValue<String, IBook>>();
  
  @Override
  /**
   * Adds a new book to the backend's database and is stored in
   * a hash table internally.
   * @param book the book to add
   */
  public void addBook(IBook book) {
    // TODO Auto-generated method stub
    hashtable.put(book.getISBN13(), book);
    
  }

  @Override
  /**
   * Returns the number of books stored in the backend's database.
   * @return the number of books
   */
  public int getNumberOfBooks() {
    // TODO Auto-generated method stub
    return hashtable.size();
    
  }

  @Override
  /**
   * This method can be used to set a filter for the author names
   * contained in the search results. A book is only returned as
   * a result for a search by title, it is also contains the string
   * filterBy in the names of its authors.
   * @param filterBy the string that the book's author names must contain
   */
  public void setAuthorFilter(String filterBy) {
    // TODO Auto-generated method stub
    this.filterBy = filterBy;
    
  }

  @Override
  /**
   * Returns the string used as the author filter, null if no author
   * filter is currently set.
   * @return the string used as the author filter, or null if none is set
   */
  public String getAuthorFilter() {
    // TODO Auto-generated method stub
    if(filterBy==null) {
      return null;
    }
    
    return filterBy;
  }

  @Override
  /**
   * Resets the author filter to null (no filter).
   */
  public void resetAuthorFilter() {
    // TODO Auto-generated method stub
    
    filterBy = null;
    
  }

  @Override
  /**
   * Search through all the books in the title base and return books whose
   * title contains the string word (and that satisfies the author filter,
   * if an author filter is set).
   * Updates Static ArrayList field to insert all StoreKeyValue objects inside
   * the hashtable's LinkedList[]
   * 
   * @param word word that must be contained in a book's title in result set
   * @return list of books found
   */
  public List<IBook> searchByTitleWord(String word) {
    // TODO Auto-generated method stub
    
    ArrayList<IBook> validBooks = new ArrayList<IBook>();
    
    Iterator<IBook> it = hashtable.iterator();
    
    while(it.hasNext()) {
      IBook currentBook = it.next();
      /**
      if(currentBook != null) {
        System.out.println(currentBook.getTitle().toLowerCase().contains(word.toLowerCase()) + " " + (filterBy == null || currentBook.getAuthors().toLowerCase().contains(filterBy.toLowerCase())));
      }
      **/
      if(currentBook != null && currentBook.getTitle().toLowerCase().contains(word.toLowerCase()) && (filterBy == null || currentBook.getAuthors().toLowerCase().contains(filterBy.toLowerCase()))) {
        validBooks.add(currentBook);
      }
    }
    
    return validBooks;
  }

  @Override
  /**
   * Return the book uniquely identified by the ISBN, or null if ISBN is not
   * present in the dataset.
   * @param ISBN the book's ISBN number
   * @return the book identified by the ISBN, or null if ISBN not in database
   */
  public IBook getByISBN(String ISBN) {
    // TODO Auto-generated method stub
    if(!hashtable.containsKey(ISBN)) {
      return null;
    }
    return (IBook)hashtable.get(ISBN);
  }

  
  


}
