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
	
	public updateTrackRecord(TrackRecord trackRecord) {
		foreach( TrackRecord tRecord : trackRecords) {
			Switch(track.startEndTansctionCode.classify(trackRcord.startEndTansctionCode))
			{
				case Relation.SUBSET: 		updateTrackRecordSubset();
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
	

