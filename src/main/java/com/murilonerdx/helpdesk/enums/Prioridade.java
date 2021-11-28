package com.murilonerdx.helpdesk.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public enum Prioridade {
    BAIXA(0, "BAIXA"), MEDIA(1, "MEDIA"), ALTA(2, "ALTA");

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

    public static Prioridade toEnum(Integer cod) throws IllegalAccessException {
        if (cod == null)
            return null;

        for(Prioridade x: Prioridade.values()){
            if(cod.equals(x.getCode()))
                return x;
        }

        throw new IllegalAccessException("Prioridade invalido");
    }
}
