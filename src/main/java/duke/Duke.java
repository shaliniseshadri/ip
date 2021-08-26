package duke;

import duke.commands.*;
import duke.exceptions.*;
import duke.parser.*;
import duke.storage.Storage;
import duke.tasklist.TaskList;
import duke.ui.Ui;

/**
 * The Duke class is the main class which starts the running of the chatbot
 */
public class Duke {

    private TaskList taskList;
    private Ui ui;
    private Storage storage;
    private String filePath = "./data/duke.txt";
    private String folderPath = "./data";

    /**
     * A public constructor which initialises the ui, storage and tasklist before the chatbot runs
     */
    public Duke() {
        ui = new Ui();
        storage = new Storage(filePath, folderPath);
        taskList = new TaskList();
        try {
            storage.readTasks(taskList);
        } catch (DukeException ex) {
            ui.displayLoadingError(ex);
            taskList = new TaskList();
        }
    }

    /**
     * The run method starts the reading of the commands and the execution of the instructions
     */
    public void run() {
        ui.init();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.read();
                ui.displayLine();
                Command c = Parser.parse(fullCommand, taskList);
                c.execute(taskList, ui);
                storage.saveTasks(taskList);
                isExit = c.isExit();
            } catch (DukeException ex) {
                ui.displayError(ex.getMessage());
            } finally {
                ui.displayLine();
            }
        }
    }

    public static void main(String[] args) {
        new Duke().run();
    }
}