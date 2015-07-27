import java.io.*;
import java.util.*;

public class TrackingRecord {
	
	public static void main(String[] args) throws IOException
	{
		File file = new File("c:/input.txt");
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			for(String line; (line = br.readLine()) != null; ) {
				System.out.println(line);
		    }
		}
		finally {
			
		}
		
	}
}
	

