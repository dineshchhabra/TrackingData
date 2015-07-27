import java.io.*;
import java.util.*;

class TrackRecord {
	Range startEndTansctionCode;
	int transferCode;
	int statusCode;
}

public class TrackingRecord {
	
	ArrayList<TrackRecord> trackRecords;
	
	TrackingRecord() {
		trackRecords = new ArrayList<TrackRecord>();
	}
	
	public displayTrackRecords() {
		
	}
	
	public updateTrackRecord() {
		
	}
	
	private mergeRecords() {
		
	}
	
	
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
	

