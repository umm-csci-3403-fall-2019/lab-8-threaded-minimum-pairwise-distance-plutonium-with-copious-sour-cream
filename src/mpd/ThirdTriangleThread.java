package mpd;

import java.util.concurrent.atomic.AtomicLong;

public class ThirdTriangleThread extends TriangleThread implements Runnable{

  public ThirdTriangleThread(int[] values, AtomicLong externalValue) {
    super(values, externalValue);
  }

  public long findMPD(){
    long best_yet = Long.MAX_VALUE;
    for (int i = values.length / 2; i < values.length; i++){
      for (int j = 0; j < i - values.length / 2; j++){
        if (Math.abs(values[i] - values[j]) < best_yet){
          best_yet = (long) Math.abs(values[i] - values[j]);
        }
      }
    }
    return best_yet;
  }

}
