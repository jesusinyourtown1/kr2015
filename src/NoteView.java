import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class NoteView extends JPanel implements Observer {
	
	private NoteModel model;
	private final JTextArea textArea = new JTextArea();
	
	public NoteView(NoteModel model) {
		this.model = model;
		
		textArea.setMaximumSize(new Dimension(650, 500));
	    textArea.setPreferredSize(new Dimension(650, 500));
	    textArea.setMinimumSize(new Dimension(650,500));
	    
	    this.add(textArea);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public void update(Observable o, Object arg1) {
		
	}
	
	

}
