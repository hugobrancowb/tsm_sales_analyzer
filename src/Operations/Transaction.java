package Operations;
import java.util.Calendar;

public class Transaction implements Comparable<Transaction> {

    private String itemName;
    private float income;
    private Calendar time;

    public Transaction() {
    }
    
	public Transaction(String itemName, int quantity, float price, long time) {
		
		Calendar t = Calendar.getInstance();
		t.setTimeInMillis(time*1000);
				
		this.itemName = itemName;
		this.income = quantity*price;
		this.time = t;
		
	}
	
	@Override
	public int compareTo(Transaction t) {
		return (int)(t.getIncome() - income);
	}

	/* getters and setters */
	
	public String getItemName() {
		return itemName;
	}

	public float getIncome() {
		return income;
	}

	public void setIncome(float income) {
		this.income = income;
	}

	public Calendar getTime() {
		return time;
	}
}