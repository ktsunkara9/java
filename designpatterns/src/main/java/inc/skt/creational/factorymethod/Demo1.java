package inc.skt.creational.factorymethod;

public class Demo1 {

	public static void main(String[] args) {
		Light tubeLight = LightFactory.getLight("tubeLight");
		tubeLight.switchOn();
		tubeLight.switchOff();
		
		Light bedLight = LightFactory.getLight("bedLight");
		bedLight.switchOn();
		
	}

}

interface Light {
	public abstract void switchOn();

	public abstract void switchOff();
}

class TubeLight implements Light {

	@Override
	public void switchOn() {
		System.out.println("Tubelight is Switched On");
	}

	@Override
	public void switchOff() {
		System.out.println("Tubelight is Switched Off");
	}

}

class BedLight implements Light {

	@Override
	public void switchOn() {
		System.out.println("BedLight is Switched On");
	}

	@Override
	public void switchOff() {
		System.out.println("BedLight is Switched Off");
	}

}

class LightFactory {
	
	public static Light getLight(String name) {
		if(name.equalsIgnoreCase("TubeLight")) {
			return new TubeLight();
		} else if(name.equalsIgnoreCase("BedLight")) {
			return new BedLight();
		} else {
			System.out.println("The Requested Light doesn't exist");
			return null;
		}
	}
}