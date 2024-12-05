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

        int size = updates.getLast().size();
        int size2 = updates.get(4).size();
        int size3 = updates.get(3).size();

        assertFalse(updateValidator.validateUpdate(updates.getLast(), rules));
        List<String> sortedUpdate = updateValidator.sortUpdateNew(updates.getLast(), rules);
        assertTrue(updateValidator.validateUpdate(sortedUpdate, rules));
        assertEquals(size, sortedUpdate.size());

        assertFalse(updateValidator.validateUpdate(updates.get(4), rules));
        List<String> sortedUpdate2 = updateValidator.sortUpdateNew(updates.get(4), rules);
        assertTrue(updateValidator.validateUpdate(sortedUpdate2, rules));
        assertEquals(size2, sortedUpdate2.size());

        assertFalse(updateValidator.validateUpdate(updates.get(3), rules));
        List<String> sortedUpdate3 = updateValidator.sortUpdateNew(updates.get(3), rules);
        assertTrue(updateValidator.validateUpdate(sortedUpdate3, rules));
        assertEquals(size3, sortedUpdate3.size());



        //assertFalse(updateValidator.validateUpdate(updates.getLast(), rules));
        //List<String> sortedUpdate = updateValidator.sortUpdateOld(updates.getLast(), rules);
        //assertTrue(updateValidator.validateUpdate(sortedUpdate, rules));

    }
}