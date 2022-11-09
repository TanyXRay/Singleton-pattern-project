package singleton.log;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Класс синглтон для класса Filter
 */
public class Logger {
    private static final Logger instance = new Logger();
    private int num = 1;
    private String timeStamp = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(Calendar.getInstance().getTime());

    private Logger() {
    }

    /**
     * Метод вывода на экран действий пользователя со счетчиком
     *
     * @param msg текст действия пользователя
     */
    public void log(String msg) {
        System.out.print("\n[" + timeStamp + " " + num++ + "] " + msg);
    }

    public static Logger getInstance() {
        return instance;
    }
}
