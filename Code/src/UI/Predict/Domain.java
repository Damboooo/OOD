package UI.Predict;

public class Domain{
	private int start;
	private int end;
	Domain(String start , String end){
		if(start.equals("")|| start == null)
			this.start = 0;
		else
		this.start = Integer.parseInt(start);
		
		if(end.equals("")|| end == null)
			this.end =-1;
		else
		this.end = Integer.parseInt(end);
	}
	
	public int getStart(){
		return start;
	}
	public int getEnd(){
		return end;
	}
}