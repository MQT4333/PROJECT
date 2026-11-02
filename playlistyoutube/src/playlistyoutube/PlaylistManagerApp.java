package playlistyoutube; // กำหนด package ให้ตรงกับคลาส Playlist และ Video

import java.util.ArrayList; // ใช้ ArrayList เก็บ Playlist หลายรายการ
import java.util.Scanner; // ใช้ Scanner รับข้อมูลจากผู้ใช้

public class PlaylistManagerApp { // คลาสหลักที่แสดงเมนูและควบคุมระบบ
    private static Scanner input = new Scanner(System.in); // สร้างตัวอ่านข้อมูลจากแป้นพิมพ์
    private static ArrayList<Playlist> playlists = new ArrayList<Playlist>(); // เก็บ Playlist ทั้งหมดในโปรแกรม

    public static void main(String[] args) { // จุดเริ่มต้นของโปรแกรม Java
        while (true) { // วนแสดงเมนูหลักจนกว่าผู้ใช้เลือกออก
            showMainMenu(); // แสดงเมนูหลักที่มีคำสั่งสำคัญเพียงไม่กี่ข้อ
            int choice = readInt("เลือกเมนู: "); // รับหมายเลขเมนูจากผู้ใช้
            if (choice == 1) { // ตรวจว่าผู้ใช้ต้องการสร้าง Playlist หรือไม่
                createPlaylist(); // เรียกเมธอดสร้าง Playlist
            } else if (choice == 2) { // ตรวจว่าผู้ใช้ต้องการเปิด Playlist เพื่อจัดการหรือไม่
                managePlaylist(); // เรียกเมนูย่อยของ Playlist ที่เลือก
            } else if (choice == 3) { // ตรวจว่าผู้ใช้ต้องการลบ Playlist หรือไม่
                deletePlaylist(); // เรียกเมธอดลบ Playlist
            } else if (choice == 0) { // ตรวจว่าผู้ใช้ต้องการออกจากโปรแกรมหรือไม่
                System.out.println("ปิดโปรแกรมแล้ว"); // แจ้งว่ากำลังจบโปรแกรม
                break; // ออกจากลูปเมนูหลัก
            } else { // ทำงานเมื่อเลือกหมายเลขที่ไม่มีในเมนู
                System.out.println("ไม่มีเมนูนี้ กรุณาเลือกใหม่"); // แจ้งให้เลือกเมนูใหม่
            } // จบการตรวจหมายเลขเมนูหลัก
            System.out.println(); // เว้นบรรทัดก่อนแสดงเมนูรอบต่อไป
        } // จบลูปเมนูหลัก
        input.close(); // ปิด Scanner เมื่อออกจากโปรแกรม
    } // จบเมธอด main

    private static void showMainMenu() { // เมธอดแสดงเมนูหลักแบบสั้น
        System.out.println(); // เว้นบรรทัดก่อนเริ่มส่วนเมนูหลัก
        System.out.println("=================================================="); // วาดเส้นแบ่งส่วนบน
        System.out.println("                 ระบบ Playlist"); // แสดงชื่อโปรแกรมไว้กลางหัวข้อ
        System.out.println("=================================================="); // วาดเส้นแบ่งส่วนล่าง
        System.out.println(); // เว้นบรรทัดระหว่างหัวข้อกับตัวเลือก
        System.out.println("[เมนูหลัก]"); // ระบุชื่อหมวดเมนู
        System.out.println(); // เว้นบรรทัดก่อนตัวเลือกแรก
        System.out.println("  1) สร้าง Playlist"); // แสดงคำสั่งสร้าง Playlist
        System.out.println("  2) เปิด Playlist เพื่อจัดการ"); // แสดงคำสั่งเลือก Playlist แล้วจัดการวิดีโอ
        System.out.println("  3) ลบ Playlist"); // แสดงคำสั่งลบ Playlist
        System.out.println(); // เว้นบรรทัดก่อนคำสั่งออก
        System.out.println("  0) ออกจากโปรแกรม"); // แสดงคำสั่งออกจากโปรแกรม
        System.out.println(); // เว้นบรรทัดก่อนรับหมายเลขเมนู
    } // จบเมธอดแสดงเมนูหลัก

    private static int readInt(String message) { // เมธอดอ่านตัวเลขจำนวนเต็ม
        System.out.print(message); // แสดงข้อความถามผู้ใช้
        int number = input.nextInt(); // อ่านจำนวนเต็มจากแป้นพิมพ์
        input.nextLine(); // อ่านตัวขึ้นบรรทัดใหม่ที่ค้างจาก nextInt
        return number; // คืนจำนวนเต็มให้เมธอดที่เรียกใช้
    } // จบเมธอดอ่านตัวเลข

