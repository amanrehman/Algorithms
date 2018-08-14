import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/** Class for buffered reading int and double values */
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                    reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}

public class HeapSort {

    static void Max_Heapify(long[] A,int heapsize,int i){       //O(logN)
        int leftchild=2*i+1;
        int rightchild=2*i+2;
        int largest=-1;
        if(leftchild<heapsize && A[leftchild]>A[i])
            largest=leftchild;
        else largest=i;
        if(rightchild<heapsize && A[rightchild]>A[largest])
            largest=rightchild;
        long temp=A[i];
        A[i]=A[largest];
        A[largest]=temp;
        if(i!=largest)
            Max_Heapify(A,heapsize,largest);

    }


    static void buildMaxHeap(long[] A)          //O(N)
    {
        for(int i=A.length/2;i>=0;i--)
        {
            Max_Heapify(A,A.length,i);
        }

    }

    static void heapSort(long A[])              //O(NlogN)
    {   buildMaxHeap(A);
        for(int i=A.length-1;i>0;i--)
        {
            long max=A[0];
            A[0]=A[i];
            A[i]=max;
            Max_Heapify(A,i,0);
        }
    }


    public static void main(String[] args) throws IOException
    {
        Reader.init(System.in);
        int length=Reader.nextInt();
        long arr[]=new long[length];
        for(int i=0;i<length;i++)
        {
            arr[i]=Reader.nextInt();
        }

        heapSort(arr);
        System.out.println();
        for(int i=0;i<length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}
