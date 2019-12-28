package utils;

public class hashMap<k,c> {
    //used to store hash chains
    private linkedList hashList;
    //Total capacity of hashList
    private int capacity;
    //Amount stored in hashList
    private int size;

    public hashMap() {
        this.hashList = new linkedList<>();
        this.capacity = 10;
        this.size = 0;

        // Create empty chains
        for (int i = 0; i < capacity; i++)
            hashList.addElementT(null);
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return getSize() == 0;
    }

    // This implements hash function to find index for a key
    public int getHashIndex(k key){
        //magic
        int hashCode = key.hashCode();
        //set index
        int index = hashCode % capacity;
        return index;
    }

    //remove a key
    public c removeKey(k key){
        //use hash function to find the index of the given key
        int hashIndex = getHashIndex(key);
        //get head of the chain
        hashNode head = (hashNode) hashList.getElement(hashIndex).getContents();

        //search the chain for the key
        hashNode prev = null;
        while (head != null){
            //if key found stops looping
            if (head.key.equals(key))
                break;//else advances through the list
            prev = head;
            head = head.next;
            }
        //if key not found
        if (head == null)
            return null;
        //reduce size
        size--;
        //when found replace key with previous key if it exists
        if (prev != null)
            prev.next = head.next;
        else //if there is no previous key replace it with the next key
            hashList.updateElement(hashIndex,head.next);

        //return the contents of the deleted key for testing purposes
        return (c) head.content;
    }

    public c getContent(k key) {
        int hashIndex = getHashIndex(key);
        //get head of the chain for given key
        hashNode head = (hashNode) hashList.getElement(hashIndex).getContents();

        //search the chain for the key
        while (head != null) {
            //if key found stops looping and returns content associated with key
            if (head.key.equals(key))
                return (c) head.content;
            //else advances through the list
            head = head.next;
        }
        //if key not found
        return null;
    }

    public void add(k key, c content){
        int hashIndex = getHashIndex(key);
        //get head of the chain for given key
        hashNode head = (hashNode) hashList.getElement(hashIndex).getContents();
        //search the chain for the key
        while (head != null) {
            //if key found stops looping and sets content associated with key to content given
            if (head.key.equals(key)){
                head.content = content;
                return;
            } //else advances through the chain
            head = head.next;
        }
        //insert key into chain
        size++;
        head = (hashNode) hashList.getElement(hashIndex).getContents();
        hashNode newNode = new hashNode(key, content);
        newNode.next = head;
        hashList.updateElement(hashIndex,newNode);
        //increases size if space runs out
        if ((1.0*getSize())/capacity >= 0.7){
            linkedList temp = hashList;
            hashList = new linkedList();
            capacity = 2 * capacity;
            size = 0;
            //makes a new list bigger than the previous one and transfers everything in
            for (int i = 0; i < capacity; i++) {
                hashList.addElementT(null);
            }
            linkedList.linkedNode tempNode = temp.getHead();
                while (tempNode != null)
                {
                    hashNode headNode = (hashNode) tempNode.getContents();
                    while (headNode != null) {
                        add((k) headNode.key,(c) headNode.content);
                        headNode = headNode.next;
                    }
                    tempNode = tempNode.next;
                }
            }
        }




    public class hashNode<k,c>{
        k key;
        c content;
        hashNode next;

        public hashNode(k key, c content) {
            this.key = key;
            this.content = content;
        }
    }
}

