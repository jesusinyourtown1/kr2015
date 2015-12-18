import java.util.ArrayList;

import javax.swing.JPanel;

public class Note  {
	
	private NoteModel nModel;   // model
	
	private EditView eView;    //edit
	private AddTagsView atView; 
	
	private NoteInList nilView;    // look 
	private SingleNoteView snView;
	
	
	
	
	
	
	
	Note(String title,String text, ArrayList<String> tagsArr, boolean isFav){
		
		
		
		nModel = new NoteModel(title,text,tagsArr,isFav);
		
		
		
	
		nModel = new NoteModel();;
		nView = new NoteView(nModel);
		nModel.addObserver(nView);
		nModel.setText(text);
		
		nView.setTextInTA(text);
		
		this.add(nView);
	}
	
	//combines NW and NV, connect them using Observers
	
}
