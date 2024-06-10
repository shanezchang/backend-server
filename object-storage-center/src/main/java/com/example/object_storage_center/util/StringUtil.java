package com.example.object_storage_center.util;

import java.util.UUID;

public class StringUtil {

    public static String getRandomString() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
