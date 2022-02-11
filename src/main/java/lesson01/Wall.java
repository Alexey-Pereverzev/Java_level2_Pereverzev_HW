package lesson01;

public class Wall implements Hurdle {
    private final int height;

    public Wall(int height) {
        this.height = Math.max(height, 0);
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Wall{" +
                "height=" + height +
                '}';
    }

    @Override
    public boolean overcomeByParticipant(Participant participant) {
        return participant.jump(this);
    }
}
