package org.processmining.configurableprocesstree.parser.predicate;

public class SeqPredicate implements Predicate {
    @Override
    public boolean checkPredicate(String word) {
        return "SEQ".equals(word);
    }
}
