package org.processmining.configurableprocesstree.impl;

import org.processmining.processtree.Block;
import org.processmining.processtree.Edge;
import org.processmining.processtree.impl.AbstractBlock;

import java.util.List;
import java.util.UUID;

public abstract class AbstractConfigurableBlock extends AbstractBlock {

    protected String label = "soy un label";

    public AbstractConfigurableBlock(String name) {
        super(name);
    }

    public AbstractConfigurableBlock(UUID id, String name) {
        super(id, name);
    }

    public AbstractConfigurableBlock(String name, List<Edge> incoming, List<Edge> outgoing) {
        super(name, incoming, outgoing);
    }

    public AbstractConfigurableBlock(UUID id, String name, List<Edge> incoming, List<Edge> outgoing) {
        super(id, name, incoming, outgoing);
    }

    public AbstractConfigurableBlock(Block b) {
        super(b);
    }

    public static class Xor extends AbstractConfigurableBlock implements Block.Xor {

        public Xor(String name) {
            super(name);
        }

        public Xor(UUID id, String name) {
            super(id, name);
        }

        public Xor(String name, List<Edge> incoming, List<Edge> outgoing) {
            super(name, incoming, outgoing);
        }

        public Xor(UUID id, String name, List<Edge> incoming, List<Edge> outgoing) {
            super(id, name, incoming, outgoing);
        }

        public Xor(Block b) {
            super(b);
        }

        @Override
        public boolean orderingOfChildernMatters() {
            return true;
        }

        @Override
        public boolean expressionsOfOutgoingEdgesMatter() {
            return true;
        }

        @Override
        public String toStringShort() {
            return "Xor";
        }
    }

    public static class Or extends AbstractConfigurableBlock implements Block.Or {

        public Or(String name) {
            super(name);
        }

        public Or(UUID id, String name) {
            super(id, name);
        }

        public Or(String name, List<Edge> incoming, List<Edge> outgoing) {
            super(name, incoming, outgoing);
        }

        public Or(UUID id, String name, List<Edge> incoming, List<Edge> outgoing) {
            super(id, name, incoming, outgoing);
        }

        public Or(Block b) {
            super(b);
        }

        @Override
        public boolean orderingOfChildernMatters() {
            return true;
        }

        @Override
        public boolean expressionsOfOutgoingEdgesMatter() {
            return true;
        }

        @Override
        public String toStringShort() {
            return "Or";
        }
    }

    public static class And extends AbstractConfigurableBlock implements Block.And {

        public And(String name) {
            super(name);
        }

        public And(UUID id, String name) {
            super(id, name);
        }

        public And(String name, List<Edge> incoming, List<Edge> outgoing) {
            super(name, incoming, outgoing);
        }

        public And(UUID id, String name, List<Edge> incoming, List<Edge> outgoing) {
            super(id, name, incoming, outgoing);
        }

        public And(Block b) {
            super(b);
        }

        @Override
        public boolean orderingOfChildernMatters() {
            return false;
        }

        @Override
        public boolean expressionsOfOutgoingEdgesMatter() {
            return false;
        }

        @Override
        public String toStringShort() {
            return "And";
        }
    }

    public static class Seq extends AbstractConfigurableBlock implements Block.Seq {

        public Seq(String name) {
            super(name);
        }

        public Seq(UUID id, String name) {
            super(id, name);
        }

        public Seq(String name, List<Edge> incoming, List<Edge> outgoing) {
            super(name, incoming, outgoing);
        }

        public Seq(UUID id, String name, List<Edge> incoming, List<Edge> outgoing) {
            super(id, name, incoming, outgoing);
        }

        public Seq(Block b) {
            super(b);
        }

        @Override
        public boolean orderingOfChildernMatters() {
            return true;
        }

        @Override
        public boolean expressionsOfOutgoingEdgesMatter() {
            return false;
        }

        @Override
        public String toStringShort() {
            return "Seq";
        }
    }

    public static class XorLoop extends AbstractConfigurableBlock implements Block.XorLoop {

        public XorLoop(String name) {
            super(name);
        }

        public XorLoop(UUID id, String name) {
            super(id, name);
        }

        public XorLoop(String name, List<Edge> incoming, List<Edge> outgoing) {
            super(name, incoming, outgoing);
        }

        public XorLoop(UUID id, String name, List<Edge> incoming, List<Edge> outgoing) {
            super(id, name, incoming, outgoing);
        }

        public XorLoop(Block b) {
            super(b);
        }

        @Override
        public boolean orderingOfChildernMatters() {
            return true;
        }

        @Override
        public boolean expressionsOfOutgoingEdgesMatter() {
            return true;
        }

        @Override
        public String toStringShort() {
            return "XorLoop" ;
        }
    }
}
