package tangbk.online.util.loader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import junit.framework.TestCase;

public class FileResourceLoaderTest extends TestCase {

	public void testLoad() {
		FileResourceLoader loader = new FileResourceLoader();
		InputStream in = loader.load("FileResourceLoaderTest.txt");
		assertNotNull(in);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line = null;
		try {
			line = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("here is a file for testing file resource loader", line);
	}

}
