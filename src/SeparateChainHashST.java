import java.util.ArrayList;

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
		if(key == null){
			throw new NullPointerException();
		}
		Integer x = (Integer) key % tableSize;
		@SuppressWarnings("unchecked")
		K newKey = (K) x;
		table[(int) key % tableSize].put(newKey, value);
		numPairs++;
	}

	@Override
	public V get(K key) {
		if(key == null){
			throw new NullPointerException();
		}
		return table[((int) key % tableSize)].get(key);
	}

	@Override
	public void delete(K key) {
		if(key == null){
			throw new NullPointerException();
		}
		SequentialSearch<K,V> temp = table[(int) key % tableSize];
		SequentialSearch<K,V>.Node prev = null;
		for(SequentialSearch<K,V>.Node x = temp.first; x!= null; x=x.next){
			if(key.equals(x.key) && x.equals(temp.first)){
				temp.first = temp.first.next;
				break;
			}
			if(key.equals(x.key) && x.next!=null){
				prev.next = x.next;
				break;
			}
			if(key.equals(x.key) && x.next==null){
				prev.next = null;
				break;
			}
			prev = x;
		}
		table[(int) key % tableSize] = temp;
	}

	@Override
	public boolean contains(K key) {
		if(key == null){
			throw new NullPointerException();
		}
		return table[(int) key % tableSize].get(key) != null;
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
		Object tempObj = null;
		K tempK = null;
		for( int i = 0; i<tableSize; i++){
			tempObj = (Object) i;
			tempK = (K) tempObj;
			datIterableDoh.add(tempK);
		}
		return datIterableDoh;
	}

}
