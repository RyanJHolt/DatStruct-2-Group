package utils;

import Models.Drink;
import Models.Ingredient;

@SuppressWarnings({"unchecked", "rawtypes", "unused"})
public class linkedList<F> {
    private linkedNode head = null;

    public void addElementH(F e) {
        //Add element to head of list
        linkedNode<F> node = new linkedNode<>(e);
        if (size() == 0){
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }

    public void addElementH(Ingredient e, int q) {
        //Add element to head of list
        linkedNode<F> node = new linkedNode<>(e, q);
        if (size() == 0){
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }

    public void addElementT(F e) {
        //Add element to tail of list
        linkedNode<F> node = new linkedNode<>(e);
        linkedNode temp = head;
        if (head == null) {
            head = node;
        } else {
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }

    public void addElementT(Ingredient e, int q) {
        //Add element to tail of list
        linkedNode<F> node = new linkedNode<>(e, q);
        linkedNode temp = head;
        if (head == null) {
            head = node;
        } else {
            while (temp.next != null)
                temp = temp.next;
            temp.next = node;
        }
    }

    public void updateElement(int n, F e) {
        linkedNode temp = head;
        if (n == 0) {
            head.setContents(e);
        } else {
            while (temp != null) {
                int i = 0;
                while (i < (n - 1) & temp != null) { //Get to the nth element
                    temp = temp.next;
                    i++;
                }
                if (temp != null && temp.next != null) { //update nth element
                    temp.next.setContents(e);
                }
            }
        }
    }

    public void updateElement(int n, Ingredient e, int q) {
        linkedNode temp = head;
        if (n == 0) {
            head.setContents(e);
            head.setQuantity(q);
        } else {
            int i = 0;
            while (i < (n - 1)) { //Get to the nth element
                temp = temp.next;
                i++;
            }
            if (temp.next != null) { //update nth element
                temp.setContents(e);
                temp.setQuantity(q);
            }
        }
    }


    public void deleteElement(int n) {
        linkedNode temp = head;
        if (n == 0 && size() >= 1) {
            head = head.next;
        } else if (n == 0 && size() == 1) {
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

    //clears the list
    public void clear() {
        head = null;
    }

    public linkedNode getHead() {
        return head;
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
            if (temp.next != null) { //return nth element
                return temp.next;
            }
        }
        return null;
    }

    public Ingredient getIngredient(int n) {
        return (Ingredient) getElement(n).getContents();
    }

    public Drink getDrink(int n) {
        return (Drink) getElement(n).getContents();
    }

    public int size() {
        int size = 0;
        if (head != null) {
            linkedNode temp = head;
            while (temp != null) {
                size++;
                temp = temp.next;
            }
        }
        return size;
    }

    public static class linkedNode<F> {
        public linkedNode next = null;
        public int quantity = 0;
        private F contents; //ADT reference!

        public linkedNode(F contents) {
            this.contents = contents;
        }

        public linkedNode(Ingredient contents, int quantity) {
            this.contents = (F) contents;
            this.quantity = quantity;
        }

        public boolean compareNodes(linkedNode compare){
            return getContents()==compare.getContents();
        }

        public F getContents() {
            return contents;
        }

        public void setContents(F c) {
            contents = c;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}
