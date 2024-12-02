package games;

import io.vavr.collection.Map;
import io.vavr.collection.Seq;

public record Rules(Map<Integer, String> mapping) {

    public Seq<String> getStrings() {
        return mapping.values();
    }

}