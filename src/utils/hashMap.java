package utils;

import java.util.Arrays;

@SuppressWarnings({"unchecked", "rawtypes"})
public class hashMap<k, c> {
    //used to store hash chains
    private hashNode[] hashArray;
    //Total capacity of hashList
    private int capacity;
    //Amount stored in hashList
    private int size;

    public hashMap() {
        this.capacity = 10;
        this.hashArray = new hashNode[capacity];
        this.size = 0;

        // Create empty chains
        for (int i = 0; i < capacity; i++)
            hashArray[i] = null;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {return getSize()==0;} //returns true if no nodes have been added to the array

    // This implements hash function to find index for a key
    public int getHashIndex(String key) {
        //magic also know as an inbuilt function of the Object class that determines object hashcode
        int hashCode = key.hashCode();
        //set index
        return hashCode % capacity;
    }

    //remove a key
    public void removeKey(String key) {
        //use hash function to find the index of the given key
        int hashIndex = getHashIndex(key);
        //get head of the chain
        hashNode<k, c> head = hashArray[hashIndex];
        //search the chain for the key
        hashNode<k, c> prev = null;
        while (head != null) {
            //if key found stops looping
            if (head.key.equals(key))
                break;
            //else advances through the list
            prev = head;
            head = head.next;
        }
        //if key not found end function
        if (head == null)
            return;
        //else reduce size
        size--;
        //when found replace key with previous key if it exists
        if (prev != null)
            prev.next = head.next;
        else if(head.next != null)//if there is no previous key replace it with the next key
            hashArray[hashIndex] = head.next; //if there is no head.next this will set hashArray[hash index] to null
    }

    public c get(String key) {
        int hashIndex = getHashIndex(key);
        //get head of the chain for given key
        hashNode<k, c> head = hashArray[hashIndex];

        //search the chain for the key
        while (head != null) {
            //if key found stops looping and returns content associated with key
            if (head.getKey().equals(key))
                return head.getContent();
            //else advances through the list
            head = head.next;
        }
        //if key not found
        return null;
    }

    public hashNode<k, c> getNode(String key) {
        int hashIndex = getHashIndex(key);
        //get head of the chain for given key
        hashNode<k, c> head = hashArray[hashIndex];
        //search the chain for the key
        while (head != null) {
            //if key found stops looping and returns node associated with key
            if (head.getKey().equals(key))
                return head;
            //else advances through the list
            head = head.next;
        }
        //if key not found
        return null;
    }

    public linkedList keyContains(String search){ //searches hashMap and returns a list of any nodes with keys that contain the search string
        linkedList results = new linkedList(); //creates new linkedList to store results of search
        for (hashNode temp : hashArray) //for each loop that runs through each node in the array
            while (temp != null) { //if a node exists in that slot of the array the next line checks if its key contains the search term
                if (temp.getKey().toUpperCase().contains(search.toUpperCase())) {
                    results.addElementH(temp.getContent()); //if it does it adds it to the array
                } temp = temp.next; //then tries to repeat along the chain
            }
        if (results.size()==0){
            return null;
        } return results; //returns the list of nodes
    }


    public void add(String key, c content) { //add a node to hashMap
        int hashIndex = getHashIndex(key);
        //get head of the chain for given key
        hashNode head = hashArray[hashIndex];
        //search the chain for the key
        while (head != null) {
            //if key found stops looping and sets content associated with key to content given
            if (head.getKey().equals(key)) {
                head.content = content;
                return;
            } //else advances through the chain
            head = head.next;
        }
        //insert key into chain
        size++;
        head = hashArray[hashIndex];
        hashNode<k, c> newNode = new hashNode(key, content);
        newNode.next = head;
        hashArray[hashIndex] = newNode;
        //increases size if space runs out
        if ((1.0 * getSize()) / capacity >= 0.7) {
            hashNode<k, c>[] temp = hashArray;
            capacity = 2 * capacity;
            hashArray = new hashNode[capacity];
            size = 0;
            //makes a new list bigger than the previous one and transfers everything in
            for (int i = 0; i < capacity; i++) {
                hashArray[i] = (null);
            }
            for (hashNode<k, c> tempNode : temp) {
                while (tempNode != null) {
                    add(tempNode.getKey(), tempNode.getContent());
                    tempNode = tempNode.next;
                }
            }
        }
    }

    @SuppressWarnings("unused")
    public static class hashNode<k, c> {
        String key;
        c content;
        hashNode next;

        public hashNode(String key, c content) {
            this.key = key;
            this.content = content;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public void setContent(c content) {
            this.content = content;
        }

        public String getKey() {
            return key;
        }

        public c getContent() {
            return content;
        }

    }
}

