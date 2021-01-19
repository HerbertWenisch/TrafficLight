package TrafficLight;

public class Timer {
    private static long startTime;
    private static long delay;
    private static long currentTime;
  
  Timer(){
    startTime = 0;
    delay = 0;
  }
  
  public static void start(long delay){
    Timer.delay = delay;
    startTime = System.currentTimeMillis();
  }

  public static boolean isFinished(){
    currentTime = System.currentTimeMillis() - startTime;
    return currentTime >= delay;
  }
}
