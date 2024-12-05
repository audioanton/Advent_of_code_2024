package day_5.part_2;

import java.util.*;

public class UpdateValidator {

    public List<String> sortUpdate(List<String> incorrectUpdate, List<String> rules) {
        System.out.println(incorrectUpdate);
        List<String> sortedUpdate = incorrectUpdate;

        for (int i = 0; i < incorrectUpdate.size()-1; i++) {
            int steps = 1;
            while (!validateUpdate(sortedUpdate, rules)) {
                if (i + steps > incorrectUpdate.size())
                    steps = -1;

                //oändlig loop
                String order = incorrectUpdate.get(i) + incorrectUpdate.get(i + steps);
                int res = Collections.binarySearch(rules, order);
                if (res >= 0) {
                    String first = sortedUpdate.get(i);
                    String second = sortedUpdate.get(i + steps);
                    sortedUpdate.set(i, second);
                    sortedUpdate.set(i + steps, first);
                }
            }
        }
        System.out.println("\n");
        System.out.println(sortedUpdate);
        return sortedUpdate;
    }



    public boolean validateUpdate(List<String> update, List<String> rules) {
        for (int i = 0; i < update.size()-1; i++) {
            String order = update.get(i) + update.get(i+1);
            int res = Collections.binarySearch(rules, order);
            if (res >= 0)
                return false;
        }
        return true;
    }

    public List<List<String>> getListOfAllUpdates(String s) {
        List<List<String>> updates = new ArrayList<>();
        Scanner scanner = new Scanner(s);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.contains(",")) {
                String[] split = line.split(",");
                List<String> update = new ArrayList<>();
                for (String str : split) {
                    update.add(str.trim());
                }
                updates.add(update);
            }
        }
        return updates;
    }

    public List<String> getListOfAllRules(String s) {
        List<String> rules = new LinkedList<>();
        Scanner scanner = new Scanner(s);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isBlank())
                break;
            String[] ruleArray = line.split("\\|");
            String rule = ruleArray[1] + ruleArray[0];
            rules.add(rule);
        }
        Collections.sort(rules);
        return rules;
    }

    public int getMiddlePageNumber(List<String> update) {
        int index = update.size() / 2;
        return Integer.parseInt(update.get(index));
    }

    public int getSumAllValidUpdates(List<List<String>> updates, List<String> rules) {
        int sum = 0;

        for (List<String> update : updates) {
            if (validateUpdate(update, rules))
                sum+=getMiddlePageNumber(update);
        }
        return sum;
    }
}