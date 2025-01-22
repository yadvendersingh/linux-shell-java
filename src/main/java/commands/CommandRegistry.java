package commands;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import entities.CommandConfig;
public class CommandRegistry {
    private static CommandRegistry instance;
    private final Map<String, Command> commandMap = new HashMap<>();

    private CommandRegistry(String jsonFilePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<CommandConfig> commands = objectMapper.readValue(new File(jsonFilePath),
                objectMapper.getTypeFactory().constructCollectionType(List.class, CommandConfig.class));

        // Register commands dynamically
        for (CommandConfig commandConfig : commands) {
            String commandName = commandConfig.getName();
            String className = commandConfig.getClassName();
            try {
                Class<?> clas = Class.forName(className);
                Command command = (Command) clas.getDeclaredConstructor().newInstance();
                commandMap.put(commandName, command);
            } catch (Exception e) {
                throw new RuntimeException("Failed to load command: " + commandName, e);
            }
        }
    }

    public static CommandRegistry getInstance(String jsonFilePath) {
        try {
            if (instance == null) {
                instance = new CommandRegistry(jsonFilePath);
            }
            return instance;
        } catch (IOException e) {
            throw new RuntimeException("Failed to initialize CommandRegistry", e);
        }
    }

    public static CommandRegistry getInstance() {
        if(instance == null){
            throw new RuntimeException("CommandRegistry not initialized");
        }
        return instance;
    }

    public Command getCommand(String name) {
        return commandMap.get(name);
    }
}