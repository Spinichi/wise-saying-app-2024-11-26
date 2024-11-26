package com.ll;

import com.ll.standard.util.TestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    @Test
    @DisplayName("== 명언 앱 ==")
    public void t1() {
        String output = AppTest.run("");

        assertThat(output)
                .contains("== 명언 앱 ==");
    }

    @Test
    @DisplayName("명령) ")
    public void t2() {
        String output = AppTest.run("""
                목록
                """);

        assertThat(output)
                .contains("명령) ");
    }

    @Test
    @DisplayName("명령을 2번 이상 입력할 수 있습니다.")
    public void t3() {
        String output = AppTest.run("""
                목록
                목록
                """);

        String[] split = output.split("명령\\)");
        assertThat(split).hasSize(4);
    }

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
