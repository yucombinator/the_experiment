

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Player extends Sprite{
	private int dx;
	private int dy;
	private ArrayList<Missile> missiles;

	public Player(int x, int y)
	{
		super(x,y);

		initPlayer();
	}

	private void initPlayer()
	{
		missiles = new ArrayList<>();
		loadImage("bitman.png");
		getImageDimensions();
	}

	public void move()
	{
		x += dx;
		y += dy;

		if(x < 1)
			x = 1;
		if(y < 1)
			y = 1;
		if(y > 278)
			y = 278;
	}

	public ArrayList getMissiles()
	{
		return missiles;
	}

	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();

		if(key == KeyEvent.VK_SPACE)
			shoot();
		
		if(key == KeyEvent.VK_LEFT)
			dx = -2;
		else if(key == KeyEvent.VK_RIGHT)
			dx = 2;
		
		if(key == KeyEvent.VK_UP)
			dy = -2;
		else if(key == KeyEvent.VK_DOWN)
			dy = 2;
	}

	public void shoot()
	{
		if(missiles.size() < 2)
			missiles.add(new Missile(x + width,y + height/2));
	}

	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();

		if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT)
			dx = 0 ;
		if(key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN)
			dy = 0;
	}
}
