
public class Assign6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i=1,j=0,nextNum=1;
		while(nextNum<=10)
		{
			for(j=1;j<=4;j++)
			{
				if(j<=i) 
					System.out.print(nextNum+++" ");
				else
					System.out.print(" ");
				
			}
			System.out.println();
			i++;
		}
	}

}
