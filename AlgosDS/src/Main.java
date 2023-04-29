import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {

	private String val;

	public Main(String id) {
		this.val = id;
	}

	@Override
	public String toString() {
		return "Main [val=" + val + "] ";
	}

	public static void main(String[] args) {

		List<String> strList = new ArrayList();
		System.out.println(strList.indexOf(strList));

	}

}
