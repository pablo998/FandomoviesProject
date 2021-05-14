package com.example.fandomoviesproject.data;

public class DocuItemCatalog {
    public final String details;
    public final int id;
    public final String content;

    public DocuItemCatalog(int id, String content, String details) {
        this.details = details;
        this.id = id;
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}
