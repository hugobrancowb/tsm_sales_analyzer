import java.util.ArrayList;

public class Wow {

	public static void main(String[] args) {
		ArrayList<Transaction> trans_list = files.import_file();
        System.out.println("");

        Transaction t = new Transaction("Postage", 270, "Robso", "Nuzia", 1572278830);

        System.out.println(t.player);
	}

}
