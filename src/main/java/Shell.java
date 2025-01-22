import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import commands.*;
import entities.State;
import utils.Util;

public class Shell{
    public void run() throws IOException{
        Scanner scanner = new Scanner(System.in);
        State state = State.getInstance();
        CommandRegistry commandRegistry = CommandRegistry.getInstance("src/main/resources/builtin_commands.json");
        while(!state.getExitStatus()){
            System.out.print("$ ");
            String input = scanner.nextLine();
            String[] words = input.split(" ");
            String commandName = words[0];
            String[] args = words.length > 1 ? java.util.Arrays.copyOfRange(words, 1, words.length) : new String[0];
            Command command = commandRegistry.getCommand(commandName);
            if(command != null){
                command.execute(state, args);
            }
            else{
                String filepath = Util.getPath(commandName);
                if(filepath != null){
                    try {
                        String executableName = new File(filepath).getName();
                        String fullPath = executableName + input.substring(commandName.length());
                        Process p = Runtime.getRuntime().exec(fullPath.split(" "));
                        p.getInputStream().transferTo(System.out);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    System.out.println(input + ": command not found");
                }
            }
        }
        scanner.close();
    }
}