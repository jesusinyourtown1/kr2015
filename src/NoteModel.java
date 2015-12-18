import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Observable;

public class NoteModel  extends Observable{
	
	//VARIABLES
	
	private String title;
	private String text;
	private ArrayList<String>  tagsArr = new ArrayList<String>();
	private boolean isFav;
	
	//private ArrayList<String>  membersArr = new ArrayList<String>();
	//private Calendar cal;
	//private SimpleDateFormat dateFormat;
	
	//CONSTRUCTORS
	
	NoteModel(String title,String text, ArrayList<String>  tagsArr, boolean isFav){
		this.title=title;
		this.text=text;
		this.tagsArr=tagsArr;
		this.isFav=isFav;
		
	}
	
	
	
	//METHODS
	
	//for text
	
	public String getText(){
		return text;
	}
	
	public void setText(String text){
		this.text=text;
	}
		
	//for tags
	
	public void addTag(String tagName){
		tagsArr.add(tagName);
	}
	
	public void delTag(int tagNum){
		tagsArr.remove(tagNum);
	}
	
	public String tagsToText(){
		String tags="";
		for(int i=0; i<tagsArr.size();i++){
			tags=tags+tagsArr.get(i)+Protocol.TAG_END;
		}
		return tags;
	}
	

	//for note
	
	public String noteToText(){
		// tag + tag + tag + tag + tag... + username + note
		String tags = tagsToText();
		String intoText=tags+Protocol.TAGS_END+name+Protocol.USER_END+text+Protocol.NOTE_END;
		return intoText;
	}

}
