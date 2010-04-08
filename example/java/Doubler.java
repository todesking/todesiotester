import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Doubler {
	public static void main(String[] args) throws Exception {
		new Doubler().execute(
			new BufferedReader(new InputStreamReader(System.in)),
			System.out);
	}

	public void execute(BufferedReader in, PrintStream out) throws Exception {
		String line;
		while ((line = in.readLine()) != null) {
			final int x = Integer.parseInt(line);
			out.println(x * x);
		}
	}
}
