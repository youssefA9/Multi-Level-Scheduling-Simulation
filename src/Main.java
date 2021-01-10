import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        MultiLvLScheduling p = new MultiLvLScheduling();
        int qNum = 0;
        int NumOfProcesses = 0;
        Process newProcess;

        Scanner s = new Scanner(System.in);
        Scanner m = new Scanner(System.in);


        System.out.println("============== Multi Level Scheduling ==============");
        System.out.print("Enter the Quantum Time: ");
        qNum = s.nextInt();
        p.setQuantumTime(qNum);

        System.out.println("Enter number of processes..");
        NumOfProcesses = s.nextInt();

        for (int i = 0; i < NumOfProcesses; i++) {

            newProcess = new Process();

            System.out.println("Enter name of process " + (i + 1) + " : ..");
            newProcess.setName(m.nextLine());
            System.out.println("Enter arrival time of process " + (i + 1) + " : ..");
            newProcess.setArrivalTime(s.nextInt());
            System.out.println("Enter burst time of process " + (i + 1) + " : ..");
            newProcess.setBurstTime(s.nextInt());
            System.out.println("Enter Queue Number: ..");
            newProcess.setQnum(s.nextInt());

            if (newProcess.getQnum() == 1) {
                p.addQ1(newProcess);
            } else if (newProcess.getQnum() == 2) {
                p.addQ2(newProcess);
            }

        }


        p.run();
        p.print();

    }
}
