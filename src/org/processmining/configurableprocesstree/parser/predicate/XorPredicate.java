package org.processmining.configurableprocesstree.parser.predicate;

public class XorPredicate implements Predicate {
    @Override
    public boolean checkPredicate(String word) {
        return "XOR".equals(word);
    }
}
