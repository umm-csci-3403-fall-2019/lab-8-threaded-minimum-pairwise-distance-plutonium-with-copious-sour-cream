package mpd;

import java.util.concurrent.atomic.AtomicLong;

abstract class TriangleThread extends Thread implements Runnable{
  int[] values;
  AtomicLong externalValue;

  public TriangleThread(int[] values, AtomicLong externalValue){
    this.values = values;
    this.externalValue = externalValue;
  }

  public abstract long findMPD();
  /*
  uses an AtomicLong and a spinloop to try and commit our value to the AtomicLong
   */
  public void report(long ourValue, AtomicLong externalValue){
    long localValue = externalValue.get();
      while ((localValue > ourValue) &&
              (!externalValue.compareAndSet(localValue,ourValue))){
        localValue = externalValue.get();
      }
    }

  @Override
  public void run() {
    report(findMPD(),externalValue);
  }
  }

