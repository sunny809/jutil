package tangbk.online.collections;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class ListsUtil {

	public static <T> T[] toArray(List<T> input) {

		Class<?> c = getGenericTypeOfList(input);
		int size = input.size();

		T[] result = (T[]) Array.newInstance(c.getClass().getComponentType(), size);
		for (int index = 0; index < size; index++) {
			result[index] = input.get(index);
		}
		return null;
	}

	public static Class<?> getGenericTypeOfList(List<?> input) {

		Class<?> genericClass = null;

		Field[] fields = input.getClass().getDeclaredFields();

		for (Field field : fields) {
			System.out.println(field.toString());
			Type type = field.getGenericType();
			System.out.println(type.toString());
		}

		Method[] types = input.getClass().getMethods();

		for (Method method : types) {
			System.out.println(method.toString());
			Type type = method.getGenericReturnType();
			System.out.println(type.toString());
		}

		System.out.println(Arrays.toString(fields));

		for (Field f : fields) {
			f.setAccessible(true);
			System.out.println(f.toGenericString());
			if (f.getType() == java.util.List.class) {
				Type genericType = f.getGenericType();
				if (genericType == null) {
					continue;
				}

				if (genericType instanceof ParameterizedType) {
					ParameterizedType type = (ParameterizedType) genericType;
					genericClass = (Class<?>) type.getActualTypeArguments()[0];
				}

			}
		}

		return genericClass;

	}

}
