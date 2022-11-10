package filter;

import singleton.log.Logger;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    private int threshold;

    public Filter(int threshold) {
        this.threshold = threshold;
    }

    /**
     * Метод производит фильтрацию списка с логированием действий
     *
     * @param source список с рандомными числами
     * @return список отфильтрованный по критерию
     */
    public List<Integer> filterOut(List<Integer> source) {
        Logger log = Logger.getInstance();
        List<Integer> resultList = new ArrayList<>();
        source.stream()
                .distinct()
                .forEach(i -> {
                    if (i > threshold) {
                        resultList.add(i);
                        log.log("Элемент " + i + " проходит");
                    } else log.log("Элемент " + i + " не проходит");
                });
        return resultList;
    }
}
