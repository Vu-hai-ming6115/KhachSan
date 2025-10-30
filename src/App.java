import java.util.Scanner;
import Class.KhachHang;
import Class.QuanLyPhong;

import java.util.ArrayList;
import java.util.List;

public class App {
    private static Scanner sc = new Scanner(System.in);
    private static List<KhachHang> dsKhachHang = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== MENU CHINH =====");
            System.out.println("1. Quan ly khach hàng");
            System.out.println("2. Quan ly phong");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> menuKhachHang();
                case 2 -> menuPhong();
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
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> {
                    KhachHang.themKhachHang();
                    // Sau khi thêm, ta lưu lại danh sách (để phòng có thể dùng)
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
            System.out.println("3. Tra phong");
            System.out.println("4. Xem khach thue theo phong");
            System.out.println("0. Quay lai");
            System.out.print("Chon: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> QuanLyPhong.xemDanhSachPhong();
                case 2 -> QuanLyPhong.datPhong(dsKhachHang);
                case 3 -> QuanLyPhong.traPhong();
                case 4 -> QuanLyPhong.xemKhachTheoPhong();
                case 0 -> System.out.println("Quay lai menu chinh");
                default -> System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 0);
    }

    // ===== CẬP NHẬT DANH SÁCH KHÁCH HÀNG =====
    private static void capNhatDanhSachKhach() {
        // Lấy danh sách mới từ class KhachHang
        try {
            java.lang.reflect.Field field = KhachHang.class.getDeclaredField("dsKhachHang");
            field.setAccessible(true);
            dsKhachHang = (List<KhachHang>) field.get(null);
        } catch (Exception e) {
            System.out.println("Khong the cap nhat danh sach khach hang!");
        }
    }
}