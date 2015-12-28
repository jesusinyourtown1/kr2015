import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class EditNoteView extends JPanel {
	
	private boolean fav;
	
	public NoteViewBottom nvbTest;
	
	final JTextArea titleArea;
	final JTextArea textArea;
	final JTextArea tagsArea;
	
	//private JLabel titleLabel; 
	//private JLabel textLabel;
	//private JLabel tagsLabel; 
	
	private JPanel main = new JPanel();
	private JPanel top = new JPanel();
	private JPanel middle = new JPanel();
	private JPanel bottom = new JPanel();
	
	private JPanel bottomNorth = new JPanel();
	private JPanel bottomSouth = new JPanel();

	//private JPanel bottom1 = new JPanel();
	private JPanel top1 = new JPanel();
	
	private JLabel image = new JLabel();
	private JLabel separ = new JLabel();
	private JLabel del = new JLabel();

	EditNoteView(String title,String text,String tags,boolean isFav,int type){
		
		
		// FAV
			
		 titleArea = new JTextArea(title);
		 textArea = new JTextArea(title);
		 tagsArea = new JTextArea(title);
		
		
	//	titleLabel = new JLabel(title, SwingConstants.RIGHT);
	//	textLabel = new JLabel(text, SwingConstants.RIGHT);
	//	tagsLabel = new JLabel(tags, SwingConstants.RIGHT);
		
		titleArea.setFont(Protocol.SFFontT);
		tagsArea.setFont(Protocol.SFFont);
		textArea.setFont(Protocol.SFFont);
		
		titleArea.setBackground(Protocol.nbColor);
		tagsArea.setBackground(Protocol.nbColor);
		textArea.setBackground(Protocol.nbColor);
		
		tagsArea.setFont(tagsArea.getFont().deriveFont(17.0f));
		textArea.setFont(textArea.getFont().deriveFont(15.0f));
	//	titleLabel.setFont(textLabel.getFont().deriveFont(20.0f));
		
		titleArea.setForeground(Protocol.accentColor);
		
		
		//заголовок
		
		top.setLayout(new BorderLayout());
		top.add(titleArea,BorderLayout.WEST);
		
		del.setIcon(Protocol.del);
		del.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		del.setPreferredSize(new Dimension(30,30));
	//	top.add(del,BorderLayout.EAST);
		
		top.setPreferredSize(new Dimension(400, 30));
		
		//основной текст
		
		middle.add(textArea);
		middle.setPreferredSize(new Dimension(410, 140));
		
		//нижняя часть
	
		bottom.setLayout(new BorderLayout());
		
		
		
		
		//Animation
		del.addMouseListener(new MouseAdapter(){
			   public void mouseEntered(MouseEvent e) {
				   del.setIcon(Protocol.del_action);
				   }
		});
		del.addMouseListener(new MouseAdapter(){
			   public void mouseExited(MouseEvent e) {
				   del.setIcon(Protocol.del);
				   }
		});
		
		
		
		
		bottomNorth.setLayout(new BorderLayout());
		bottomSouth.setLayout(new BorderLayout());
		
	
		image.setIcon(Protocol.tag);
		image.setPreferredSize(new Dimension(30,30));
		bottomNorth.add(image,BorderLayout.WEST);
		
		tagsArea.setPreferredSize(new Dimension(30,30));
		
		bottomNorth.add(tagsArea,BorderLayout.CENTER);	
		
		//TEST
		
		 nvbTest = new NoteViewBottom();
	     nvbTest.create(type);
	     nvbTest.setOpaque(true);
	     
		 nvbTest.favButton.addMouseListener(new MouseAdapter(){
			   public void mouseClicked(MouseEvent e) {
				 if (isFav()==true){
					 nvbTest.favButton.setIcon(Protocol.favButton);
					 fav=false;
				 }
				 else{
					 nvbTest.favButton.setIcon(Protocol.favButtonAction);
					 fav=true;
				 }
			   }
		   });
		
			
		 
		 nvbTest.favButton.addMouseListener(new MouseAdapter(){
			   public void mouseEntered(MouseEvent e) {
				   if (isFav()==false){
					   nvbTest.favButton.setIcon(Protocol.favButtonAction);  
				   }
			   }
				  
		});
		 nvbTest.favButton.addMouseListener(new MouseAdapter(){
			   public void mouseExited(MouseEvent e) {
				   if (isFav()==true){
					   nvbTest.favButton.setIcon(Protocol.favButtonAction);
					   }
					   else{
						nvbTest.favButton.setIcon(Protocol.favButton);  
					   }
				   }
		});
		 
		 
		 
		 
		 
		 
		 
	     
	     bottomSouth.add(nvbTest,BorderLayout.WEST);
		
	     bottomNorth.setPreferredSize(new Dimension(400,80));
	     bottomSouth.setPreferredSize(new Dimension(400,80));
	     
	     bottomNorth.setBackground(Protocol.nbColor);
	     bottomSouth.setBackground(Protocol.nbColor);
	     
	     
	     bottom.add( bottomNorth,BorderLayout.NORTH);
	     bottom.add( bottomSouth,BorderLayout.SOUTH);
		
		
		
		
	     
	     
	     
	     
	     
	     
	     
	     
	     
	     
		main.setLayout(new BoxLayout(main, BoxLayout.PAGE_AXIS));
		main.add(top);
		main.add(middle);
		main.add(bottom);
		//main.add(bottom1);
		
		this.add(main);
		
		
		
//		middle.setPreferredSize(new Dimension(410,250));
		this.setPreferredSize(new Dimension(410,310));
		
		
		//PANEL COLORS 
		
		top.setBackground(Protocol.nbColor);
		middle.setBackground(Protocol.nbColor);
		bottom.setBackground(Protocol.nbColor);
	//	bottom1.setBackground(Protocol.nbColor);
		main.setBackground(Protocol.nbColor);
		this.setBackground(Protocol.nbColor);
		
		
		
		
		
		//ACTION
		
		EditNoteView obj = this;
		
		titleArea.addMouseListener(new MouseAdapter(){
			   public void mouseClicked(MouseEvent e) {
				if ( Objects.equals("Type here", titleArea.getText())) titleArea.setText("");
				//top.setBackground(Protocol.greyColor);
				   }
				});
		
		textArea.addMouseListener(new MouseAdapter(){
			   public void mouseClicked(MouseEvent e) {
				if ( Objects.equals("Type here", textArea.getText())) textArea.setText("");
				   }
				});
		tagsArea.addMouseListener(new MouseAdapter(){
			   public void mouseClicked(MouseEvent e) {
				if ( Objects.equals("Type here", tagsArea.getText())) tagsArea.setText("");
				   }
				});
		
		
		
		
		del.addMouseListener(new MouseAdapter(){
			   public void mouseClicked(MouseEvent e) {
				     obj.setVisible(false);
				     //notifyNoteList();
		
				   }
				});
	}
	
	
	

	
	
	//FAV
	

	public boolean isFav(){
		return fav;
		
	}
	
	//getters
	
	public String getTitle(){
		return titleArea.getText();
	}
	
	public String getText(){
		return textArea.getText();
	}
	
	public String getTags(){
		return tagsArea.getText();
	}
	
	
	

}
