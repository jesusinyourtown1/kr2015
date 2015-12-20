import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Observer;

import javax.swing.*;

public class MainTest {
	final JFrame frame = new JFrame("TagIT");

	
	//Main panels

	final JPanel mPanel = new JPanel();  // main-main panel
	final JPanel mPanel1 = new JPanel(); // - for notes list
	final JPanel mPanel2 = new JPanel(); // - for new note
	final JPanel infoPanel = new JPanel(); // - for info
	final JPanel tutoPanel = new JPanel(); // - 1st tutorial panel
	
	
	//mPanel1 components
		
		//panels
			final JPanel emptypanel = new JPanel(); 
			final JPanel mPanel1R = new JPanel();  //Right
			final JPanel mPanel1RT = new JPanel(); //Right - Top
			final JPanel mPanel1RTE = new JPanel();  //Right - Top - East
			final JPanel close = new JPanel(); 
	
		//labels
			final JLabel emptypic = new JLabel();
			final JLabel info = new JLabel();
			final JLabel neww = new JLabel(); 
			final JLabel closepic = new JLabel(); 
	
			
	//infoPanel components	
		
		//panels
			final JPanel newnote_panel = new JPanel(); 
			final JLayeredPane layeredPane = new JLayeredPane();
			
		//labels	
			final JLabel newbg_label = new JLabel();
			
			
	//mPanel2
			
		    private JLayeredPane lpane = new JLayeredPane();
		    private JPanel panelBlue = new JPanel();
		    private JPanel panelGreen = new JPanel();
		    
		    
	// TUTORIAL PANELS AND LABELS 
		    
		  //  final JPanel tutoPanelBottom = new JPanel();
		    
		    final JPanel tutoPanel1 = new JPanel();
		    final JPanel tutoPanel2 = new JPanel();
		    final JPanel tutoPanel3 = new JPanel();
		    final JPanel tutoPanel4 = new JPanel();
	
		    final TutorialBottom bottomPanel1 = new TutorialBottom();  // tuto - start or skip
		    final TutorialBottom bottomPanel2 = new TutorialBottom(); // tuto - next
		    final TutorialBottom bottomPanel3 = new TutorialBottom();  // warning - i'm ready
		    
		    final JLabel tutoLabel1 = new JLabel();
		    
