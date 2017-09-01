package org.ostroukh.dionisus.app.infra;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

/**
 * Contains utility functions of the general purpose
 * @author Eugene Ostroukh
 */

public class CommonUtil {
    private CommonUtil() {
    }


    /**
     * Returns not-null unmodifiable copy of the source set
     * @param source
     * @return
     */
    public static <T> Set<T> getSafeSet(Set<T> source) {
        return Collections.unmodifiableSet(Optional.ofNullable(source).orElse(Collections.emptySet()));
    }
}
