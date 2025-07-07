package com.example.mangku.models; // Pastikan ini sesuai dengan lokasi file

public class Manga {
    private String id;
    private String title;
    private String coverUrl; // URL atau path resource gambar
    private String latestChapter;

    public Manga(String id, String title, String coverUrl, String latestChapter) {
        this.id = id;
        this.title = title;
        this.coverUrl = coverUrl;
        this.latestChapter = latestChapter;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public String getLatestChapter() {
        return latestChapter;
    }
}