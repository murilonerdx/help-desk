package com.murilonerdx.helpdesk.services;

import java.util.List;

public interface DAOService<O, I> {
    O create(O o);
    O findById(I i);
    List<O> listAll();
    void remove(I i);
    O update(O o);
}
