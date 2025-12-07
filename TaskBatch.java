
public class TaskBatch {
    private Task[] tasks;
    private int taskCount;
    public TaskBatch(){
        tasks=new Task[5];
        taskCount=0;
    }
    public void addTask(Task t){
        if(taskCount<5){
            tasks[taskCount]=t;
            taskCount++;
            System.out.println("Task added:"+ t.getTaskName());
        }
        else{
            System.out.println("Can not add more!!!");
        }
    }
    public int getTotalEnergyCost(){
        int total=0;
        if (taskCount==0){
            System.out.println("ERROR: No taks in batch!");
            return 0;
        }
        else{
            for(int i=0;i<taskCount;i++){
                total+=tasks[i].getEnergyCost();

            }
            return total;
        }
    }
    public Task[] getTasks(){
        if (taskCount==0){
            System.out.println("ERROR: NO tasks in batch!");
            return null;
        }
        Task[] results=new Task[taskCount];
        for(int i=0;i<taskCount;i++){
            results[i]=tasks[i];
        }
        return results;
    }
    public void printBatchInfo(){
        if(taskCount==0){
            System.out.println("ERROR: NO tasks in batch!");
        }
        System.out.println("Tasks in batch: ");
        for(int i=0;i<taskCount;i++){
            System.out.println("Name :"+tasks[i].getTaskName()+ " Energy cost:"+tasks[i].getEnergyCost());
        }
    }




}

