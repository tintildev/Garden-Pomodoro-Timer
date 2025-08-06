package at.mklestil.gardenpomodorotimer.model;

/**
 * Model for PomodoroSessions, a central data model for Pomodoro sessions
 */
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

    public PomodoroSession(int duration, String plantChoice, String timestamp) {
        this(0, duration, plantChoice, timestamp); // Default ID to 0 for new sessions
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