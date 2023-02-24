import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import duke.TaskList;
import duke.commands.Task;

public class Storage {
    public Storage() {}

    private static String changeTaskDescription(TaskList tasks) {
        String content = "";
        for (int i = 0; i < tasks.size(); i++) {
            Task curtask = tasks.get(i);
            content += (Integer.toString(i) + " | ");
            content += ((curtask.getTaskStatus().equals("X") ? "1" : "0") + " | " + curtask.getTaskDiscription());
            if (!curtask.getClass().getName().equals("commands.Todo")) {
                content += ("| " + tasks.get(i).getDue());
            }
            content += System.lineSeparator();
        }
        return content;
    }

    public static void autoSave() throws IOException {
        File f = new File("./data/duke.txt");
        if (!f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }
        FileWriter fw = new FileWriter("./data/duke.txt");
        fw.write(changeTaskDescription());
        fw.close();
    }
}