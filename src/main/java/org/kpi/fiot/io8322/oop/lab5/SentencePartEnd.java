package org.kpi.fiot.io8322.oop.lab5;

import java.util.ArrayList;

public class SentencePartEnd extends SentencePart {
    @Override
    public int getPart() {
        return SentencePart.PART_END;
    }

    @Override
    public int initFromStringBuilder(StringBuilder sb, int indexChar) {
        children = new ArrayList<>();
        CharOne charOne = new CharOne();
        children.add(charOne);
        charOne.setData(sb.charAt(indexChar));
        return indexChar + 1;
    }

}
