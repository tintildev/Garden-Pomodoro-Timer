module at.mklestil.pomodorotimer {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens at.mklestil.gardenpomodorotimer to javafx.fxml;
    exports at.mklestil.gardenpomodorotimer;
}