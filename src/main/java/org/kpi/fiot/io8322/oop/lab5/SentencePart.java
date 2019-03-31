package org.kpi.fiot.io8322.oop.lab5;

import java.util.List;

public abstract class SentencePart {
    protected List<CharOne> children;
    public static final int PART_WORD = 1;
    public static final int PART_DEVIDER = 2;
    public static final int PART_END = 3;

    public abstract int getPart();

    public abstract int initFromStringBuilder(StringBuilder sb, int indexChar);

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (CharOne charOne : children) {
            sb.append(charOne.getData());
        }
        return sb.toString();
    }
}

