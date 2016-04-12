import com.novelbio.fans.Judgment;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	Judgment judgment = new Judgment(4);
    	
    	Group groupa = new Group(judgment);
    	groupa.setName("groupa");
    	Group groupb = new Group(judgment);
    	groupb.setName("groupb");
    	Group groupc = new Group(judgment);
    	groupc.setName("groupc");
    	Group groupd = new Group(judgment);
    	groupd.setName("groupd");
    
    	groupa.start();
    	groupb.start();
    	groupc.start();
    	groupd.start();
    	
    	try {
    		judgment.getCountDownLatch().await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	
    	System.out.println("All group is finished!");
    	judgment.result();
    }
}
