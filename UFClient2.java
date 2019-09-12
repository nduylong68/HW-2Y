/**
 * Created by CCNE on 12/09/2019.
 */

import edu.princeton.cs.algs4.*;

public class UFClient2 {

    private int[] id;

    public UFClient2(int N){
        id = new int[N];
        for (int i = 0; i < N; i++)
        {
            id[i] = i;
        }
    }

    public int root(int p)
    {
        while(p != id[p])
        {
            p = id[id[p]];
        }
        return p;
    }

    public int size(int p)
    {
        int count = 0;
        while ( p != root(p) )
        {
            p = id[p];
            count +=1;
        }
        return count;
    }


    public void union(int p, int q)
    {
        int rp = root(p);
        int rq = root(q);
        if(rp != rq)
        {
            if(size(p) < size(q))
            {
                id[rp] = id[rq];
            }
            else id[rq] = id[rp];
        }

    }

    public boolean allconnected()
    {
        int checkroot = root(id[0]);
        for(int i = 1; i < id.length; i++)
        {
            if (root(id[i]) != checkroot) return false;
        }
        return true;
    }

    public static  void  main(String[] args)
    {
        int N = StdIn.readInt();
        UFClient2 list = new UFClient2(N);
        int count = 0;
        int Step = StdIn.readInt();
            while (!list.allconnected() && count < Step) {
                count++;
                int p = StdIn.readInt();
                int q = StdIn.readInt();
                list.union(p, q);
            }
        if (!list.allconnected())
        {
            System.out.println("FAILED");
        }
        else System.out.println(count);
    }

}


