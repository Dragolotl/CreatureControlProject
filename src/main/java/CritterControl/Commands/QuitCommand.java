package CritterControl.Commands;

public class QuitCommand implements ICommand{
    Boolean isPlaying;

    public QuitCommand(Boolean isPlaying) {
        this.isPlaying = isPlaying;
    }

    @Override
    public boolean execute() {
        isPlaying = false;
        return true;
    }
}
