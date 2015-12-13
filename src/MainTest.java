import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Observer;

import javax.swing.*;

public class MainTest {
	final JFrame frame = new JFrame("TagIT");
	
	final JPanel mPanel = new JPanel();  // main-main panel
	final JPanel mPanel1 = new JPanel(); // - for notes list
	final JPanel mPanel2 = new JPanel(); // - for 1 note (to edit)
	
	private JButton swtch = new JButton();
	private NoteInList nit = new NoteInList("Title","Text","tag tag tag");
	
	Note n = new Note("Hey!");
	Note n1 = new Note("Note2");
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
					new MainTest();
				
			}
		});
	}
	
	 public MainTest()  {
		
		Color color = new Color(51, 102,255);
		Color color1 = new Color(255,204,51);
		
		mPanel1.add(n);
		mPanel2.add(n1);
	
		frame.setLocationRelativeTo(null);
		frame.setAlwaysOnTop(true);
		
		mPanel1.setBackground(color);
		mPanel2.setBackground(color1);
		
		swtch.setText("Switch");
		
		swtch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mPanel2.isVisible()==true){
					mPanel2.setVisible(false);
					mPanel1.setVisible(true);
				}
				else{
					mPanel2.setVisible(true);
					mPanel1.setVisible(false);
				}
			}
		});
		
		mPanel2.addMouseListener(new MouseAdapter(){
			   public void mouseClicked(MouseEvent e) {
				     mPanel2.setVisible(false);
				     mPanel1.setVisible(true);
				   }
				});
		
		
		
		
		
		
		mPanel.add(mPanel1);
		mPanel.add(mPanel2);
		mPanel.add(swtch);
		
		mPanel2.add(nit);
		
		mPanel2.setVisible(false);

		frame.add(mPanel);
		
		//mPanel2.setVisible(false);
		//mPanel1.setVisible(false);
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
}
//frame.setUndecorated(true);


