package com.example.Ajax_PhanTrang;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class BacSiRepository {
    Session s;

    public BacSiRepository() {
        s = HibernateConfig.getFACTORY().openSession();
    }

    public List<BacSi> hienThi() {
        return s.createQuery("FROM BacSi bs").list();
    }

    public List<BacSi> phanTrang(int page, int pageSize) {
        Query query = s.createQuery("FROM BacSi");
        query.setFirstResult(page * pageSize);
        query.setMaxResults(pageSize);
        return (List<BacSi>) query.list();
    }
}
