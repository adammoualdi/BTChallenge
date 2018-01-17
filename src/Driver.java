

public class Driver {
	public static void main(String[] args) {
		Report r = new Report("file.txt");
//		System.out.println(r.getReportList());
		r.checkAlive();
//		System.out.println(r.getReportMap());
		r.getReportMap();
	}
}
