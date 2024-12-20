package com.ll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandTest {

    @Test
    @DisplayName("""
            cmd.getActionName() ==  "삭제"
            """ )
    public void t1() {
        Command cmd = new Command("삭제?id=10");
        assertThat(cmd.getActionName()).isEqualTo("삭제");
    }

    @Test
    @DisplayName("""
            cmd.getParam("id") = "10"
            """)
    public void t2() {
        Command cmd = new Command("삭제?id=10");
        assertThat(cmd.getParam("id")).isEqualTo("10");
    }

    @Test
    public void t3() {
        Command cmd = new Command("삭제?id=10");
        assertThat(cmd.getParam("number")).isNull();
    }

    @Test
    public void t4() {
        Command cmd = new Command("삭제?id=10");
        assertThat(cmd.getParam("number", "-")).isEqualTo("-");
    }

    @Test
    public void t5() {
        Command cmd = new Command("삭제?id=10");
        assertThat(cmd.getParamAsInt("id", 0)).isEqualTo(10);
    }

    @Test
    public void t6() {
        Command cmd = new Command("삭제?id=10");
        assertThat(cmd.getParamAsInt("number", 0)).isEqualTo(0);
    }

    @Test
    @DisplayName("""
            cmd.getParamAsInt("number",0) == 0
            cmd.getName("name") == "Paul"
            """)
    public void t7() {
        Command cmd = new Command("목록?number=10&name=Paul");
        assertThat(cmd.getParamAsInt("number", 0)).isEqualTo(10);
        assertThat(cmd.getParam("name")).isEqualTo("Paul");
    }

    @Test
    @DisplayName("""
            new Command("목록? ") does not throw Exception
            """)
    public void t8() {
        Command cmd = new Command("목록? ");
    }
}
