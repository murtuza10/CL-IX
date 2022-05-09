
public class Bully {
	static int num_proc = 6;
	static boolean[] state;
	public static void elect(int proc_id)
	{
		int temp_coord= proc_id;
		for(int i=proc_id;i<=num_proc;i++)
		{
			for(int j=i+1;j<=num_proc;j++)
			{
				if(state[i]==true)
					System.out.println("Msg sent from "+ i + "to" + j);
				
			}
			for(int j=i+1;j<=num_proc;j++)
			{
				if(state[j]==true&&state[i]==true)
				{
					System.out.println("OK sent from" + j + "to "+ i);
					temp_coord = j;
				}
			}
		}
		System.out.println("Coordinator is: "+ temp_coord);
	}
	
	public static void bringUp(int proc_id)
	{
		state[proc_id] = true;
		elect(proc_id);
	}
	public static void bringDown(int proc_id)
	{
		state[proc_id] = false;
	}
	
	public static void main(String[] args)
	{
		System.out.println("Number of processes are: " + num_proc);
		state = new boolean[num_proc+1];
		for(int i=1;i<=num_proc;i++)
		{
			state[i] = true;
		}
		System.out.println("6 active processes are up");
		System.out.println("Process up = P1 P2 P3 P4 P5 P6");
		System.out.println("Process 6 is coordinator");
		bringDown(6);
		bringDown(5);
		elect(2);
		bringUp(6);
		bringUp(5);
		
	}

}
