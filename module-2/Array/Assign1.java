import java.util.Arrays;
public  class Assign1
{
	public static int max(int... arr)
	{
		int max=Integer.MIN_VALUE;
		for(int i:arr)
		max=i>max?i:max;

		return max;
	}
	
	public static void main(String args[])
	{
		int arr[]={12,23,1,-4,5};
		
		System.out.println("maximum value in given array:"+Arrays.toString(arr)+" is:"+max(arr));
	}
}