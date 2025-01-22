package commands;
import entities.State;

public class ExitCommand implements Command{
    @Override
    public void execute(State state, String[] args) {
        if(args.length == 0){
            state.setExitStatus(true);
        }
        else{
            System.out.println("exit: invalid arguments");
        }
    }
}