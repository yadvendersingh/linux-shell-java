package commands;
import entities.State;

class ClearCommand implements Command {
    @Override
    public void execute(State state, String[] args) {
        try {
            if (System.getProperty("os.name").startsWith("Windows")) {
                // Execute the 'cls' command on Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // ANSI escape code for Unix-based systems
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("clear: Failed to clear the screen - " + e.getMessage());
        }
    }
}
