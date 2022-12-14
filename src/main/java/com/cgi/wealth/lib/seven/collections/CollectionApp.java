package com.cgi.wealth.lib.seven.collections;

import lombok.Data;

import java.util.*;

/**
 * Collection framework is group of interfaces and frameworks used to store data efficiently
 *
 * Collection | No direct implementation
 *      Root level interface
 * List |  insertion order is reserved
 *      ArrayList
 *          LinkedList
 *      Vector
 *      Stack
 * Set | No duplicate elements
 *      HashSet
 *          LinkedHashSet
 *      SortedSet
 *          NavigableSet
 *              TreeSet
 * Queue | FIFO First in First Out
 *      LinkedList
 *      PriorityQueue
 *
 * Map | Key value pair | No duplicate keys
 *
 * Collections are growable in nature not like arrays. Collections Efficiently use memory
 * Can not have primitives
 *
 */

public class CollectionApp {

    public static void main(String[] args) {
        CollectionApp collectionApp = new CollectionApp();
        collectionApp.sychronizeIt();
        collectionApp.createEmptyList();
        collectionApp.createACopy();
        collectionApp.createArray();
        collectionApp.createArrayList();
        collectionApp.createLinkedList();
    }

    private void createLinkedList() {
        /**
         * Insertion and removal is faster
         * Read by index performance is not as good ArrayList
         * Consumes more memory
         */
        List<User> users = new LinkedList<>();

    }

    private void createArrayList() {
        /**
         * Index based data structure
         * Read by index performance is good
         * Insertion and removal is slow
         * Consumes less memory
         * Allows duplicates
         */
        List<User> users = Arrays.asList(createArray());
        Set<User> targetSet = new HashSet<User>(Arrays.asList(createArray()));
    }

    private User[] createArray() {
        User user1 = new User(1);
        User[] users = new User[] {user1};
        return users;
    }

    private void createACopy() {
        List<String> srclst = new ArrayList<String>(3);
        List<String> destlst = new ArrayList<String>(3);

        // Adding element to srclst
        srclst.add("Ram");
        srclst.add("Gopal");
        srclst.add("Verma");

        // Adding element to destlst
        destlst.add("1");
        destlst.add("2");
        destlst.add("3");

        // printing the srclst
        System.out.println("Value of source list: " + srclst);

        // printing the destlst
        System.out.println("Value of destination list: " + destlst);

        System.out.println("\nAfter copying:\n");

        // copy element into destlst
        Collections.copy(destlst, srclst);

        // printing the srclst
        System.out.println("Value of source list: " + srclst);

        // printing the destlst
        System.out.println("Value of destination list: " + destlst);
    }

    private void createEmptyList() {
        List list = Collections.EMPTY_LIST;
        Set set = Collections.EMPTY_SET;
        Map map = Collections.EMPTY_MAP;
    }

    private void sychronizeIt() {
        Set<Integer> dataSet = Collections.synchronizedSet(new HashSet<Integer>());
        List<Integer> dataList = Collections.synchronizedList(new ArrayList<>());
    }

    public boolean IsMapPartOfCollections(){
        return true;
    }

    public boolean doesMapPartofCollectionInterface(){
        return false;
    }
}

@Data
class User{
    public User(int id){
        this.id = String.valueOf(id);
    }
    private String id;
    private String name;


}
