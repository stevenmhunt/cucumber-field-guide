import org.jooq.DSLContext;

public class CustomWorld {
    private DSLContext context;
    private Config config;

    public CustomWorld() {
        String env = System.getenv("TEST_ENV");
        this.config = ConfigFactory.load(env != null ? env : "default");
    }

    public DSLContext getDBContext() {
        if (context == null) {
            context = DBTestUtils.connect(this.config.getString("db"));
            DBSchema.createSchema(context);
            DBTestUtils.loadBaselineData(context);
        }
        return context;
    }
}