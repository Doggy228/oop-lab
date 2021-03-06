package org.kpi.fiot.io8322.oop.lab5;

import java.util.ArrayList;

public class SentencePartWord extends SentencePart {
    @Override
    public int getPart() {
        return SentencePart.PART_WORD;
    }

    @Override
    public int initFromStringBuilder(StringBuilder sb, int indexChar) {
        children = new ArrayList<>();
        int indexCurrent = indexChar;
        while (indexCurrent < sb.length()) {
            char c = ("" + sb.charAt(indexCurrent)).toLowerCase().charAt(0);
            if ((c >= 'a' && c <= 'z') || (c >= 'а' && c <= 'я') || (c >= '0' && c <= '9') || c == 'є' || c == 'і' || c == 'ї' || c == '_' || c == '\'') {
                CharOne charOne = new CharOne();
                children.add(charOne);
                charOne.setData(sb.charAt(indexCurrent));
                indexCurrent++;
            } else {
                break;
            }
        }
        return indexCurrent;

    }


}
