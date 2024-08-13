package challenge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    private int contactID;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String zipCode;
    private String address;
}
