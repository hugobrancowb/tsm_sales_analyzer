package Operations;
import java.util.Calendar;

public class Transaction {

    private String itemName;
    private float income;
    private Calendar time;

    public Transaction() {
    }
    
	public Transaction(String itemName, int quantity, float price, float time) {
		
		Calendar t = Calendar.getInstance();
		t.setTimeInMillis((long)time*1000);
		t.set(Calendar.DAY_OF_MONTH,1);
		
		this.itemName = itemName;
		this.income = quantity*price;
		this.time = t;
		
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