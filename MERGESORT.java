import java.util.Scanner;
class MERGESORT {
	
	static void merge(int arr[],int low,int high,int aux[])
	{
		if(low<high)
		{
			int middle=(low+high)/2;
			merge(arr,low,middle,aux);
			merge(arr,middle+1,high,aux);
			mergesort(arr,low,middle,high,aux);
			
		}
		
		
	}
	
	static void mergesort(int arr[],int low,int middle,int high,int aux[])
	{
		
		for(int m=low;m<=high;m++)
		{
			aux[m]=arr[m];
		}

		
		int i=low;
		int j=middle+1;
		int k=low;
		while(i<=middle && j<=high)
		{
			if(aux[i]>aux[j])
				arr[k++]=aux[j++];
			else arr[k++]=aux[i++];
		}
		while(i<=middle)
		{
			arr[k++]=aux[i++];
		}
		
		while(j<=high)
		{
			arr[k++]=aux[j++];
		}
	}
	
	static void aslisorter(int arr[],int N)
	{
		
		int aux[]=new int[N];
		
		merge(arr,0,N-1,aux);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int N=in.nextInt();
		int arr[]=new int[N];
		for(int i=0;i<N;i++)
		{
			arr[i]=in.nextInt();
		}
		
		aslisorter(arr,N);
		for(int i=0;i<N;i++)
		{
			System.out.print(arr[i]+" ");
		}
	}

}