    private static String readText(String message) { // เมธอดอ่านข้อความทั้งบรรทัด
        System.out.print(message); // แสดงข้อความถามผู้ใช้
        String text = input.nextLine().trim(); // อ่านข้อความและตัดช่องว่างหัวท้าย
        return text; // คืนข้อความให้เมธอดที่เรียกใช้
    } // จบเมธอดอ่านข้อความ

    private static void createPlaylist() { // เมธอดสร้าง Playlist ใหม่
        System.out.println(); // เว้นบรรทัดก่อนเริ่มขั้นตอนสร้าง
        System.out.println("---------------- สร้าง Playlist ----------------"); // แสดงหัวข้อขั้นตอน
        String name = readText("ตั้งชื่อ Playlist: "); // รับชื่อ Playlist
        if (name.equals("")) { // ตรวจว่าชื่อว่างหรือไม่
            System.out.println("กรุณากรอกชื่อ Playlist"); // แจ้งให้ผู้ใช้ใส่ชื่อ
            return; // จบเมธอดโดยไม่สร้างรายการว่าง
        } // จบการตรวจชื่อว่าง
        System.out.println(); // เว้นบรรทัดก่อนตัวเลือกสถานะ
        System.out.println("เลือกระดับการมองเห็น:"); // แสดงหัวข้อสถานะ
        System.out.println("  1) public   - ทุกคนมองเห็น"); // อธิบายสถานะ public
        System.out.println("  2) unlisted - ผู้มีลิงก์จึงเข้าถึงได้"); // อธิบายสถานะ unlisted
        System.out.println("  3) private  - เห็นได้เฉพาะเจ้าของ"); // อธิบายสถานะ private
        int privacyChoice = readInt("เลือก 1, 2 หรือ 3: "); // รับหมายเลขสถานะ
        while (privacyChoice < 1 || privacyChoice > 3) { // วนถามใหม่เมื่อหมายเลขอยู่นอกช่วง
            System.out.println("กรุณาเลือก 1, 2 หรือ 3"); // แจ้งค่าที่เลือกได้
            privacyChoice = readInt("เลือกสถานะ: "); // รับหมายเลขสถานะใหม่
        } // จบการตรวจหมายเลขสถานะ
        String privacy = "private"; // กำหนดค่าเริ่มต้นเป็น private
        if (privacyChoice == 1) { // ตรวจว่าผู้ใช้เลือก public หรือไม่
            privacy = "public"; // กำหนดสถานะ public
        } else if (privacyChoice == 2) { // ตรวจว่าผู้ใช้เลือก unlisted หรือไม่
            privacy = "unlisted"; // กำหนดสถานะ unlisted
        } // ถ้าเลือก 3 จะใช้ค่า private ที่กำหนดไว้แล้ว
        Playlist playlist = new Playlist(name, privacy); // สร้างออบเจ็กต์ Playlist
        playlists.add(playlist); // เพิ่ม Playlist ลงใน ArrayList หลัก
        System.out.println(); // เว้นบรรทัดก่อนแสดงผล
        System.out.println("สร้าง Playlist สำเร็จ"); // แจ้งผลการสร้าง
        System.out.println("ใช้เมนู 2 เพื่อเพิ่มหรือจัดการวิดีโอ"); // บอกขั้นตอนถัดไป
    } // จบเมธอดสร้าง Playlist

    private static void showPlaylists() { // เมธอดแสดงรายการ Playlist ทั้งหมด
        if (playlists.size() == 0) { // ตรวจว่ามี Playlist หรือไม่
            System.out.println("ยังไม่มี Playlist"); // แจ้งเมื่อรายการยังว่าง
            return; // จบเมธอดเพราะไม่มีรายการให้แสดง
        } // จบการตรวจรายการว่าง
        System.out.println(); // เว้นบรรทัดก่อนเริ่มรายการ
        System.out.println("---------------- Playlist ของคุณ ----------------"); // แสดงหัวข้อรายการ
        for (int i = 0; i < playlists.size(); i++) { // วนผ่าน Playlist ทุกตัว
            Playlist playlist = playlists.get(i); // อ่าน Playlist ตามตำแหน่งปัจจุบัน
            System.out.println((i + 1) + ") " + playlist.getName() + " | " + playlist.getPrivacy() + " | " + playlist.getVideoCount() + " วิดีโอ"); // แสดงหมายเลข ชื่อ สถานะ และจำนวนวิดีโอ
        } // จบการวนแสดง Playlist
    } // จบเมธอดแสดง Playlist

