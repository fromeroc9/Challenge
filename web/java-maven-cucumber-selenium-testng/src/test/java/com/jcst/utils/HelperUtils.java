package com.jcst.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.security.SecureRandom;
import java.util.*;

public class HelperUtils {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final Random RANDOM = new SecureRandom();

    public static String generateRandomString(int length) {
        Objects.requireNonNull(length, "Length cannot be null");
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be greater than zero");
        }

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }

    public static void sleep(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleep(double seconds){
        try {
            Thread.sleep((long) (seconds * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clickElement(List<WebElement> elements, String value){
        elements.stream()
                .filter( element ->  element.getText().contains(value) )
                .findFirst()
                .ifPresent( (e) -> {
                    scrollElement(e);
                    sleep(1);
                    e.click();
                });
    }

    public static void clickElement2(List<WebElement> elements, String value){
        elements.stream()
                .filter( element ->  element.getText().contains(value) )
                .findFirst()
                .ifPresent( (e) -> {
                    scrollElement(e);
                    sleep(1);
                    e.click();
                });
    }

    public static void scrollElement(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) HelperClass.getDriver();
            js.executeScript("arguments[0].scrollIntoView();", element);
        } catch (RuntimeException we) {
            System.out.println("Error: " + we.getMessage());
        }
    }

    public static List<String> getElement(List<WebElement> elements){
        List<String> response = new ArrayList<>();
        elements.forEach( element -> {
            response.add(element.getText());
        });
        return response;
    }
}
