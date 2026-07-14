import com.sprintxxl.ascenthub.definitions.AscentDefinitionRegistry;
import com.sprintxxl.ascenthub.definitions.AscentID;

public class TestDefinitionRegistry {

    void main() {

        AscentDefinitionRegistry registry = new AscentDefinitionRegistry();

        registry.getGuiRegistry().register(
                AscentID.id("ascenthub", "test"),
                TestGuiDefinition.TEST
        );

        try {
            registry.getGuiRegistry().register(
                    AscentID.id("ascenthub", "test"),
                    TestGuiDefinition.TEST
            );
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(registry.getGuiRegistry().size());

        System.out.println(registry.getGuiRegistry().get(
                AscentID.id("ascenthub", "test")) == TestGuiDefinition.TEST
        );
    }
}
