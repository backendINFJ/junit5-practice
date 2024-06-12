package com.sparta.junit5practice;

import org.junit.jupiter.api.*;

public class BeforeAfterTest {
    @BeforeEach
    void setUp() {
        System.out.println("각각의 테스트가 실헹되기 전에 수행");
    }

    @AfterEach
    void tearDown() {
        System.out.println("각각의 테스트가 실행된 후에 수행\n");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("모든 테스트가 실행되기 전에 수행, 최초로 수행될 때");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("모든 테스트가 실행된 후에 수행, 마지막으로 수행될 때");
    }

    @Test
    void test1() {
        System.out.println("테스트 1");
    }

    @Test
    void test2() {
        System.out.println("테스트 2");
    }
}
