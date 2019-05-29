package tangbk.online.collections;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import junit.framework.TestCase;

public class ArraysUtilTest extends TestCase {

	public void testToList() {
		List<String> input = new LinkedList<String>();
		for (int index = 0; index < 10; index++) {
			input.add(String.valueOf(input));
		}

		String[] result = ListsUtil.toArray(input);

		String[] compare = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
		assertEquals(compare, result);
	}

	public void testGetGenericTypeOfList() {
		String[] compare = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
		List<String> list = Arrays.asList(compare);

		Class z = ListsUtil.getGenericTypeOfList(list);
		assertEquals(String.class, z);
	}

}
