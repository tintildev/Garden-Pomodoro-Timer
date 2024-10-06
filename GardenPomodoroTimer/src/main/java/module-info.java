module at.mklestil.pomodorotimer {
    requires javafx.controls;
    requires javafx.fxml;


    opens at.mklestil.gardenpomodorotimer to javafx.fxml;
    exports at.mklestil.gardenpomodorotimer;
}