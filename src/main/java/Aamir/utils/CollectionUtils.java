package Aamir.utils;

import java.util.Collection;
import java.util.Map;

/**
 * @author peiyunluo@icloud.com
 * @date 2020/3/4 10:23
 */
public class CollectionUtils {
    public CollectionUtils() {
    }

    public static boolean isEmpty(Collection<?> coll) {
        return coll == null || coll.isEmpty();
    }

    public static boolean isNotEmpty(Collection<?> coll) {
        return !isEmpty(coll);
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }
}
