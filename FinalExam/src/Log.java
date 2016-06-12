import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

/**Приложение использует класс журнала регистрации для вывода в консоль
 *  сообщений отладчика. Реализовать данный класс через паттерн Singleton.
 * @author victor
 *
 */
public class Log  {
	private static Log instance = null;
	private Log() { }
	public static synchronized Log getInstance() {
		if(instance == null) instance = new Log();
		return instance;
	}
	public void debug(String str) {
		System.out.println("DEBUG - " + str);
	}
	

	public static void main(String[] args) {
		int a = 100;
		Log log = Log.getInstance();
		log.debug("a = " + a);
		//Logger from log4j already make singleton logger
		Logger log4j = Logger.getLogger(Log.class);
		Logger log4j1 = Logger.getLogger(Log.class);
		System.out.println(log4j);
		System.out.println(log4j1);
		log4j.addAppender(new ConsoleAppender(new SimpleLayout()));
		log4j.debug("a = " + a);
	}

}
