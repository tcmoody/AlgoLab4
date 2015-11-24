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
