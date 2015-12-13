import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class NoteInList extends JPanel implements Observer {
	
	private String title;
	private String text;
	private String tags;
	
	private JLabel titleLabel = new JLabel(this.title, SwingConstants.RIGHT);
	private JLabel textLabel = new JLabel(this.text, SwingConstants.RIGHT);
	private JLabel tagsLabel = new JLabel(this.tags, SwingConstants.RIGHT);
	

	
	private JPanel main = new JPanel();
	private JPanel top = new JPanel();
	private JPanel middle = new JPanel();
	private JPanel bottom = new JPanel();
	private JLabel image = new JLabel();
	

	NoteInList(String title,String text,String tags){
		this.title=title;
		this.text=text;
		this.tags=tags;
		
		//настраиваем текст
		
		titleLabel.setText(this.title);
		textLabel.setText(this.text);
		tagsLabel.setText(this.tags);
		
		//заголовок
		
		top.setLayout(new BorderLayout());
		top.add(titleLabel,BorderLayout.WEST);
		top.setPreferredSize(new Dimension(300, 30));
		top.setBackground(new Color(51, 102,255));
		
		//основной текст
		
		middle.add(textLabel);
		middle.setPreferredSize(new Dimension(300, 80));
		
		//bottom.setLayout(new FlowLayout());
		
		//image.setIcon(new ImageIcon(Protocol.myPicture));
		//bottom.add(image,FlowLayout.LEFT);
		
		bottom.setLayout(new BorderLayout());
		bottom.add(tagsLabel,BorderLayout.WEST);
		bottom.setPreferredSize(new Dimension(300, 15));
		bottom.setBackground(new Color(51, 102,255));
		
		main.setLayout(new BoxLayout(main, BoxLayout.PAGE_AXIS));
		main.add(top);
		main.add(middle);
		main.add(bottom);
		
		this.add(main);
		
		this.setPreferredSize(new Dimension(310,135));
		
	}
	
	
	
	
	

	
	
	
	
	
	
	
	
	public void update(Observable o, Object arg1) {
		
	}
}
