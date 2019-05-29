package tangbk.online.collections;

import java.util.Arrays;
import java.util.List;

public class ArraysUtil {
	public static <T> List<T> toList(T[] input) {
		return Arrays.asList(input);
	}
}
