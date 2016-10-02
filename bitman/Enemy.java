import javax.swing.Timer;
import java.awt.event.*;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Enemy extends Sprite{
	private final int initialX= 400;
	
	final int delay = 15;
	int mouthState = 0;
	boolean mouthOpening = false;
	public Enemy(int x,int y)
	{
		super(x,y);
		initEnemy();
	}

	private void initEnemy()
	{
		loadImage("teeth0.png");
		getImageDimensions();
	}

	@Override
	public Image getImage()
	{
		if(mouthOpening == false)
		{
			switch(mouthState)
			{	
				case 0:
					loadImage("teeth1.png");
					mouthState = 1;
					break;
				case 1:
					loadImage("teeth2.png");
					mouthState = 2;
					mouthOpening = true;
					break;
			}
		}
		else
		{
			switch(mouthState)
			{
				case 2:
					loadImage("teeth1.png");
					mouthState = 1;
					break;
				case 1:
					loadImage("teeth0.png");
					mouthState = 0;
					mouthOpening = false;
					break;
			}
		}
	//	getImageDimensions();
		return image;
	}
	public void move()
	{
		if(x < -20)
		{
			x = initialX;
		}

		x = x-1;
	}
}