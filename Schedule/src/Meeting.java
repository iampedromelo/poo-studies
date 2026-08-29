import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Meeting {
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;

    public Meeting(String description, LocalTime startTime, LocalTime endTime){
        if(startTime.isBefore(endTime)) {
            this.description = description;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public long durationInMinutes(){
        return Duration.between(startTime,endTime).toMinutes();
    }

    public boolean isOverlap(Meeting meeting){
        return (startTime.isBefore(meeting.startTime) && endTime.isAfter((meeting.startTime))) || (startTime.isBefore(meeting.endTime) && endTime.isAfter((meeting.endTime)));
    }

    public boolean equals(Meeting meeting){
        return (description.equals(meeting.description)) && (startTime.equals(meeting.startTime)) && (endTime.equals(meeting.endTime));
    }

    public String meetingAsString(){
        return String.format(
                """
                Starts at: %s,
                Ends at: %s,
                Description, %s
                ---------------""",startTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")), endTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")), description);
    }

    public String getDescription() {
        return description;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
}
