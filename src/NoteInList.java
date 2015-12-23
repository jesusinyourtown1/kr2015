import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class NoteInList extends JPanel {
	
	private String title;
	private String text;
	private String tags;
	private boolean isFav;
	
	private JLabel titleLabel = new JLabel(this.title, SwingConstants.RIGHT);
	private JLabel textLabel = new JLabel(this.text, SwingConstants.RIGHT);
	private JLabel tagsLabel = new JLabel(this.tags, SwingConstants.RIGHT);
	

	
	private JPanel main = new JPanel();
	private JPanel top = new JPanel();
	private JPanel middle = new JPanel();
	private JPanel bottom = new JPanel();
	

	private JPanel bottom1 = new JPanel();
	private JPanel top1 = new JPanel();
	
	private JLabel image = new JLabel();
	private JLabel separ = new JLabel();
	private JLabel del = new JLabel();

	

	NoteInList(String title,String text,String tags){
		this.title=title;
		this.text=text;
		this.tags=tags;
		
		//настраиваем текст
		
		titleLabel.setText(this.title);
		textLabel.setText(this.text);
		tagsLabel.setText(this.tags);
		
		
		titleLabel.setFont(Protocol.SFFontT);
		tagsLabel.setFont(Protocol.SFFont);
		textLabel.setFont(Protocol.SFFont);
		
		tagsLabel.setFont(tagsLabel.getFont().deriveFont(15.0f));
		textLabel.setFont(textLabel.getFont().deriveFont(14.0f));
		
		
		
		titleLabel.setForeground(Protocol.accentColor);
		
		
		//заголовок
		
		top.setLayout(new BorderLayout());
		top.add(titleLabel,BorderLayout.WEST);
		
		del.setIcon(Protocol.del);
		del.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		del.setPreferredSize(new Dimension(30,30));
		top.add(del,BorderLayout.EAST);
		
		top.setPreferredSize(new Dimension(300, 30));
		
		//основной текст
		
		middle.add(textLabel);
		middle.setPreferredSize(new Dimension(300, 80));
		
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
		
		
		NoteInList obj = this;
		
	
		
		
	
		image.setIcon(Protocol.tag);
		image.setPreferredSize(new Dimension(30,30));
		bottom.add(image,BorderLayout.WEST);
		
		tagsLabel.setPreferredSize(new Dimension(30,30));
		
		bottom.add(tagsLabel,BorderLayout.CENTER);
		bottom.setPreferredSize(new Dimension(300,30));
		
		//разделитель
		separ.setIcon(Protocol.separ);
		separ.setPreferredSize(new Dimension(300,10));
		bottom.add(separ,BorderLayout.SOUTH);
		
		
		main.setLayout(new BoxLayout(main, BoxLayout.PAGE_AXIS));
		main.add(top);
		main.add(middle);
		main.add(bottom);
		main.add(bottom1);
		
		this.add(main);
		
		this.setPreferredSize(new Dimension(310,145));
		
		
		//PANEL COLORS 
		
		top.setBackground(Protocol.nbColor);
		middle.setBackground(Protocol.nbColor);
		bottom.setBackground(Protocol.nbColor);
		bottom1.setBackground(Protocol.nbColor);
		main.setBackground(Protocol.nbColor);
		this.setBackground(Protocol.nbColor);
		
		
		
		
		
		//ACTION
		
		
		
		del.addMouseListener(new MouseAdapter(){
			   public void mouseClicked(MouseEvent e) {
				     obj.setVisible(false);
				   //  notifyNoteList();
		
				   }
				});
	}
	
	
	


	//getters
	
	public String getTitle(){
		return title;
	}
	
	public String getText(){
		return text;
	}
	
	public String getTags(){
		return tags;
	}
	
	public boolean getFav(){
		return isFav;
	}

	
	
	
	
	
	
	
	
	public void update(Observable o, Object arg1) {
		
	}
}
