package co.ke.willsprojects.daraja.JsonSchemas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModulePrivileges {
    String role;
    String privilege;
    String module;
}
