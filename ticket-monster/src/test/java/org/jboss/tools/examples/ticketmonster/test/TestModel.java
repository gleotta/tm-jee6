package org.jboss.tools.examples.ticketmonster.test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jboss.tools.examples.ticketmonster.model.CategoriaDisco;
import org.jboss.tools.examples.ticketmonster.model.CategoriaSoftware;
import org.jboss.tools.examples.ticketmonster.model.Compra;
import org.jboss.tools.examples.ticketmonster.model.Disco;
import org.jboss.tools.examples.ticketmonster.model.Genero;
import org.jboss.tools.examples.ticketmonster.model.Pelicula;
import org.jboss.tools.examples.ticketmonster.model.Producto;
import org.jboss.tools.examples.ticketmonster.model.Software;
import org.jboss.tools.examples.ticketmonster.model.Usuario;

public class TestModel {

	private static EntityManager em;

	private static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyyy");

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("tm-test");
		em = emf.createEntityManager();
		try {
			// Incio transaccion
			em.getTransaction().begin();
//
			cargarCategorias();
//
			cargarProductos();
//
			cargarUsuarios();
//
			cargarCompras();

			em.getTransaction().commit();

		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}

	}

	private static void cargarCompras() {
		// TODO Auto-generated method stub
		Compra compra1 = new Compra();
		compra1.setUsuario((Usuario) em
				.createQuery("select u from Usuario u where u.email = :email")
				.setParameter("email", "pepe@argentina.com").getSingleResult());
		
		
		Producto p = (Producto) em
				.createQuery("select p from Producto p where p.codigo = :codigo")
				.setParameter("codigo", "SALMON").getSingleResult();
		compra1.setProducto(p);
		compra1.setFecha(new Date());
		
		double monto = p.getPrecio().doubleValue() * 1.21;
		compra1.setMonto(new BigDecimal(monto, new MathContext(2)));
		
		em.persist(compra1);

	}

	private static void cargarUsuarios() {
		// TODO Auto-generated method stub
		Usuario u1 = new Usuario();
		u1.setNombre("Pepe");
		u1.setApellido("Argento");
		u1.setEmail("pepe@argentina.com");
		try {
			u1.setFechaNacimiento(dateFormat.parse("28/12/1971"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		u1.setContrasenia("pepe");

		Usuario u2 = new Usuario();
		u2.setNombre("Moni");
		u2.setApellido("Argento");
		u2.setEmail("moni@argentina.com");
		try {
			u2.setFechaNacimiento(dateFormat.parse("11/05/1973"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		u2.setContrasenia("moni");

		em.persist(u1);
		em.persist(u2);

	}

	private static void cargarProductos() {
		// TODO Auto-generated method stub
		Disco disco1 = new Disco();
		disco1.setArtista("Andres Calamaro");
		disco1.setCantidadTrack(101);
		disco1.setCodigo("SALMON");
		disco1.setDescripcion("El Salmon");
		disco1.setPrecio(new BigDecimal("54.35"));
		disco1.setCategoria((CategoriaDisco) em
				.createQuery(
						"select c from CategoriaDisco c where c.nombre = :cat")
				.setParameter("cat", "rock").getSingleResult());
		disco1.setTitulo("El Salmon");

		Pelicula peli1 = new Pelicula();
		peli1.setCodigo("VOLVERFUTURO");
		peli1.setDescripcion("Volever al Futuro");
		peli1.setDirector("Steven Spielberg");
		peli1.setDuracion(95);
		peli1.setGenero((Genero) em
				.createQuery("select c from Genero c where c.nombre = :cat")
				.setParameter("cat", "ficcion").getSingleResult());
		peli1.setPrecio(new BigDecimal("35.87"));
		peli1.setTitulo("Back to the Future");

		Software soft1 = new Software();
		soft1.setAutor("Google Inc");
		soft1.setCodigo("GTALK");
		soft1.setDescripcion("Google Talk (Hangout sucks!)");
		soft1.setLicencia("Google");
		soft1.setPrecio(new BigDecimal("0.01"));
		soft1.setTamanio(new BigDecimal("78"));
		soft1.setCategoria((CategoriaSoftware) em
				.createQuery(
						"select c from CategoriaSoftware c where c.nombre = :cat")
				.setParameter("cat", "comunicacion").getSingleResult());
		soft1.setTitulo("Google Talk");

		em.persist(disco1);
		em.persist(peli1);
		em.persist(soft1);

	}

	private static void cargarCategorias() {
		// TODO Auto-generated method stub
		Genero genero1 = new Genero();
		genero1.setNombre("terror");
		genero1.setDescripcion("De Terror");
		em.persist(genero1);

		Genero genero2 = new Genero();
		genero2.setNombre("ficcion");
		genero2.setDescripcion("Ciencia Ficcion");
		em.persist(genero2);

		CategoriaDisco catd1 = new CategoriaDisco();
		catd1.setNombre("rock");
		catd1.setDescripcion("Rock Nacional");
		em.persist(catd1);

		CategoriaSoftware catsoft = new CategoriaSoftware();
		catsoft.setNombre("comunicacion");
		catsoft.setDescripcion("Comunicacion");
		em.persist(catsoft);

	}

}
