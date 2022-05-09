import java.util.Scanner;
import static java.lang.System.exit;
public class Ring {
	static int n,f=0,r=1,maxi,coord,ch;
	static int[][] cq;
	public static void main(String[] args)
	{
		int a=1;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the total number of processes: ");
		coord = n = scanner.nextInt();
		cq = new int[n+1][n+1];
		for(int i=1;i<=n;i++)
		{
			System.out.println("Enter the process id: ");
			cq[i][0] = scanner.nextInt();
			System.out.println("Enter the state: ");
			cq[i][1] = scanner.nextInt();
			
		}
		display();
		while(a==1)
		{
			System.out.print("\n1.Election\n2.Quit");
			System.out.print("Enter Choice");
			ch = scanner.nextInt();
			switch(ch)
			{
			case 1:
				if(cq[coord][1]==1)
					System.out.println("No need to start election");
				else
				{
					System.out.println("Enter process id to start election");
					int x = scanner.nextInt();
					while(cq[x][1]==0)
					{
						System.out.println("Process"+x+"is crash and cannot start election\nEnter another process id");
						x=scanner.nextInt();
					}
					dis(x);
				}
				break;
				
			case 2:
				exit(0);
				break;
			}
			System.out.print("\nDo you want to continue:");
			a=scanner.nextInt();
		}
	}
	public static void display()
	{
		System.out.print("Process :");
		for(int i=1;i<=n;i++)
		{
			System.out.print("P"+i+"\t|");
			
		}
		System.out.print("\nID: ");
		for(int i=1;i<=n;i++)
		{
			System.out.print(cq[i][0]+"\t");
			
		}
		System.out.print("\nStatus: ");
		for(int i=1;i<=n;i++)
		{
			System.out.print(cq[i][1]+"\t");
			
		}
	}
	
	public static void dis(int x)
	{
		r=x-1;
		f=x;
		for(int i=f;i<=n;i++)
		{
			if(cq[i][1]!=0)
			{
				System.out.print(cq[i][0]);
				if(i!=n-1)
					System.out.print("->");
				maxi = Math.max(maxi, cq[i][0]);
				
			}
		}
		if(r!=0)
			System.out.print("->");
		for(int i=1;i<=r;i++)
		{
			if(cq[i][1]!=0)
			{
				System.out.print(cq[i][0]);
				if(i!=n-1)
					System.out.print("->");
				maxi = Math.max(maxi, cq[i][0]);
				
			}
		}
		System.out.print("Max Coordinator is: "+maxi);
	}
}
