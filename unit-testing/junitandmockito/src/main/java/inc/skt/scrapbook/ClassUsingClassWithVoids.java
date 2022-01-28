package inc.skt.scrapbook;

public class ClassUsingClassWithVoids {

	private ClassWithVoids voids;

	public ClassUsingClassWithVoids(ClassWithVoids voids) {
		this.voids = voids;
	}

	public int useDoNothing() {
		voids.doNothingMethod();
		return 1;
	}

}
