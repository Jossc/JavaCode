package com.enums;

public enum TestEnums {
    /**
     * hha
     */
    H("11",1),
    A("22",2);

    String name;
    int gae;

    TestEnums(String name, int gae) {
        this.name = name;
        this.gae = gae;
    }

    public String getName() {
        return name;
    }

    public int getGae() {
        return gae;
    }
}
