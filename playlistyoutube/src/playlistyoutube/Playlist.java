package playlistyoutube; // กำหนด package ให้ตรงกับ PlaylistManagerApp และ Video

import java.util.ArrayList; // นำเข้า ArrayList เพื่อเก็บ Video ตามลำดับ

public class Playlist { // คลาสแทน Playlist หนึ่งรายการและจัดการวิดีโอของรายการนั้น
    private String name; // เก็บชื่อ Playlist
    private String privacy; // เก็บสถานะ public, unlisted หรือ private
    private ArrayList<Video> videos; // เก็บ Video ทั้งหมดตามลำดับใน Playlist

    public Playlist(String name, String privacy) { // ตัวสร้างรับชื่อและสถานะของ Playlist
        this.name = name; // บันทึกชื่อ Playlist
        this.privacy = privacy; // บันทึกสถานะการมองเห็น
        videos = new ArrayList<Video>(); // สร้างรายการวิดีโอว่างไว้เก็บ Video
    } // จบตัวสร้าง Playlist

    public String getName() { // เมธอดอ่านชื่อ Playlist
        return name; // คืนชื่อ Playlist
    } // จบเมธอดอ่านชื่อ Playlist

    public String getPrivacy() { // เมธอดอ่านสถานะการมองเห็น
        return privacy; // คืนสถานะการมองเห็น
    } // จบเมธอดอ่านสถานะ Playlist

    public int getVideoCount() { // เมธอดอ่านจำนวนวิดีโอใน Playlist
        return videos.size(); // คืนจำนวนสมาชิกใน ArrayList
    } // จบเมธอดอ่านจำนวนวิดีโอ

    public Video getVideoAt(int index) { // เมธอดอ่านวิดีโอตามดัชนี
        return videos.get(index); // คืน Video ที่ตำแหน่งที่ระบุ
    } // จบเมธอดอ่านวิดีโอตามดัชนี

    public void addVideo(Video video) { // เมธอดเพิ่มวิดีโอท้าย Playlist
        videos.add(video); // เพิ่ม Video ลงท้าย ArrayList จึงรักษาลำดับที่เพิ่ม
    } // จบเมธอดเพิ่มวิดีโอ

    public int findVideoIndex(String title) { // เมธอดค้นหาชื่อวิดีโอด้วย Linear Search
        for (int i = 0; i < videos.size(); i++) { // วนตรวจวิดีโอทีละตัวจากรายการแรก
            if (videos.get(i).getTitle().equals(title)) { // เปรียบเทียบชื่อเต็มกับชื่อที่ต้องการค้นหา
                return i; // คืนดัชนีทันทีเมื่อพบชื่อที่ตรงกัน
            } // จบการเปรียบเทียบชื่อวิดีโอตัวปัจจุบัน
        } // จบการวนตรวจวิดีโอทั้งหมด
        return -1; // คืน -1 เมื่อค้นหาครบแล้วยังไม่พบ
    } // จบเมธอดค้นหาวิดีโอ

    public Video removeVideoAt(int index) { // เมธอดลบวิดีโอตามดัชนี
        return videos.remove(index); // ลบ Video และคืนออบเจ็กต์ที่ถูกลบ
    } // จบเมธอดลบวิดีโอ

    public boolean moveVideo(int oldPosition, int newPosition) { // เมธอดย้ายวิดีโอจากตำแหน่งเดิมไปตำแหน่งใหม่
        if (oldPosition < 1 || oldPosition > videos.size()) { // ตรวจว่าตำแหน่งเดิมอยู่นอกช่วงหรือไม่
            return false; // แจ้งว่าย้ายไม่ได้
        } // จบการตรวจตำแหน่งเดิม
        if (newPosition < 1 || newPosition > videos.size()) { // ตรวจว่าตำแหน่งใหม่อยู่นอกช่วงหรือไม่
            return false; // แจ้งว่าย้ายไม่ได้
        } // จบการตรวจตำแหน่งใหม่
        Video video = videos.remove(oldPosition - 1); // นำวิดีโอออกจากดัชนีเดิมและเก็บไว้ชั่วคราว
        videos.add(newPosition - 1, video); // แทรกวิดีโอกลับที่ดัชนีใหม่
        return true; // แจ้งว่าย้ายสำเร็จ
    } // จบเมธอดย้ายวิดีโอ

    public void displayVideos() { // เมธอดแสดงวิดีโอทั้งหมดใน Playlist
        System.out.println(); // เว้นบรรทัดก่อนเริ่มแสดงรายการ
        System.out.println("---------------- รายการวิดีโอ ----------------"); // แสดงหัวข้อรายการ
        System.out.println("Playlist: " + name); // แสดงชื่อ Playlist
        System.out.println("สถานะ: " + privacy); // แสดงระดับการมองเห็น
        if (videos.size() == 0) { // ตรวจว่ารายการวิดีโอว่างหรือไม่
            System.out.println(); // เว้นบรรทัดก่อนแจ้งผล
            System.out.println("ยังไม่มีวิดีโอใน Playlist"); // แจ้งเมื่อยังไม่มีวิดีโอ
            return; // จบเมธอดเพราะไม่มีรายการให้แสดง
        } // จบการตรวจรายการว่าง
        for (int i = 0; i < videos.size(); i++) { // วนแสดงวิดีโอตามลำดับใน ArrayList
            System.out.println(); // เว้นบรรทัดคั่นระหว่างวิดีโอ
            System.out.println("  วิดีโอหมายเลข " + (i + 1)); // แสดงหมายเลขแบบเริ่มนับจากหนึ่ง
            videos.get(i).displayDetails(); // ให้ Video แสดงชื่อและ URL ของตัวเอง
        } // จบการวนแสดงวิดีโอ
        System.out.println(); // เว้นบรรทัดหลังรายการสุดท้าย
    } // จบเมธอดแสดงวิดีโอ
} // จบคลาส Playlist
