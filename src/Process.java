public class Process {
    String Name;
    int BurstTime;
    int Priority;
    int ArrivalTime;

    public Process(String s, int a, int b, int p) {
        Name = s;
        ArrivalTime = a;
        BurstTime = b;
        Priority = p;
    }

    public Process() {
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

    public int getPriority() {
        return Priority;
    }

    public String getName() {
        return Name;
    }


    public void setBurstTime(int burstTime) {
        BurstTime = burstTime;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPriority(int priority) {
        Priority = priority;
    }

}
