import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Schedule {
    private final int MAX_MEETINGS = 20;
    private LocalDate day;
    private LocalTime startTime;
    private LocalTime endTime;
    private Meeting[] meetings;
    private int numberOfMeeting;

    public Schedule(LocalDate day, LocalTime startTime, LocalTime endTime){
        if(startTime.isBefore(endTime)){
            this.day = day;
            this.startTime = startTime;
            this.endTime = endTime;
            meetings = new Meeting[MAX_MEETINGS];
            numberOfMeeting = 0;
        }
    }

    private boolean isFull(){
        return numberOfMeeting == MAX_MEETINGS;
    }

    private boolean outOfWorkDay(Meeting meeting){
        return meeting.getStartTime().isBefore(startTime) || meeting.getEndTime().isAfter(endTime);
    }

    public void addMeeting(Meeting meeting){
        if(isFull() || outOfWorkDay(meeting)) return;
        for(int i=0;i<numberOfMeeting;i++){
            if(meetings[i].isOverlap(meeting)) return;
        }
        meetings[numberOfMeeting++] = meeting;
    }

    public void removeMeeting(Meeting meeting){
        for (int i=0;i<numberOfMeeting;i++){
            if(meetings[i].equals(meeting)){
                for(int j=i;j<numberOfMeeting-1;j++){
                    meetings[j] = meetings[j+1];
                }
                meetings[--numberOfMeeting] = null;
                return;
            }
        }
    }

    public double percentageSpentInMeeting(){
        long minutesofSchedule = Duration.between(startTime,endTime).toMinutes();
        long sumMinuteofMeeting = 0;

        for(int i=0;i<numberOfMeeting;i++){
            sumMinuteofMeeting += meetings[i].durationInMinutes();
        }

        return ((double) sumMinuteofMeeting/minutesofSchedule)*100;
    }

    public String scheduleAsString(){
        StringBuilder stringMeetings = new StringBuilder();
        for(int i=0;i<numberOfMeeting;i++){
            stringMeetings.append(meetings[i].meetingAsString()).append("\n");
        }
        return String.format("""
                Day: %s
                Start at: %s,
                Ends at: %s,
                Meetings:[%s]
                """,day.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),startTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")), endTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")),stringMeetings);

    }

    public LocalDate getDay() {
        return day;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public Meeting[] getMeetings() {
        return meetings;
    }
}
