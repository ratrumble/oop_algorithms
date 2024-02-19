import java.util.ArrayList;
import java.util.List;

public class HashtableMapTests {

  //rehash, remove, clear, put, get, contains, size
  
  //tests constructor without input
  //verifies generic types
  //verifies no rehashing at load factor of .5
  //verifies size() working with put()
  //verifies dupe/null key input rejection
  //verifies index determination. because I want to see index I do NOT use contains()
  public static boolean test1() { 
    HashtableMap<String, Integer> ht = new HashtableMap();
    
    for (int i = 0; i < 5; i ++) {
      ht.put("object" + i, i);
    }
    
    if(ht.hashtable.length!=15){
      return false;
    }
    
    if(ht.size() != 5) {
      return false;
    }
    
    if(ht.put("object0", 0)) {
      return false;
    }
    
    if(ht.put(null, 21)) {
      return false;
    }
    
    int index = ("object0").hashCode();
    if(index < 0) {
      index *= -1;
    }
    index %= ht.hashtable.length;
    
    boolean bSwitch = false;
    
    for(int i = 0; i < ht.hashtable[index].size(); i ++) {
      if("object0".equals(ht.hashtable[index].get(i).getKey())) {
        bSwitch = true;
      }
    }
    
    if(!bSwitch) {
      return false;
    }
    
    return true;
  }
  
  //verifies constructor with input
  //verifies rehashing at load factor >=.7
  //verifies rehashing table size
  //verifies old pairs getting relocated if necessary
  //does NOT use contains() because I want to see the actual index, whether it is old or new
  public static boolean test2() { 
    
    HashtableMap<String, Integer> ht = new HashtableMap(10);
    
    for (int i = 0; i < 5; i ++) {
      ht.put("object" + i, i);
    }
    
    if(ht.hashtable.length!=10){
      return false;
    }
    
    ht.put("object5", 5);
    ht.put("object6", 6);
    
    if(ht.hashtable.length!=20){
      return false;
    }
    
    if(ht.size() != 7) {
      return false;
    }
    
    int index = ("object0").hashCode();
    if(index < 0) {
      index *= -1;
    }
    index %= ht.hashtable.length;
    
    boolean bSwitch = false;
    
    for(int i = 0; i < ht.hashtable[index].size(); i ++) {
      if("object0".equals(ht.hashtable[index].get(i).getKey())) {
        bSwitch = true;
      }
    }
    
    if(!bSwitch) {
      return false;
    }
    
    return true;
  }
  
  //tests get()
  //verifies that it works with null values
  //verifies that nonexistent keys do not work with get()
  public static boolean test3() {
    
    HashtableMap<String, Integer> ht = new HashtableMap(10);
    
    for (int i = 0; i < 5; i ++) {
      ht.put("object" + i, i);
    }
    
    ht.put("object5", null);
    
    if(!ht.get("object0").equals(0)) {
      return false;
    }
    
    if(ht.get("object5")!=null) {
      return false;
    }
    
    try {
      ht.get("object6");
    }
    catch(Exception e) {
      System.out.println(e.getMessage());
    }
    
    return true;
  }
  
  //tests remove()
  //verifies that remove does return Value
  //verifies that size is modified upon successful removal.
  //verifies that a nonexistent/null value returns null
  //verifies that key is not contained
  public static boolean test4() { 
    
    HashtableMap<String, Integer> ht = new HashtableMap(10);
    
    for (int i = 0; i < 5; i ++) {
      ht.put("object" + i, i);
    }
    
    ht.put("object5", null);
    
    if(ht.size()!=6) {
      return false;
    }
    
    if(!ht.remove("object0").equals(0)) {
      return false;
    }
    
    if(ht.size()!=5) {
      return false;
    }
    
    if(ht.remove("object5")!=null) {
      return false;
    }
    
    if(ht.size()!=4) {
      return false;
    }
    
    if(ht.remove("object6")!=null) {
      return false;
    }
    
    if(ht.size()!=4) {
      return false;
    }
    
    if(ht.containsKey("object0")) {
      return false;
    }
    
    return true;
  }
  
