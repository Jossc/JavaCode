package com.basics.enumTest;

/**
 * @ClassName EnumTest
 * @Despacito TODO
 * @Author chenzhuo
 * @Version 1.0
 **/
public enum  EnumTest {
    ADULT_SBP_FIRST_LEVEL("abc"){
        @Override
        public String testMethod(String originalValue) {
            return "cc";
        }
    };
    String value;
    EnumTest(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    public abstract String testMethod(String originalValue);
}
