import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {
        MyHashTable<Integer,String> hashTable = new MyHashTable<>(4);
        hashTable.put(10,"Hello");
        hashTable.put(5,"I'm");
        hashTable.put(4,"Adil");
        hashTable.put(3,"Mir");

        for(Integer key : hashTable.keySet())
        {
            System.out.println(hashTable.get(key));
        }
        //System.out.println(Integer.valueOf("1234"));
    }
}