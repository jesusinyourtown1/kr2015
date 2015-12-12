import javax.swing.JPanel;

public class Note extends JPanel {
	private NoteModel nModel;
	private NoteView nView;
	
	Note(String text){
		nModel = new NoteModel();;
		nView = new NoteView(nModel);
		nModel.addObserver(nView);
		nModel.setText(text);
		
		nView.setTextInTA(text);
		
		this.add(nView);
	}
	
	//combines NW and NV, connect them using Observers
	
}
