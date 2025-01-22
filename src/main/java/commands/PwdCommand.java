package commands;
import entities.State;

public class PwdCommand implements Command{
    @Override
    public void execute(State state, String[] args) {
        if(args.length == 0){
            System.out.println(state.getCurrentPath());
        }
        else{
            System.out.println("pwd: no arguments expected");
        }
    }
}