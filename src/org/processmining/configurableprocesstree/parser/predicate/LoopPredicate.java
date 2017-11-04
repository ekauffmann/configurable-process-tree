package org.processmining.configurableprocesstree.parser.predicate;

public class LoopPredicate implements Predicate {
    @Override
    public boolean checkPredicate(String word) {
        return "LOOP".equals(word);
    }
}