    private static int choosePlaylistIndex() { // เมธอดให้ผู้ใช้เลือก Playlist และคืนดัชนี
        if (playlists.size() == 0) { // ตรวจว่ามี Playlist ให้เลือกหรือไม่
            System.out.println("ยังไม่มี Playlist กรุณาสร้างก่อน"); // แจ้งว่าต้องสร้าง Playlist ก่อน
            return -1; // คืน -1 เพื่อบอกว่าเลือกไม่ได้
        } // จบการตรวจรายการว่าง
        showPlaylists(); // แสดงรายการให้ผู้ใช้เลือก
        System.out.println(); // เว้นบรรทัดก่อนถามหมายเลข
        int number = readInt("เลือกหมายเลข Playlist: "); // รับหมายเลขที่ผู้ใช้เลือก
        if (number < 1 || number > playlists.size()) { // ตรวจว่าหมายเลขอยู่นอกช่วงหรือไม่
            System.out.println("หมายเลข Playlist ไม่ถูกต้อง"); // แจ้งว่าหมายเลขไม่ถูกต้อง
            return -1; // คืน -1 เพื่อยกเลิกการทำงาน
        } // จบการตรวจหมายเลข Playlist
        return number - 1; // แปลงหมายเลขหน้าจอเริ่มจาก 1 เป็นดัชนี ArrayList เริ่มจาก 0
    } // จบเมธอดเลือก Playlist

    private static void managePlaylist() { // เมธอดเลือก Playlist หนึ่งครั้งแล้วจัดการต่อเนื่อง
        int playlistIndex = choosePlaylistIndex(); // ให้ผู้ใช้เลือก Playlist
        if (playlistIndex == -1) { // ตรวจว่าเลือก Playlist ไม่สำเร็จหรือไม่
            return; // กลับไปเมนูหลัก
        } // จบการตรวจผลการเลือก
        Playlist playlist = playlists.get(playlistIndex); // อ่าน Playlist ที่เลือกไว้ใช้ในเมนูย่อย
        while (true) { // วนอยู่ใน Playlist เดิมจนกว่าผู้ใช้เลือกกลับ
            showManageMenu(playlist); // แสดงคำสั่งจัดการ Playlist ที่เลือก
            int choice = readInt("เลือกเมนู: "); // รับหมายเลขคำสั่งย่อย
            if (choice == 1) { // ตรวจว่าต้องการเพิ่มวิดีโอหรือไม่
                addVideo(playlist); // เพิ่มวิดีโอลง Playlist ที่เลือกไว้
            } else if (choice == 2) { // ตรวจว่าต้องการดูวิดีโอหรือไม่
                playlist.displayVideos(); // แสดงวิดีโอใน Playlist ที่เลือกไว้
            } else if (choice == 3) { // ตรวจว่าต้องการค้นหาวิดีโอหรือไม่
                searchVideo(playlist); // ค้นหาวิดีโอใน Playlist ที่เลือกไว้
            } else if (choice == 4) { // ตรวจว่าต้องการลบวิดีโอหรือไม่
                removeVideo(playlist); // ลบวิดีโอจาก Playlist ที่เลือกไว้
            } else if (choice == 5) { // ตรวจว่าต้องการย้ายลำดับหรือไม่
                moveVideo(playlist); // ย้ายวิดีโอใน Playlist ที่เลือกไว้
            } else if (choice == 0) { // ตรวจว่าต้องการกลับเมนูหลักหรือไม่
                break; // ออกจากเมนูย่อย
            } else { // ทำงานเมื่อเลือกหมายเลขที่ไม่มี
                System.out.println("ไม่มีเมนูนี้ กรุณาเลือกใหม่"); // แจ้งให้เลือกเมนูใหม่
            } // จบการตรวจคำสั่งย่อย
            System.out.println(); // เว้นบรรทัดก่อนแสดงเมนูย่อยอีกครั้ง
        } // จบลูปจัดการ Playlist
    } // จบเมธอดจัดการ Playlist

