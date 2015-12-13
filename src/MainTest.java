import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
	final JPanel emptypanel = new JPanel();
	final JLabel emptypic = new JLabel();
	
	
	 Protocol p = new Protocol();
	 
	 NoteList ntList = new NoteList();
	 final JPanel mPanel1R = new JPanel();  //Right
	 final JPanel mPanel1RT = new JPanel(); //Right - Top
	 final JPanel mPanel1RTE = new JPanel();  //Right - Top - East
	 
	 final JLabel info = new JLabel();
	 final JLabel neww = new JLabel(); 
	 
	 final JPanel close = new JPanel(); 
	 final JLabel closepic = new JLabel(); 

		
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
					new MainTest();
				
			}
		});
	}
	
	 public MainTest()  {
	
		mPanel1.setLayout(new BorderLayout());

		
		info.setIcon(Protocol.info);
		neww.setIcon(Protocol.neww);
		
		mPanel1RTE.add(info);
		mPanel1RTE.add(neww);
		
		mPanel1RT.setLayout(new BorderLayout());	
		mPanel1RT.add(mPanel1RTE,BorderLayout.EAST);
		
		mPanel1R.setLayout(new BorderLayout());
		mPanel1R.setPreferredSize(new Dimension(300,40));
		//mPanel1R.setMaximumSize(new Dimension(1920,30));
		mPanel1R.add(mPanel1RT,BorderLayout.NORTH);
		
		
		//pic for empty list
		emptypic.setIcon(Protocol.empty);
		emptypanel.setLayout(new BorderLayout());
		emptypanel.add(emptypic,BorderLayout.WEST);
		
		
		closepic.setIcon(Protocol.del);
		close.setLayout(new BorderLayout());
		close.add(closepic,BorderLayout.NORTH);
		emptypanel.add(close,BorderLayout.EAST);
		
		
		
		mPanel1.add(mPanel1R,BorderLayout.EAST);
		mPanel1.add(emptypanel,BorderLayout.CENTER);
		mPanel1.add(ntList,BorderLayout.WEST);
		
		
		
		
		ntList.addNoteInList(new NoteInList("Note #1","Text ot the first note","tag tag tag"));
		ntList.addNoteInList(new NoteInList("Note #2","Text ot the second note","tag tag tag"));
		ntList.addNoteInList(new NoteInList("Note #3","Text ot the third note","tag tag tag"));
		
		
		
		//SET BG COLORS
		
		mPanel.setBackground(Protocol.nbColor);
		mPanel1.setBackground(Protocol.nbColor);
		mPanel2.setBackground(Protocol.nbColor);
		emptypanel.setBackground(Protocol.nbColor);
		mPanel1R.setBackground(Protocol.nbColor);
		mPanel1RT.setBackground(Protocol.nbColor);
		mPanel1RTE.setBackground(Protocol.nbColor);
		ntList.setBackground(Protocol.nbColor);
		close.setBackground(Protocol.nbColor);
		
		
		MainTest obj = this;
		
		
		//ACTION LISTENERS
		neww.addMouseListener(new MouseAdapter(){
			   public void mouseClicked(MouseEvent e) {
				     mPanel1.setVisible(false);
				     mPanel2.setVisible(true);
		
				   }
				});
		
		closepic.addMouseListener(new MouseAdapter(){
			   public void mouseClicked(MouseEvent e) {
				   emptypanel.setVisible(false);
				   }
				});
		
		
		
		
		
		mPanel.add(mPanel1);
		mPanel.add(mPanel2);
		
		mPanel2.setVisible(false);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		mPanel2.addMouseListener(new MouseAdapter(){
			   public void mouseClicked(MouseEvent e) {
				     mPanel2.setVisible(false);
				     mPanel1.setVisible(true);
				   }
				});
		
		
		
		

		frame.add(mPanel);
		
		frame.setLocationRelativeTo(null);
		frame.setAlwaysOnTop(true);
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
}
//frame.setUndecorated(true);


