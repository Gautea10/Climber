import java.util.Date;

class GameTimer {
    private final Date createdDate = new java.util.Date();

    public int getSecondsSinceCreation() {
        java.util.Date now = new java.util.Date();
        return (int)((now.getTime() - this.createdDate.getTime()) / 1000);
    }
}