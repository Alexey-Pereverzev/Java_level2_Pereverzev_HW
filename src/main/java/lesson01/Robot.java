package lesson01;

public class Robot implements Participant {
    private final String name;
    private final int runningAbility;
    private final int jumpingAbility;

    public Robot(String name, int runningAbility, int jumpingAbility) {
        this.name = name;
        this.runningAbility = Math.max(runningAbility, 0);
        this.jumpingAbility = Math.max(jumpingAbility, 0);
    }

    @Override
    public boolean jump(Wall wall) {
        if (jumpingAbility >= wall.getHeight()) {
            System.out.println("Робот " + name + " успешно перепрыгнул стену!");
            return true;
        } else {
            System.out.println("Робот " + name + " не смог перепрыгнуть стену...");
            return false;
        }
    }

    @Override
    public boolean run(RunningTrack track) {
        if (runningAbility >= track.getLength()) {
            System.out.println("Робот " + name + " успешно пробежал трек!");
            return true;
        } else {
            System.out.println("Робот " + name + " не смог пробежать трек...");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                ", runningAbility=" + runningAbility +
                ", jumpingAbility=" + jumpingAbility +
                '}';
    }

    @Override
    public String getName() {
        return name;
    }


}

