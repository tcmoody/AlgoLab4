import java.util.Iterator;

public class SequentialSearchST<K, V> {

	public Node first;
	public int sz;

	public class Node {
		K key;
		V value;
		Node next;

		public Node(K k, V v, Node n) {
			this.key = k;
			this.value = v;
			this.next = n;
		}
	}

	public SequentialSearchST() {
	}

	/**
	 * add key-value pair to the symbol table
	 * 
	 * @param key
	 * @param value
	 * @throws NullPointerException
	 *             if key is null
	 */
	public void put(K key, V value) {
		if (key == null)
			throw new NullPointerException("null keys are not defined");

		if (value == null) {
			delete(key);
			return;
		}
		
		Node prev = null;
		for (Node node = first; node != null; node = node.next) {
			if (key.equals(node.key)) {
				if (node == first) {
					node.value = value;
				} else {
					node.value = value;
					prev.next = node.next;
					node.next = first;
					first = node;
				}
				return;
			}
			prev = node;
		}
		
		if(first == null){
			first = new Node(key, value, null);
		}
//		for(Node n = first; n!=null; n = n.next){
//			System.out.println(n);
//		}
		sz++;
	}

	/**
	 * retrieve the value associated with the key
	 * 
	 * @param key
	 * @return returns the value associated with the key, otherwise it returns
	 *         null
	 * @throws NullPointerException
	 *             if the key is null
	 */
	public V get(K key) {
		for (Node n = first; n != null; n = n.next) {
			if (key.equals(n.key)) {
				return n.value;
			}
		}
		return null;
	}

	/**
	 * deletes the key-value pair associated with the key from the symbol table
	 * 
	 * @param key
	 * @throws NullPointerException
	 *             if the key is null
	 */

	/**
	 * recursive delete implementation. what is wrong here?
	 * 
	 * @param nd
	 * @param key
	 * @return
	 */
	//switched the delete function to a loop, couldn't see how to circumvent the stack overflow
	//while still recursing
	public void delete(K key) {
		Node nd = first;
		Node prev = null;
		for (int i = 0; i < sz; i++) {
			if (nd == null)
				break;
			if (key.equals(first.key)) {
				first = nd.next;
				sz--;
			} else if (key.equals(nd.key)) {
				sz--;
				prev.next = nd.next;
			}
			prev = nd;
			nd = nd.next;
		}
	}

	/**
	 * is a key in the symbol table or not?
	 * 
	 * @param key
	 * @return returns true if the a key-value pair is associated with the key,
	 *         otherwise false
	 * @throws NullPointerException
	 *             if the key is null
	 */
	public boolean contains(K key) {
		return get(key) != null;
	}

	/**
	 * 
	 * @return true if the table is empty, otherwise false
	 */
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * returns the number of key-value pairs in the table
	 * 
	 * @return
	 */
	public int size() {
		return sz;
	}

	/**
	 * 
	 * @return iterator of keys in the table
	 */
	public Iterable<K> keys() {
		class IterTable implements Iterable<K> {

			@Override
			public Iterator<K> iterator() {
				return new It();
			}

		}
		return new IterTable();
	}

	class It implements Iterator<K> {
		Node n;

		public It() {
			n = first;
		}

		@Override
		public boolean hasNext() {
			if (n.next != null) {
				return true;
			}
			return false;
		}

		@Override
		public K next() {
			K temp;
			temp = n.key;
			n = n.next;
			return temp;
		}

	}
}
