package thread;

/**
 * @Author: lds
 * @Date: 2019/8/1 11:09
 */
public interface AbstractStorage {
	void consume(int num,Thread thread);
	void produce(int num,Thread thread);
	
}
