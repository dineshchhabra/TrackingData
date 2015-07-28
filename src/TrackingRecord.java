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
		

	public displayTrackRecords() {
		
	}
	
	public updateTrackRecord(TrackRecord addtrackRecord) {
		ArrayList<TrackRecord> updatedtrackRecords = new ArrayList<TrackRecord>();
		
		foreach( TrackRecord tRecord : trackRecords) {
			Switch(track.startEndTansctionCode.classify(addtrackRcord.startEndTansctionCode))
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
											
			}
		}
	}
	
	
	public updateTrackRecordSubset(TrackRecord tRecord, TrackRecord addtrackRecord, ArrayList<TrackRecord> updatedtrackRecords )
	{
		if ((addtrackRecord.transferCode != tRecord.transferCode) || ( addtrackRecord.statusCode != tRecord.statusCode)) {
			updatedtrackRecords.add(new TrackRecord(new Range(tRecord.startEndTansctionCode.lo,addtrackRecord.startEndTansctionCode.hi -1), tRecord.transferCode , tRecord.statusCode));
			updatedtrackRecords.add(new TrackRecord(new Range(addtrackRecord.startEndTansctionCode.lo, tRecord.startEndTansctionCode.hi), addtrackRecord.transferCode , addtrackRecord.statusCode));
			updatedtrackRecords.add(new TrackRecord(new Range(addtrackRecord.startEndTansctionCode.hi+1, tRecord.startEndTansctionCode.hi), tRecord.transferCode , tRecord.statusCode));
		}
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
	

