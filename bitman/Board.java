import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.KeyEvent;
public class Board extends JPanel implements ActionListener{
	Timer timer;
	Player player;
	ArrayList<Enemy> enemies;
	boolean ingame;
	final int initPlayerX = 40;
	final int initPlayerY = 60;
	final int boardWidth = 400;
	final int boardHeight = 300;
	final int delay = 15;

	Image bkgd;

	private final int[][] enemyPos = {
		{2380, 29}, {2500, 59}, {1380, 89},
        {780, 109}, {580, 139}, {680, 239},
        {790, 259}, {760, 50}, {790, 150},
        {980, 209}, {560, 45}, {510, 70},
        {930, 159}, {590, 80}, {530, 60},
        {940, 59}, {990, 30}, {920, 200},
        {900, 259}, {660, 50}, {540, 90},
        {810, 220}, {860, 20}, {740, 180},
        {820, 128}, {490, 170}, {700, 30}
	};
       public void keyPressed(KeyEvent e)
        {
                int key = e.getKeyCode();

                if(!ingame && e != null)
                        initBoard();
	}
	public Board()
	{
		addKeyListener(new TAdapter());
		setFocusable(true);
	//	setBackground(Color.BLUE);
		bkgd = Toolkit.getDefaultToolkit().createImage("background.jpg");


		initBoard();
	}

	private void initBoard()
	{

		ingame = true;

		setPreferredSize(new Dimension(boardWidth,boardHeight));

		player = new Player(initPlayerX,initPlayerY);

		initEnemies();

		timer = new Timer(delay,this);
		timer.start();
	}

	public void initEnemies()
	{
		enemies = new ArrayList<>();

		for(int[] p : enemyPos)
		{
			enemies.add(new Enemy(p[0],p[1]));
		}
	}

	@Override
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		if(ingame)
			drawObjects(g);
		else
			drawGameOver(g);
		Toolkit.getDefaultToolkit().sync();//dafaq is this for??????#no internet
	}

	private void drawObjects(Graphics g)
	{
		g.drawImage(bkgd,0,0,null);//background
		if(player.isVis())
			g.drawImage(player.getImage(),player.getX(),player.getY(),this);

		ArrayList<Missile> ms = player.getMissiles();

		for(Missile m : ms)
		{
			if(m.isVis())
				g.drawImage(m.getImage(), m.getX(), m.getY(), this);
		}

		for(Enemy a : enemies)
		{
			if(a.isVis())
			{
				g.drawImage(a.getImage(), a.getX(), a.getY(), this);
			}
		}

		g.setColor(Color.BLACK);
		g.drawString("Enemies left: "+enemies.size(), 5, 15);
	}

	private void drawGameOver(Graphics g)
	{
		initBoard();
		String msg = "";
		if(player.isVis())
			msg = "Winner!";
		else
			msg = "Game Over";
		Font small = new Font("Helvetica", Font.BOLD, 14);
		FontMetrics fm = getFontMetrics(small);

		g.setColor(Color.BLACK);
        	g.setFont(small);
        g.drawString(msg, (boardWidth - fm.stringWidth(msg)) / 2, boardHeight / 2);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		inGame();

		updatePlayer();
		updateMissiles();
		updateEnemies();

		checkCollisions();

		repaint();
	}

	private void inGame()
	{
		if(!ingame)
			timer.stop();
	}

	private void updatePlayer()
	{
		if(player.isVis())
			player.move();
	}

	private void updateMissiles()
	{
		ArrayList<Missile> ms = player.getMissiles();

		for(int i=0; i<ms.size(); i++)
		{
			Missile m = ms.get(i);
			
			if(m.isVis())
				m.move();
			else
				ms.remove(i);
		}
	}

	private void updateEnemies()
	{
		if(enemies.isEmpty())
		{
			ingame = false;
			return;
		}

		for(int i=0; i<enemies.size(); i++)
		{
			Enemy enemy = enemies.get(i);
			if(enemy.isVis())
				enemy.move();
			else
				enemies.remove(i);
		}
	}

	public void checkCollisions()
	{
		Rectangle playerRect = player.getBounds();

		for(Enemy enemy : enemies)
		{
			Rectangle enemyRect = enemy.getBounds();

			if(enemyRect.intersects(playerRect))
			{
				player.setVis(false);
				enemy.setVis(false);
				ingame = false;
			}
		}

		ArrayList<Missile> ms = player.getMissiles();
		
		for(Missile missile : ms)
		{
			Rectangle missileRect = missile.getBounds();

			for(Enemy enemy : enemies)
			{
				Rectangle enemyRect = enemy.getBounds();

				if(enemyRect.intersects(missileRect))
				{
					missile.setVis(false);
					enemy.setVis(false);
				}
			}
		}
	}

	private class TAdapter extends KeyAdapter {
		@Override
		public void keyReleased(KeyEvent e){
			player.keyReleased(e);
		}

		@Override
		public void keyPressed(KeyEvent e){
			player.keyPressed(e);
			this.keyPressed(e);
		}
	}

}
