package com.murilonerdx.helpdesk.services;

import java.util.List;

public interface DAOService<O, I, D> {
    O create(D o);
    O findById(I i);
    List<O> listAll();
    void remove(I i);
    O update(I i, D o);
}
