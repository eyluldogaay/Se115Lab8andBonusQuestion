public class Robot {
    private String modelName;
    private int batteryLevel;
    private String status;
    public Robot(String modelName,int batteryLevel,String status){
        this.modelName=modelName;
        this.batteryLevel=batteryLevel;
        this.status=status;
    }
    public void setModelName(String modelName){
        this.modelName=modelName;
    }
    public void setBatteryLevel(int batteryLevel){
        this.batteryLevel=batteryLevel;

    }
    public void setStatus(String status){
        this.status=status;
    }
    public String getModelName(){
        return modelName;
    }
    public int getBatteryLevel(){
        return batteryLevel;
    }
    public String getStatus(){
        return status;
    }
    public void displayRobotInfo(){
        System.out.println("Model name:"+modelName+" Battery level:"+batteryLevel+" Status:"+status);
    }
    public boolean isBatteryEnough(int requiredAmount){
        if(batteryLevel>=requiredAmount){
            return true;
        }
        else{
            return false;
        }
    }
    public void consumeBattery(int amount){
        batteryLevel-=amount;
    }
    public void chargeBattery(int amount){
        batteryLevel+=amount;
        if(batteryLevel>=100){
            batteryLevel=100;
            status="Active";
        }else{
            status="Charging";
        }
    }
    public void performTask(Task t){
        System.out.println("Robot attempting the task.");
        if (status.equals("Charging")){
            System.out.println("Robot is charging!!!");
        }
        if(!isBatteryEnough(t.getEnergyCost())){
            System.out.println("Task failed! Not enough battery.");
        }
        consumeBattery(t.getEnergyCost());
        System.out.println("Task completed successfully!");
    }
    //BONUS!!!
    public void performTaskBatch(TaskBatch batch){
        Task[] tasks= batch.getTasks();
        if(tasks==null){
            System.out.println("ERROR no tasks in batch!!!");
        }
        int totalCost=batch.getTotalEnergyCost();
         if(!isBatteryEnough(totalCost)){
             System.out.println("ERROR: Not enough battery to process the entire batch!");
         }
         else{
             System.out.println(modelName+" processing entire task");
             for(int i=0;i<tasks.length;i++) {
                 performTask(tasks[i]);
             }
         }
         System.out.println("Batch completed.");
         System.out.println("Updated robot info:");
         displayRobotInfo();

    }


}
