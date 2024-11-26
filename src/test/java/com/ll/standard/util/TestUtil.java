package com.ll.standard.util;

import java.io.*;
import java.util.Scanner;

public class TestUtil {
    public static Scanner getScanner(String input) {
        return new Scanner(input);
    }

    public static ByteArrayOutputStream setOutToByteArray() {
        ByteArrayOutputStream output = new ByteArrayOutputStream(); // output 안에 쌓임
        System.setOut(new PrintStream(output)); // 기존의 out이 교체됨
        return output;
    }

    public static void clearSetOutToByteArray(ByteArrayOutputStream byteArrayOutputStream) {
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        try {
             byteArrayOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
