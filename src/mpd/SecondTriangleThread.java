package mpd;

import java.util.concurrent.atomic.AtomicLong;

public class SecondTriangleThread extends TriangleThread implements Runnable{

  public SecondTriangleThread(int[] values, AtomicLong externalValue) {
    super(values, externalValue);
  }

  public long findMPD(){
    long best_yet = Long.MAX_VALUE;
    for (int j = 0; j < values.length / 2; j++){
      for (int i = values.length / 2; i <= j + values.length / 2; i++){
        best_yet=Math.min(Math.abs((long)values[i] - values[j]),best_yet);
      }
    }
    return best_yet;
  }

}
