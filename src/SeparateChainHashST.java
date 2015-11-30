import java.util.ArrayList;

public class SeparateChainHashST<K, V> implements SymbolTable<K, V> {

	private int tableSize;
	private int numPairs;
	private SequentialSearchST<K, V>[] table;

	@SuppressWarnings("unchecked")
	public SeparateChainHashST(int tableSize) {
		this.tableSize = tableSize;
		table = (SequentialSearchST<K, V>[]) new SequentialSearchST[tableSize];
		for (int i = 0; i < tableSize; i++) {
			table[i] = new SequentialSearchST<K, V>();
		}
		numPairs = 0;
	}

	@Override
	public void put(K key, V value) {
		if (key == null) {
			throw new NullPointerException();
		}
		table[(int) key % tableSize].put(key, value);
		numPairs++;
	}

	@Override
	public V get(K key) {
		if (key == null) {
			throw new NullPointerException();
		}
		return table[((int) key % tableSize)].get(key);
	}

	@Override
	public void delete(K key) {
		if (key == null) {
			throw new NullPointerException();
		}
		table[(int) key % tableSize].delete(key);
	}

	@Override
	public boolean contains(K key) {
		if (key == null) {
			throw new NullPointerException();
		}
		return table[(int) key % tableSize].contains(key);
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int size() {
		return numPairs;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Iterable<K> keys() {
		ArrayList<K> datIterableDoh = new ArrayList<K>();
		for (int i = 0; i < tableSize; i++) {
			for (SequentialSearchST<K, V>.Node x = table[i].first; x != null; x = x.next) {
				if (x != null) {
					datIterableDoh.add(x.key);
				}
			}
		}
		return datIterableDoh;
	}

}
