import com.github.jknack.handlebars.*;

public abstract class TransformableSteps {
    protected CustomWorld world;
    private final Handlebars hbs = new Handlebars();

    public TransformableSteps(CustomWorld world) {
        this.world = world;
    }

    protected Object transformValue(Object value) {
        try {
            if (value instanceof String) {
                Template t = hbs.compile((String)value);
                return t.apply(world);
            }
        } catch (Exception ex) { return value; }
    }

    protected <T, U> BiConsumer<T, U> transformer(BiConsumer<T, U> step) {
        return (arg1, arg2) -> {
            step.accept(transformValue(arg1), transformValue(arg2));
        };
    }
}