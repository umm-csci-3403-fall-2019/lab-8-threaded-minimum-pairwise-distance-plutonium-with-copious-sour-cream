package mpd;

import java.util.concurrent.atomic.AtomicLong;

public class FirstTriangleThread extends TriangleThread implements Runnable{

  public FirstTriangleThread(int[] values, AtomicLong externalValue) {
    super(values, externalValue);
  }

  public long findMPD(){
    long best_yet = Long.MAX_VALUE;
    for (int i = 0; i < values.length / 2; i++){
      for (int j = 0; j < i; j++){
        best_yet=Math.min(Math.abs((long)values[i] - values[j]),best_yet);
      }
    }
    return best_yet;
  }

}
