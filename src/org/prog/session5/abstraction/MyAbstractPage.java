package org.prog.session5.abstraction;

public abstract class MyAbstractPage {

    private String url;

    public MyAbstractPage(String url) {
        this.url = url;
    }

    public void loadPage() {
        System.out.println("Loading page " + url);
    }
}
