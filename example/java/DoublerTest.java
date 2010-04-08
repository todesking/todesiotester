import org.junit.Test;

import com.todesking.util.test.IOTester;

public class DoublerTest {
	@Test
	public void hoge() throws Exception {
		// setup
		final IOTester io = new IOTester();
		io.lines("1", "2", "3");

		new Doubler().execute(io.in(), io.out());

		// verify
		io.assertOutLines("1", "4", "9");
	}
}
