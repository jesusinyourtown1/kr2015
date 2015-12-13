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
	public static  ImageIcon separ;
	public static  ImageIcon info;
	public static  ImageIcon neww;
	public static  ImageIcon empty;
	
	//Fonts
	
	 private GraphicsEnvironment ge;
	 private GraphicsEnvironment ge1;
	 public static Font SFFont;
	 public static Font SFFontT;
	 
	 
	 //Colors
	 
	 public static Color nbColor= new Color(242, 242,242);
	 public static Color accentColor= new Color(246,177,0);
	 
	 
	 
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
