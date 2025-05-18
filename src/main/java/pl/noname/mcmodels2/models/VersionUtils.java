package pl.noname.mcmodels2.models;

import org.bukkit.Server;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VersionUtils {
    public static String getMinecraftVersion(Server server) {
        String version = server.getVersion();
        Pattern pattern = Pattern.compile("\\(MC: ([^)]+)\\)");
        Matcher matcher = pattern.matcher(version);
        if (matcher.find()) {
            return matcher.group(1); // np. "1.20.4"
        }
        return "unknown";
    }
    public static boolean isAtLeastVersion(String current, String required) {
        String[] cur = current.split("\\.");
        String[] req = required.split("\\.");

        for (int i = 0; i < Math.max(cur.length, req.length); i++) {
            int curPart = i < cur.length ? Integer.parseInt(cur[i]) : 0;
            int reqPart = i < req.length ? Integer.parseInt(req[i]) : 0;
            if (curPart < reqPart) return false;
            if (curPart > reqPart) return true;
        }
        return true;
    }
}
