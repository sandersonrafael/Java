package com.cursojava.springmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

// classe necessária para decodar o parâmetro de url que pode estar com caracteres encodados
// como %20, ou %n, etc
public class URL {

    public static String decodeParam(String text) {
        try {
            return URLDecoder.decode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}
