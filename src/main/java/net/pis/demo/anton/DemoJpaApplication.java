package net.pis.demo.anton;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import net.pis.demo.anton.dao.BeritaDao;

import net.pis.demo.anton.entity.Berita;
import net.pis.demo.anton.entity.Komentar;

@SpringBootApplication
public class DemoJpaApplication {

	public static void main(String[] args) {
		//ApplicationContext app = 
				SpringApplication.run(DemoJpaApplication.class, args);
		
		/*Berita b = new Berita();
        b.setJudul("Ridho Rhoma Ditangkap BNN");
        b.setIsi("Ridho Rhoma Menyesal Pakai Narkoba");
        b.setWaktuPublikasi(new Date());

        Komentar k = new Komentar();
        k.setEmail("anton@example.com");
        k.setNama("Anton Purwanto");
        k.setIsi("Wih, ngeri gan");
        k.setWaktuPublikasi(new Date());
        
        k.setBerita(b);
        
        b.getDaftarKomentar().add(k);
        BeritaDao bd = app.getBean(BeritaDao.class);
        bd.save(b);*/
	}
}
