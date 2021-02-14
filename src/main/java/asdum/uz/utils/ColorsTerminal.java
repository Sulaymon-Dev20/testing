package asdum.uz.utils;

import lombok.Data;

@Data
public class ColorsTerminal {
    public String ANSI_RESET  = "\u001B[0m";

    public String ANSI_BLACK  = "\u001B[30m";
    public String ANSI_RED    = "\u001B[31m";
    public String ANSI_GREEN  = "\u001B[32m";
    public String ANSI_YELLOW = "\u001B[33m";
    public String ANSI_BLUE   = "\u001B[34m";
    public String ANSI_PURPLE = "\u001B[35m";
    public String ANSI_CYAN   = "\u001B[36m";
    public String ANSI_WHITE  = "\u001B[37m";

    public String ANSI_BRIGHT_BLACK  = "\u001B[90m";
    public String ANSI_BRIGHT_RED    = "\u001B[91m";
    public String ANSI_BRIGHT_GREEN  = "\u001B[92m";
    public String ANSI_BRIGHT_YELLOW = "\u001B[93m";
    public String ANSI_BRIGHT_BLUE   = "\u001B[94m";
    public String ANSI_BRIGHT_PURPLE = "\u001B[95m";
    public String ANSI_BRIGHT_CYAN   = "\u001B[96m";
    public String ANSI_BRIGHT_WHITE  = "\u001B[97m";

    public String ANSI_BG_BLACK  = "\u001B[40m";
    public String ANSI_BG_RED    = "\u001B[41m";
    public String ANSI_BG_GREEN  = "\u001B[42m";
    public String ANSI_BG_YELLOW = "\u001B[43m";
    public String ANSI_BG_BLUE   = "\u001B[44m";
    public String ANSI_BG_PURPLE = "\u001B[45m";
    public String ANSI_BG_CYAN   = "\u001B[46m";
    public String ANSI_BG_WHITE  = "\u001B[47m";

    public String ANSI_BRIGHT_BG_BLACK  = "\u001B[100m";
    public String ANSI_BRIGHT_BG_RED    = "\u001B[101m";
    public String ANSI_BRIGHT_BG_GREEN  = "\u001B[102m";
    public String ANSI_BRIGHT_BG_YELLOW = "\u001B[103m";
    public String ANSI_BRIGHT_BG_BLUE   = "\u001B[104m";
    public String ANSI_BRIGHT_BG_PURPLE = "\u001B[105m";
    public String ANSI_BRIGHT_BG_CYAN   = "\u001B[106m";
    public String ANSI_BRIGHT_BG_WHITE  = "\u001B[107m";

/*    public void main(String[] args) {
        System.out.println(ANSI_BG_BLACK + ANSI_GREEN   +"Hello world");
        System.out.println(ANSI_RESET + "\n  Back to default.\n");

    }*/

    public String GET_ANSI_RESET() {
        return ANSI_RESET;
    }

    public String GET_ANSI_BLACK() {
        return ANSI_BLACK;
    }

    public String GET_ANSI_RED() {
        return ANSI_RED;
    }

    public String GET_ANSI_GREEN() {
        return ANSI_GREEN;
    }

    public String GET_ANSI_YELLOW() {
        return ANSI_YELLOW;
    }

    public String GET_ANSI_BLUE() {
        return ANSI_BLUE;
    }

    public String GET_ANSI_PURPLE() {
        return ANSI_PURPLE;
    }

    public String GET_ANSI_CYAN() {
        return ANSI_CYAN;
    }

    public String GET_ANSI_WHITE() {
        return ANSI_WHITE;
    }

    public String GET_ANSI_BRIGHT_BLACK() {
        return ANSI_BRIGHT_BLACK;
    }

    public String GET_ANSI_BRIGHT_RED() {
        return ANSI_BRIGHT_RED;
    }

    public String GET_ANSI_BRIGHT_GREEN() {
        return ANSI_BRIGHT_GREEN;
    }

    public String GET_ANSI_BRIGHT_YELLOW() {
        return ANSI_BRIGHT_YELLOW;
    }

    public String GET_ANSI_BRIGHT_BLUE() {
        return ANSI_BRIGHT_BLUE;
    }

    public String GET_ANSI_BRIGHT_PURPLE() {
        return ANSI_BRIGHT_PURPLE;
    }

    public String GET_ANSI_BRIGHT_CYAN() {
        return ANSI_BRIGHT_CYAN;
    }

    public String GET_ANSI_BRIGHT_WHITE() {
        return ANSI_BRIGHT_WHITE;
    }

    public String GET_ANSI_BG_BLACK() {
        return ANSI_BG_BLACK;
    }

    public String GET_ANSI_BG_RED() {
        return ANSI_BG_RED;
    }

    public String GET_ANSI_BG_GREEN() {
        return ANSI_BG_GREEN;
    }

    public String GET_ANSI_BG_YELLOW() {
        return ANSI_BG_YELLOW;
    }

    public String GET_ANSI_BG_BLUE() {
        return ANSI_BG_BLUE;
    }

    public String GET_ANSI_BG_PURPLE() {
        return ANSI_BG_PURPLE;
    }

    public String GET_ANSI_BG_CYAN() {
        return ANSI_BG_CYAN;
    }

    public String GET_ANSI_BG_WHITE() {
        return ANSI_BG_WHITE;
    }

    public String GET_ANSI_BRIGHT_BG_BLACK() {
        return ANSI_BRIGHT_BG_BLACK;
    }

    public String GET_ANSI_BRIGHT_BG_RED() {
        return ANSI_BRIGHT_BG_RED;
    }

    public String GET_ANSI_BRIGHT_BG_GREEN() {
        return ANSI_BRIGHT_BG_GREEN;
    }

    public String GET_ANSI_BRIGHT_BG_YELLOW() {
        return ANSI_BRIGHT_BG_YELLOW;
    }

    public String GET_ANSI_BRIGHT_BG_BLUE() {
        return ANSI_BRIGHT_BG_BLUE;
    }

    public String GET_ANSI_BRIGHT_BG_PURPLE() {
        return ANSI_BRIGHT_BG_PURPLE;
    }

    public String GET_ANSI_BRIGHT_BG_CYAN() {
        return ANSI_BRIGHT_BG_CYAN;
    }

    public String GET_ANSI_BRIGHT_BG_WHITE() {
        return ANSI_BRIGHT_BG_WHITE;
    }
}
