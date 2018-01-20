
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NotificationReader {
	
    private List<Node> notificationList = new ArrayList<Node>();
	
    public void readDB(String filename) {
    	Scanner scanner = null;
    	try {
    		scanner = new Scanner(new File(filename));

        while(scanner.hasNext()) {
        	try {
	            long start = scanner.nextLong();
	            long end = scanner.nextLong();
	            String name = scanner.next();
	            String desc = scanner.next();
	            String secondName = scanner.next();
	            // create new Node
	            Node newNode = new Node(start, end, name, desc, secondName);
	            notificationList.add(newNode);
        	} catch(Exception e) {
        		System.out.println("error, can't read file.");
//        		e.printStackTrace();
        		System.exit(0);
        	}
        }

    	} catch(IOException e) {
    		System.out.println("Exception, can not find text file.");
//    		e.printStackTrace();
    	}

    	scanner.close();
    }
    
    public List<Node> getList() {
    	return notificationList;
    }
    
    
	public static void main(String[] args) {
		NotificationReader nr = new NotificationReader();
		nr.readDB("src/file.txt");
		System.out.println(nr.getList());
	}
}
