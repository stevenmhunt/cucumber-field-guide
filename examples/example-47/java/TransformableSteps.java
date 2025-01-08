import java.util.HashMap;
import java.util.Map;
import java.util.List;

import com.github.jknack.handlebars.*;

public abstract class TransformableSteps {
    protected CustomWorld world;
    private final Handlebars hbs = new Handlebars();
    private final Map<String, Template> templates = new HashMap<String, Template>();

    public TransformableSteps(CustomWorld world) {
        this.world = world;
    }

    protected String transformString(String value) {
        try {
            Template t = templates.putIfAbsent((String)value,
                handlebars.compile((String)value));
            return t.apply(world);
        } catch (Exception ex) { return value; }
    }

    protected DataTable transformDataTable(DataTable table) {
        try {
            List<List<String>> originalRows = table.asLists(String.class);
            List<List<String>> transformedRows = originalRows.stream()
                    .map(row -> row.stream()
                            .map(this::transformValue)
                            .collect(Collectors.toList()))
                    .collect(Collectors.toList());

            return DataTable.create(transformedRows);
        } catch (Exception ex) { return table; }
    }

    protected Object transformValue(Object value) {
        if (value instanceof String) {
            return transformString((String)value);
        } else if (value instanceof DataTable) {
            return transformDataTable((DataTable)value);
        }
        return value;
    }

    protected <T, U> BiConsumer<T, U> transformer(BiConsumer<T, U> step) {
        return (arg1, arg2) -> {
            step.accept(transformValue(arg1), transformValue(arg2));
        };
    }
}