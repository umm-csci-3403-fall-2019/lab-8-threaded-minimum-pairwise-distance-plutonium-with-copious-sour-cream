package mpd;

import java.util.concurrent.atomic.AtomicLong;

abstract class TriangleThread extends Thread implements Runnable{
  int[] values;
  AtomicLong externalValue;

  public TriangleThread(int[] values, AtomicLong externalValue){
    this.values = values;
    this.externalValue = externalValue;
  }

  /*
  Each class implements it's own traversal of the subtriangle as an override of this method.
   */
  public abstract long findMPD();


  /*
  uses an AtomicLong and a spinloop to try and commit our value to the AtomicLong
   */
  public void updateExternalValue(long ourValue, AtomicLong externalValue){
    long localValue;
    //While loop tries to update external value if the new value is less than the current value in external value
    //if the value in external value is updated in the meantime we get its value again and repeat
      while (((localValue= externalValue.get()) > ourValue) &&
              (!externalValue.compareAndSet(localValue,ourValue)));
    }

  @Override
  public void run() {
    updateExternalValue(findMPD(),externalValue);
  }
  }

