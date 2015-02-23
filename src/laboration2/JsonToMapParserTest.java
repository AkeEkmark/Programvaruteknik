package laboration2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class JsonToMapParserTest {
	@Before
	public void setUp() throws Exception {
		
	}
	@Test
	public void testGetEmptyResult() {
		Map<String, Object> resultingMap = new JsonToMapParser("{}").getResult();
		assertEquals(0, resultingMap.size());
	}
	@Test
	public void testGetSingleResult() {
		Map<String, Object> resultingMap = new JsonToMapParser("{\"key\" : \"value\"}").getResult();
		assertEquals(1, resultingMap.size());
	}
	@Test
	public void testGetTwoResults() {
		Map<String, Object> resultingMap = new JsonToMapParser("{\"key\" : \"value\", \"key2\" : \"value2\"}").getResult();
		assertEquals(2, resultingMap.size());
		assertEquals("value", resultingMap.get("key"));
	}
	@Test
	public void testGetLongResults() {
		Map<String, Object> resultingMap = new JsonToMapParser("{\"key\" : 2, \"key2\" : 3}").getResult();
		long nbr = 2;
		long nbr2 = 3;
		assertEquals(2, resultingMap.size());
		assertEquals(nbr, resultingMap.get("key"));
		assertEquals(nbr2, resultingMap.get("key2"));
	}
	@Test
	public void testGetDoubleResults() {
		Map<String, Object> resultingMap = new JsonToMapParser("{\"key\" : 2.0, \"key2\" : 3.0}").getResult();
		assertEquals(2, resultingMap.size());
		assertEquals(2.0, resultingMap.get("key"));
		assertEquals(3.0, resultingMap.get("key2"));
	}
	@Test
	public void testGetArrayResults() {
		Map<String, Object> resultingMap = new JsonToMapParser("{\"key\" :  [2.0, 3.0], \"key2\" : 3.0}").getResult();
		assertEquals(2, resultingMap.size());
		assertEquals(ArrayList.class, resultingMap.get("key").getClass());
		assertEquals(3.0, resultingMap.get("key2"));
	}
	
	
	
}