		    int tutoCount;
		    
	 
	 
	
	 //not GUI variables
		Protocol p = new Protocol();
		NoteList ntList = new NoteList();
		
		
		
		
		

		
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
					new MainTest();
				
			}
		});
	}
	
	
	
	 public MainTest()  {
		 
		 Toolkit kit = Toolkit.getDefaultToolkit();
		 Image img = kit.getImage("icon.png");
		 frame.setIconImage(img);
		 
		 
		 
		 
//ALL ABOUT TUTORIAL PANEL 1
		 
		 tutoPanel.setLayout(new BorderLayout());
		 
		 tutoLabel1.setIcon(Protocol.tour1);
		 tutoPanel1.add(tutoLabel1);
		 
		 tutoPanel.add(tutoPanel1,BorderLayout.NORTH);
		 
		 bottomPanel1.create(1);
		 bottomPanel2.create(2);
		 bottomPanel3.create(3);
		 
		 tutoPanel.add(bottomPanel1,BorderLayout.SOUTH);
		
		 
		 //bottomPanel2.setVisible(false);
		 
		 
		 tutoPanel1.setBackground(Protocol.nbColor);
		 tutoPanel.setBackground(Protocol.nbColor);
		 
		 
		 bottomPanel1.primaryButton.addMouseListener(new MouseAdapter(){   // TUTO: when u click "start tour"
			   public void mouseClicked(MouseEvent e) { 
				   bottomPanel1.setVisible(false);
				   tutoPanel.add(bottomPanel2,BorderLayout.SOUTH);
				   tutoLabel1.setIcon(Protocol.tour2);
				   tutoCount=1;
				   }
				});
		 
		 bottomPanel1.smButton.addMouseListener(new MouseAdapter(){   //  TUTO: when u click "skip it"
			   public void mouseClicked(MouseEvent e) { 
				   tutoLabel1.setIcon(Protocol.warning);
				   bottomPanel1.setVisible(false);
				   tutoPanel.add(bottomPanel3,BorderLayout.SOUTH);
				     
				   }
				});
		 
		 
		 
		 bottomPanel2.primaryButton.addMouseListener(new MouseAdapter(){   //  TUTO: 
			   public void mouseClicked(MouseEvent e) { 
				   		if(tutoCount==1){
				   			tutoLabel1.setIcon(Protocol.tour3);   // skip to "tags tags tags"
				  
				   		}
				   		if(tutoCount==2){
				   			tutoLabel1.setIcon(Protocol.tour4);   // skip to "fav"
				   	
				   		}
				   		if(tutoCount==3){
				   			tutoLabel1.setIcon(Protocol.tour5); // skip to "future stuff"
				   		//	bottomPanel2.primaryButton.setIcon(Protocol.doneTour);
				   		
				   		}
				   		if(tutoCount==4){
				   			tutoLabel1.setIcon(Protocol.warning);
						   bottomPanel2.setVisible(false);
						   tutoPanel.add(bottomPanel3,BorderLayout.SOUTH);
				   			
				   		}
				   		tutoCount++;
				   }
				});
		 
		 
		 //WARNING
		 
		 bottomPanel3.primaryButton.addMouseListener(new MouseAdapter(){
			 public void mouseClicked(MouseEvent e) { 
				 tutoPanel.setVisible(false);
				   mPanel1.setVisible(true);		 
		 }
		 });
		 
		 
		 

		 
		 
//ALL ABOUT MAIN PANEL 1 (note list, new button)
	
		mPanel1.setLayout(new BorderLayout());
		
		JScrollPane ntListScroll = new JScrollPane(ntList);
		//ntListScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		ntList.add(new NoteInList("English","From the sunny beaches","#eng #USA #homework"));
		ntList.add(new NoteInList("Swift","Swift Community -facebook.com/swift_kh","#swift #programming #iOS_dev"));
		ntList.add(new NoteInList("Games","To download: The Settlers 6","#games"));
		ntList.add(new NoteInList("Vsauce","To Google: How Shazam works?","#vsause #video"));

		
		info.setIcon(Protocol.info);
		neww.setIcon(Protocol.neww);
		
		info.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		neww.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
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
		
		
		closepic.setIcon(Protocol.del1);
		closepic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		close.setLayout(new BorderLayout());
		close.add(closepic,BorderLayout.NORTH);
		emptypanel.add(close,BorderLayout.EAST);
		
		
		
		mPanel1.add(mPanel1R,BorderLayout.EAST);
		mPanel1.add(emptypanel,BorderLayout.CENTER);
		mPanel1.add(ntListScroll,BorderLayout.WEST);
		
		
		
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
		frame.setBackground(Protocol.nbColor);
		
				
		//ACTION LISTENERS ALS
		neww.addMouseListener(new MouseAdapter(){
			   public void mouseClicked(MouseEvent e) {
				     mPanel1.setVisible(false);
				     mPanel2.setVisible(true);
				     
				     
				//     mPanel.setVisible(false);
						mPanel1.setVisible(false);
						emptypanel.setVisible(false);
						mPanel1R.setVisible(false);
						mPanel1RT.setVisible(false);
						mPanel1RTE.setVisible(false);
						ntList.setVisible(false);
						close.setVisible(false);
				     
				     
		
				   }
				});
		
		closepic.addMouseListener(new MouseAdapter(){
			   public void mouseClicked(MouseEvent e) {
				   emptypanel.setVisible(false);
				   }
				});
		
		info.addMouseListener(new MouseAdapter(){
			   public void mouseClicked(MouseEvent e) {
				   mPanel1.setVisible(false);
				   infoPanel.setVisible(true);
				   }
				});
		
		
		
		
		
		
		
		
	
		//something like animation
		
		
		
		neww.addMouseListener(new MouseAdapter(){
			   public void mouseEntered(MouseEvent e) {
				   	neww.setIcon(Protocol.plus_action);
				   }
		});
		neww.addMouseListener(new MouseAdapter(){
			   public void mouseExited(MouseEvent e) {
				   	neww.setIcon(Protocol.neww);
				   }
		});
		
		info.addMouseListener(new MouseAdapter(){
			   public void mouseEntered(MouseEvent e) {
				   info.setIcon(Protocol.info_action);
				   }
		});
		info.addMouseListener(new MouseAdapter(){
			   public void mouseExited(MouseEvent e) {
				   info.setIcon(Protocol.info);
				   }
		});
		
		
		closepic.addMouseListener(new MouseAdapter(){
			   public void mouseEntered(MouseEvent e) {
				   closepic.setIcon(Protocol.del_padd_action);
				   }
		});
		closepic.addMouseListener(new MouseAdapter(){
			   public void mouseExited(MouseEvent e) {
				   closepic.setIcon(Protocol.del1);
				   }
		});
		
		
		
		
		
		
		
		
		
		
//ALL ABOUT MAIN PANEL 2 (new note)
		

		newbg_label.setIcon(Protocol.new_bg);
		
		

		mPanel2.setPreferredSize(new Dimension(1300, 1000));
		mPanel2.setLayout(new BorderLayout());
		mPanel2.add(lpane, BorderLayout.CENTER);
		        lpane.setBounds(0, -100, 1300, 1000);
		        panelBlue.add(newbg_label);
		        panelBlue.setBounds(0,0, 1300, 1000);
		        panelBlue.setOpaque(true);
		        panelGreen.add(new NoteInList("Try title","Try text","tag tag tag"));
		        panelGreen.setBounds(500, 310, 310,145);
		        panelGreen.setOpaque(true);
		        lpane.add(panelBlue, new Integer(0), 0);
		        lpane.add(panelGreen, new Integer(1), 0);
		    
		        
		        
	//	newnote_panel.setOpaque(false);
	//	newnote_panel.add(new NoteInList("Title4","text1","tag tag tag"));
	//	mPanel2.add(newnote_panel);
	//	newbg_label.setIcon(Protocol.new_bg);
	//	newbg_label.setBorder(null);
		//layeredPane.add(newbg_label);
	//	mPanel2.add(newbg_label);
	//	layeredPane.add(new NoteInList("Title4","text1","tag tag tag"), new Integer(2));
		
	//	mPanel2.add(layeredPane,new Integer(2), 0);
		
		
		
		
		
		
		// adding to the main panel
		mPanel.add(tutoPanel);
		mPanel.add(mPanel1);
		mPanel.add(mPanel2);
		
		// hiding all main panels except start panel (1)
		mPanel1.setVisible(false);
		mPanel2.setVisible(false);
			
		//adding main panel on frame
		frame.add(mPanel);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}	
}


