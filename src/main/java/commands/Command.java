package commands;

import entities.State;
public interface Command{
    void execute(State state, String[] args);
    
    default String getType(){
        return "builtin";
    };
}