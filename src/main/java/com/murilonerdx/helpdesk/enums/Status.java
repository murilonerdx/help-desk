package com.murilonerdx.helpdesk.enums;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public enum Status {
    ABERTO(0, "ABERTO"), ANDAMENTO(1, "ANDAMENTO"), ENCERRADO(2, "ENCERRADO");

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

        throw new IllegalAccessException("Status invalido");
    }
}
