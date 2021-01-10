import java.util.ArrayList;
import java.util.List;

public class MultiLvLScheduling {
    List<Process> AllProcesses = new ArrayList<>();
    List<String> AllProcessesName = new ArrayList<>();
    List<Integer> AllProcessesBurstTime = new ArrayList<>();
    List<Process> ProcessesQ1 = new ArrayList<>();
    List<Process> ProcessesQ2 = new ArrayList<>();
    List<ProcessEx> processExes = new ArrayList<>();
    int quantumTime;
    int timer = 0;

    public int getQuantumTime() {
        return quantumTime;
    }

    public void setQuantumTime(int quantumTime) {
        this.quantumTime = quantumTime;
    }

    public List<Process> getProcessesQ1() {
        return ProcessesQ1;
    }

    public void setProcessesQ1(List<Process> processesQ) {
        ProcessesQ1 = processesQ;
    }

    public List<Process> getProcessesQ2() {
        return ProcessesQ2;
    }

    public void setProcessesQ2(List<Process> processesQ) {
        ProcessesQ2 = processesQ;
    }

    public void addQ1(Process p) {
        ProcessesQ1.add(p);
        AllProcesses.add(p);
        AllProcessesName.add(p.getName());
        AllProcessesBurstTime.add(p.getBurstTime());
    }

    public void addQ2(Process p) {
        ProcessesQ2.add(p);
        AllProcesses.add(p);
        AllProcessesName.add(p.getName());
        AllProcessesBurstTime.add(p.getBurstTime());
    }

    public void roundRobin() {
        ProcessEx processEx;
        int oldTimer;

        while (ProcessesQ1.size() > 0 && timer + quantumTime >= ProcessesQ1.get(0).ArrivalTime) {

            for (int i = 0; i < ProcessesQ1.size(); i++) {
                oldTimer = 0;

                if (timer >= ProcessesQ1.get(i).ArrivalTime) {

                    ProcessesQ1.get(i).BurstTime -= quantumTime;
                    oldTimer = timer;

                    if (ProcessesQ1.get(i).BurstTime > 0) {
                        timer += quantumTime;
                    } else {
                        timer += ProcessesQ1.get(i).BurstTime + quantumTime;
                    }

                    processEx = new ProcessEx(oldTimer, timer, ProcessesQ1.get(i));
                    processExes.add(processEx);

                    for (int j = 0; j < ProcessesQ1.size(); j++) {
                        if (ProcessesQ1.get(j).BurstTime <= 0) {
                            ProcessesQ1.remove(j);
                        }
                    }
                }
            }

        }

    }

    void FCFS() {
        ProcessEx processEx;

        for (int i = 0; i < ProcessesQ2.size(); i++) {
            if (ProcessesQ1.size() > 0) {
                if (ProcessesQ1.get(0).ArrivalTime <= timer) {
                    break;
                } else {
                    if (timer + ProcessesQ2.get(i).BurstTime >= ProcessesQ1.get(0).ArrivalTime) {
                        ProcessesQ2.get(i).BurstTime -= ProcessesQ1.get(0).ArrivalTime - timer;

                        processEx = new ProcessEx(timer, ProcessesQ1.get(0).ArrivalTime, ProcessesQ2.get(i));
                        processExes.add(processEx);

                        timer = ProcessesQ1.get(0).ArrivalTime;

                    } else {

                        processEx = new ProcessEx(timer, timer + ProcessesQ2.get(i).BurstTime, ProcessesQ2.get(i));
                        processExes.add(processEx);
                        timer += ProcessesQ2.get(i).BurstTime;
                        ProcessesQ2.remove(i);
                    }
                }
            } else {

                processEx = new ProcessEx(timer, timer + ProcessesQ2.get(i).BurstTime, ProcessesQ2.get(i));
                processExes.add(processEx);
                timer += ProcessesQ2.get(i).BurstTime;
                ProcessesQ2.remove(i);

            }
        }

    }


    void run() {

        while (ProcessesQ1.size() != 0 || ProcessesQ2.size() != 0) {
            while (ProcessesQ1.size() != 0 && timer == ProcessesQ1.get(0).ArrivalTime) {
                roundRobin();
            }
            if (ProcessesQ2.size() > 0) {
                FCFS();
            }
        }
    }

    void calcStatistics() {
        String tempName;
        int tempWaiting = 0;
        int tempTurn = 0;


        for (int i = 0; i < AllProcesses.size(); i++) {
            tempName = AllProcesses.get(i).getName();
            for (int j = 0; j < processExes.size(); j++) {
                if (processExes.get(j).p.Name.equalsIgnoreCase(tempName)) {
                    tempWaiting = processExes.get(j).endTime;
                    tempTurn = processExes.get(j).endTime;
                }
            }
            AllProcesses.get(i).waitingTime = tempWaiting;
            AllProcesses.get(i).turnAroundTime = tempTurn;
        }

        for (int i = 0; i < AllProcesses.size(); i++) {
            AllProcesses.get(i).BurstTime = AllProcessesBurstTime.get(i);
        }

        for (int i = 0; i < AllProcesses.size(); i++) {
            AllProcesses.get(i).waitingTime -= AllProcesses.get(i).ArrivalTime;
            AllProcesses.get(i).waitingTime -= AllProcesses.get(i).BurstTime;
            AllProcesses.get(i).turnAroundTime -= AllProcesses.get(i).ArrivalTime;
        }

    }

    void print() {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("                    Gantt Chart");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        for (int i = 0; i < processExes.size(); i++) {
            System.out.println("=====================================================================");
            System.out.println("Process Name: " + processExes.get(i).p.getName());
            System.out.println("Process Start Time: " + processExes.get(i).beginTime);
            System.out.println("Process End Time: " + processExes.get(i).endTime);
            System.out.println("=====================================================================");
        }

        System.out.println();
        System.out.println();
        System.out.println();

        printStatistics();
    }

    void printStatistics() {
        double averageWaiting = 0;
        double averageTurn = 0;
        calcStatistics();

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("                    Processes");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");

        for (int i = 0; i < AllProcesses.size(); i++) {
            System.out.println();
            System.out.println("-------------------------------------------------------------------");
            System.out.println("Process Name: " + AllProcesses.get(i).getName());
            System.out.println("Process waiting Time: " + AllProcesses.get(i).waitingTime);
            System.out.println("Process Turn Around Time: " + AllProcesses.get(i).turnAroundTime);
            System.out.println("-------------------------------------------------------------------");
            averageWaiting += AllProcesses.get(i).waitingTime;
            averageTurn += AllProcesses.get(i).turnAroundTime;
        }

        averageWaiting = (double) averageWaiting / AllProcesses.size();
        averageTurn = (double) averageTurn / AllProcesses.size();

        System.out.println("Average Waiting Time: " + averageWaiting);
        System.out.println("Average Waiting Turn Around Time: " + averageTurn);

    }


}
