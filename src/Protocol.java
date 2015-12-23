import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Protocol {
	
	//Text
	
	public static final char NOTE_END ='\n';
	public static final char TAG_END ='\t';
	public static final String TAGS_END ="\tgs";
	public static final String TIME_END ="\tm";
	public static final String USER_END ="\r";
	
	//Images
	
	public static  BufferedImage myPicture;
	public static  ImageIcon tag;
	public static  ImageIcon del;
	public static  ImageIcon del1;
	public static  ImageIcon separ;
	public static  ImageIcon info;
	public static  ImageIcon neww;
	public static  ImageIcon empty;
	public static  ImageIcon new_bg;
	
	public static  ImageIcon plus_action;
	public static  ImageIcon info_action;
	public static  ImageIcon del_action;
	public static  ImageIcon del_padd_action;
	
	
	//for tuto
	
	public static  ImageIcon startTour;
	public static  ImageIcon startTourAction;
	
	public static  ImageIcon nextTour;
	public static  ImageIcon nextTourAction;
	
	public static  ImageIcon skipTour;
	public static  ImageIcon skipTourAction;
	
	public static  ImageIcon tour1;
	public static  ImageIcon tour2;
	public static  ImageIcon tour3;
	public static  ImageIcon tour4;
	public static  ImageIcon tour5;
	
	public static  ImageIcon warning;
	public static  ImageIcon bugsWarn;
	public static  ImageIcon bugsWarnAction;
	
	
	//for note views 
	
	public static  ImageIcon backButton;
	public static  ImageIcon favButton;
	public static  ImageIcon tagButton;
	public static  ImageIcon editButton;
	public static  ImageIcon saveButton;
	public static  ImageIcon createButton;
	
	public static  ImageIcon backButtonAction;
	public static  ImageIcon favButtonAction;
	public static  ImageIcon tagButtonAction;
	public static  ImageIcon editButtonAction;
	public static  ImageIcon saveButtonAction;
	public static  ImageIcon createButtonAction;
	
	
	
	//TEST
	static int counter;
	static NoteInList tmpNIL;

	
	//Fonts
	
	 private GraphicsEnvironment ge;
	 private GraphicsEnvironment ge1;
	 public static Font SFFont;
	 public static Font SFFontT;
	 
	 
	 //Colors
	 
	 public static Color nbColor= new Color(242, 242,242);
	 public static Color accentColor= new Color(246,177,0);
	 public static Color greyColor= new Color(206,206,206);
	 
	 
	 
	Protocol() {
		try {
			myPicture = ImageIO.read(new File("tag.png"));
			tag = new ImageIcon(Protocol.myPicture);
			
			myPicture = ImageIO.read(new File("del.png"));
			del = new ImageIcon(Protocol.myPicture);
			
			myPicture = ImageIO.read(new File("separ.png"));
			separ = new ImageIcon(Protocol.myPicture);
			
			myPicture = ImageIO.read(new File("info.png"));
			info = new ImageIcon(Protocol.myPicture);
			
			myPicture = ImageIO.read(new File("new.png"));
			neww = new ImageIcon(Protocol.myPicture);
			
			myPicture = ImageIO.read(new File("emptylist.png"));
			empty = new ImageIcon(Protocol.myPicture);
			
			myPicture = ImageIO.read(new File("new_bg.png"));
			new_bg = new ImageIcon(Protocol.myPicture);
			
			myPicture = ImageIO.read(new File("del1.png"));
			del1 = new ImageIcon(Protocol.myPicture);
			
			//for animation:
			
			myPicture = ImageIO.read(new File("plus_action.png"));
			plus_action = new ImageIcon(Protocol.myPicture);
			
			myPicture = ImageIO.read(new File("info_action.png"));
			info_action = new ImageIcon(Protocol.myPicture);
			
			myPicture = ImageIO.read(new File("del_action.png"));
			del_action = new ImageIcon(Protocol.myPicture);
			
			myPicture = ImageIO.read(new File("del_padd_action.png"));
			del_padd_action = new ImageIcon(Protocol.myPicture);
			
			
			//for tuto
			
			myPicture = ImageIO.read(new File("startTour.png"));
			startTour = new ImageIcon(Protocol.myPicture);
			
			myPicture = ImageIO.read(new File("startTourAction.png"));
			startTourAction = new ImageIcon(Protocol.myPicture);
			
			myPicture = ImageIO.read(new File("nextTour.png"));
			nextTour = new ImageIcon(Protocol.myPicture);
			
			myPicture = ImageIO.read(new File("nextTourAction.png"));
			nextTourAction = new ImageIcon(Protocol.myPicture);
			
			myPicture = ImageIO.read(new File("skipTour.png"));
			skipTour = new ImageIcon(Protocol.myPicture);
			
			myPicture = ImageIO.read(new File("skipTourAction.png"));
			skipTourAction = new ImageIcon(Protocol.myPicture);
			
			myPicture = ImageIO.read(new File("tour1.png"));  // tuto: intro
			tour1 = new ImageIcon(Protocol.myPicture);
			
			myPicture = ImageIO.read(new File("tour2.png"));  // tuto: info and new
			tour2 = new ImageIcon(Protocol.myPicture);
			
			myPicture = ImageIO.read(new File("tour3.png")); // 
			tour3 = new ImageIcon(Protocol.myPicture);
			
			myPicture = ImageIO.read(new File("tour3.png")); // 
			tour3 = new ImageIcon(Protocol.myPicture);
			
			myPicture = ImageIO.read(new File("tour4.png")); // 
			tour4 = new ImageIcon(Protocol.myPicture);
			
			myPicture = ImageIO.read(new File("tour5.png")); // 
			tour5 = new ImageIcon(Protocol.myPicture);
			
			myPicture = ImageIO.read(new File("warning.png")); // 
			warning = new ImageIcon(Protocol.myPicture);
			
			myPicture = ImageIO.read(new File("bugsWarn.png")); // 
			bugsWarn = new ImageIcon(Protocol.myPicture);
			
			myPicture = ImageIO.read(new File("bugsWarnAction.png")); // 
			bugsWarnAction = new ImageIcon(Protocol.myPicture);
			
			
			//for note view
			
			myPicture = ImageIO.read(new File("backButton.png")); // 
			backButton = new ImageIcon(Protocol.myPicture);
			
			myPicture = ImageIO.read(new File("tagButton.png")); // 
			tagButton = new ImageIcon(Protocol.myPicture);
			
			myPicture = ImageIO.read(new File("favButton.png")); // 
			favButton = new ImageIcon(Protocol.myPicture);
			
			myPicture = ImageIO.read(new File("editButton.png")); // 
			editButton = new ImageIcon(Protocol.myPicture);
			
			myPicture = ImageIO.read(new File("saveButton.png")); // 
			saveButton = new ImageIcon(Protocol.myPicture);
			
			myPicture = ImageIO.read(new File("createButton.png")); // 
			createButton = new ImageIcon(Protocol.myPicture);
			
			
			myPicture = ImageIO.read(new File("backButtonAction.png")); // 
			backButtonAction = new ImageIcon(Protocol.myPicture);
			
			myPicture = ImageIO.read(new File("tagButtonAction.png")); // 
			tagButtonAction = new ImageIcon(Protocol.myPicture);
			
			myPicture = ImageIO.read(new File("favButtonAction.png")); // 
			favButtonAction = new ImageIcon(Protocol.myPicture);
			
			myPicture = ImageIO.read(new File("editButtonAction.png")); // 
			editButtonAction = new ImageIcon(Protocol.myPicture);
			
			myPicture = ImageIO.read(new File("saveButtonAction.png")); // 
			saveButtonAction = new ImageIcon(Protocol.myPicture);
			
			myPicture = ImageIO.read(new File("createButtonAction.png")); // 
			createButtonAction = new ImageIcon(Protocol.myPicture);
			
			
			
			
			
			SFFont = Font.createFont(Font.TRUETYPE_FONT, new File("System.ttf")).deriveFont(12f);
             ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("System.ttf")));
            
            SFFontT = Font.createFont(Font.TRUETYPE_FONT, new File("SF.otf")).deriveFont(12f);
            ge1 = GraphicsEnvironment.getLocalGraphicsEnvironment();
           //register the font
           ge1.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("SF.otf")));
           
			
			
			
		
			
			 } catch (IOException e1) {
		         e1.printStackTrace();
		     } catch (FontFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	
}
