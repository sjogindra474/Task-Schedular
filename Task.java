package taskscheduler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.management.Notification;
public class Task {
        private String  title;
        private Date duedate;
         private Priority priority;

         public Task(String title, Date duDate, Priority priority) {
          this.title= title;
          this.dueDate = dueDate;
          this.priority = priority
         }

         public String getTitle() {
          return title;
         }

         public Date getDueDate() {
          return duedate;
         }

         public Priority gePriority() {
          return priority;
         }
}

enum Priority{
 LOW,
 MEDIUM,
 HIGH
}

class TaskManager {
   private List<Task> task;

   public TaskManager() {
    this.tasks= new ArrayList<>();
   }

   public void addTask(Task task) {
       tasks.add(task);
   }

   public List<Task> getTasks() {
      return tasks
   }
}

class NotificationService {
  public void sendNotification(String message) {
          System.out.println("Notifiaction: " + message);
  }
}

public class TaskschedularApp () {
   public static void main(String[] args) {
       TaskManager taskManager = new TaskManager();
       NotificationService notificationService = new NotificationService();

       //  add some sample tasks
       taskManager.addTask(new Task("Task 1", new Date(), Priority.MEDIUM));
        taskManager.addTask(new Task("Task 1", new Date(), Priority.HIGH));
         taskManager.addTask(new Task("Task 1", new Date(), Priority.LOW));

         // Schedule notification for tasks
         Timer timer = new Timer();
         for(Task task : taskManager.getTasks()) {
          timer.schedule(new  TimerTask()) {
          public void run(){
                    notificationService.sendNotification("Due date for task "  + task.getTitle() + " reached.");
          }
          task.getDueDate());
          }
         }

         try {
          Thread.sleep(5000);
         }catch (InterruptedException e){
          e.printStackTrace();
         }
   }
}
