public class Process {
    String Name;
    int BurstTime;
    int ArrivalTime;
    int Qnum;
    int waitingTime;
    int turnAroundTime;

    public Process(String s, int a, int b, int p) {
        Name = s;
        ArrivalTime = a;
        BurstTime = b;
    }

    public Process() {
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getTurnAroundTime() {
        return turnAroundTime;
    }

    public void setTurnAroundTime(int turnAroundTime) {
        this.turnAroundTime = turnAroundTime;
    }

    public int getQnum() {
        return Qnum;
    }

    public void setQnum(int Q) {
        this.Qnum = Q;
    }

    public int getArrivalTime() {
        return ArrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        ArrivalTime = arrivalTime;
    }

    public int getBurstTime() {
        return BurstTime;
    }

    public void setBurstTime(int burstTime) {
        BurstTime = burstTime;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


}
