package commands;

import exceptions.LackOfTaskDetail;

public class Event extends Task {
    private String due;

    private static boolean containTime(String s) {
        boolean haveContent = false;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                haveContent = true;
                break;
            }
        }

        return haveContent;
    }

    public Event(String discription, String due) throws LackOfTaskDetail {
        super(discription);
        if (due.equals("") || !containTime(due)) {
            throw new LackOfTaskDetail("No time information!");
        }
        this.due = due;
    }

    public String toString() {
        return "[E]" + super.toString() + " (" + due + ")";
    }
}