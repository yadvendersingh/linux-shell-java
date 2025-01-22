package commands;
import java.nio.file.Files;
import java.nio.file.Path;
import entities.State;
import utils.Util;

public class CdCommand implements Command{
    @Override
    public void execute(State state, String[] args) {
        if(args.length == 1){
            // if the argument starts with a dot, then it is a relative path
            if (args[0].equals("~")){
                state.setCurrentPath(Path.of(Util.getHome()).toAbsolutePath().normalize());
            }
            else if(args[0].startsWith(".")){
            state.setCurrentPath(state.getCurrentPath().resolve(args[0]).toAbsolutePath().normalize());
            }
            // if the argument is a directory, then it is an absolute path
            else if (Files.isDirectory(Path.of(args[0]))) {
            state.setCurrentPath(Path.of(args[0]).toAbsolutePath().normalize());
            }
            else {
            System.out.printf("cd: %s: No such file or directory%n", args[0]);
            }
        }
        else{
            System.out.println("cd: one argument expected [string]");
        }
    }
}