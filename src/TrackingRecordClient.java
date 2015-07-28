import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class TrackingRecordClient {
	private static ArrayList<String> recordInput = new ArrayList<String> ();
	public static void addRecordInput(BufferedReader br) throws IOException
	{
		for(String line; (line = br.readLine()) != null; ) {
			recordInput.add(line);
	    }
	}
	public static void populateRecords(ArrayList<String> recordInput, TrackingRecord recordObj)
	{

		for(String line: recordInput)
		{
			char firstChar = line.charAt(0);
			String[] record ={""};
			if(firstChar=='0')
			{
				recordObj.putRecord(0, 0, "0", 0);
			}
			if(Character.isDigit(firstChar) && firstChar!='0')
			{
				
				record = line.split(" ");
				int lo, hi, trackingId;
				String status;
				lo = Integer.parseInt(record[0]);
				hi = Integer.parseInt(record[1]);
				status = record[2];
				trackingId = Integer.parseInt(record[3]);
				recordObj.putRecord(lo, hi, status, trackingId);
				
			}

		}
	}
	public static void main(String[] args) throws IOException
	{
		File file = new File("c:/input.txt");
		TrackingRecord recordObj = new TrackingRecord();
		BufferedReader br = new BufferedReader(new FileReader(file));
		addRecordInput(br);	
		populateRecords(recordInput, recordObj);
		recordObj.optimizeRecords();
		ArrayList<Integer> lo, hi, trackingNumber;
		ArrayList<String> status;
		lo=recordObj.getLo();
		hi = recordObj.getHi();
		status = recordObj.getStatus();
		trackingNumber = recordObj.getTrackingNumber();
		
		for(int i=0; i<lo.size(); i++)
		{
			System.out.println(lo.get(i)+ " " + hi.get(i) + " " + status.get(i) + " " + trackingNumber.get(i));
		}
		
	}
}
