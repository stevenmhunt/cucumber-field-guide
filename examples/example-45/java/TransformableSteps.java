import java.util.function.BiConsumer;

public abstract class TransformableSteps {
    protected <T, U> BiConsumer<T, U> transformer(BiConsumer<T, U> step) {
        return (arg1, arg2) -> { /* transform here */ step.accept(arg1, arg2); };
    }
}