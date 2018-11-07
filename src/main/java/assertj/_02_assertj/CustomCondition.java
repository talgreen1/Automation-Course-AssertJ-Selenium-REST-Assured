package assertj._02_assertj;

import org.assertj.core.api.Condition;
import org.springframework.beans.factory.config.CustomEditorConfigurer;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomCondition {

    static Condition<String> validUuid = new Condition<String>("valid uuid") {
        @Override
        public boolean matches(String uuid) {
            try {
                UUID.fromString(uuid);
                return true;
            } catch (IllegalArgumentException exception) {
                return false;
            }
        }
    };

    public static void main(String[] args) {
//        String uuid = "9c29c2f5-b192-4169-a8b4-89c4c8a24919";
        String uuid = "aa";

        System.out.println(uuid.toString());



        assertThat(uuid).is(validUuid);
    }
}
