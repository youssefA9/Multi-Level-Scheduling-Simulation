import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        MultiLvLScheduling p = new MultiLvLScheduling();
        int NumOfProcesses = 0;
        Process newProcess;
        Scanner s = new Scanner(System.in);
        Scanner m = new Scanner(System.in);
        System.out.println("============== PRIORITY SCHEDULING ==============");
        System.out.println("Enter number of processes..");
        NumOfProcesses = s.nextInt();
        List<Process> prs = new ArrayList<>();
        for (int i = 0; i < NumOfProcesses; i++) {
            newProcess = new Process();
            System.out.println("Enter name of process " + (i + 1) + " : ..");
            newProcess.setName(m.nextLine());
            System.out.println("Enter arrival time of process " + (i + 1) + " : ..");
            newProcess.setArrivalTime(s.nextInt());
            System.out.println("Enter burst time of process " + (i + 1) + " : ..");
            newProcess.setBurstTime(s.nextInt());
            System.out.println("Enter priority of process " + (i + 1) + " : ..");
            newProcess.setPriority(s.nextInt());
            prs.add(newProcess);
        }


        p.setProcesses(prs);
        p.run();
        p.print();


    }
}
