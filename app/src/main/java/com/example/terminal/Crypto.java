package com.example.terminal;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import android.util.Log;

import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class Crypto {
    private static final String TRANSFORM = "AES";
    private static final String LOG_MESSAGE = "TEST.Crypto";

    private Cipher cipher;

    public Crypto(){
        try {
            cipher = Cipher.getInstance(TRANSFORM);
        }catch (NoSuchPaddingException | NoSuchAlgorithmException ex){
            Log.e(LOG_MESSAGE, "Error initializing crypto", ex);
        }
    }

    public void encrypt(String data){
        try {
            byte[] plainText  = data.getBytes("UTF-8");
            byte[] cipherText = cipher.doFinal(plainText);

        }catch (BadPaddingException | IllegalBlockSizeException  | UnsupportedEncodingException ex){
            Log.e(LOG_MESSAGE, "Error crypt string", ex);
        }
    }

}
