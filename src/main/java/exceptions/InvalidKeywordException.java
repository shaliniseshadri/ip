package exceptions;

public class InvalidKeywordException extends DukeException {

    public InvalidKeywordException() {
        super("Sorry, I don't know what that means. " +
                "\nPlease use the keywords:" +
                "\n'todo', 'deadline' or 'event' to create a new task" +
                "\n'list' to view all the existing tasks" +
                "\n'tasks_on' to view all tasks on a given date" +
                "\n'done' to mark a task as complete" +
                "\n'delete' to remove a task from the list" +
                "\n'bye' to exit");
    }

}
