package inc.skt.solidprinciples;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SRPDemo1 {

	public static void main(String[] args) throws IOException {
		Journal journal = new Journal();
		journal.addEntry("Revised a Design Pattern");
		journal.addEntry("Revised a SOLID Principle");

		Persistence persistence = new Persistence();
		String filename = "srp-demo.txt";
		persistence.saveToFile(journal, filename);

		if (System.getProperty("os.name").toLowerCase().contains("windows")) {
			Runtime.getRuntime().exec("notepad.exe"+filename);
		} else {
			Desktop.getDesktop().edit(new File(filename));
		}
	}

}

class Journal {
	private List<String> entries = new ArrayList<>();
	private static int count = 0;

	public void addEntry(String action) {
		entries.add(++count + " - " + action);
	}

	public void removeEntryAtIndex(int index) {
		entries.remove(index);
	}

	@Override
	public String toString() {
		return String.join(System.lineSeparator(), entries);
	}

	/********
	 * Now this breaks the Single Responsibility Principle save/persist is concerned
	 * with Persistence Layer So we should have a Separate class for doing this to
	 * have separation of concerns
	 ********/
	/*
	 * public void save(String fileName) throws FileNotFoundException {
	 * try(PrintStream out = new PrintStream(fileName)) { out.print(toString());; }
	 * }
	 */
}

class Persistence {
	public void saveToFile(Journal jounal, String filename) throws FileNotFoundException {

		try (PrintStream out = new PrintStream(filename)) {
			out.append(LocalDate.now().toString());
			out.append("\n");
			out.append("==========");
			out.append("\n");
			out.append(jounal.toString());
		}

	}
}
