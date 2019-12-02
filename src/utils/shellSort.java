package utils;

import Models.Ingredient;

public class shellSort {
    linkedList gaps = new linkedList();
    public void shellSort(linkedList a){
        if (gaps.getElement(1) == null) {
            gaps.addElementH(1);
            gaps.addElementH(3);
            gaps.addElementH(5);
        } //creates the gaps that the algorithm sorts within
        for (int g = 0; g < getGaps().size(); g++){
            int gap = (int)gaps.getElement(g).getContents(); //sets gap to one of the gaps created earlier
            for( int e = gap;e<a.size();e++){ //sets e to gap than reduces it each iteration
                int elem = (int)a.getElement(e).getContents(), i; //initialises i as an int and sets elem to a specific element, in conjunction with the loop
                for (i = e; i >= gap && (int)a.getElement(i-gap).getContents() > elem; i -= gap) {
                    a.updateElement(i, a.getElement(i - gap));
                    a.getElement(i).setContents(elem);
                }
            }
        }
    }

    public void SortABV(linkedList a) {
        int interval = 1;
        int outer;
        int inner;
        double insertValue;

        while (interval < a.size()) {
            interval = (interval * 3) + 1;
        }
        while (interval > 0) {
            for (outer = interval; outer < a.size(); outer++) {
                insertValue = a.getElement(outer).getABV();
                inner = outer;
                while (inner > interval - 1 && a.getElement(inner - interval).getABV() >= insertValue) {
                    a.updateElement(inner,a.getElement(inner - interval));
                    inner -= interval;
                }
                a.updateElement(inner,a.getElement(outer));
            }
            interval = (interval -1) /3;
        }
    }

    public linkedList getGaps() {
        return gaps;
    }
}
