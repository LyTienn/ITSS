package model;

public class Order {
	private static int nextId = 1;
	private int id;
	private int deliveryinfoId;
	private String standardfees;
	private String rushfees;
	public Order(int id, int deliveryinfoId, String standardfees, String rushfees){
		this.id = id;
		this.deliveryinfoId = deliveryinfoId;
		this.standardfees = standardfees;
		this.rushfees = rushfees;
	}
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	public int getDeliveryinfoId() {return deliveryinfoId;}
	public void setDeliveryinfoId(int deliveryinfoId) {this.deliveryinfoId = deliveryinfoId;}
	
	public String getStandardfees() {return standardfees;}
	public void setStandardfees(String standardfees) {this.standardfees = standardfees;}
	
	public String getRushfees() {return rushfees;}
	public void setRushfees(String rushfees) {this.rushfees = rushfees;}

	public static Order createOrder(Cart cart) {
		int id = nextId++;
		int deliveryinfoId = 1;
		String standardfees = String.valueOf(cart.getPrice() * 0.05);
		String rushfees = "0";
		
		return new Order(id, deliveryinfoId, standardfees, rushfees);
	}
}
