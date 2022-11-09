package filter;

import singleton.log.Logger;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    private int threshold;

    public Filter(int threshold) {
        this.threshold = threshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger log = Logger.getInstance();
        List<Integer> resultList = new ArrayList<>();
        for (Integer integer : source) {
            if (integer > threshold) {
                resultList.add(integer);
                log.log("Элемент " + integer + " проходит");
            } else {
                log.log("Элемент " + integer + " не проходит");
            }
        }
        return resultList;
    }
}
