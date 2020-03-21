package GenericHashMap;

@SuppressWarnings ("unchecked")
public class HashTable<Key,Value> {

  private Key[] keys;
  private Value[] value;
  private int noOfItems;
  private int capacity; //Maximum number of items that can be inserted in the table. i.e noOfItems<= capacity

  public HashTable(){
     this.keys = (Key[]) new Object [Constants.TABLE_SIZE];
     this.value = (Value[]) new Object [Constants.TABLE_SIZE];
     this.capacity = Constants.TABLE_SIZE;
     this.noOfItems = 0;
  }

  public HashTable(int newCapacity){
    this.keys = (Key[]) new Object [newCapacity];
    this.value = (Value[]) new Object [newCapacity];
    this.capacity = newCapacity;
    this.noOfItems = 0;
  }

  public void remove(Key key){
    if(key==null) return;

    int index = hash (key);

    while(!keys[index].equals(key)){
      index= (index+1)%capacity;
    }

    keys[index] = null;
    value[index] = null;
    noOfItems--;

    while(keys[index]!=null){

      Key tempKey = keys[index];
      Value tempVal = value[index];

      keys[index]=null;
      value[index] = null;

      noOfItems--;
      put (tempKey,tempVal);
      index= (index+1)%capacity;

    }



    if(noOfItems<= capacity/3){
      System.out.println ("halfing the size of the hashTable.. " );
      resize(capacity/2);
    }


  }

  private void resize(int newCapacity) {

    System.out.println("Resize table with new capacity: " + newCapacity);

    HashTable<Key, Value> newTable = new HashTable<>(newCapacity);


    for(int i=0;i<capacity;++i) {
      if( keys[i] != null ) {
        newTable.put(keys[i], value[i]);
      }
    }

    keys = newTable.getKeys();
    value = newTable.getValue();
    capacity = newTable.getCapacity();
  }


  public void put(Key key,Value values){

    if(key == null || value == null){
      return;
    }

    if(noOfItems >= capacity*0.75){
      System.out.println ("Doubling the size of the table... " );
      resize(2*capacity);
    }
    int index = hash (key);
    while(keys[index] != null){

      //update
    if(keys[index].equals(key)){
      value[index] = values;
      return;
    }

    index=(index+1)%capacity;
  }
    keys[index]= key;
    value[index] = values;
    noOfItems++;

  }

  public Value get(Key key){
    if(key == null) return null;

    int index = hash(key);

    while(keys[index] != null){
      if(keys[index].equals(key)){
        return value[index];
      }else{
        index = (index+1)%capacity;
      }
    }
    return null;

  }

  private int hash(Key key){
    return Math.abs(key.hashCode ()) % capacity;
  }

  public int size(){
    return noOfItems;
  }

  public boolean isEmpty(){
    return noOfItems==0;
  }

  public Key[] getKeys() {
    return keys;
  }

  public void setKeys(Key[] keys) {
    this.keys = keys;
  }

  public Value[] getValue() {
    return value;
  }

  public void setValue(Value[] value) {
    this.value = value;
  }

  public int getNoOfItems() {
    return noOfItems;
  }

  public void setNoOfItems(int noOfItems) {
    this.noOfItems = noOfItems;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }
}
