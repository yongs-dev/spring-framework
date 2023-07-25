package com.mark.springframework.examples.c1;

import org.springframework.stereotype.Repository;

@Repository
public class MySqlDBDataService implements DataService {

    @Override
    public int[] retrieveData() {
        return new int[]{1, 2, 3, 4, 5};
    }
}
