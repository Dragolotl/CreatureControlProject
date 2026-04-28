package CritterControl.Strategy;

public class StrategyFactory {
    public IStrategy BaseStrategy() {
        return new BaseStrategy();
    }

    public IStrategy MinitaurLevel5Strategy() {
        return new MinitaurLevel5Strategy();
    }

    public IStrategy MinitaurLevel10Strategy() {
        return new MinitaurLevel10Strategy();
    }

    public IStrategy VelociraptorLevel5Strategy() {
        return new VelociraptorLevel5Strategy();
    }

    public IStrategy VelociraptorLevel10Strategy() {
        return new VelociraptorLevel10Strategy();
    }

    public IStrategy NecroBonesLevel5Strategy() {
        return new NecroBonesLevel5Strategy();
    }

    public IStrategy NecroBonesLevel10Strategy() {
        return new NecroBonesLevel10Strategy();
    }
}
