public class ResourceSteps {
    private CustomWorld world;
    public ResourceSteps(CustomWorld world) {
        this.world = world;
    }

    @Given
    public void given_some_file_is_loaded() {
        String data = (String)world.getResources().loadResource("someFile");
    }
}