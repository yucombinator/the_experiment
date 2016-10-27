import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Sprite{
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected boolean vis;
	protected Image image;

	public Sprite(int x, int y)
	{
		this.x = x;
		this.y = y;
		vis = true;
	}

	protected void getImageDimensions(){
		width = image.getWidth(null);
		height = image.getHeight(null);
	}

	protected void loadImage(String imageName){
		ImageIcon ii = new ImageIcon(imageName);
		image = ii.getImage();
	}

	public Image getImage()
	{
		return image;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public boolean isVis()
	{
		return vis;
	}

	public void setVis(Boolean visible)
	{
		vis = visible;
	}

	public Rectangle getBounds()
	{
		return new Rectangle(x,y,width,height);
	}
}