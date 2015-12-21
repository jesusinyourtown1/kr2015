import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class NoteViewBottom extends JPanel {
	
	

	final JPanel backButtonPanel = new JPanel();
	final JPanel centerButtonPanel = new JPanel();
	final JPanel favTagsButtonPanel = new JPanel();  // set border
	
	
	final JLabel backButton = new JLabel();
	final JLabel centerButton = new JLabel();   // edit, save or create
	
	final JLabel tagButton = new JLabel();
	final JLabel favButton = new JLabel();
	
	
	
	
	
	public void create(int type){
		
		this.setBackground(Protocol.nbColor);
		backButtonPanel.setBackground(Protocol.nbColor);
		centerButtonPanel.setBackground(Protocol.nbColor);
		favTagsButtonPanel.setBackground(Protocol.nbColor);
		
		
		this.setLayout(new BorderLayout());
		
		//this.setPreferredSize(new Dimension(400,60));
		
		backButton.setIcon(Protocol.backButton);    
		favButton.setIcon(Protocol.favButton);
		tagButton.setIcon(Protocol.tagButton);
		
		if (type==1){
			centerButton.setIcon(Protocol.editButton);   
			
			centerButton.addMouseListener(new MouseAdapter(){
				   public void mouseEntered(MouseEvent e) {
					   centerButton.setIcon(Protocol.editButtonAction);
					   }
			});
			centerButton.addMouseListener(new MouseAdapter(){
				   public void mouseExited(MouseEvent e) {
					   centerButton.setIcon(Protocol.editButton);
					   }
			});
			
		}
		if (type==2){
			centerButton.setIcon(Protocol.saveButton);   	
			
			centerButton.addMouseListener(new MouseAdapter(){
				   public void mouseEntered(MouseEvent e) {
					   centerButton.setIcon(Protocol.saveButtonAction);
					   }
			});
			centerButton.addMouseListener(new MouseAdapter(){
				   public void mouseExited(MouseEvent e) {
					   centerButton.setIcon(Protocol.saveButton);
					   }
			});
			
		}
		if (type==3){
			centerButton.setIcon(Protocol.createButton);   	
			
			centerButton.addMouseListener(new MouseAdapter(){
				   public void mouseEntered(MouseEvent e) {
					   centerButton.setIcon(Protocol.createButtonAction);
					   }
			});
			centerButton.addMouseListener(new MouseAdapter(){
				   public void mouseExited(MouseEvent e) {
					   centerButton.setIcon(Protocol.createButton);
					   }
			});
		}
		
		favButton.setPreferredSize(new Dimension(50,34));
		centerButtonPanel.setPreferredSize(new Dimension(170,34));
		
		backButtonPanel.add(backButton);
		centerButtonPanel.add(centerButton);
		
		favTagsButtonPanel.add(favButton);
		favTagsButtonPanel.add(tagButton);
		
		
		
		this.add(backButtonPanel, BorderLayout.WEST);	
		this.add(centerButtonPanel, BorderLayout.CENTER);
		this.add(favTagsButtonPanel, BorderLayout.EAST);
		
		
		
		
		
		
		
		//Animation
		
		backButton.addMouseListener(new MouseAdapter(){
			   public void mouseEntered(MouseEvent e) {
				   backButton.setIcon(Protocol.backButtonAction);
				   }
		});
		backButton.addMouseListener(new MouseAdapter(){
			   public void mouseExited(MouseEvent e) {
				   backButton.setIcon(Protocol.backButton);
				   }
		});
		
		
		favButton.addMouseListener(new MouseAdapter(){
			   public void mouseEntered(MouseEvent e) {
				   favButton.setIcon(Protocol.favButtonAction);
				   }
		});
		favButton.addMouseListener(new MouseAdapter(){
			   public void mouseExited(MouseEvent e) {
				   favButton.setIcon(Protocol.favButton);
				   }
		});
		
		
		tagButton.addMouseListener(new MouseAdapter(){
			   public void mouseEntered(MouseEvent e) {
				   tagButton.setIcon(Protocol.tagButtonAction);
				   }
		});
		tagButton.addMouseListener(new MouseAdapter(){
			   public void mouseExited(MouseEvent e) {
				   tagButton.setIcon(Protocol.tagButton);
				   }
		});
		
		tagButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		favButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		centerButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		
		
	}

}
