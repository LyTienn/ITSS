package model;

public class DeliveryInfo {
	private int id;
	private String address;
	private String name;
	private String phone;
	private String instruction;
	
	public DeliveryInfo(int id, String address, String name, String phone, String instruction) {
		this.id = id;
		this.address = address;
		this.name = name;
		this.phone = phone;
		this.instruction = instruction;
	}

	public int getId() {return id;}
	public void setId(int id) {this.id = id;}

	public String getAddress() {return address;}
	public void setAddress(String address) {this.address = address;}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public String getPhone() {return phone;}
	public void setPhone(String phone) {this.phone = phone;}

	public String getInstruction() {return instruction;}
	public void setInstruction(String instruction) {this.instruction = instruction;}
	
	
}
