package inc.skt.structural.adapter;

public class AdapterDemo1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.getElement();
		driver.selectElement();
		driver = new WebDriverAdapter(new IEDriver());
		driver.getElement();
		driver.selectElement();
	}

}

interface WebDriver {
	public abstract void getElement();

	public abstract void selectElement();
}

class ChromeDriver implements WebDriver {

	@Override
	public void getElement() {
		System.out.println("getElement() of ChromeDriver");
	}

	@Override
	public void selectElement() {
		System.out.println("selectElement() of ChromeDriver");
	}

}

class IEDriver {

	public void findElement() {
		System.out.println("findElement() of IEDriver");
	}

	public void clickElement() {
		System.out.println("clickElement() of IEDriver");
	}
}

class WebDriverAdapter implements WebDriver {

	IEDriver ieDriver ;
	
	public WebDriverAdapter(IEDriver ieDriver) {
		super();
		this.ieDriver = ieDriver;
	}

	@Override
	public void getElement() {
		ieDriver.findElement();
	}

	@Override
	public void selectElement() {
		ieDriver.clickElement();
	}

}