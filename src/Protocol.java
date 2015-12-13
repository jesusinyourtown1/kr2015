import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Protocol {
	
	public static final char NOTE_END ='\n';
	public static final char TAG_END ='\t';
	public static final String TAGS_END ="\tgs";
	public static final String TIME_END ="\tm";
	public static final String USER_END ="\r";
	public static  BufferedImage myPicture;
	
	
	Protocol(){
		try {
			myPicture = ImageIO.read(new File("tag.png"));
			 } catch (IOException e1) {
		         e1.printStackTrace();
		     }
	}
	
	
}
