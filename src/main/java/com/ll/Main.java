package com.ll;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //lab1();

        //lab2();

        //lab3();

        lab4();

    }

    // out 이 모니터에 출력시킴 -> 새로운 output안에 받아보자
    private static void lab4() {
        System.out.println("== 시작 ==");

        // 출력이 모니터로 안되도록 설정
        ByteArrayOutputStream output = new ByteArrayOutputStream(); // output 안에 쌓임
        System.setOut(new PrintStream(output)); // 기존의 out이 교체됨

        System.out.println("안녕하세요."); // println을 해도 나오지 않음 -> output안에 쌓이는 중
        System.out.println("반갑습니다.");

        // 다시 모니터로 출력되도록 설정
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));

        System.out.println("== 끝 ==");

        System.out.println("출력  : " + output.toString());

        //output 자원 해제
        try {
            output.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //모니터가 아니라 어떠한 로봇이 문자열을 받을 수 있을까? (출력 대체 가능 확인)
    private static void lab3() {
        System.out.println("== 시작 ==");
        System.out.println("안녕하세요.");
        System.out.println("== 끝 ==");

    }

    // 사람의 입력을 scan
    private static void lab1() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("명령) ");
        String cmd = scanner.nextLine().trim();

        System.out.println("입력한 명령: " + cmd);
    }

    //scanner는 in을 받아옴  (입력을 대체하는 방법 찾기)
    private static void lab2() {
        InputStream in = new ByteArrayInputStream("안녕\n잘가".getBytes());

        Scanner scanner = new Scanner(in);

        System.out.println("명령) ");
        String cmd = scanner.nextLine().trim(); // in을 받아옴

        System.out.println("입력한 명령: " + cmd);

        System.out.println("명령) ");
        cmd = scanner.nextLine().trim(); // in을 받아옴

        System.out.println("입력한 명령: " + cmd);

    }
}