package com.ll;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //lab1();
        lab2();

    }

    // 사람의 입력을 scan
    private static void lab1() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("명령) ");
        String cmd = scanner.nextLine().trim();

        System.out.println("입력한 명령: " + cmd);
    }

    //scanner는 in을 스캔함
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