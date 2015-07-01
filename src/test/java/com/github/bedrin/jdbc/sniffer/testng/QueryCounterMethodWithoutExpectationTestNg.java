package com.github.bedrin.jdbc.sniffer.testng;

import com.github.bedrin.jdbc.sniffer.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertTrue;

@Listeners({QueryCounter.class, MustFailListener.class})
public class QueryCounterMethodWithoutExpectationTestNg extends BaseTest {

    @BeforeClass
    @Expectation(atLeast = 0)
    public void setUp() throws ClassNotFoundException, SQLException {
        BaseTest.loadDriverAndCreateTables();
    }

    @Test
    @Expectation(1)
    public void testAllowedOneQuery() {
        executeStatement();
    }

    @Test
    public void testWithoutExpectations() {
        assertTrue(true);
    }

    @Expectation(value = 5, atLeast = 2)
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testAmbiguousExpectationAnnotation() {
    }

}
