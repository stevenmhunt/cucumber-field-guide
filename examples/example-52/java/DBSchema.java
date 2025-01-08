import org.jooq.*;
import org.jooq.impl.*;
import static org.jooq.impl.DSL.*;

public class DBSchema {
    public static void createSchema(DSLContext context) {
        context.createTableIfNotExists("users")
                .column("id", SQLDataType.INTEGER.identity(true))
                .column("name", SQLDataType.VARCHAR(255))
                .constraints(constraint("PK_USERS").primaryKey("id")).execute();
    }
}