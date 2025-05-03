package at.mklestil.gardenpomodorotimer.view;

import javafx.scene.control.Button;

public class TimesButton extends Button {
    private int timeValue = 0;

    public TimesButton(String name, int value){
        this.setText(name);
        timeValue = value;
        this.getStyleClass().add("button");
    }

    public int getTimeValue() {
        return timeValue;
    }

    public void setTimeValue(int timeValue) {
        this.timeValue = timeValue;
    }
}
