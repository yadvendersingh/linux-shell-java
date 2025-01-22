package commands;
import entities.State;
import utils.Util;

public class TypeCommand implements Command{
    @Override
    public void execute(State state, String[] args) {
        if(args.length == 1){
            Command command = CommandRegistry.getInstance().getCommand(args[0]);
            if(command != null){
                System.out.println(args[0] + " is a shell " + command.getType());
            }
            else{
                String path = Util.getPath(args[0]);
                if (path != null) {
                    System.out.println(args[0] + " is " + path);
                } else {
                    System.out.println(args[0] + ": not found");
                }
            }
        }
        else{
            System.out.println("type: arguments expected [string]");
        }
    }
}