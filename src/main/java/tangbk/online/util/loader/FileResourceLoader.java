package tangbk.online.util.loader;

import java.io.InputStream;

public class FileResourceLoader {

	public InputStream load(String resourceFileName) {
		ClassLoader cl = this.getClass().getClassLoader();
		return cl.getResourceAsStream(resourceFileName);
	}

}
