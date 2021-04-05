package tp_JRame;

public class Ma_liste {
	private String destination;
	private String date;
	private float prix;
	private static int id;
	
	
	protected Ma_liste( String destination, String date, float prix) {
		super();
		this.destination = destination;
		this.date = date;
		this.prix = prix;
		id++;
	
	}
	
	
	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public int getId() {
		return id;
	}
	
	

}
