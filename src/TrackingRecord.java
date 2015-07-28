import java.io.*;
import java.util.*;

class TrackRecord {
	Range startEndTansctionCode;
	int transferCode;
	int statusCode;
	
	TrackRecord(Range startEndTansctionCode, int transferCode, int statusCode  ) {
		startEndTansctionCode = startEndTansctionCode;
		transferCode = transferCode;
		statusCode = statusCode;
	}
}

public class TrackingRecord {
	
	ArrayList<TrackRecord> trackRecords;
	
	TrackingRecord() {
		trackRecords = new ArrayList<TrackRecord>();
	}
	
	public enum Relation {
        SUBSET, SUPERSET, LESSOVERLAP, MOREOVERLAP, LESSDISJOINT, MOREDISJOINT, SAME;
    }
		

	public void display() {
		for (TrackRecord tRecord : trackRecords) {
			System.out.println(tRecord.startEndTansctionCode.lo +" "+tRecord.startEndTansctionCode.hi+" "+tRecord.transferCode +" "+ tRecord.statusCode );
		}
	}
	
	public void updateTrackRecord(TrackRecord addtrackRecord) {
		ArrayList<TrackRecord> updatedtrackRecords = new ArrayList<TrackRecord>();
		
		for ( TrackRecord tRecord : trackRecords) {
			switch(tRecord.startEndTansctionCode.classify(addtrackRecord.startEndTansctionCode))
			{
				case Relation.SUBSET: 		updateTrackRecordSubset(tRecord, addtrackRecord, updatedtrackRecords);
									    	break;
				case Relation.SUPERSET:		updateTrackRecordSuperset();
											break;
				case Relation.LESSOVERLAP:	updateTrackRecordlessOverLap();
											break;
				case Relation.MOREOVERLAP: 	updateTrackRecordMoreOverlap();
											break;
				case Relation.LESSDISJOINT: updateTrackRecordLessDisjoint();
											break;
				case Relation.MOREDISJOINT: updateTrackRecordMoreDisjoint();
											break;
				case Relation.SAME: 		updateTrackRecordSame();
											break;				
				default:				updatedtrackRecords.add(tRecord);
											break;							
			}
		}
		
		trackRecords = updatedtrackRecords;
	}
	
	
	public void updateTrackRecordSubset(TrackRecord tRecord, TrackRecord addtrackRecord, ArrayList<TrackRecord> updatedtrackRecords )
	{
		updatedtrackRecords.add(new TrackRecord(new Range(tRecord.startEndTansctionCode.lo,addtrackRecord.startEndTansctionCode.hi -1), tRecord.transferCode , tRecord.statusCode));
		updatedtrackRecords.add(new TrackRecord(new Range(addtrackRecord.startEndTansctionCode.lo, tRecord.startEndTansctionCode.hi), addtrackRecord.transferCode , addtrackRecord.statusCode));
		updatedtrackRecords.add(new TrackRecord(new Range(addtrackRecord.startEndTansctionCode.hi+1, tRecord.startEndTansctionCode.hi), tRecord.transferCode , tRecord.statusCode));
		
	}

	
	public void updateTrackRecordSuperset(TrackRecord tRecord, TrackRecord addtrackRecord, ArrayList<TrackRecord> updatedtrackRecords )
	{
		updatedtrackRecords.add(new TrackRecord(new Range(addtrackRecord.startEndTansctionCode.lo, addtrackRecord.startEndTansctionCode.hi), addtrackRecord.transferCode , addtrackRecord.statusCode));
	}
	
	public void updateTrackRecordlessOverLap(TrackRecord tRecord, TrackRecord addtrackRecord, ArrayList<TrackRecord> updatedtrackRecords )
	{
		updatedtrackRecords.add(new TrackRecord(new Range(tRecord.startEndTansctionCode.lo, addtrackRecord.startEndTansctionCode.lo -1), tRecord.transferCode , tRecord.statusCode));
		updatedtrackRecords.add(new TrackRecord(new Range(addtrackRecord.startEndTansctionCode.lo, addtrackRecord.startEndTansctionCode.hi), addtrackRecord.transferCode , addtrackRecord.statusCode));
	}
	
	public void updateTrackRecordMoreOverlap(TrackRecord tRecord, TrackRecord addtrackRecord, ArrayList<TrackRecord> updatedtrackRecords )
	{
		updatedtrackRecords.add(new TrackRecord(new Range(addtrackRecord.startEndTansctionCode.lo, addtrackRecord.startEndTansctionCode.hi), addtrackRecord.transferCode , addtrackRecord.statusCode));
		updatedtrackRecords.add(new TrackRecord(new Range(addtrackRecord.startEndTansctionCode.hi+1, tRecord.startEndTansctionCode.hi), tRecord.transferCode , tRecord.statusCode));
	}

	public void updateTrackRecordLessDisjoint(TrackRecord tRecord, TrackRecord addtrackRecord, ArrayList<TrackRecord> updatedtrackRecords )
	{
		updatedtrackRecords.add(new TrackRecord(new Range(tRecord.startEndTansctionCode.hi+1, tRecord.startEndTansctionCode.hi), tRecord.transferCode , tRecord.statusCode));
		//updatedtrackRecords.add(new TrackRecord(new Range(addtrackRecord.startEndTansctionCode.lo, addtrackRecord.startEndTansctionCode.hi), addtrackRecord.transferCode , addtrackRecord.statusCode));
		
	}
	public void updateTrackRecordMoreDisjoint(TrackRecord tRecord, TrackRecord addtrackRecord, ArrayList<TrackRecord> updatedtrackRecords )
	{
		updatedtrackRecords.add(new TrackRecord(new Range(addtrackRecord.startEndTansctionCode.lo, addtrackRecord.startEndTansctionCode.hi), addtrackRecord.transferCode , addtrackRecord.statusCode));
	}
	
	
	public void updateTrackRecordSame(TrackRecord tRecord, TrackRecord addtrackRecord, ArrayList<TrackRecord> updatedtrackRecords )
	{
		updatedtrackRecords.add(new TrackRecord(new Range(addtrackRecord.startEndTansctionCode.lo, addtrackRecord.startEndTansctionCode.hi), addtrackRecord.transferCode , addtrackRecord.statusCode));
		
	}

	private void mergeRecords() {
		
	}
	
	public TrackRecord  convertStringToTrackObject(String line)
	{
		String[] record = line.split(" ");
		int lo = Integer.parseInt(record[0]);
		int hi = Integer.parseInt(record[1]);	

		return new TrackRecord(new Range(lo,hi),Integer.parseInt(record[2]),Integer.parseInt(record[3]));
	}
	
	public static void main(String[] args) throws IOException
	{
		File file = new File("c:/input.txt");
		TrackingRecord trackingInfo = new TrackingRecord();
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			for(String line; (line = br.readLine()) != null; ) {
				trackingInfo.updateTrackRecord(convertStringToTrackObject(line));
		    }
			trackingInfo.display();
		}
		finally {
			
		}
		
	}
	
	
}
	

