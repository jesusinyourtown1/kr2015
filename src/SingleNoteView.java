import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SingleNoteView extends JPanel {
	
	private boolean fav;
	
	private JLabel titleLabel; 
	private JLabel textLabel;
	private JLabel tagsLabel; 
	
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
	
	
	public NoteViewBottom nvbTest;

	SingleNoteView(String title,String text,String tags,boolean isFav){
		titleLabel = new JLabel(title, SwingConstants.RIGHT);
		textLabel = new JLabel(text, SwingConstants.RIGHT);
		tagsLabel = new JLabel(tags, SwingConstants.RIGHT);
		
		titleLabel.setFont(Protocol.SFFontT);
		tagsLabel.setFont(Protocol.SFFont);
		textLabel.setFont(Protocol.SFFont);
		
		tagsLabel.setFont(tagsLabel.getFont().deriveFont(17.0f));
		textLabel.setFont(textLabel.getFont().deriveFont(15.0f));
	//	titleLabel.setFont(textLabel.getFont().deriveFont(20.0f));
		
		titleLabel.setForeground(Protocol.accentColor);
		
		
		//���������
		
		top.setLayout(new BorderLayout());
		top.add(titleLabel,BorderLayout.WEST);
		
		del.setIcon(Protocol.del);
		del.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		del.setPreferredSize(new Dimension(30,30));
	//	top.add(del,BorderLayout.EAST);
		
		top.setPreferredSize(new Dimension(400, 50));
		
		//�������� �����
		
		middle.add(textLabel);
		middle.setPreferredSize(new Dimension(410, 140));
		
		//������ �����
	
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
		
		tagsLabel.setPreferredSize(new Dimension(30,30));
		
		bottomNorth.add(tagsLabel,BorderLayout.CENTER);	
		
		//TEST
		
		 nvbTest = new NoteViewBottom();
	     nvbTest.create(1);
	     nvbTest.setOpaque(true);
	     
	     
	     
	     bottomSouth.add(nvbTest,BorderLayout.WEST);
		
	     bottomNorth.setPreferredSize(new Dimension(400,80));
	     bottomSouth.setPreferredSize(new Dimension(400,80));
	     
	     bottomNorth.setBackground(Protocol.nbColor);
	     bottomSouth.setBackground(Protocol.nbColor);
	     
	     
	     bottom.add( bottomNorth,BorderLayout.NORTH);
	     bottom.add( bottomSouth,BorderLayout.SOUTH);
		
		
		
		
	  // Fav
	     
	     if (isFav){
	    	 nvbTest.favButton.setIcon(Protocol.favButtonAction);
			 fav=true; 
	     }
	     
	     
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
	     
	     
	     
	     
	     
	     
	     
	     
	     
		main.setLayout(new BoxLayout(main, BoxLayout.PAGE_AXIS));
		main.add(top);
		main.add(middle);
		main.add(bottom);
		//main.add(bottom1);
		
		this.add(main);
		
		
		
//		middle.setPreferredSize(new Dimension(410,250));
		this.setPreferredSize(new Dimension(410,340));
		
		
		//PANEL COLORS 
		
		top.setBackground(Protocol.nbColor);
		middle.setBackground(Protocol.nbColor);
		bottom.setBackground(Protocol.nbColor);
	//	bottom1.setBackground(Protocol.nbColor);
		main.setBackground(Protocol.nbColor);
		this.setBackground(Protocol.nbColor);
		
		
		
		
		
		//ACTION
		
		final SingleNoteView obj = this;
		
		del.addMouseListener(new MouseAdapter(){
			   public void mouseClicked(MouseEvent e) {
				     obj.setVisible(false);
				     //notifyNoteList();
		
				   }
				});
	}
	
	
	//M
	
	public void setTitle(String title){
		titleLabel.setText(title);
	}
	
	public boolean isFav(){
		return fav;
	}
	
	
	//getters and setters 
	
	public String getTitle(){
		return titleLabel.getText();
	}
	
	public String getText(){
		return textLabel.getText();
	}
	
	public String getTags(){
		return tagsLabel.getText();
	}
	
	public void setTitleLabel(String title) {
		this.titleLabel.setText(title);
	}
	public void setTextLabel(String text) {
		this.textLabel.setText(text);
	}
	public void setTagsLabel(String tags) {
		this.tagsLabel.setText(tags);
	}
	public void setFav(boolean isFav) {
		this.fav=isFav;
	}


	
	
	
	}
	
	
	

