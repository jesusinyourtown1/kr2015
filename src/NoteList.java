import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class NoteList extends JPanel {
	
	private static ArrayList<NoteInList> nilArr = new ArrayList<NoteInList>();
	private static ArrayList<SingleNoteView> vArr = new ArrayList<SingleNoteView>();
	private static ArrayList<EditNoteView> eArr = new ArrayList<EditNoteView>();
	
	
	
	NoteList(){
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		for (int i=0; i<nilArr.size();i++){
			this.add(nilArr.get(i));
		}
		this.setBackground(Protocol.nbColor);
	}
	
	
	
	
	
	public void add(String title,String text, String tags, boolean isFav){
		NoteInList tmp_nil = new NoteInList(title,text,tags);
		nilArr.add(tmp_nil);
		this.add(tmp_nil);
	}
	
	
	
	
	
	public void addNoteInList(NoteInList n){
		nilArr.add(n);
		this.add(n);
	}
	
	

	public static void check(){
		for (int i=0; i<nilArr.size();i++){
			if (nilArr.get(i).isVisible()==false){
				nilArr.remove(i);
			}
		}
	}
	
}
