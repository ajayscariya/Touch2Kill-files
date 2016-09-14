package com.wTouch2KiLL.inline;

import com.google.android.gms.common.ConnectionResult;
import com.startapp.android.publish.model.MetaData;
import com.wTouch2KiLL.C0866R;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;

public class StringEscapeUtils {
    private static final char CSV_DELIMITER = ',';
    private static final char CSV_QUOTE = '\"';
    private static final String CSV_QUOTE_STR;

    static {
        CSV_QUOTE_STR = String.valueOf(CSV_QUOTE);
    }

    public static String escapeJava(String str) {
        try {
            str = escapeJavaStyleString(str, false, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public static void escapeJava(Writer out, String str) throws IOException {
        escapeJavaStyleString(out, str, false, false);
    }

    public static String escapeJavaScript(String str) {
        try {
            str = escapeJavaStyleString(str, true, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public static void escapeJavaScript(Writer out, String str) throws IOException {
        escapeJavaStyleString(out, str, true, true);
    }

    private static String escapeJavaStyleString(String str, boolean escapeSingleQuotes, boolean escapeForwardSlash) throws Exception {
        if (str == null) {
            return null;
        }
        try {
            StringWriter writer = new StringWriter(str.length() * 2);
            escapeJavaStyleString(writer, str, escapeSingleQuotes, escapeForwardSlash);
            return writer.toString();
        } catch (IOException e) {
            throw new Exception("escapeJavaStyleString error!");
        }
    }

    private static void escapeJavaStyleString(Writer out, String str, boolean escapeSingleQuote, boolean escapeForwardSlash) throws IOException {
        if (out == null) {
            throw new IllegalArgumentException("The Writer must not be null");
        } else if (str != null) {
            int sz = str.length();
            for (int i = 0; i < sz; i++) {
                char ch = str.charAt(i);
                if (ch <= '\u0fff') {
                    if (ch <= '\u00ff') {
                        if (ch <= '\u007f') {
                            if (ch >= ' ') {
                                switch (ch) {
                                    case Tokens.EXPRTOKEN_AXISNAME_ANCESTOR_OR_SELF /*34*/:
                                        out.write(92);
                                        out.write(34);
                                        break;
                                    case Tokens.EXPRTOKEN_AXISNAME_FOLLOWING /*39*/:
                                        if (escapeSingleQuote) {
                                            out.write(92);
                                        }
                                        out.write(39);
                                        break;
                                    case Tokens.EXPRTOKEN_NUMBER /*47*/:
                                        if (escapeForwardSlash) {
                                            out.write(92);
                                        }
                                        out.write(47);
                                        break;
                                    case C0866R.styleable.Theme_alertDialogButtonGroupStyle /*92*/:
                                        out.write(92);
                                        out.write(92);
                                        break;
                                    default:
                                        out.write(ch);
                                        break;
                                }
                            }
                            switch (ch) {
                                case ConnectionResult.INTERNAL_ERROR /*8*/:
                                    out.write(92);
                                    out.write(98);
                                    break;
                                case ConnectionResult.SERVICE_INVALID /*9*/:
                                    out.write(92);
                                    out.write(116);
                                    break;
                                case MetaData.DEFAULT_MAX_ADS /*10*/:
                                    out.write(92);
                                    out.write(110);
                                    break;
                                case Tokens.EXPRTOKEN_NODETYPE_COMMENT /*12*/:
                                    out.write(92);
                                    out.write(C0866R.styleable.Theme_checkboxStyle);
                                    break;
                                case ConnectionResult.CANCELED /*13*/:
                                    out.write(92);
                                    out.write(114);
                                    break;
                                default:
                                    if (ch <= '\u000f') {
                                        out.write("\\u000" + hex(ch));
                                        break;
                                    } else {
                                        out.write("\\u00" + hex(ch));
                                        break;
                                    }
                            }
                        }
                        out.write("\\u00" + hex(ch));
                    } else {
                        out.write("\\u0" + hex(ch));
                    }
                } else {
                    out.write("\\u" + hex(ch));
                }
            }
        }
    }

    private static String hex(char ch) {
        return Integer.toHexString(ch).toUpperCase(Locale.ENGLISH);
    }
}
