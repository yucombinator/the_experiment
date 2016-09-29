

public class Missile extends Sprite{
	private final int boardWidth = 400;
	private final int missileSpeed = 4;

	public Missile(int x, int y){
		super(x,y);
		initMissile();
	}

	private void initMissile()
	{
		loadImage("batarang.png");
		getImageDimensions();
	}

	public void move()
	{
		x += missileSpeed;
		if(x > boardWidth)
			vis = false;
	}
}