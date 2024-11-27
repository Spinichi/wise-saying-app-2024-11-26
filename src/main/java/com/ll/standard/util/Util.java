package com.ll.standard.util;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Util {
    public static class file {
        public static void touch(String filePath) {
            // 파일 생성만 함
            set(filePath, "");
        }

        public static boolean exists(String filePath) {
            Path path = Paths.get(filePath);
            return Files.exists(path);

        }

        public static void set(String filePath, String content) {
            Path path = Paths.get(filePath);

            try {
                // 파일 없으면 만듬 , 있으면 뒤집어씌움
                Files.writeString(path, content, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            } catch (IOException e) {
                // 예외 되는경우 -> 폴더가 없을때도 있음
                // 이 경우 폴더를 만들어 주는 시도.
                final Path parentDir = path.getParent();
                if (parentDir != null && Files.notExists(parentDir)) {
                    try {
                        Files.createDirectories(parentDir);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    try {
                        Files.writeString(path, content, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                } else {
                    throw new RuntimeException(e);
                }
            }
        }

        public static String get(String filePath, String defaultValue) {
            Path path = Paths.get(filePath);

            try {
                return Files.readString(path);
            } catch (IOException e) {
                return defaultValue;
            }
        }

        public static boolean delete(String filePath) {
            Path path = Paths.get(filePath);
            try {
                Files.walkFileTree(path, new SimpleFileVisitor<>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                        Files.delete(file); // 파일 삭제
                        return FileVisitResult.CONTINUE;
                    }

                    @Override
                    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                        Files.delete(dir); // 디렉토리 삭제
                        return FileVisitResult.CONTINUE;
                    }
                });
                return true;
            } catch (NoSuchFileException e) {
                return false;
            } catch (IOException e) {
                return false;
            }
        }

        public static boolean notExists(String filePath) {
            return !exists(filePath);
        }

        public static void mkdir(String dirPath) {
            Path path = Paths.get(dirPath);
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public static boolean rmdir(String dirPath) {
            return delete(dirPath);
        }
    }

    // 점심먹고
    public static class json {
//        public static String toString(Map<String, String> map) {
//            StringBuilder sb = new StringBuilder();
//
//            sb.append("{");
//            sb.append("\n");
//
//            map.forEach((key,value) -> {
//                sb.append("    ");
//            }   sb.append()
//        })
//
//    }
    }
}