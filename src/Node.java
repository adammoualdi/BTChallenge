

import java.io.Serializable;

public class Node implements Serializable {
	private long recieved;
	private long generated;
	private String name;
	private String desc; 
	private String secondName;
//{ 
//		HELLO, LOST, FOUND  
//	}
	
	public Node(long recieved, long generated, String name, String desc) {
		this.recieved = recieved;
		this.generated = generated;
		this.name = name;
		this.desc = desc;
		secondName = null;
	}
	
	public Node(long recieved, long generated, String name, String desc, String secondName) {
		this.recieved = recieved;
		this.generated = generated;
		this.name = name;
		this.desc = desc;
		this.secondName = secondName;
	}
	
	public void setStart(long recieved) {
		this.recieved = recieved;
	}
	
	public long getStart() {
		return recieved;
	}
	
	public long getEnd() {
		return generated;
	}

	public void setEnd(long generated) {
		this.generated = generated;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String notificationOutput() {
		String s = " ";
		return recieved + s + generated + s + name + s + desc + s + secondName;
	}
	
	public static void main(String[] args) {
		Node node = new Node(100000, 1000001, "luke", "HELLO", "a");
		System.out.println(node.notificationOutput());
	}
	
}
