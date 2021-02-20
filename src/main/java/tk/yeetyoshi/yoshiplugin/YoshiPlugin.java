package tk.yeetyoshi.yoshiplugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class YoshiPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getConsoleSender().sendMessage("[LightFlight] Light Flight has been successfully started up!");
        // Plugin startup logic
        this.getCommand("fly").setExecutor(new CommandFly());

    }

    public class CommandFly implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
            Player player = (Player) sender;
            if (!player.hasPermission("light.flight") || !player.isOp()) {
                player.sendMessage("[LightFlight] You do not have PERMISSION to execute this command!");
            }
            else if (!player.getAllowFlight()) {
                player.setAllowFlight(true);
                player.sendMessage("[LightFlight] Flight has been commenced!");
            }
            else {
                player.setAllowFlight(false);
                player.sendMessage("[LightFlight] Flight has been deactivated!");
            }
            return true;
        }
    }
}
