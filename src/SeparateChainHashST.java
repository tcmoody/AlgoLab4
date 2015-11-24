
public class SeparateChainHashST<K,V> implements SymbolTable<K,V> {
	
	private int tableSize;
	private int numPairs;
	private SequentialSearch<K,V>[] table;
	
	@SuppressWarnings("unchecked")
	public SeparateChainHashST(int tableSize){
		this.tableSize=tableSize;
		table = (SequentialSearch<K,V>[]) new SequentialSearch[tableSize];
		for(int i = 0; i < tableSize; i++){
			table[i] = new SequentialSearch();
		}
		numPairs = 0;
	}

	@Override
	public void put(K key, V value) {
		table[(int) key % tableSize].put(key, value);
		numPairs++;
	}

	@Override
	public V get(K key) {
		return table[((int) key % tableSize)].get(key);
	}

	@Override
	public void delete(K key) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean contains(K key) {
		return table[(int) key].get(key) != null;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int size() {
		return numPairs;
	}

	@Override
	public Iterable<K> keys() {
		// NOTE: you may use ArrayList here for simplicity.
		// TODO Auto-generated method stub
		return null;
	}

}
