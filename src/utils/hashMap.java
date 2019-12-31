package utils;

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

    // This implements hash function to find index for a key
    public int getHashIndex(k key) {
        //magic also know as an inbuilt function of the Object class that determines object hashcode
        int hashCode = key.hashCode();
        //set index
        return hashCode % capacity;
    }

    //remove a key
    public void removeKey(k key) {
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
        //if key not found
        if (head == null)
            return;
        //else reduce size
        size--;
        //when found replace key with previous key if it exists
        if (prev != null)
            prev.next = head.next;
        else //if there is no previous key replace it with the next key
            hashArray[hashIndex] = head.next;

        /*return the contents of the deleted key for testing purposes
        return (c) head.getContent();*/
    }

    public c get(k key) {
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

    public void add(k key, c content) {
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


    public static class hashNode<k, c> {
        k key;
        c content;
        hashNode next;

        public hashNode(k key, c content) {
            this.key = key;
            this.content = content;
        }

        public k getKey() {
            return key;
        }

        public c getContent() {
            return content;
        }
    }
}

