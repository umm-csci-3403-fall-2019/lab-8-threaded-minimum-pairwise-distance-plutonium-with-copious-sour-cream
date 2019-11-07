package mpd;

import java.util.concurrent.atomic.AtomicLong;

public class SecondTriangleThread extends TriangleThread implements Runnable{
  int[] values;
  AtomicLong externalValue;

  public SecondTriangleThread(int[] values, AtomicLong externalValue){
    this.values = values;
    this.externalValue = externalValue;
  }

  public Long findMPD(){
    Long best_yet = Long.MAX_VALUE;
    for (int j = 0; j < values.length / 2; j++){
      for (int i = values.length / 2; i <= j + values.length / 2; i++){
        if (Math.abs(values[i] - values[j]) < best_yet){
          best_yet = (long) Math.abs(values[i] - values[j]);
        }
      }
    }
    return best_yet;
  }

  @Override
  public void run() {
    report(findMPD(),externalValue);
  }
}