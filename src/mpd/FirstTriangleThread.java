package mpd;

import java.util.concurrent.atomic.AtomicLong;

public class FirstTriangleThread extends TriangleThread implements Runnable{

  public FirstTriangleThread(int[] values, AtomicLong externalValue) {
    super(values, externalValue);
  }

  public Long findMPD(){
    Long best_yet = Long.MAX_VALUE;
    for (int i = 0; i < values.length / 2; i++){
      for (int j = 0; j < i; j++){
        if (Math.abs(values[i] - values[j]) < best_yet){
          best_yet = (long) Math.abs(values[i] - values[j]);
        }
      }
    }
    return best_yet;
  }

}
