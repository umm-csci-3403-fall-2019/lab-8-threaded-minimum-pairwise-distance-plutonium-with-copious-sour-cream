package mpd;

import java.util.concurrent.atomic.AtomicLong;

public class ThreadedMinimumPairwiseDistance implements MinimumPairwiseDistance {

    @Override
    public long minimumPairwiseDistance(int[] values) {
        TriangleThread[] threads = new TriangleThread[4];
        AtomicLong best_yet = new AtomicLong(Long.MAX_VALUE);

        //for each thread, assign it a triangle
        threads[0] = new FirstTriangleThread(values,best_yet);
        threads[1] = new SecondTriangleThread(values,best_yet);
        threads[2] = new ThirdTriangleThread(values,best_yet);
        threads[3] = new FourthTriangleThread(values,best_yet);
        for (TriangleThread thread:threads){
          thread.start();
        }

        try {
          //wait for them all to join
          for (Thread thread : threads) {
            thread.join();
          }
        } catch (InterruptedException ex){
          System.err.println(ex);
        }
        return  best_yet.get();
    }

}
