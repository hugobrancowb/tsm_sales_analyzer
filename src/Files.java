import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import Operations.ListTrans;
import Operations.Transaction;

public class Files {
	public static ArrayList<Transaction> import_file() {

        String csvFile = "data/Accounting_Azralon_sales.csv";
        BufferedReader br = null;
        String line = "";

        try {

            br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(csvFile), "UTF-8"));
            
            br.readLine(); /* descarta a primeira linha */

            while ((line = br.readLine()) != null) {

            	String[] value = line.split(",");
                
                int t_quantity = Integer.parseInt(value[3]);
                float t_price = Float.parseFloat(value[4]);
                Long t_time = Long.parseLong(value[7]);
                
                ListTrans.addNew(value[1], t_quantity, t_price, t_time, value[8]);
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
