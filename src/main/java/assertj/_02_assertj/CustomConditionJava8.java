package assertj._02_assertj;

import org.assertj.core.api.Condition;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomConditionJava8 {
    public static void main(String[] args) {
//        String uuid = "9c29c2f5-b192-4169-a8b4-89c4c8a24919";
        String uuid = "1111";

        Condition<String> validUuid = new Condition<String>(CustomConditionJava8::isValidUuid, "Valid UUID");


        assertThat(uuid).is(validUuid);

    }




    public static boolean isValidUuid(String uuid) {
        try {
            UUID.fromString(uuid);
            return true;
        } catch (IllegalArgumentException exception) {
            return false;
        }
    }
}
