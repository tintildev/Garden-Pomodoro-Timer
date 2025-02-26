/**
 * The main module of the Garden Pomodoro Timer application.
 * <p>
 * It contains the timer control, database management
 * and the graphical user interface with JavaFX.
 * </p>
 */
module at.mklestil.pomodorotimer {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens at.mklestil.gardenpomodorotimer to javafx.fxml;
    exports at.mklestil.gardenpomodorotimer;
}