package at.mklestil.gardenpomodorotimer.model;

public class PomodoroSession {
    private int id;
    private int duration;
    private String plantChoice;
    private String timestamp;

    public PomodoroSession(int id, int duration, String plantChoice, String timestamp) {
        this.id = id;
        this.duration = duration;
        this.plantChoice = plantChoice;
        this.timestamp = timestamp;
    }

    public int getId() { return id; }
    public int getDuration() { return duration; }
    public String getPlantChoice() { return plantChoice; }
    public String getTimestamp() { return timestamp; }

    @Override
    public String toString() {
        return "ID: " + id + ", Duration: " + duration + "min, Plant: " + plantChoice + ", Timestamp: " + timestamp;
    }
}