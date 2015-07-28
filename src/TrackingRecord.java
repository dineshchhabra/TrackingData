import java.io.*;
import java.util.*;

public class TrackingRecord {

	private ArrayList<Integer> lo = new ArrayList<Integer>();
	private ArrayList<Integer> hi = new ArrayList<Integer>();
	private ArrayList<String> status = new ArrayList<String>();
	private ArrayList<Integer> trackingNumber = new ArrayList<Integer>();
	
	public void putRecord(int lo, int hi, String status, int trackingNumber)
	{
		this.lo.add(lo);
		this.hi.add(hi);
		this.status.add(status);
		this.trackingNumber.add(trackingNumber);
	}
	
	public ArrayList<Integer> getLo()
	{
		return lo;
	}
	
	public ArrayList<Integer> getHi()
	{
		return hi;
	}
	
	public ArrayList<String> getStatus()
	{
		return status;
	}
	public ArrayList<Integer> getTrackingNumber()
	{
		return trackingNumber;
	}
	
	public void optimizeRecords()
	{
		for(int i=0; i<lo.size(); i++)
		{
			if(i>0)
			{
				for(int j=0; j<i; j++)
				{
					if(lo.get(j) > lo.get(i) && hi.get(i) > hi.get(j))
					{
						lo.remove(j);
						hi.remove(j);
						status.remove(j);
						trackingNumber.remove(j);
					}
						
				}
			}
		}
	}
}
	

