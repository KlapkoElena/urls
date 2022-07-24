package urls;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Urls {

    public static ArrayList<String> readAddUrls() throws FileNotFoundException {
        File file = new File("urls");
        Scanner sc = new Scanner(file);

        ArrayList<String> site = new ArrayList<>();
        while (true) {
            assert null != sc;
            if (!sc.hasNextLine()) break;
            site.add(sc.nextLine());
        }
        return site;
    }

    public static void siteNameCutting(ArrayList<String> site) {
        for (int i = 0; i < site.size(); i++) {
            String shortDomain = site.get(i).split("/")[0];
            if (!shortDomain.startsWith("m.")) {
                if (shortDomain.startsWith("www.")) {
                    shortDomain = shortDomain.substring(4);
                }
            } else {
                shortDomain = shortDomain.substring(2);
            }
            site.set(i, shortDomain);
        }
    }

    public static HashMap<String, Integer> calcRepeatDomains(ArrayList<String> site) {
        HashMap<String, Integer> repeatDomains = new HashMap<>();
        for (String s : site) {
            String key = String.valueOf(s);
            if (!repeatDomains.containsKey(key)) {
                repeatDomains.put(key, 1);
            } else {
                int n = repeatDomains.get(key);
                repeatDomains.replace(key, n + 1);
            }
        }
        return repeatDomains;
    }

    public static void show10Urls(HashMap<String, Integer> domainRepeat) {
        System.out.println("10 most repeating domains in a file:");
        ArrayList<Map.Entry<String, Integer>> toSort = new ArrayList<>(domainRepeat.entrySet());
        toSort.sort(HashMap.Entry.<String, Integer>comparingByValue().reversed());
        long limit = 10;
        for (Map.Entry<String, Integer> stringIntegerEntry : toSort) {
            if (0 != limit--) {
                System.out.println(stringIntegerEntry);
            } else {
                break;
            }
        }
    }
}