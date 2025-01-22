package entities;
import java.nio.file.Path;
import java.nio.file.Paths;

public class State {
    private static State instance;
    private Path currentPath;
    private boolean exitStatus;
    
    private State(){
        this.currentPath = Paths.get("").toAbsolutePath().normalize();
        this.exitStatus = false;
    }

    public static State getInstance(){
        if(instance == null){
            instance = new State();
        }
        return instance;
    }

    public Path getCurrentPath(){
        return currentPath;
    }

    public void setCurrentPath(Path path){
        currentPath = path;
    }

    public boolean getExitStatus(){
        return exitStatus;
    }

    public void setExitStatus(boolean status){
        exitStatus = status;
    }
}
