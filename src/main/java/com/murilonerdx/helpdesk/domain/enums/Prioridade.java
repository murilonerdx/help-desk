package com.murilonerdx.helpdesk.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public enum Prioridade {
    ADMIN(0, "BAIXA"), CLIENTE(1, "MEDIA"), TECNICO(2, "ALTA");

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

    public static Status toEnum(Integer cod) throws IllegalAccessException {
        if (cod == null)
            return null;

        for(Status x: Status.values()){
            if(cod.equals(x.getCode()))
                return x;
        }

        throw new IllegalAccessException("Prioridade invalido");
    }
}
