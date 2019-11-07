package mpd;

import java.util.concurrent.atomic.AtomicLong;

public class FourthTriangleThread extends TriangleThread implements Runnable{

  public FourthTriangleThread(int[] values, AtomicLong externalValue) {
    super(values, externalValue);
  }

  public Long findMPD(){
    Long best_yet = Long.MAX_VALUE;
    for (int i = values.length / 2; i < values.length; i++){
      for (int j = values.length / 2; j < i; j++){
        if (Math.abs(values[i] - values[j]) < best_yet){
          best_yet = (long) Math.abs(values[i] - values[j]);
        }
      }
    }
    return best_yet;
  }

}
