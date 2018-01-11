

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Report {
	
//	public enum DeadAlive {
//		ALIVE,
//		DEAD;
//	}
	private long start;
	private String name;
	private String desc;
	private String secondName;
	
	public HashMap<String, Report> report = new HashMap<String, Report>();
	List<Node> notificationList = new ArrayList<Node>();
	
	NotificationReader rd = new NotificationReader();

	
	public Report(String alive, long start, String name, String desc, String secondName) {
		this.alive = alive;
		this.start = start;
		this.name = name;
		this.desc = desc;
		this.secondName = secondName;
		rd.readDB("file.txt");
		notificationList = rd.getList();
	}
	
	public Report(String filename) { 
		rd.readDB(filename);
		notificationList = rd.getList();
	}
	
	private String alive;
	public String getAlive() {
		return alive;
	}

	public void setAlive(String alive) {
		this.alive = alive;
	}

	public long getStart() {
		return start;
	}

	public void setStart(long start) {
		this.start = start;
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




	
	public void checkAlive() {
	//	for (Node node : notificationList) {
	//		String name = node.getName();

				for (int i = 0; i < notificationList.size()-1; i++ ) {
					
					int k = 0;
					for (k = 0; k < notificationList.size()-1; k++ ) {
						Node node1 = notificationList.get(i);
						Node node2 = notificationList.get(k);
						if (node1.getName().equals(node2.getName())) {
							if (node1.getStart() <= node2.getStart()) { 
								if (node2.getDesc().equals("HELLO")) {
									Report newReport = new Report("ALIVE", node2.getStart(), node2.getName(), node2.getDesc(), node2.getSecondName());
									report.put(node1.getName(), newReport);
									
									System.out.println(node2.getStart() + " " + node2.getName() + " is alive");
										
									
								}
							}
					
						}
						if (node1.getSecondName().equals(node2.getSecondName())) {
								if (node2.getDesc().equals("FOUND")) {
									Report newReport = new Report("ALIVE", node2.getStart(), node2.getName(), node2.getDesc(), node2.getSecondName());
									report.put(node1.getName(), newReport);
									
									System.out.println(node2.getStart() + " " + node2.getSecondName() + " is alive");
									
								}
						
							
						}
					
					k++;
					}
				i++;
				}	
				System.out.println("DEAD");
			}
		

		
//	}

	
	public String getReportList() {
		StringBuilder newReport = new StringBuilder("");
		String s = " ";
		for (Node n : notificationList) {
			newReport.append(n.getName() + " ALIVE " + n.getStart() + s + n.getName() + s + n.getDesc() + s + n.getSecondName() +  "\n");
		}
		return newReport.toString();
	}
	
	public String getReportMap() {
		StringBuilder newReport = new StringBuilder("");
		String s = " ";
		for (Report n : report.values()) {
			newReport.append(n.getName() + s + n.getAlive() + s + n.getStart() + s + n.getName() + s + n.getDesc() + s + n.getSecondName() + "\n");
		}
		return newReport.toString();
	}


	
	public static void main(String[] args) {
		Report r = new Report("src/file.txt");
		System.out.println(r.getReportList());
		r.checkAlive();
		System.out.println(r.getReportMap());
	}
}

//List<String> checkName = new ArrayList<String>();
//if (checkName.contains(name)) {
//System.out.println("name exists");
//}
//else {
//	checkName.add(name);
