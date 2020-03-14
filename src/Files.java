import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import operations.ListTrans;
import operations.Transaction;

public class Files {
	
	public static ArrayList<Transaction> import_file(String csvFile) {
		
        BufferedReader br = null;
        String line = "";

        try {

            br = new BufferedReader(new InputStreamReader(
                    new FileInputStream(csvFile), "UTF-8"));
            
            line = br.readLine(); /* descarta a primeira linha */
            
            if(error_wrong_file(line, csvFile) == 0) {
            	while ((line = br.readLine()) != null) {
            		
            		String[] value = line.split(",");
            		
            		int t_quantity = Integer.parseInt(value[3]);
            		float t_price = Float.parseFloat(value[4]);
            		Long t_time = Long.parseLong(value[7]);
            		
            		ListTrans.addNew(value[1], t_quantity, t_price, t_time, value[8]);
            	}
            } else {
            	return null;
            }

        } catch (FileNotFoundException e) {
        	error_notfound();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (NullPointerException e) {
        	error_notfound();
        	return null;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        
        return ListTrans.getTrans_list();
    }

	private static void error_notfound() {
		error_popup("CSV file not found.");
	}
	
	private static int error_wrong_file(String line, String csvFile) {
		
		String[] input = line.split(",");
		String[] path = csvFile.split("\\\\");
		String[] file = path[7].split("_");
		String[] csv = file[2].split("\\.");
		String type = csv[0];
		String format = csv[1];
		
		int key = 0;
		
        if(		(input.length != 9) || (
        		(input[1].compareTo("itemName") != 0) &&
        		(input[3].compareTo("quantity") != 0) &&
        		(input[4].compareTo("price") != 0) &&
        		(input[7].compareTo("time") != 0) &&
        		(input[8].compareTo("source") != 0)) || (
        		(type.compareTo("sales") != 0) ||
        		(format.compareTo("csv") != 0) )
    		){
        	error_popup("The chosen CSV file doesn't appear " + 
                	"to be the right one.\r\nMake sure you choose " +
                	"\"Accounting_[your realm]_sales.csv\"");
        	key = 1;
    	}
        
        return key;
	}
	
	private static void error_popup(String msg) {
		JFrame errorframe = new JFrame("Show Message Box");
    	errorframe.setBackground(Color.WHITE);
    	JOptionPane.showMessageDialog(errorframe, msg);
	}
	
}
