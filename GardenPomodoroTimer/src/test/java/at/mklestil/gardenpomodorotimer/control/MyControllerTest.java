package at.mklestil.gardenpomodorotimer.control;

import at.mklestil.gardenpomodorotimer.view.MainWindow;
import javafx.application.Platform;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class MyControllerTest {

    private MyController controller;
    private MainWindow view;  // use Mock or Dummy-View

    @BeforeAll
    static void initJfxRuntime() {
        // JavaFX initialization required for tests
        Platform.startup(() -> {});
    }

    @BeforeEach
    void setUp() {
        view = new MainWindow();
        controller = new MyController(view);
    }

    @Test
    void testPlusTime() {
        int initialTime = 25 * 60; // 25 Minuten
        controller.plusTime();
        assertEquals(initialTime + 60, controller.getRemainingTime());
    }

    @Test
    void testMinusTime() {
        int initialTime = 25 * 60; // 25 Minuten
        controller.minusTime();
        assertEquals(initialTime - 60, controller.getRemainingTime());
    }

    @Test
    void testFormatTime() {

        assertEquals("25:00", controller.formatTime(1500));
        assertEquals("01:00", controller.formatTime(60));
        assertEquals("00:59", controller.formatTime(59));
    }

    @Test
    void testResetTimer() {
        controller.resetTimer();
        assertEquals(25 * 60, controller.getRemainingTime());  // Soll auf ursprüngliche Zeit zurückgesetzt werden
        assertEquals(0, view.getProgress().getProgress());
    }
}