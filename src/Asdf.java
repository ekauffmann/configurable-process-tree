import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Asdf {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("([A-Z0-9]+)(\\[.*\\])?");
        Matcher m = p.matcher("TAU[]");
        m.matches();
    }
}
