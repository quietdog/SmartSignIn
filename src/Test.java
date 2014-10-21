import java.awt.*;
import java.awt.image.*;

public class Test extends java.applet.Applet {

  public void init()
  {
  	Image image = getImage(getCodeBase(), "Cursor/zoomin.gif");  	
  	MediaTracker mt = new MediaTracker(this);
  	mt.addImage(image, 0);
  	try{
  	 mt.waitForID(0);
  	}catch(Exception e) {}
  	
  	Cursor cursor = createCustomCursor(image, new Point(0,0), "TEST", this);
  	setCursor(cursor); 
  }

private Cursor createCustomCursor(Image cursor, Point hotSpot, String name, ImageObserver ob)  {
    
    Dimension bestCursorSize = Toolkit.getDefaultToolkit().getBestCursorSize(cursor.getWidth(ob), cursor.getHeight(ob) );
        
    BufferedImage bufferedImage = new BufferedImage(
        bestCursorSize.width,
        bestCursorSize.height,
        BufferedImage .TYPE_INT_ARGB
    );
    for(int x=0;x<bestCursorSize.width;x++)
       for(int y=0;y<bestCursorSize.height;y++) 
          bufferedImage .setRGB(x,y,0);
    bufferedImage.getGraphics().drawImage(cursor, 0,0,ob);
    
    return Toolkit.getDefaultToolkit().createCustomCursor(bufferedImage, hotSpot, name);

}
}
