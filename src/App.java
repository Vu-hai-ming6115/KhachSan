import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import Class.KhachHang;
import Class.NhanVien;
import Class.QuanLyPhong;
import Class.ThanhToan;

public class App {
    private static Scanner sc = new Scanner(System.in);
    private static List<KhachHang> dsKhachHang = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== MENU CHINH =====");
            System.out.println("1. Quan ly khach hang");
            System.out.println("2. Quan ly phong");
            System.out.println("3. Quan ly doanh thu");
            System.out.println("4. Quan ly nhan vien");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> menuKhachHang();
                case 2 -> menuPhong();
                case 3 -> menuThanhToan();
                case 4 -> menuNhanVien();
                case 0 -> System.out.println("Tam biet!");
                default -> System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 0);
    }

    // ===== MENU KHÁCH HÀNG =====
    private static void menuKhachHang() {
        int choice;
        do {
            System.out.println("\n===== QUAN LY KHACH HANG =====");
            System.out.println("1. Them khach hang");
            System.out.println("2. Xoa khach hang");
            System.out.println("3. Sua thong tin khach hang");
            System.out.println("4. Xem danh sach khach hang");
            System.out.println("5. Tim thong tin khach hang");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> {
                    KhachHang.themKhachHang();
                    capNhatDanhSachKhach();
                }
                case 2 -> {
                    KhachHang.xoaKhachHang();
                    capNhatDanhSachKhach();
                }
                case 3 -> {
                    KhachHang.suaKhachHang();
                    capNhatDanhSachKhach();
                }
                case 4 -> KhachHang.xemKhachHang();
                case 5 -> KhachHang.timKhachHang();
                case 0 -> System.out.println("Quay lai menu chinh");
                default -> System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 0);
    }

    // ===== MENU PHÒNG =====
    private static void menuPhong() {
        int choice;
        do {
            System.out.println("\n===== QUAN LY PHONG =====");
            System.out.println("1. Xem danh sach phong");
            System.out.println("2. Dat phong");
            System.out.println("3. Tra phong va thanh toan");
            System.out.println("4. Xem khach thue theo phong");
            System.out.println("5. Xoa phong");
            System.out.println("6. Them dich vu");
            System.out.println("7. Xem dich vu");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> QuanLyPhong.xemDanhSachPhong();
                case 2 -> QuanLyPhong.datPhong(dsKhachHang);
                case 3 -> {
                    // Khi trả phòng thì tạo bản ghi thanh toán
                    ThanhToan.thanhToanPhong();
                }
                case 4 -> QuanLyPhong.xemKhachTheoPhong();
                case 5 -> QuanLyPhong.xoaPhong();
                case 6 -> QuanLyPhong.themDichVuVaoPhong(sc);
                case 7 -> QuanLyPhong.xemDichVuTheoPhong(sc);
                case 0 -> System.out.println("Quay lai menu chinh");
                default -> System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 0);
    }

    // ===== MENU DOANH THU =====
    private static void menuThanhToan() {
        int choice;
        do {
            System.out.println("\n===== QUAN LY DOANH THU =====");
            System.out.println("1. Xem lich su thanh toan");
            System.out.println("2. Xem tong doanh thu");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> ThanhToan.xemLichSuThanhToan();
                case 2 -> ThanhToan.xemDoanhThu();
                case 0 -> System.out.println("Quay lai menu chinh");
                default -> System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 0);
    }

    // ===== MENU Nhan Vien =====
    private static void menuNhanVien(){
        int choice1;
        do {
            System.out.println("\n===== QUAN LY NHAN VIEN =====");
            System.out.println("1. Them nhan vien");
            System.out.println("2. Xoa nhan vien");
            System.out.println("3. Sua thong tin nhan vien");
            System.out.println("4. Xem danh sach nhan vien");
            System.out.println("5. Thanh toan tien luong");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            choice1 = Integer.parseInt(sc.nextLine());

            switch (choice1) {
                case 1 -> {
                    NhanVien.themNhanVien();
                }
                case 2 -> {
                    NhanVien.xoaNhanVien();
                    
                }
                case 3 -> {
                    NhanVien.suaNhanVien();
                    
                }
                case 4 -> NhanVien.xemNhanVien();
                case 5 -> NhanVien.ThanhToanLuong();
                case 0 -> System.out.println("Quay lai menu chinh");
                default -> System.out.println("Lua chon khong hop le!");
            }
        } while (choice1 != 0);
    }

    // ===== CẬP NHẬT DANH SÁCH KHÁCH HÀNG =====
    @SuppressWarnings("unchecked")
    private static void capNhatDanhSachKhach() {
        try {
            java.lang.reflect.Field field = KhachHang.class.getDeclaredField("dsKhachHang");
            field.setAccessible(true);
            dsKhachHang = (List<KhachHang>) field.get(null);
        } catch (Exception e) {
            System.out.println("Khong the cap nhat danh sach khach hang!");
        }
    }
    
}