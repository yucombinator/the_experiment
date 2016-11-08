public class ModulusAnimationSymbols
{
	public static void main( String[] args ) throws Exception
	{
		int repeats = 5;
		int steps_per_second = 10;

		for ( int i=0; i<repeats*11 ; i++ )
		{
			if ( i%11 == 0 )
				System.out.print(" ._|_..... \r");
			else if ( i%11 == 1 )
				System.out.print(" .._|_.... \r");
			else if ( i%11 == 2 )
				System.out.print(" ..._|_... \r");
			else if ( i%11 == 3 )
				System.out.print(" ...._|_.. \r");
			else if ( i%11 == 4 )
				System.out.print(" ....._|_. \r");
			else if ( i%11 == 5 )
				System.out.print(" ......_|_ \r");
			else if ( i%11 == 6 )
				System.out.print(" ......._| \r");
			else if ( i%11 == 7 )
				System.out.print(" o.......o \r");
			else if ( i%11 == 8 )
				System.out.print(" |_....... \r");
			else if ( i%11 == 9 )
				System.out.print(" _|_...... \r");
			else if ( i%11 == 10 )
				System.out.print(" ._|_..... \r");

			Thread.sleep(1000/steps_per_second);
		}
		
	}
}
