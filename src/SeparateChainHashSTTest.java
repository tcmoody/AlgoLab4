  import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SeparateChainHashSTTest<K, V> {
	private SeparateChainHashST<Integer, Post> hashMap;
	private SeparateChainHashST<Integer, Post> hashMap2;
	private Post[] items;
	@Before
	public void setUp() throws Exception {
		items = new Post[100];
		hashMap = new SeparateChainHashST<Integer, Post>(100);
		hashMap2 = new SeparateChainHashST<Integer, Post>(100);
		for(int i=0; i<100; i++){
			items[i] = new Post();
		}
		for(int i=0; i<100; i++){
			hashMap.put(items[i].hashCode(), items[i]);
		}
	}

	@Test
	public void testPut() {
		System.out.println("put1:" + items[12].hashCode());
		hashMap.put(items[12].hashCode(), items[12]);
		System.out.println("put2:" + items[12].hashCode());
		assertNotNull(hashMap.get(items[12].hashCode()));
	}

//	@Test
//	public void testDelete() {
//		hashMap.delete(items[21].hashCode());
//		assertFalse(hashMap.contains(items[21].hashCode()));
//	}

	@Test
	public void testContains() {
		System.out.println("contains1:" + items[15].hashCode());
		hashMap.put(items[15].hashCode(), items[15]);
		System.out.println("contains2:" + items[15].hashCode());
		assertTrue(hashMap.contains(items[15].hashCode()));
	}

	@Test
	public void testIsEmpty() {
		assertTrue(hashMap2.isEmpty());
	}

	@Test
	public void testSize() {
		assertEquals(hashMap.size(), 100);
	}

	@Test
	public void testKeys() {
		Iterable<Integer> x = hashMap.keys();
		assertNotNull(x);
	}

}
