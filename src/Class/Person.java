package Class;

public class Person {
    private String maID;
    private String ten;
    private String soCMND;
    private String soDienThoai;

    protected static int cnt = 1;

    // Constructor tự tạo ID tăng dần
    public Person(String prefix) {
        this.maID = String.format("%s%03d",prefix, cnt++);
    }

    // Constructor đầy đủ thông tin (không nhập maID thủ công)
    public Person(String prefix,String ten, String soCMND, String soDienThoai) {
        this(prefix);  // Gọi constructor để tự tạo maID
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

    // Reset ID counter nếu cần
    public static void setCnt(int cnt) {
        Person.cnt = cnt;
    }
}
