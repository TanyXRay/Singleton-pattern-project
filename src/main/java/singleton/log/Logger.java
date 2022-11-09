package singleton.log;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Класс синглтон для класса Filter
 */
public class Logger {
    private static volatile Logger instance;
    private int num = 1;

    private Logger() {
    }

    /**
     * Метод вывода на экран действий пользователя со счетчиком
     *
     * @param msg текст действия пользователя
     */
    public void log(String msg) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss:S").format(Calendar.getInstance().getTime());
        System.out.print("\n[" + timeStamp + " " + num++ + "] " + msg);
    }

    public static Logger getInstance() {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        return instance;
    }
}
