import org.jooq.DSLContext;

public class CustomWorld {
    private DSLContext context;
    public DSLContext getDBContext() {
        if (context == null) {
            context = DBTestUtils.connect();
            DBSchema.createSchema(context);
            DBTestUtils.loadBaselineData(context);    
        }
        return context;
    } // ...existing code...
}