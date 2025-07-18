package business;

import entity.Invoice;
import java.util.ArrayList;

public class ManageImp implements Manage<Invoice> {
    private ArrayList<Invoice> invoiceList = new ArrayList<>();

    @Override
    public void add(Invoice item) {
        invoiceList.add(item);
    }

    @Override
    public void update(int index, Invoice item) {
        if (index >= 0 && index < invoiceList.size()) {
            invoiceList.set(index, item);
        } else {
            System.out.println("Không tìm thấy hóa đơn với id = " + (index + 1));
        }
    }

    @Override
    public void delete(int index) {
        if (index >= 0 && index < invoiceList.size()) {
            invoiceList.remove(index);
        } else {
            System.out.println("Không tìm thấy hóa đơn với id = " + (index + 1));
        }
    }

    @Override
    public void display() {
        if (invoiceList.isEmpty()) {
            System.out.println("Danh sách hóa đơn trống.");
        } else {
            for (int i = 0; i < invoiceList.size(); i++) {
                System.out.println("ID : " + (i + 1) + " , " + invoiceList.get(i));
            }
        }
    }
}
