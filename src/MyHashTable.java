import java.util.ArrayList;
import java.util.LinkedList;

public class MyHashTable<K,V>{
    private int capacity = 11; // default
   // private LinkedList<V> list = new LinkedList<>();
    private final LinkedList<Type<K, V>>[] list;
    private final ArrayList<K> values = new ArrayList<>();
    int size;

//    public MyHashTable(int capacity) {
//        this.capacity = capacity;
//        this.list = new ArrayList<>(this.capacity);
//        list.addAll(new LinkedList<>());
//    }
//
//    public MyHashTable() {
//        list = new ArrayList<>(capacity);
//        list.addAll(new LinkedList<>());
//    }
//
//    public void put(K key, V value)
//    {
//        int index = hashFunction(key);
//        values.add(key);
//        LinkedList<V> tempList = new LinkedList<>();
//        try
//        {
//            tempList = list.get(index); // copying all elements into temporary LinkList
//        }
//        catch ( IndexOutOfBoundsException e )
//        {
//            //ignore
//        }
//        tempList.add(value);
//        System.out.println(list.size());
//        list.add(index,tempList);
//    }
//    public V get(K key)
//    {
//        int index = hashFunction(key);
//        LinkedList<V> tempList = new LinkedList<>();
//        tempList = list.get(index); // copying all elements into temporary LinkList.
//        return tempList.get(0);
//    }
//    private int hashFunction(K key) {
//        int val = Integer.parseInt(String.valueOf(key));
//        return val%capacity;
//        //return capacity;
//    }
//    public ArrayList<K> keySet()
//    {
//        return values;
//    }

    MyHashTable() {
        list = new LinkedList[capacity];
        size = 0;
    }

    MyHashTable(int capacity) {
        this.capacity = capacity;
        list = new LinkedList[this.capacity];
        size = 0;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % list.length;
    }

    public void put(K key, V value) {
        int index = hash(key);

        if (list[index] == null) {
            list[index] = new LinkedList<>(); // if no value is assigned to the list
        }
        LinkedList<Type<K, V>> tempList = list[index];
        for (Type<K, V> val : tempList) {
            if (val.getKey().equals(key)) {
                val.value = value; // replace values
                return;
            }
        }
        tempList.add(new Type<>(key, value));
        size++;

//        if ((double) size / list.length > 0.75) {
//            resize(); // load factor
//        }
    }

    public V get(K key) {
        int index = hash(key);
        LinkedList<Type<K, V>> tempList = list[index];
        if (tempList != null) {
            for (Type<K, V> val : tempList) { // returns the val at k index
                if (val.getKey().equals(key)) {
                    return val.getValue();
                }
            }
        }
        return null;
    }

    public ArrayList<K> keySet() //returns all keys
    {
        ArrayList<K> tempList = new ArrayList<>(size);
        for(int i=0;i<size;i++)
        {
            for (Type<K, V> val : list[i])
            {
                tempList.add(val.getKey());
            }
        }
        return tempList;
    }
}

