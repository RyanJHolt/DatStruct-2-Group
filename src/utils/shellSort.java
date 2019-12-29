package utils;

public class shellSort {

    public static void sortABV(linkedList a){
        int listSize = a.size();
        for (int gap = listSize/2; gap > 0; gap /= 2 ){ //creates large gap than reduces it after every pass
            for (int i = gap; i < listSize; i += 1){ // Do a gapped insertion sort for this gap size. keeps adding one more element until the entire array is gap sorted
                int j;
                linkedList.linkedNode temp = a.getElement(i);
                for (j = i; j >= gap && comparator.moreThanABV(a.getElement(j-gap),temp); j -= gap) {
                    a.updateElement(j, a.getElement(j - gap));
                }
                a.updateElement(j, temp.getContents());
            }
        }
    }

    public static void sortAlpha(linkedList a){
        int listSize = a.size();
        for (int gap = listSize/2; gap > 0; gap /= 2 ){
            for (int i = gap; i < listSize; i += 1){
                //int temp = a.getElement(i).getQuantity();
                int j;
                linkedList.linkedNode temp = a.getElement(i);
                for (j = i; j >= gap && comparator.Alphabetical(a.getElement(j-gap),temp); j -= gap) {
                    a.updateElement(j, a.getElement(j - gap));
                }
                a.updateElement(j, temp.getContents());
            }
        }
    }
}
