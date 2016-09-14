package com.startapp.android.publish.gson;

import java.lang.reflect.Field;

/* compiled from: StartAppSDK */
public enum FieldNamingPolicy implements FieldNamingStrategy {
    IDENTITY {
        public String translateName(Field f) {
            return f.getName();
        }
    },
    UPPER_CAMEL_CASE {
        public String translateName(Field f) {
            return FieldNamingPolicy.upperCaseFirstLetter(f.getName());
        }
    },
    UPPER_CAMEL_CASE_WITH_SPACES {
        public String translateName(Field f) {
            return FieldNamingPolicy.upperCaseFirstLetter(FieldNamingPolicy.separateCamelCase(f.getName(), " "));
        }
    },
    LOWER_CASE_WITH_UNDERSCORES {
        public String translateName(Field f) {
            return FieldNamingPolicy.separateCamelCase(f.getName(), "_").toLowerCase();
        }
    },
    LOWER_CASE_WITH_DASHES {
        public String translateName(Field f) {
            return FieldNamingPolicy.separateCamelCase(f.getName(), "-").toLowerCase();
        }
    };

    private static String separateCamelCase(String name, String separator) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            char charAt = name.charAt(i);
            if (Character.isUpperCase(charAt) && stringBuilder.length() != 0) {
                stringBuilder.append(separator);
            }
            stringBuilder.append(charAt);
        }
        return stringBuilder.toString();
    }

    private static String upperCaseFirstLetter(String name) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        char charAt = name.charAt(0);
        while (i < name.length() - 1 && !Character.isLetter(charAt)) {
            stringBuilder.append(charAt);
            i++;
            charAt = name.charAt(i);
        }
        if (i == name.length()) {
            return stringBuilder.toString();
        }
        if (Character.isUpperCase(charAt)) {
            return name;
        }
        return stringBuilder.append(modifyString(Character.toUpperCase(charAt), name, i + 1)).toString();
    }

    private static String modifyString(char firstCharacter, String srcString, int indexOfSubstring) {
        return indexOfSubstring < srcString.length() ? firstCharacter + srcString.substring(indexOfSubstring) : String.valueOf(firstCharacter);
    }
}
