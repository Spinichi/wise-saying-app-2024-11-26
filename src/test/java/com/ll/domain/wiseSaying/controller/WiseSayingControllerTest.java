package com.ll.domain.wiseSaying.controller;

import com.ll.standard.util.TestUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class WiseSayingControllerTest {
    @Test
    @DisplayName("== 명언 앱 ==")
    public void t1() {
        Scanner scanner = TestUtil.getScanner("종료"); // 입력을 대신 넣어줌
        ByteArrayOutputStream outputstream = TestUtil.setOutToByteArray(); // 출력을 대신 받아줌

        App app = new App(scanner);
        app.run();

        String output = outputstream.toString();

        TestUtil.clearSetOutToByteArray(outputstream); // 출력 비워줌(원상복구)

        assertThat(output)
                .contains("== 명언 앱 ==");
    }
}
