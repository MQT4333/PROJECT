package playlistyoutube; // กำหนด package ให้ตรงกับ PlaylistManagerApp และ Playlist

public class Video { // คลาสเก็บข้อมูลวิดีโอหนึ่งรายการ
    private String title; // เก็บชื่อวิดีโอ
    private String url; // เก็บลิงก์วิดีโอที่ผู้ใช้กรอก

    public Video(String title, String url) { // ตัวสร้างรับชื่อและลิงก์วิดีโอ
        this.title = title; // บันทึกชื่อวิดีโอ
        this.url = url; // บันทึกลิงก์วิดีโอ
    } // จบตัวสร้าง Video

    public String getTitle() { // เมธอดอ่านชื่อวิดีโอ
        return title; // คืนชื่อวิดีโอ
    } // จบเมธอดอ่านชื่อวิดีโอ

    public String getUrl() { // เมธอดอ่านลิงก์วิดีโอ
        return url; // คืนลิงก์วิดีโอ
    } // จบเมธอดอ่านลิงก์วิดีโอ

    public void displayDetails() { // เมธอดแสดงข้อมูลวิดีโอ
        System.out.println("    ชื่อ: " + title); // แสดงชื่อวิดีโอแยกเป็นบรรทัด
        System.out.println("    URL : " + url); // แสดงลิงก์แยกเป็นบรรทัด
    } // จบเมธอดแสดงข้อมูลวิดีโอ
} // จบคลาส Video
