

/**
 * 运动员
 * 
 * @author fans.fan
 *
 */
public class User{
	
	public User(String name){
		this.name = name;
	}
	
	/** 运动员名称 */
	String name;

	long time = 0l;
	
	public long run() {
		try {
			time = (long)(Math.random() * 10000);
			System.out.println("user" + this.getName() + " run.need start=" + time);
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
