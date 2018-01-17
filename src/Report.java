

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Report {
	
//	public enum DeadAlive {
//		ALIVE,
//		DEAD;
//	}
	private long end;
	private String name;
	private String desc;
	private String secondName;
	
	public HashMap<String, Report> report = new HashMap<String, Report>();
	List<Node> notificationList = new ArrayList<Node>();
	
	NotificationReader rd = new NotificationReader();

	
	public Report(String alive, long end, String name, String desc, String secondName) {
		this.alive = alive;
		this.end = end;
		this.name = name;
		this.desc = desc;
		this.secondName = secondName;
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

	public long getEnd() {
		return end;
	}

	public void setEnd(long start) {
		this.end = start;
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
		for (int i = 0; i < notificationList.size(); i++ ) {
			for (int k = 0; k < notificationList.size(); k++ ) {
				Node node1 = notificationList.get(i);
				Node node2 = notificationList.get(k);
					if (node1.getName().equals(node2.getName())) {
						if (node1.getEnd() <= node2.getEnd()) { 
							if (node2.getDesc().equals("HELLO")) {
								Report newReport = new Report("ALIVE", node2.getEnd(), node2.getName(), node2.getDesc(), node2.getSecondName());
								report.put(node1.getName(), newReport);
									
								System.out.println(node2.getEnd() + " " + node2.getName() + " said hello: is alive");
										
									
							}
					}
						if (node1.getEnd() <= node2.getEnd()) {
							if ((node1.getSecondName().equals(node2.getSecondName()) && (!node1.getSecondName().equals("NULL")))) {
								if (node2.getDesc().equals("FOUND")) {
									
									//If getName finds someone: they are alive.
								
									Report newReport = new Report("ALIVE", node2.getEnd(), node2.getName(), node2.getDesc(), node2.getSecondName());
									report.put(node2.getName(), newReport);
									
									System.out.println("1 " + node2.getEnd() + " " + node2.getName() + " found someone: is alive");
									
									//If secondName is found: they are alive.
									newReport = new Report("ALIVE", node2.getEnd(), node2.getName(), node2.getDesc(), node2.getSecondName());
									report.put(node2.getSecondName(), newReport);
									System.out.println(report.keySet());
									System.out.println("2 " + node2.getEnd() + " " + node2.getSecondName() + " has been found: is alive");
								}	
							}
						}
						if (node2.getDesc().equals("LOST")) {
							if (node1.getEnd() < node2.getEnd()) {
								Report newReport = new Report("DEAD", node2.getEnd(), node2.getName(), node2.getDesc(), node2.getSecondName());
								report.put(node2.getSecondName(), newReport);
								
								System.out.println(node2.getStart() + " " + node2.getSecondName() + " has been lost: is dead");
								
								newReport = new Report("ALIVE", node2.getEnd(), node2.getName(), node2.getDesc(), node2.getSecondName());
								report.put(node2.getName(), newReport);
								System.out.println(node2.getEnd() + " " + node2.getName() + " has lost someone: is alive");
							}
						}
					}		
			}
		}	
	}


	
	public String getReportList() {
		StringBuilder newReport = new StringBuilder("");
		String s = " ";
		for (Node n : notificationList) {
			newReport.append(n.getName() + " ALIVE " + n.getEnd() + s + n.getName() + s + n.getDesc() + s + n.getSecondName() +  "\n");
		}
		return newReport.toString();
	}
	
	public HashMap<String, Report> getMap() {
		return report;
	}
	
//	public String getReportMap() {
//		StringBuilder newReport = new StringBuilder("");
//		String s = " ";
//		for (Report n : getMap().values()) {
//			newReport.append(n.getName() + s + n.getAlive() + s + n.getStart() + s + n.getName() + s + n.getDesc() + s + (!(n.secondName.equals("NULL")) ? n.getSecondName() : "") + "\n");
//		}
//		return newReport.toString();
//}
	
	public void getReportMap() {
		for (Map.Entry<String, Report> entry : report.entrySet()) {
			System.out.println(entry.getKey()+" : "+entry.getValue().toString());
		}
	}
	
	public String toString() {
		String s = " ";
		return s + getAlive() + s + getEnd() + s + getName() + s + getDesc() + s + (!(secondName.equals("NULL")) ? getSecondName() : "");
	}
	
	public static void main(String[] args) {
		Report r = new Report("src/file.txt");
//		System.out.println(r.getReportList());
		System.out.println(r.getMap());
		r.checkAlive();
		System.out.println(r.getMap());
//		System.out.println(r.getReportMap());
		r.getReportMap();
	}
}

//List<String> checkName = new ArrayList<String>();
//if (checkName.contains(name)) {
//System.out.println("name exists");
//}
//else {
//	checkName.add(name);
