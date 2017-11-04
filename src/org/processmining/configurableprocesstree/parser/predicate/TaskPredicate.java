package org.processmining.configurableprocesstree.parser.predicate;

public class TaskPredicate implements Predicate {
    @Override
    public boolean checkPredicate(String word) {
        return word != null && word.matches("\\d+");
    }
}
