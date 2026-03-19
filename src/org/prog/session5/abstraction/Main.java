package org.prog.session5.abstraction;

public class Main {

    public static void main(String[] args) {
        GooglePage googlePage = new GooglePage();
        googlePage.loadPage();

        AmazonPage amazonPage = new AmazonPage();
        amazonPage.loadPage();
    }
}
