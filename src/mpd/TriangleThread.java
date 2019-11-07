package mpd;

import java.util.concurrent.atomic.AtomicLong;

abstract class TriangleThread extends Thread{

  /*
  uses an AtomicLong and a spinloop to try and commit our value to the AtomicLong
   */
  public void report(Long ourValue, AtomicLong externalValue){
    Long localValue = externalValue.get();
      while ((localValue > ourValue) &&
              (!externalValue.compareAndSet(localValue,ourValue))){
        localValue = externalValue.get();
      }
    }
  }

