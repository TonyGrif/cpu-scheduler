package cpuscheduling;

/** Process class to store a process' data. */
public class Process implements Cloneable {

  /** Global counter for the process id number. */
  private static int PID_COUNTER = 1;

  /** The process id number. */
  private final int pid;

  /** The arrival time of this Process. */
  private final int arrivalTime;

  /** The CPU Burst time required of this Process. */
  private int burstTime;

  /** The remaining bursts needed for this Process. */
  private int remainingBurstTime;

  /** The priority of this Process. */
  private int priority;

  /**
   * Multi-integer constructor for the Process.
   *
   * @param enterTime the arrival time for the Process.
   * @param cpuTime the burst time required for this Process.
   * @param prior the priority of this Process.
   */
  public Process(int enterTime, int cpuTime, int prior) {
    this.pid = PID_COUNTER;
    PID_COUNTER++;

    this.arrivalTime = enterTime;

    setBurstTime(cpuTime);
    setPriority(prior);
  }

  /**
   * Array constructor for the Process.
   *
   * @param data the 3-element array of data for the Process.
   */
  public Process(int[] data) {
    this.pid = PID_COUNTER;
    PID_COUNTER++;

    this.arrivalTime = data[0];
    setBurstTime(data[1]);
    setPriority(data[2]);
  }

  /**
   * Get the pid of this Process.
   *
   * @return process id.
   */
  public int getPid() {
    return this.pid;
  }

  /**
   * Get the arrival time of this Process.
   *
   * @return arrival time.
   */
  public int getArrivalTime() {
    return this.arrivalTime;
  }

  /**
   * Get this Process' CPU burst time.
   *
   * @return the burst time.
   */
  public int getBurstTime() {
    return this.burstTime;
  }

  /**
   * Get this Process' remaining CPU burst time.
   *
   * @return the remaining burst time.
   */
  public int getRemainingBurstTime() {
    return this.remainingBurstTime;
  }

  /**
   * Set this Process' CPU burst time.
   *
   * @param time required CPU burst time.
   */
  public void setBurstTime(int time) {
    if (time < 0) {
      time = (time * -1);
    }
    this.burstTime = time;
    this.remainingBurstTime = time;
  }

  /** Decrement the remaining burst time by one. */
  public void decrementRemainingBurst() {
    this.remainingBurstTime--;
  }

  /**
   * Get the priority of this Process.
   *
   * @return priority of this Process.
   */
  public int getPriority() {
    return this.priority;
  }

  /**
   * Set the priority of this Process.
   *
   * @param prior the priority integer.
   */
  public void setPriority(int prior) {
    if (prior < 0) {
      prior = prior * -1;
    }
    this.priority = prior;
  }

  /**
   * Return a string representation of this Process.
   *
   * @return String of Process.
   */
  public String toString() {
    return String.format("%d %d %d %d", getPid(), getArrivalTime(), getBurstTime(), getPriority());
  }

  /**
   * Clone the current process to another.
   *
   * @return cloned process.
   */
  @Override
  public Process clone() {
    try {
      Process clone = (Process) super.clone();
      clone = new Process(this.arrivalTime, this.burstTime, this.priority);
      return clone;
    } catch (CloneNotSupportedException e) {
      throw new AssertionError();
    }
  }
}
