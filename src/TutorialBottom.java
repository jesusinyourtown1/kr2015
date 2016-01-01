import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TutorialBottom extends JPanel {
	
	final JLabel primaryButton = new JLabel();
	final JLabel smButton = new JLabel();
	
	final JPanel primaryButtonPanel = new JPanel();
	final JPanel smButtonPanel = new JPanel();
	
	
	//private int type;
	

	
	public void create(int type){
		
		this.setLayout(new BorderLayout());
		
		
		if (type == 1){
			
			
			primaryButton.setIcon(Protocol.startTour);
			smButton.setIcon(Protocol.skipTour);
			
			primaryButtonPanel.add(primaryButton);
			smButtonPanel.add(smButton);
			
			primaryButton.addMouseListener(new MouseAdapter(){
				   public void mouseEntered(MouseEvent e) {
					   primaryButton.setIcon(Protocol.startTourAction);
					   }
			});
			primaryButton.addMouseListener(new MouseAdapter(){
				   public void mouseExited(MouseEvent e) {
					   primaryButton.setIcon(Protocol.startTour);
					   }
			});
			
			
			smButton.addMouseListener(new MouseAdapter(){
				   public void mouseEntered(MouseEvent e) {
					   smButton.setIcon(Protocol.skipTourAction);
					   }
			});
			smButton.addMouseListener(new MouseAdapter(){
				   public void mouseExited(MouseEvent e) {
					   smButton.setIcon(Protocol.skipTour);
					   }
			});
			
			this.add(primaryButtonPanel, BorderLayout.NORTH);	
			this.add(smButtonPanel, BorderLayout.SOUTH);	
			
			
			
			
		}
		if(type ==2){
			
			primaryButton.setIcon(Protocol.nextTour);
			primaryButtonPanel.add(primaryButton);
			
		//	buttons.add(primaryButton,BorderLayout.CENTER);
			
			primaryButton.addMouseListener(new MouseAdapter(){
				   public void mouseEntered(MouseEvent e) {
					   primaryButton.setIcon(Protocol.nextTourAction);
					   }
			});
			primaryButton.addMouseListener(new MouseAdapter(){
				   public void mouseExited(MouseEvent e) {
					   primaryButton.setIcon(Protocol.nextTour);
					   }
			});
			this.add(primaryButtonPanel, BorderLayout.NORTH);	
			
			
		}
		
		if(type ==3){
			primaryButton.setIcon(Protocol.bugsWarn);
			primaryButtonPanel.add(primaryButton);
			
			primaryButton.addMouseListener(new MouseAdapter(){
				   public void mouseEntered(MouseEvent e) {
					   primaryButton.setIcon(Protocol.bugsWarnAction);
					   }
			});
			primaryButton.addMouseListener(new MouseAdapter(){
				   public void mouseExited(MouseEvent e) {
					   primaryButton.setIcon(Protocol.bugsWarn);
					   }
			});
			this.add(primaryButtonPanel, BorderLayout.NORTH);	
			
		}
		
		if(type ==4){
			primaryButton.setIcon(Protocol.backButton);
			primaryButtonPanel.add(primaryButton);
			
			this.add(primaryButtonPanel, BorderLayout.NORTH);	
		}
		
		
	//	this.add(buttons,BorderLayout.CENTER);
		
		primaryButtonPanel.setBackground(Protocol.nbColor);
		smButtonPanel.setBackground(Protocol.nbColor);
		
		primaryButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		smButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	
		
		
	}	
	
	
}
