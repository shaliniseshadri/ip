import exceptions.RepeatedTaskException;
import task.Task;

public class AddCommand extends Command {
    Task task;
    public AddCommand(Task task) {
        this.task = task;
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(TaskList taskList, Ui ui){
        if (taskList.containsTask(task)) {
            throw new RepeatedTaskException();
        } else {
            taskList.add(task);
            ui.displayAdd(task, taskList);
        }
    }
}
