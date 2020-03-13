import operations.ListTrans;

public class Wow {

	public static void main(String[] args) {
		
		ListTrans.setTrans_list(Files.import_file());
		ListTrans.printReport(3, 2);
	}

}