import java.io.IOException;
import java.util.*;

public class testSample {
	public static void main(String[] args) throws IOException {
		dataDriven d = new dataDriven();
	ArrayList<String> datArrayList=	d.getData("Add Profile");
	
	System.out.println(datArrayList.get(0));
	System.out.println(datArrayList.get(1));
	System.out.println(datArrayList.get(2));
	System.out.println(datArrayList.get(3));
	
	}

}
