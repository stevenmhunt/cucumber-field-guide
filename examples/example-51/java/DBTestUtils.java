import org.jooq.*;
import org.jooq.impl.*;
import static org.jooq.impl.DSL.*;

public class DBTestUtils {
    public static DSLContext connect() { return DSL.using("jdbc:sqlite::memory:"); }

    public static void loadBaselineData(DSLContext context) {
        context.insertInto(table("users"), field("name"))
              .values("Test User 1").execute();
    }
}