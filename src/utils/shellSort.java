package utils;

public class shellSort {
    linkedList gaps = new linkedList();
    public void shellSort(linkedList a){
        if (gaps.getElement(1) == null) {
            gaps.addElementH(1);
            gaps.addElementH(3);
            gaps.addElementH(5);
        } //need to swap most gs to gaps.getElement(g);
        for (int g = 0; g < getGaps().size(); g++){
            int gap = (int)gaps.getElement(g).getContents();
            for(int e = gap;e<a.size();e++){
                int elem= (int)a.getElement(e).getContents(), i;
                for(i=e;i>=gap && (int)a.getElement(i-gap).getContents()>elem;i-=gap)
                    a.updateElement(i, a.getElement(i-gap));
                a.getElement(i).setContents(elem);
            }
        }
    }

    public linkedList getGaps() {
        return gaps;
    }
}
