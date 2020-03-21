package HashMapLinearProbing;

public class HashTable {
  private HashItem[] hashTable;

  public HashTable(){
    this.hashTable = new HashItem[Constants.TABLE_SIZE];
  }

  public void put(int key, int data){
    int hashIndex = hash(key);
    System.out.println ("put() method called with the value: "+data+" at key: "+ key );

    while(hashTable[hashIndex]!=null){
      System.out.println ("collision --> at Index: "+ hashIndex );
      hashIndex = hash (hashIndex+1);

    }
    System.out.println ("Inserted at Index: "+hashIndex);
    hashTable[hashIndex] = new HashItem (key,data);
    System.out.println ( );
  }

  public int get(int key){
    int hashIndex = hash (key);

    while(hashTable[hashIndex] != null && hashTable[hashIndex].getKey () != key){
      hashIndex = hash(hashIndex+1);
      System.out.println ("Hopping to the next Index..." );
    }

    if(hashTable[hashIndex]==null){
      return -1;
    }else{
      return hashTable[hashIndex].getData ();
    }
  }

  private int hash(int key){
    return key%Constants.TABLE_SIZE;
  }
}