    private static void showManageMenu(Playlist playlist) { // เมธอดแสดงเมนูย่อยของ Playlist ที่เลือก
        System.out.println(); // เว้นบรรทัดก่อนเริ่มเมนูจัดการ
        System.out.println("=================================================="); // วาดเส้นแบ่งส่วนบน
        System.out.println("กำลังจัดการ Playlist: " + playlist.getName()); // แสดงชื่อ Playlist ปัจจุบัน
        System.out.println("=================================================="); // วาดเส้นแบ่งส่วนล่าง
        System.out.println(); // เว้นบรรทัดระหว่างหัวข้อกับคำสั่ง
        System.out.println("[วิดีโอ]"); // แสดงหัวข้อกลุ่มคำสั่งวิดีโอ
        System.out.println("  1) เพิ่มวิดีโอ"); // แสดงคำสั่งเพิ่มวิดีโอ
        System.out.println("  2) ดูวิดีโอทั้งหมด"); // แสดงคำสั่งดูรายการ
        System.out.println(); // เว้นบรรทัดก่อนกลุ่มค้นหาและจัดลำดับ
        System.out.println("[ค้นหาและจัดลำดับ]"); // แสดงหัวข้อกลุ่มคำสั่งค้นหา
        System.out.println("  3) ค้นหาวิดีโอ"); // แสดงคำสั่งค้นหา
        System.out.println("  4) ลบวิดีโอ"); // แสดงคำสั่งลบ
        System.out.println("  5) ย้ายลำดับวิดีโอ"); // แสดงคำสั่งย้ายลำดับ
        System.out.println(); // เว้นบรรทัดก่อนคำสั่งกลับ
        System.out.println("  0) กลับเมนูหลัก"); // แสดงคำสั่งกลับ
        System.out.println(); // เว้นบรรทัดก่อนรับหมายเลขเมนู
    } // จบเมธอดแสดงเมนูย่อย

    private static void addVideo(Playlist playlist) { // เมธอดรับข้อมูลแล้วเพิ่มวิดีโอใน Playlist ที่เลือก
        System.out.println(); // เว้นบรรทัดก่อนเริ่มเพิ่มวิดีโอ
        System.out.println("---------------- เพิ่มวิดีโอ ----------------"); // แสดงหัวข้อขั้นตอน
        String title = readText("ชื่อวิดีโอ: "); // รับชื่อวิดีโอ
        String url = readText("ลิงก์ YouTube: "); // รับ URL ของวิดีโอ
        if (title.equals("") || url.equals("")) { // ตรวจว่าชื่อหรือลิงก์ว่างหรือไม่
            System.out.println("กรุณากรอกทั้งชื่อและลิงก์"); // แจ้งว่าต้องกรอกข้อมูลทั้งสองช่อง
            return; // จบเมธอดโดยไม่เพิ่มข้อมูล
        } // จบการตรวจข้อมูลว่าง
        Video video = new Video(title, url); // สร้างออบเจ็กต์ Video จากชื่อและ URL
        playlist.addVideo(video); // ให้ Playlist เพิ่ม Video ลงท้าย ArrayList
        System.out.println(); // เว้นบรรทัดก่อนแสดงผล
        System.out.println("เพิ่มวิดีโอสำเร็จ"); // แจ้งผลการเพิ่ม
    } // จบเมธอดเพิ่มวิดีโอ

    private static void searchVideo(Playlist playlist) { // เมธอดค้นหาวิดีโอใน Playlist ที่เลือกไว้
        if (playlist.getVideoCount() == 0) { // ตรวจว่า Playlist ยังไม่มีวิดีโอหรือไม่
            System.out.println("Playlist นี้ยังไม่มีวิดีโอ"); // แจ้งว่าไม่มีข้อมูลให้ค้นหา
            return; // จบเมธอดค้นหา
        } // จบการตรวจรายการว่าง
        System.out.println(); // เว้นบรรทัดก่อนเริ่มค้นหา
        System.out.println("---------------- ค้นหาวิดีโอ ----------------"); // แสดงหัวข้อขั้นตอน
        String title = readText("พิมพ์ชื่อให้ตรงกับรายการ: "); // รับชื่อเต็มที่ต้องการค้นหา
        int index = playlist.findVideoIndex(title); // เรียก Linear Search จากคลาส Playlist
        if (index == -1) { // ตรวจว่าเมธอดคืน -1 ซึ่งหมายถึงไม่พบหรือไม่
            System.out.println("ไม่พบวิดีโอนี้"); // แสดงผลเมื่อค้นหาไม่พบ
        } else { // ทำงานเมื่อค้นพบวิดีโอ
            System.out.println("พบวิดีโอลำดับที่ " + (index + 1)); // แสดงหมายเลขที่เริ่มนับจาก 1
            playlist.getVideoAt(index).displayDetails(); // แสดงชื่อและ URL ของวิดีโอที่พบ
        } // จบการแสดงผลค้นหา
    } // จบเมธอดค้นหาวิดีโอ

