package day_5.part_1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
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

    int expectedSum = 143;

    @Test
    void validateUpdate() {
        List<String> rules = updateValidator.getListOfAllRules(testInput);
        List<List<String>> updates = updateValidator.getListOfAllUpdates(testInput);
        assertTrue(updateValidator.validateUpdate(updates.getFirst(), rules));
        assertTrue(updateValidator.validateUpdate(updates.get(1), rules));
        assertTrue(updateValidator.validateUpdate(updates.get(2), rules));
        assertFalse(updateValidator.validateUpdate(updates.get(3), rules));
        assertFalse(updateValidator.validateUpdate(updates.get(4), rules));
        assertFalse(updateValidator.validateUpdate(updates.getLast(), rules));
    }

    @Test
    void getListOfAllRules() {
        List<String> rules = updateValidator.getListOfAllRules(testInput);
        assertEquals(rules.getFirst(), "5347");
        assertEquals(rules.getLast(), "1353");
        assertEquals(21, rules.size());
    }

    @Test
    void getListOfAllUpdates() {
        List<List<String>> updates = updateValidator.getListOfAllUpdates(testInput);
        assertEquals("75", updates.getFirst().getFirst());
        assertEquals("47", updates.getLast().getLast());
        assertEquals(6, updates.size());
        assertEquals(5, updates.getFirst().size());
        assertEquals(5, updates.getLast().size());
    }

    @Test
    void getMiddlePageNumber() {
        List<List<String>> updates = updateValidator.getListOfAllUpdates(testInput);
        assertEquals(61, updateValidator.getMiddlePageNumber(updates.getFirst()));
        assertEquals(53, updateValidator.getMiddlePageNumber(updates.get(1)));
        assertEquals(29, updateValidator.getMiddlePageNumber(updates.get(2)));

    }

    @Test
    void getSumAllValidUpdates() {
        List<String> rules = updateValidator.getListOfAllRules(testInput);
        List<List<String>> updates = updateValidator.getListOfAllUpdates(testInput);

        assertEquals(expectedSum, updateValidator.getSumAllValidUpdates(updates, rules));
    }
}