package urls;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<String> site = Urls.readAddUrls();
        Urls.siteNameCutting(site);
        HashMap<String, Integer> repeatDomains = Urls.calcRepeatDomains(site);
        Urls.show10Urls(repeatDomains);
    }
}