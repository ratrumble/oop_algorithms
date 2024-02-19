
public class StoreKeyValue<KeyType, ValueType>{

  public KeyType key;
  public ValueType value;
  public StoreKeyValue<KeyType, ValueType> next;
  
  public StoreKeyValue(KeyType key, ValueType value) {
    this.key = key;
    this.value = value;
  }
  
  public KeyType getKey() {
    return key;
  }
  
  public ValueType getValue() {
    return value;
  }
  
  public String toString() {
    return key.toString() + " " + value.toString();
  }
  
}
