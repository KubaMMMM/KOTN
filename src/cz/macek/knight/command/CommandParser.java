package cz.macek.knight.command;

import java.util.HashMap;
import java.util.Map;

public class CommandParser {

    private Map<String, Command> commands = new HashMap<>();

    public CommandParser() {
        commands.put("jdi", new Jdi());
        commands.put("inventar", new Inventar());
        commands.put("vezmi", new Vezmi());
        commands.put("pouzij", new Pouzij());
        commands.put("odemkni", new Odemknout());
        commands.put("prozkoumej", new Prozkoumej());
        commands.put("pomoc", new Pomoc());
        commands.put("konec", new Konec());
    }

    public Command getCommand(String name) {
        return commands.get(name);
    }
}