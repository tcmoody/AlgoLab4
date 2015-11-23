import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PostTest {

	Post p;

	@Before
	public void setUp() throws Exception {
		p = new Post();
	}

	@Test
	public void testHashCode() {
		int[] test = new int[100000];
		for (int i = 0; i < test.length; i++) {
			test[i] = 0;
		}
		for (int i = 0; i < 10000; i++) {
			p = new Post();
			test[p.hashCode()]++;
		}
		for (int i = 0; i < test.length; i++) {
			if (test[i] > 0) {
				System.out.println("i: " + i + "num: " + test[i]);
			}
		}
		assertNotNull(p.hashCode());

	}

	@Test
	public void testEqualsObject() throws CloneNotSupportedException {
		Post f = (Post) p.clone();
		Post g = new Post();
		assertTrue(f.equals(p));
		assertFalse(f.equals(g));
	}

}
