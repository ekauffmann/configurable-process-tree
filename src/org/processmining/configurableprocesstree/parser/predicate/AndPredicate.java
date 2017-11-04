package org.processmining.configurableprocesstree.parser.predicate;

public class AndPredicate implements Predicate {
    @Override
    public boolean checkPredicate(String word) {
        return "AND".equals(word);
    }
}
