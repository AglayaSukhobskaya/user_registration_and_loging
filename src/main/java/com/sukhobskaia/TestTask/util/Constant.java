package com.sukhobskaia.TestTask.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constant {
    public static final String PASSWORD_PATTERN = "^(?=.*[A-Z])(?=.*[a-zA-Z\\d]).{6,}$";
}
