package com.recSystem.Utils;

import lombok.Data;

@Data
public class B {
    private A a;
    private String c;

    @Override
    public String toString() {
        return a + " - " + c;
    }
}
