package program;

import filter.Filter;
import singleton.log.Logger;
import util.exception.NumberGreaterThenThresholdException;

import java.util.*;

/**
 * Класс, в котором происходит общение с пользователем и логирование данных
 */
public class Program {
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);
    private Logger logger = Logger.getInstance();

    private int valueOfList;
    private int threshold;
    private int numberForFilter;

    public void communicationWithUser() {
        while (true) {
            System.out.println("Доброго времени суток!");
            try {
                System.out.println("Введите число для размера списка: ");
                valueOfList = scanner.nextInt();

                System.out.println("Введите число для границы значений элементов в списке: ");
                threshold = scanner.nextInt();

                System.out.println("Введите число для фильтрации: ");
                numberForFilter = scanner.nextInt();
                if (numberForFilter >= threshold) {
                    try {
                        throw new NumberGreaterThenThresholdException("Вы ввели число больше, чем диапозон ранд. чисел");
                    } catch (NumberGreaterThenThresholdException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            } catch (InputMismatchException e) {
                throw new RuntimeException("Вы ввели текст заместо числа!");
            }
            startLoggingProgram();
            break;
        }
    }

    private void startLoggingProgram() {
        logger.log("Запускаем программу!");
        String logInputData = "Пользователь ввел входные данные для списка:\n" +
                              " -размер списка: " + "**" + valueOfList + "**\n" +
                              " -порог вхождения рандомных элементов: " + "**" + threshold + "**\n" +
                              " -число для фильтрации: " + "**" + numberForFilter + "**";
        logger.log(logInputData);

        logger.log("Создаём и наполняем список");
        List<Integer> rawList = fillingList(valueOfList, threshold);

        System.out.print("\nСлучайный список: ");
        rawList.forEach(i -> System.out.print(i + " "));

        logger.log("Запускаем фильтрацию...");
        Filter filter = new Filter(numberForFilter);
        List<Integer> resultList = filter.filterOut(rawList);

        logger.log("Прошло фильтр: " + resultList.size() + " элемента из " + valueOfList);
        logger.log("Выводим результат на экран: ");
        System.out.print("\nОтфильтрованный список: ");
        resultList.forEach(i -> System.out.print(i + " "));
    }

    private List<Integer> fillingList(int valueOfList, int threshold) {
        List<Integer> rawList = new ArrayList<>();
        for (int i = 0; i < valueOfList; i++) {
            rawList.add(random.nextInt(threshold));
        }
        return rawList;
    }
}

