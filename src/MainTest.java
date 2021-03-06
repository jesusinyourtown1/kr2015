import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;

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
		    final TutorialBottom bottomPanel4 = new TutorialBottom();  // warning - i'm ready
		    
		    final JLabel tutoLabel1 = new JLabel();
		    
		    int tutoCount;
		    
	 
	 
	
	 //not GUI variables
		Protocol p = new Protocol();
		NoteList ntList = new NoteList();
		int heightNotesList; 
		InputOutputStream ioStream;
		
		
		

		
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
		 
		 
		// mPanel.add(new JLabel("ttt"));
		 
//ALL ABOUT TUTORIAL PANEL 1
		 
		 tutoLabel1.setPreferredSize(new Dimension(1000,600));
		 
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
		
		// Scrollable 
		ntList.setPreferredSize(new Dimension( 310,heightNotesList));
		JScrollPane ntListScroll = new JScrollPane(ntList);
		ntListScroll.setPreferredSize(new Dimension( 330,700));
		ntListScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
	//	addInList("English","From the sunny beaches","#eng #USA #homework",true);
	//	addInList("Swift","Swift Community -facebook.com/swift_kh","#swift #programming #iOS_dev",false);
	//	addInList("Games","To download: The Settlers 6","#games",true);
	//	addInList("Vsauce","To Google: How Shazam works?","#vsause #video",true);

		
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
	/*	neww.addMouseListener(new MouseAdapter(){
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
				});    */
		
		closepic.addMouseListener(new MouseAdapter(){
			   public void mouseClicked(MouseEvent e) {
				   emptypanel.setVisible(false);
				   }
				});
		
		
		
		bottomPanel4.create(4);
		
		info.addMouseListener(new MouseAdapter(){
			   public void mouseClicked(MouseEvent e) {
				   mPanel1.setVisible(false);
				   
				   tutoLabel1.setIcon(Protocol.infoPic);
				   bottomPanel3.setVisible(false);
				   tutoPanel.add(bottomPanel4);
				   
				   tutoPanel.setVisible(true);
				   
				   
				   bottomPanel4.primaryButton.addMouseListener(new MouseAdapter(){
						 public void mouseClicked(MouseEvent e) { 
							 tutoPanel.setVisible(false);
							   mPanel1.setVisible(true);		 
					 }
					 });
				   
				   
				   
				   
				   
				   
				   }
				});
		
		
//INFO PANEL
		
		
		
		
		
		
		
	
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
		
		
		
// FOR TEST NOTES (can be deleted later)
		
	/*	for (int i=0; i<ntList.nilArr.size();i++){
			final NoteInList tmpNil = ntList.nilArr.get(i);
			ntList.nilArr.get(i).addMouseListener(new MouseAdapter(){
				   public void mouseClicked(MouseEvent e) {	   
					   
					   
					   final SingleNoteView snvTest = new SingleNoteView(tmpNil.getTitle(),tmpNil.getText(),tmpNil.getTags(),tmpNil.getFav());
					   panelGreen.add(snvTest);
					   mPanel1.setVisible(false);
					   mPanel2.setVisible(true);
					   
					 
					   snvTest.nvbTest.backButton.addMouseListener(new MouseAdapter(){
						   public void mouseClicked(MouseEvent e) {
							  mPanel1.setVisible(true);
							  mPanel2.setVisible(false);
							  snvTest.setVisible(false);
							  panelGreen.removeAll();
							  
							  addInList(snvTest.getTitle(),snvTest.getText(),snvTest.getTags(),snvTest.isFav());
						   }
						   
					   });
					  
					   }
				  
					});
		}*/
		
		

		
		
		
		
		
		
		
