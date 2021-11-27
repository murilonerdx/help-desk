package com.murilonerdx.helpdesk.domain.enums;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
public enum Perfil {
    ADMIN(0, "ROLE_ADMIN"), CLIENTE(1, "ROLE_CLIENTE"), TECNICO(2, "ROLE_TECNICO");

    private Integer code;
    private String description;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static Perfil toEnum(Integer cod) throws IllegalAccessException {
        if (cod == null)
            return null;

        for(Perfil x: Perfil.values()){
            if(cod.equals(x.getCode()))
                return x;
        }

        throw new IllegalAccessException("Perfil invalido");
    }
}
