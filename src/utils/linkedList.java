package utils;

import Models.Ingredient;

public class linkedList<F> {
    private linkedNode head=null;

    public void addElementH(F e) {
        //Add element to head of list
        linkedNode<F> node=new linkedNode<F>(e);
        node.next=head;
        head=node;
    }

    public void addElementH(Ingredient e, int q) {
        //Add element to head of list
        linkedNode<F> node=new linkedNode<F>(e,q);
        node.next=head;
        head=node;
    }

    public void addElementT(F e) {
        //Add element to tail of list
        linkedNode<F> node=new linkedNode<F>(e);
        linkedNode temp = head;
        while (temp != null &&  temp.next != null)
            temp = temp.next;
        temp.next = node;
    }

    public void updateElement(int n,F e) {
        linkedNode temp = head;
        if (n==1){
            head = new linkedNode<F>(e);
        } else {
            while (temp != null) {
                int i = 0;
                while (i < (n - 1)) { //Get to the nth element
                    temp = temp.next;
                    i++;
                }
                if (temp.next != null) { //update nth element
                    temp.next = new linkedNode<F>(e);
                }
            }
        }
    }

    public void updateElement(int n,Ingredient e, int q) {
        linkedNode temp = head;
        if (n==0){
            head = new linkedNode<F>(e,q);
        } else {
                int i = 0;
                while (i < (n - 1)) { //Get to the nth element
                    temp = temp.next;
                    i++;
                }
                if (temp.next != null) { //update nth element
                    temp.next = new linkedNode<F>(e,q);
            }
        }
    }


    public void deleteElement(int n) {
        linkedNode temp = head;
        if (n==0 && size()>=1){
            head = head.next;
        } else if (n==0 && size()==1) {
            head = null;
        } else {
                int i = 0;
                while (i < (n - 1)) { //Get to the nth element
                    temp = temp.next;
                    i++;
                }
                if (temp.next != null) { //delete nth element
                    temp.next = temp.next.next;
            }
        }
    }

    public linkedNode getElement(int n) {
        linkedNode temp = head;
        if (n == 0) {
            return head;
        } else {
                int i = 0;
                while (i < (n - 1)) { //Get to the nth element
                    temp = temp.next;
                    i++;
                }
                if (temp.next != null) { //update nth element
                    return temp.next;
            }
        } return null;
    }

    public int size() {
        int size = 0;
        linkedNode temp = head;
        while (temp != null){
            size++;
            temp = temp.next;
        } return size;
    }

    public class linkedNode<F> {
        public linkedNode next=null;
        private F contents; //ADT reference!
        public int quantity = 0;

        public linkedNode(F contents) {
            this.contents = contents;
        }
        public linkedNode(Ingredient contents,int quantity) {
            this.contents = (F)contents;
            this.quantity = quantity;
        }

        public F getContents() { return contents; }
        public void setContents(F c) { contents=c; }


        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}
