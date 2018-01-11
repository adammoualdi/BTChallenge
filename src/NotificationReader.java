

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NotificationReader {
	
    public List<Node> notificationList = new ArrayList<Node>();
	
    public void readDB(String filename) {
    	try {
    	Scanner input = new Scanner(new File(filename));

        while(input.hasNext()) {
        	try {
            long start = input.nextLong();
            long end = input.nextLong();
            String name = input.next();
            String desc = input.next();
            String secondName = input.next();
            Node newNode = new Node(start, end, name, desc, secondName);
            notificationList.add(newNode);
        	} catch(Exception e) {
        		System.out.println("error");
  //      		e.printStackTrace();
        		System.exit(0);
        	}
        }

        for (Node node : notificationList) {
 //           System.out.println(node);
        }
    	} catch(IOException e) {
//    		System.out.println("Exception");
//    		e.printStackTrace();
    	}
    	
    }
    
    public List<Node> getList() {
    	return notificationList;
//    	List<Node> tmpList = new ArrayList<Node>();
//    	for (Node n : notificationList) {
//    		tmpList.add(n);
//    	}
//    	return tmpList;
    }
    
    
    
	public static void main(String[] args) {
		NotificationReader nr = new NotificationReader();
		nr.readDB("file.txt");
		System.out.println(nr.getList());
	}
}
