package MoneyApp.money;

public class Money {

	String Productltem;
	String Product;
	int Price;
	int Year;
	int Month;
	int Day;

	public Money(String productltem, String product, int price, int year, int month, int day) {
		super();
		Productltem = productltem;
		Product = product;
		Price = price;
		Year = year;
		Month = month;
		Day = day;
	}

	public void setProductltem(String productltem) {
		Productltem = productltem;
	}

	public void setProduct(String product) {
		Product = product;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public void setYear(int year) {
		Year = year;
	}

	public void setMonth(int month) {
		Month = month;
	}

	public void setDay(int day) {
		Day = day;
	}

	public String getProductltem() {
		return Productltem;
	}

	public String getProduct() {
		return Product;
	}

	public int getPrice() {
		return Price;
	}

	public int getYear() {
		return Year;
	}

	public int getMonth() {
		return Month;
	}

	public int getDay() {
		return Day;
	}

	public void moneyIndication() {
		System.out.println("========================" + "\n"
				+ "項目" + "：" + getProductltem() + "\n"
				+ "商品名" + "：" + getProduct() + "\n"
				+ "値段" + "：" + getPrice() + "円" + "\n"
				+ "購入日" + "：" + getYear() + "/" + getMonth() + "/" + getDay() + "\n"
				+ "========================");

	}
}
