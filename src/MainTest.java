import java.awt.BorderLayout;
import java.io.IOException;
import java.util.Observer;

import javax.swing.*;

public class MainTest {
	final JFrame frame = new JFrame("ChatApp 2.0");

	final JPanel panel1 = new JPanel(); // main panel
	
	private NoteModel nModel = new NoteModel();;
	private NoteView nView = new NoteView(nModel);
	
	
	
	
	
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
					new MainTest();
				
			}
		});
	}
	
	 public MainTest()  {
		
		nModel.addObserver(nView);
		panel1.setLayout(new BorderLayout());
		
		panel1.add(nView);
		
		frame.add(panel1);
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		
		
		
	}
	
}
