
public class Hamburger {

	private String name;
	private String meat;
	private double price;
	private String breadRollType;
	private String addition1Name;
	private double addition1Price;
	private String addition2Name;
	private double addition2Price;
	private String addition3Name;
	private double addition3Price;
	private String addition4Name;
	private double addition4Price;

	public Hamburger(String name, String meat, double price, String breadRollType) {
		super();
		this.name = name;
		this.meat = meat;
		this.price = price;
		this.breadRollType = breadRollType;
	}
	public void addHamburgerAddition1(String name, double price) {
		addition1Name = name;
		addition1Price = price;
	}

	public void addHamburgerAddition2(String name, double price) {
		addition2Name = name;
		addition2Price = price;

	}

	public void addHamburgerAddition3(String name, double price) {
		addition3Name = name;
		addition3Price = price;
	}

	public void addHamburgerAddition4(String name, double price) {
		addition4Name = name;
		addition4Price = price;
	}


	public double itemizeHamburger() {

		System.out.println(name + "hamburger on a " + breadRollType + " roll with " + meat + ", price is " + price);

		if (addition1Name != null) {
			price += addition1Price;
			System.out.println("Name != null " + addition1Name + " for an extra " + addition1Price);
		}
		if (addition2Name != null) {
			price += addition2Price;
			System.out.println("Name != null " + addition2Name + " for an extra " + addition2Price);
		}
		if (addition3Name != null) {
			price += addition3Price;
			System.out.println("Name != null " + addition3Name + " for an extra " + addition3Price);
		}
		if (addition4Name != null) {
			price += addition4Price;
			System.out.println("Name != null " + addition4Name + " for an extra " + addition4Price);
		}

		return price;
	}
}
