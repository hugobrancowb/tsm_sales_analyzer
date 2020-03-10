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
	
	public String getFullDate() {
		String s = "";
		
		s = s.concat(Integer.toString(this.getTime().get(Calendar.DAY_OF_MONTH)));
		s = s.concat("/");
		s = s.concat(Integer.toString(this.getTime().get(Calendar.MONTH) + 1));
		s = s.concat("/");
		s = s.concat(Integer.toString(this.getTime().get(Calendar.YEAR)));		
		
		return s;
	}
	
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
	
	public int getYear() {
		return time.get(Calendar.YEAR);
	}
	
	public int getMonth() {
		return time.get(Calendar.MONTH);
	}
}