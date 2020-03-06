import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class files {
	public static ArrayList<Transaction> import_file() {

        String csvFile = "data/Accounting_Azralon_expenses.csv";
        BufferedReader br = null;
        String line = "";
        // ArrayList<Transaction> trans_list = new ArrayList<>();

        try {

            br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(csvFile), "UTF-8"));
            
            br.readLine(); /* descarta a primeira linha */

            while ((line = br.readLine()) != null) {
                String[] value = line.split(",");
                
                int t_amount = Integer.parseInt(value[1]);
                int t_time = Integer.parseInt(value[4]);
                
                //Transaction t = new Transaction(value[0], t_amount, value[2], value[3], t_time);
                
                ListTrans.addNew(value[0], t_amount, value[2], value[3], t_time);
                //System.out.println("Player: " + t.getPlayer());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return ListTrans.getTrans_list();
    }
}
