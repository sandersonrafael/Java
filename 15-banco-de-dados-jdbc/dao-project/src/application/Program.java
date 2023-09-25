package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== Teste 1: seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("\n=== Teste 2: seller findByDepartment ===");

        List<Seller> sellers = sellerDao.findByDepartment(new Department(2, null));
        sellers.forEach(System.out::println);

        System.out.println("\n=== Teste 3: seller findAll ===");

        sellers = sellerDao.findAll();
        sellers.forEach(System.out::println);
    }
}
