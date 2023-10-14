package com.hunbk.shop.controller;

import java.io.File;

public interface StringConst {
    String AUTH_INFO = "authInfo";

    String UPLOAD_PATH = "file:" +
            System.getProperty("user.dir") + File.separator +
            "src" + File.separator +
            "main" + File.separator +
            "resources" + File.separator +
            "upload" + File.separator;
}
