package HashMapChaining;

public class HashTable {
  private HashItem[] hashTable;

  public HashTable() {
    hashTable =  new HashItem[Constants.TABLE_SIZE];
  }

  public void put(int key, int value){
    int hashIndex = hash(key);

    if(hashTable[hashIndex] == null){
      System.out.println ("No collision situation..." );
      hashTable[hashIndex] = new HashItem (key,value);
    }else{
      HashItem hashItem = hashTable[hashIndex];

      System.out.println ("Collision at the key: "+key );

      while(hashItem.getNextHashItem () != null){
        hashItem= hashItem.getNextHashItem ();
        System.out.println ("Considering the next item in linked list: "+hashItem.getData () );
      }

      System.out.println ("Finally found a location to insert." );
      hashItem.setNextHashItem(new HashItem (key,value));

    }
    System.out.println ( );
  }

  public int get(int key){

    int hashIndex = hash(key);

    if(hashTable[hashIndex] == null){
      return -1;
    }else{
      HashItem hashItem = hashTable[hashIndex];

      while(hashItem.getNextHashItem () != null){
        hashItem = hashItem.getNextHashItem ();
      }

      if(hashItem == null){
        return -1;
      }else{
        return hashItem.getData ();
      }
    }

  }


  private int hash(int key){
    return key%Constants.TABLE_SIZE;
  }
}
