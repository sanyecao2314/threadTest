import java.util.concurrent.BrokenBarrierException;

import com.novelbio.fans.Judgment;

/**
 * 组
 * 
 * @author fans.fan
 *
 */
public class Group extends Thread {

	public Group(Judgment judgment) {
		this.judgment = judgment;
	}
	
	/** 起跑发令员 */
	Judgment judgment;
	

	@Override
	public void run() {
		String groupname = getName();
		User user1 = new User(groupname + " user1");
		User user2 = new User(groupname + " user2");
		User user3 = new User(groupname + " user3");
		User user4 = new User(groupname + " user4");
		/* 该组所用时间  */
		long time = 0l;
		System.out.println(groupname + " is ready.");
		try {
			judgment.getBarrier().await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		time = time + user1.run();
		time = time + user2.run();
		time = time + user3.run();
		time = time + user4.run();
		System.out.println(groupname + " finish.time=" + time);
		judgment.getMapGroup2Time().put(groupname, time);
		judgment.getCountDownLatch().countDown();
	}


}
