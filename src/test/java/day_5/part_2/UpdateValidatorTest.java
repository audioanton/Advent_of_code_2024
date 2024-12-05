package day_5.part_2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UpdateValidatorTest {
    UpdateValidator updateValidator = new UpdateValidator();

    String testInput = """
            47|53
            97|13
            97|61
            97|47
            75|29
            61|13
            75|53
            29|13
            97|29
            53|29
            61|53
            97|53
            61|29
            47|13
            75|47
            97|75
            47|61
            75|61
            47|29
            75|13
            53|13
            
            75,47,61,53,29
            97,61,53,29,13
            75,29,13
            75,97,47,61,53
            61,13,29
            97,13,75,29,47""";

    int expectedSum = 123;

    @Test
    void sortUpdate() {
        List<String> rules = updateValidator.getListOfAllRules(testInput);
        List<List<String>> updates = updateValidator.getListOfAllUpdates(testInput);

        assertFalse(updateValidator.validateUpdate(updates.getLast(), rules));
        List<String> sortedUpdate = updateValidator.sortUpdate(updates.getLast(), rules);
        assertTrue(updateValidator.validateUpdate(sortedUpdate, rules));

    }
}