public class CubbyHole{

  private int contents;
  private boolean available = false;

  public synchronized int get() {
    while (available == false) {
      try {
        wait();
      } catch (InterruptedException e) { }
    }
      System.out.println("Consumidor #"+" obtiene:"+contents);
    available = false;
    notifyAll();
    return contents;
  }
  public synchronized void put(int value) {
    while (available == true) {
      try {
        wait();
      } catch (InterruptedException e) { }
    }
    contents = value;
      System.out.println("Productor #"  + "pone:" + contents);

    available = true;
    notifyAll();
  }
}
