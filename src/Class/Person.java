package Class;

import java.util.HashMap;
import java.util.Map;

public class Person {
    private String maID;
    private String ten;
    private String soCMND;
    private String soDienThoai;

    // Lưu bộ đếm riêng cho từng loại (NV, KH, ...)
    private static Map<String, Integer> demTheoPrefix = new HashMap<>();

    // Constructor tự tạo ID theo prefix, đếm riêng từng loại
    public Person(String prefix) {
        int so = demTheoPrefix.getOrDefault(prefix, 0) + 1;
        demTheoPrefix.put(prefix, so);
        this.maID = String.format("%s%03d", prefix, so);
    }

    // Constructor đầy đủ thông tin
    public Person(String prefix, String ten, String soCMND, String soDienThoai) {
        this(prefix);
        setTen(ten);
        setSoCMND(soCMND);
        setSoDienThoai(soDienThoai);
    }

    // ===== GETTER =====
    public String getMaID() {
        return maID;
    }

    public String getTen() {
        return ten;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    // ===== SETTER =====
    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    // ===== TIỆN ÍCH =====
    public static void resetCounter() {
        demTheoPrefix.clear();
    }
}
