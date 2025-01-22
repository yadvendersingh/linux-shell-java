package commands;

import entities.State;

public class EchoCommand implements Command{
    @Override
    public void execute(State state, String[] args) {
        if(args.length >= 1){
            for(int i = 0; i < args.length; i++){
                System.out.print(args[i] + " ");
            }
            System.out.println();
        }
        else{
            System.out.println("echo: arguments expected [string ...]");
        }
    }
}