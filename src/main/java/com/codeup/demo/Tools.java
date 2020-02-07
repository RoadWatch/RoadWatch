package com.codeup.demo;

public class Tools {
    public boolean tinyToBool(byte n){
        return n != 0;
    }
    public byte boolToTiny(boolean n){
        if (n){
            return 1;
        } else {
            return 0;
        }
    }
}
