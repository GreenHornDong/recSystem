package com.recSystem.Utils;

import lombok.Data;

@Data
public class A {
    private String A1;
    private String A2;

    @Override
    public String toString() {
        return A1 + " - " + A2;
    }
}