    private static void removeVideo(Playlist playlist) { // เมธอดลบวิดีโอตามหมายเลขใน Playlist ที่เลือก
        System.out.println(); // เว้นบรรทัดก่อนเริ่มลบ
        System.out.println("---------------- ลบวิดีโอ ----------------"); // แสดงหัวข้อขั้นตอน
        playlist.displayVideos(); // แสดงรายการเพื่อให้ผู้ใช้เลือกหมายเลข
        if (playlist.getVideoCount() == 0) { // ตรวจว่ารายการวิดีโอว่างหรือไม่
            return; // จบเมธอดเพราะไม่มีวิดีโอให้ลบ
        } // จบการตรวจรายการว่าง
        System.out.println(); // เว้นบรรทัดก่อนถามหมายเลข
        int number = readInt("หมายเลขวิดีโอที่ต้องการลบ: "); // รับหมายเลขจากผู้ใช้
        if (number < 1 || number > playlist.getVideoCount()) { // ตรวจว่าหมายเลขอยู่นอกช่วงหรือไม่
            System.out.println("หมายเลขวิดีโอไม่ถูกต้อง"); // แจ้งว่าหมายเลขไม่ถูกต้อง
            return; // จบเมธอดโดยไม่ลบข้อมูล
        } // จบการตรวจหมายเลขวิดีโอ
        Video removedVideo = playlist.removeVideoAt(number - 1); // ลบวิดีโอตามดัชนี ArrayList
        System.out.println("ลบวิดีโอแล้ว: " + removedVideo.getTitle()); // แจ้งชื่อวิดีโอที่ลบ
    } // จบเมธอดลบวิดีโอ

    private static void moveVideo(Playlist playlist) { // เมธอดย้ายวิดีโอใน Playlist ที่เลือกไว้
        System.out.println(); // เว้นบรรทัดก่อนเริ่มย้ายลำดับ
        System.out.println("---------------- ย้ายลำดับวิดีโอ ----------------"); // แสดงหัวข้อขั้นตอน
        playlist.displayVideos(); // แสดงลำดับปัจจุบันให้ผู้ใช้ดู
        if (playlist.getVideoCount() == 0) { // ตรวจว่ามีวิดีโอให้ย้ายหรือไม่
            return; // จบเมธอดเพราะไม่มีวิดีโอ
        } // จบการตรวจรายการว่าง
        System.out.println(); // เว้นบรรทัดก่อนถามตำแหน่ง
        System.out.println("หมายเลขเริ่มนับจาก 1 เช่น ย้ายหมายเลข 3 ไปหมายเลข 1"); // ยกตัวอย่างรูปแบบการกรอก
        int oldPosition = readInt("หมายเลขเดิม: "); // รับตำแหน่งเดิม
        int newPosition = readInt("หมายเลขใหม่: "); // รับตำแหน่งปลายทาง
        if (playlist.moveVideo(oldPosition, newPosition)) { // ให้ Playlist ย้ายวิดีโอ
            System.out.println("ย้ายลำดับวิดีโอสำเร็จ"); // แจ้งผลการย้าย
        } else { // ทำงานเมื่อหมายเลขตำแหน่งไม่ถูกต้อง
            System.out.println("หมายเลขตำแหน่งไม่ถูกต้อง"); // แจ้งให้ตรวจตำแหน่งอีกครั้ง
        } // จบการแจ้งผลการย้าย
    } // จบเมธอดย้ายวิดีโอ

    private static void deletePlaylist() { // เมธอดลบ Playlist ที่เลือก
        System.out.println(); // เว้นบรรทัดก่อนเริ่มลบ Playlist
        System.out.println("---------------- ลบ Playlist ----------------"); // แสดงหัวข้อขั้นตอน
        int playlistIndex = choosePlaylistIndex(); // ให้ผู้ใช้เลือก Playlist ที่ต้องการลบ
        if (playlistIndex == -1) { // ตรวจว่าเลือก Playlist ไม่สำเร็จหรือไม่
            return; // จบเมธอดเมื่อไม่มี Playlist เป้าหมาย
        } // จบการตรวจผลการเลือก
        Playlist removedPlaylist = playlists.remove(playlistIndex); // ลบ Playlist ตามดัชนีและรับออบเจ็กต์ที่ถูกลบ
        System.out.println("ลบ Playlist แล้ว: " + removedPlaylist.getName()); // แจ้งชื่อ Playlist ที่ลบ
    } // จบเมธอดลบ Playlist
} // จบคลาสหลัก