  //tests both contains() and remove()
  //verifies contains() functionality
  //verifies that contains() returns false if input key does not exist
  //verifies that contains() works on relocated keys
  //verifies that clear() does not reset array size
  //verifies that size is reset to 0 upon clear()
  //verifies functionality of clear()
  public static boolean test5() { 
    
    HashtableMap<String, Integer> ht = new HashtableMap(10);
    
    for (int i = 0; i < 5; i ++) {
      ht.put("object" + i, i);
    }
    
    if(ht.containsKey("thisKeyDoesntExist")) {
      return false;
    }
    
    ht.put("object5", 5);
    ht.put("object6", 6);
    
    //I have checked the hashcode value and the index does change after 1 rehash
    if(!ht.containsKey("object0")) {
      return false;
    }
    
    ht.clear();
    
    if(ht.hashtable.length!=20) {
      return false;
    }
    
    if(ht.size()!=0) {
      return false;
    }
    
    for(int i = 0; i < ht.hashtable.length; i++) {
      if(ht.hashtable[i]!=null) {
        return false;
      }
    }
    
    return true;
  }
  
  
  public static void main (String args[]) {
    /**
    HashtableMap<String, Integer> ht = new HashtableMap(10);
    
    for (int i = 0; i < 5; i ++) {
      ht.put("object" + i, i);
    }
    
    ht.printString();
    **/
    
    /**
    System.out.println("test 1 result is " + test1());
    System.out.println("test 2 result is " + test2());
    System.out.println("test 3 result is " + test3());
    System.out.println("test 4 result is " + test4());
    System.out.println("test 5 result is " + test5());
    **/
    
    /**
     * ADDED BDIterableMapADT placeholder
     * ADDED BookMapperBackend implementation
     * ADDED HashtableMap for BDIterableMapADT
     * ADDED MapADT for HashtableMap
     * ADDED StoreKeyValue as KeyType ValueType storage class
     * CHANGED IBook to implementation placeholder
     * COMMENTED OUT unimplemented objects in BookMapper
     */
    BookMapperBackend bm = new BookMapperBackend();
    IBook book1 = new IBook();
    book1.author = "joe";
    book1.ISBN = "1234567890123";
    book1.title = "Lolz";
    bm.addBook(book1);
    
    IBook book2 = new IBook();
    book2.author = "bob";
    book2.ISBN = "0987654321098";
    book2.title = "lol";
    bm.addBook(book2);
    

    System.out.println(bm.getAuthorFilter());
    
    bm.setAuthorFilter("joe");
    System.out.println(bm.getAuthorFilter());
    
    bm.resetAuthorFilter();
    System.out.println(bm.getAuthorFilter());
    
    System.out.println(bm.getNumberOfBooks());
    
    System.out.println(bm.getByISBN("1234567890123").equals(book1));
    

    
    List<IBook> list= bm.searchByTitleWord("lol");
    /**
    for (int i = 0; i < list.size(); i ++) {
      System.out.println(list.get(i).getTitle());
    }
    **/
    if(list.size()!=2) {
      System.out.println("fail 2");
    }
    
    
    list = bm.searchByTitleWord("ballsacks");
    if(list.size()!=0) {
      System.out.println("fail 0");
    }
    
    bm.setAuthorFilter("joe");
    list = bm.searchByTitleWord("lol");
    if(list.size()!=1) {
      System.out.println("fail 1");
      System.out.println(list.size());
      for (int i = 0 ; i < list.size(); i ++) {
        System.out.println(list.get(i).getTitle());
      }
    }
    for (int i = 0 ; i < list.size(); i ++) {
      System.out.println(list.get(i).getTitle());
    }
    
    System.out.println(list.get(0).equals(book1));
  }
}
