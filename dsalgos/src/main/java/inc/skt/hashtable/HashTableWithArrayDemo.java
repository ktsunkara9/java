package inc.skt.hashtable;

public class HashTableWithArrayDemo {

	public static void main(String[] args) {
		Employee sai = new Employee(1, "Sai", "Kowthavarapu");
		Employee teja = new Employee(1, "Teja", "Krishna");
		Employee sitaram = new Employee(1, "Sita Ram", "Kelam");
		Employee diwakar = new Employee(1, "Diwakar", "Tandra");
		Employee suresh = new Employee(1, "Suresh", "Yadali");
		Employee nagarjuna = new Employee(1, "Nagarjuna Rao", "Sunkara");

		SimpleHashTable hashTable = new SimpleHashTable();
		hashTable.put("Kowthavarapu", sai);
		hashTable.put("Krishna", teja);
		hashTable.put("Kelam", sitaram);
		hashTable.put("Tandra", diwakar);
		hashTable.put("Yadali", suresh);
		hashTable.put("Sunkara", nagarjuna);

		hashTable.printHashTable();
		System.out.println("============================================================");
		System.out.println("Yadali : " + hashTable.get("Yadali"));

		System.out.println("============================================================");
		System.out.println(hashTable.remove("Yadali"));
		System.out.println(hashTable.remove("Kowthavarapu"));
		System.out.println("============================================================");

		hashTable.printHashTable();

		System.out.println("Sunkara : " + hashTable.get("Sunkara"));

	}

}

class SimpleHashTable {

	StoredEmployee[] hashTable;

	public SimpleHashTable() {
		hashTable = new StoredEmployee[10];
	}

	void put(String key, Employee employee) {
		int hashedKey = hashKey(key);

		if (occupied(hashedKey)) {
			int stopIndex = hashedKey;

			if (hashedKey == hashTable.length - 1) {
				hashedKey = 0;
			} else {
				hashedKey++;
			}

			while (hashedKey != stopIndex && occupied(hashedKey)) {
				hashedKey = (hashedKey + 1) % hashTable.length;
			}
		}

		if (occupied(hashedKey))
			System.out.println("Sorry There's already an Employee at Position : " + employee);
		else
			hashTable[hashedKey] = new StoredEmployee(key, employee);
	}

	private boolean occupied(int index) {
		return hashTable[index] != null;
	}

	public Employee get(String key) {
		int hashedKey = findKey(key);

		if (hashedKey == -1) {
			return null;
		}
		return hashTable[hashedKey].employee;
	}

	private int findKey(String key) {
		int hashedKey = hashKey(key);

		if (hashTable[hashedKey] != null && hashTable[hashedKey].key.equals(key)) {
			return hashedKey;
		}

		int stopIndex = hashedKey;

		if (hashedKey == hashTable.length - 1) {
			hashedKey = 0;
		} else {
			hashedKey++;
		}

		while (hashedKey != stopIndex && hashTable[hashedKey] != null && !hashTable[hashedKey].key.equals(key)) {
			hashedKey = (hashedKey + 1) % hashTable.length;
		}

		if (hashTable[hashedKey] != null && hashTable[hashedKey].key.equals(key)) {
			return hashedKey;
		}

		else {
			return -1;
		}

	}

	int hashKey(String key) {
		return key.length() % hashTable.length;
	}

	void printHashTable() {
		for (int i = 0; i < hashTable.length; i++) {

			if (hashTable[i] == null) {
				System.out.println("empty");
			} else {
				System.out.println("Position : " + i + " " + hashTable[i].employee);
			}

		}
	}

	public Employee remove(String key) {

		int hashedKey = findKey(key);

		if (hashedKey == -1) {
			return null;
		}

		Employee employee = hashTable[hashedKey].employee;
		hashTable[hashedKey] = null;

		StoredEmployee[] oldHashTable = hashTable;
		hashTable = new StoredEmployee[oldHashTable.length];
		for (int i = 0; i < oldHashTable.length; i++) {
			if (oldHashTable[i] != null) {
				put(oldHashTable[i].key, oldHashTable[i].employee);
			}
		}

		return employee;
	}
}

class StoredEmployee {
	public String key;
	public Employee employee;

	public StoredEmployee(String key, Employee employee) {
		this.key = key;
		this.employee = employee;
	}

}