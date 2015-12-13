import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class NoteList extends JPanel {
	
	private ArrayList<NoteInList> nilArr = new ArrayList<NoteInList>();
	
	NoteList(){
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		for (int i=0; i<nilArr.size();i++){
			this.add(nilArr.get(i));
		}
		this.setBackground(Protocol.nbColor);
	}
	
	public void addNoteInList(NoteInList n){
		nilArr.add(n);
		this.add(n);
	}
	
	
}
