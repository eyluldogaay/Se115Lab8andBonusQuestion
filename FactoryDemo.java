import java.util.Scanner;
public class FactoryDemo {
    public static void main(String[] args){
        Robot r1=new Robot("Niko",100,"Active");
        Robot r2=new Robot("Elon",100,"Active");
        r1.displayRobotInfo();
        r2.displayRobotInfo();
        Scanner sc=new Scanner(System.in);
        System.out.println("Amount of battery consume:");
        int consume= sc.nextInt();
        r1.consumeBattery(consume);
        Task t1=new Task("Task1",10);
        System.out.println(r2.getModelName()+" will be success or not:");
        System.out.println(r2.isBatteryEnough(t1.getEnergyCost()));
        Robot r3=new Robot("Dobby",100,"Active");
        System.out.println("Task Description:");
        t1.describeTask();
        System.out.println("Robot info before task:");
        r3.displayRobotInfo();
        System.out.println("Processing task..");
        r3.performTask(t1);
        System.out.println("Robot info after task:");
        r3.displayRobotInfo();
        Task t2=new Task("Task2",21);
        Task t3=new Task("Task3",32);
        Task t4=new Task("Task 4",11);
        TaskBatch tb=new TaskBatch();
        tb.addTask(t2);
        tb.addTask(t3);
        tb.addTask(t4);
        System.out.println("The information is:");
        tb.printBatchInfo();
        System.out.println("Total energy cost:");
        System.out.println(tb.getTotalEnergyCost());
        //BONUS!!!
        System.out.println("Robot battery before processing batch " +r3.getBatteryLevel());
        r3.performTaskBatch(tb);
        System.out.println("Robot battery after processing batch " +r3.getBatteryLevel());


    }
}