//ALL ABOUT MAIN PANEL 2 (new note)
		

		newbg_label.setIcon(Protocol.new_bg);
		
		
		  //TEST!!!!!
		
		 // SingleNoteView snvTest = new SingleNoteView("Test title","text text text","tag tag tag");
		
		  panelBlue.setBackground(new Color(170, 170,170));
		  panelGreen.setBackground(Protocol.nbColor);
		  
		  
		
		        lpane.setBounds(0, -100, 1300, 1000);
		        panelBlue.add(newbg_label);
		        panelBlue.setBounds(0,0, 1300, 1000);
		        panelBlue.setOpaque(true);
		        
		        panelGreen.setBounds(446, 230, 410,340);
		        panelGreen.setOpaque(true);
		        lpane.add(panelBlue, new Integer(0), 0);
		        lpane.add(panelGreen, new Integer(1), 0);
		    
		        mPanel2.setPreferredSize(new Dimension(1300, 1000));
				mPanel2.setLayout(new BorderLayout());
				mPanel2.add(lpane, BorderLayout.CENTER);     
				
				
				
				
				neww.addMouseListener(new MouseAdapter(){
					   public void mouseClicked(MouseEvent e) {
						   final EditNoteView envTest = new EditNoteView("Type here","and here","and then here",false,3);  // false - for isFav 
						    // 3 - type for the NoteViewBottom
				
					        panelGreen.add(envTest); 
					        mPanel1.setVisible(false);
						     mPanel2.setVisible(true);
					        
							envTest.nvbTest.centerButton.addMouseListener(new MouseAdapter(){
								//final NoteInList tmpNil = ntList.nilArr.get(ntList.nilArr.size()-1);
								   public void mouseClicked(MouseEvent e) {
									  addInList(envTest.titleArea.getText(),envTest.textArea.getText(),envTest.tagsArea.getText(),envTest.isFav());
									  mPanel2.setVisible(false);
									  mPanel1.setVisible(true);
									  panelGreen.removeAll();
								   }  
							   });
							
							envTest.nvbTest.backButton.addMouseListener(new MouseAdapter(){
								   public void mouseClicked(MouseEvent e) {
									  mPanel1.setVisible(true);
									  mPanel2.setVisible(false);
									  panelGreen.removeAll();
								   }});
					   }  
				   });

		
		
		//TEST !!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		        
		  
		
		// adding to the main panel
		mPanel.add(tutoPanel);
		mPanel.add(mPanel1);
		mPanel.add(mPanel2);
		
		// hiding all main panels except start panel (1)
		mPanel1.setVisible(false);
		mPanel2.setVisible(false);
			
		//adding main panel on frame
		frame.add(mPanel);
	//	frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		ioStream = new InputOutputStream("Notes.txt");
		try {
			readFromFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}	
	 
	 
	 
	 
	 public void writeInFile() throws IOException{
		 String tmpStr="";
	
		 for (int i=0; i<ntList.nilArr.size();i++){
			tmpStr = tmpStr+ ntList.nilArr.get(i).getTitle()+"%"+ntList.nilArr.get(i).getText()+"%"+ntList.nilArr.get(i).getTags()+"%"+ntList.nilArr.get(i).getFav()+"/";
		 }
	     ioStream.clean();
		 ioStream.write(tmpStr);  
	 }
	 
	 public void readFromFile() throws IOException{
		 String tmpStr="";
		 String [] tmpArr;
		 
		 tmpStr=ioStream.read();
		 tmpArr = tmpStr.split("/");
		 
		 for (int i=0; i<tmpArr.length;i++){
			 String [] tmpArr1 = tmpArr[i].split("%");
		//	 System.out.println((tmpArr1[0]+tmpArr1[1]+tmpArr1[2]+Boolean.parseBoolean(tmpArr1[3])));
			 addInList(tmpArr1[0],tmpArr1[1],tmpArr1[2],Boolean.parseBoolean(tmpArr1[3]));
		 }
		 
		 
	 }
	 

		// FOR NEW NOTE IN LIST!!  -- use THIS to add note in list (DON'T USE ADDS)
		public void addInList(final String title, final String text,final String tags,final boolean isFav){
			heightNotesList = heightNotesList+145;
			ntList.setPreferredSize(new Dimension( 310,heightNotesList));
			
			
			ntList.adds(title,text,tags,isFav);
			
			ntList.nilArr.get(ntList.nilArr.size()-1).ind=ntList.nilArr.size()-1;
			
			try {
			//	File fileToDelete = new File("Notes.txt");  
		//		fileToDelete.delete();
				
			//	File file = new File("Notes.txt");
		//		file.createNewFile();
				
				
				
			//	ioStream.clean();
				writeInFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		    NoteInList tmpNil = ntList.nilArr.get(ntList.nilArr.size()-1);
		    
		    tmpNil.del.addMouseListener(new MouseAdapter(){
				   public void mouseClicked(MouseEvent e) {
					   ntList.nilArr.remove(tmpNil.ind);
					   heightNotesList = heightNotesList-145;
					   ntList.setPreferredSize(new Dimension( 310,heightNotesList));
					   
					   try {
					//	ioStream.clean();
						writeInFile();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					   
				   }   
			   });   

		    
			tmpNil.addMouseListener(new MouseAdapter(){
				   public void mouseClicked(MouseEvent e) {
					   
					   
					   ntList.nilArr.remove(tmpNil.ind);
					   
					   heightNotesList = heightNotesList-145;
					   ntList.setPreferredSize(new Dimension( 310,heightNotesList));
					   
					   final SingleNoteView snvTest = new SingleNoteView(title,text,tags,isFav);
					   panelGreen.add(snvTest);
					   mPanel1.setVisible(false);
					   mPanel2.setVisible(true);
					   
					 
					  snvTest.nvbTest.backButton.addMouseListener(new MouseAdapter(){
						   public void mouseClicked(MouseEvent e) { 
							  mPanel1.setVisible(true);
							  mPanel2.setVisible(false);
							  panelGreen.removeAll();
							  addInList(snvTest.getTitle(),snvTest.getText(),snvTest.getTags(),snvTest.isFav());
						   }   
					   });   
					  
					  snvTest.nvbTest.centerButton.addMouseListener(new MouseAdapter(){
						   public void mouseClicked(MouseEvent e) { 
							  final EditNoteView envTest = new EditNoteView(snvTest.getTitle(),snvTest.getText(),snvTest.getTags(),snvTest.isFav(),2);
							  	envTest.nvbTest.backButton.setVisible(false);
							  //panelGreen.removeAll();
							 	snvTest.setVisible(false);
							 	panelGreen.add(envTest);
							 
							 
							 
							   // SAVE view -- 
							   
							 	  envTest.nvbTest.centerButton.addMouseListener(new MouseAdapter(){
									   public void mouseClicked(MouseEvent e) { 
										   snvTest.setTitleLabel(envTest.getTitle());
										   snvTest.setTextLabel(envTest.getText());
										   snvTest.setTagsLabel(envTest.getTags());
										   snvTest.setFav(envTest.isFav());
										   //panelGreen.removeAll();
										   envTest.setVisible(false);
										   envTest.nvbTest.backButton.setVisible(true);
										   panelGreen.add(snvTest);
										   snvTest.setVisible(true);
								   
									   }   
								   });
								   
								   
							   
							   
							   
							   //   panelGreen.removeAll();  // removing single note view
							   
						   }   
					   });   
					  
					  
					  
					    
					   }
				  
					});
			
			
		}	 
	 
}


