package utils;

@SuppressWarnings({"rawtypes", "unchecked"})
public class shellSort {
//based on https://www.geeksforgeeks.org/shellsort/
    public static void sortABV(linkedList a) {
        int listSize = a.size();
        for (int gap = listSize / 2; gap > 0; gap /= 2) { //creates large gap than reduces it after every pass
            for (int i = gap; i < listSize; i += 1) { // Do a gapped insertion sort for this gap size. keeps adding one more element until the entire array is gap sorted
                int j;
                linkedList.linkedNode temp = new linkedList.linkedNode(a.getElement(i).getContents()); //stores node contents in temp
                for (j = i; j >= gap && !comparator.moreThanABV(a.getElement(j - gap), temp); j -= gap) {
                    a.updateElement(j, a.getElement(j - gap).getContents()); //replaces element j with element j-i if element j's ABV is higher than element j-i's ABV
                }
                a.updateElement(j, temp.getContents()); //updates element j with the contents of temp aka element i
            }
        }
    }

    public static void sortAlpha(linkedList a) { //same comments as above except for a different comparator
        int listSize = a.size();
        for (int gap = listSize / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < listSize; i += 1) {
                int j;
                linkedList.linkedNode temp = new linkedList.linkedNode(a.getElement(i).getContents());
                for (j = i; j >= gap && comparator.alphabetical(a.getElement(j - gap), temp); j -= gap) {
                    a.updateElement(j, a.getElement(j - gap).getContents());
                }
                a.updateElement(j, temp.getContents());
            }
        }
    }
}
