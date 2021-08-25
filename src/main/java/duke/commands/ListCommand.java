package duke.commands;

import duke.tasklist.TaskList;
import duke.ui.Ui;

public class ListCommand extends Command {

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public void execute(TaskList taskList, Ui ui) {
        ui.displayList(taskList);
    }
}