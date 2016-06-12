import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**Реализуйте программные потоки производителя (producer) и потребителя (consumer),
 *  совместно использующих буфер фиксированного размера и индекс доступа к нему. 
 *  Первый поток помещает в буфер числа, второй - извлекает их оттуда. 
 *  Порядок добавления и извлечения чисел не имеет значения. 
 * @author victor
 *
 */
public class ConsumerProducer {
	
	public static void main(String[] args) {
		BlockingQueue<Integer> buffer = new ArrayBlockingQueue<Integer>(10, false);
		new Producer(buffer).start();
		new Consumer(buffer).start();

	}

}

class Producer extends Thread
{
	private BlockingQueue<Integer> buffer;
	public Producer(BlockingQueue<Integer> buf) { this.buffer = buf; }
	public void run()
	{
		for(int i = 0; i < 10; i ++) {
			try {
				buffer.put(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
class Consumer extends Thread
{
	private BlockingQueue<Integer> buffer;
	public Consumer(BlockingQueue<Integer> buf) { this.buffer = buf; }
	public void run()
	{
		for(int i = 0; i < 10; i ++) {
			try {
				System.out.println(buffer.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}