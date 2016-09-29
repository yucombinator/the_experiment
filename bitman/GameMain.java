
import java.awt.EventQueue;
import javax.swing.JFrame;

public class GameMain extends JFrame{
	public GameMain()
	{
		initUI();
	}

	private void initUI()
	{
		add(new Board());

		setResizable(false);
		pack();

		setTitle("Bitman");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable(){
			@Override
			public void run()
			{
				GameMain gm = new GameMain();
				gm.setVisible(true);
			}
		});
	}
}