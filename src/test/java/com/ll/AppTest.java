package com.ll;

import com.ll.standard.util.TestUtil;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

public class AppTest {

    public static String run(String input) {
        input = input.stripIndent().trim() + "\n종료";
        Scanner scanner = TestUtil.getScanner(input); // 입력을 대신 넣어줌

        ByteArrayOutputStream outputstream = TestUtil.setOutToByteArray(); // 출력을 대신 받아줌

        App app = new App(scanner);
        app.run();

        String output = outputstream.toString();

        TestUtil.clearSetOutToByteArray(outputstream); // 출력 비워줌(원상복구)

        return output;
    }
}
