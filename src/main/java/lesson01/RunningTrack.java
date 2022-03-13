package lesson01;

public class RunningTrack implements Hurdle {
    private final int length;

    public RunningTrack(int length) {
        this.length = Math.max(length, 0);
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "RunningTrack{" +
                "length=" + length +
                '}';
    }

    @Override
    public boolean overcomeByParticipant(Participant participant) {
        return participant.run(this);
    }
}
