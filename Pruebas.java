import Creacionales.Builder.*;
import Creacionales.Fabrica.*;
import Creacionales.Prototipo.*;
import Creacionales.Singleton.*;
import DeComportamiento.Cadena.*;
import DeComportamiento.Observador.*;
import EntradasSalidas.EntradaConsola;
import EntradasSalidas.SalidaConsola;
import Estructura.*;
import Estructurales.Bridge.*;
import Estructurales.Composite.*;
import Estructurales.Decorator.*;
import Estructurales.Facade.*;
import Estructurales.Flyweight.*;
import Estructurales.Proxy.*;

public class Pruebas {
	
	private static final SalidaConsola salida = new SalidaConsola();
	private static final EntradaConsola entrada = new EntradaConsola();
	
	public static void main(String[] args) {
		salida.enviar("1) Creacionales"+"\n"+"2) Estructurales"+"\n"+"3) DeComportamiento");
		int dec = Integer.parseInt(entrada.capturar());
		switch(dec) {
		case 1:
			salida.enviar("Fabrica: \n");
			PruebaFabrica();
			salida.enviar("Builder: \n");
			PruebaBuilder();
			salida.enviar("Prototipo: \n");
			PruebaPrototipo();
			salida.enviar("Singleton: \n");
			PruebaSingleton();
			break;
		case 2:
			salida.enviar("Bridge: \n");
			PruebaBridge();
			salida.enviar("Composite: \n");
			PruebaComposite();
			salida.enviar("Decorator: \n");
			PruebaDecorator();
			salida.enviar("Facade: \n");
			PruebaFacade();
			salida.enviar("FlyWeight: \n");
			PruebaFlyweight();
			salida.enviar("Proxy: \n");
			PruebaProxy();
			break;
		case 3:
			salida.enviar("Cadena: ");
			PruebaChain();
			salida.enviar("Observer: ");
			PruebaObserver();
		}
	}
	
	public static void PruebaFabrica() {
		FabricaAbstracta fabrica = new FabricaCiudad();
		
		Alojamiento apto = fabrica.crearAlojamiento(20);
		Experiencia cultura = fabrica.crearExperiencia("Museo");
		Servicio foto = fabrica.crearServicio("Sesion");
		
		salida.enviar("Alojamiento: "+apto+"\n"+"Experiencia: "+cultura+"\n"+"Servicio: "+foto);
		
		fabrica = new FabricaPlaya();
		
		Alojamiento cabina = fabrica.crearAlojamiento(20);
		Experiencia entrenamiento = fabrica.crearExperiencia("Yoga");
		Servicio masaje = fabrica.crearServicio("Spa");
		
		salida.enviar("Alojamiento: "+cabina+"\n"+"Experiencia: "+entrenamiento+"\n"+"Servicio: "+masaje+"\n");
	}
	
	public static void PruebaBuilder() {
		Builder builder = new BuilderReservas();
		
		builder.setAlojo(new Apartamento(12));
		builder.setExperiencia(new Cultural("Cultural"));
		
		if(!builder.verificar()) {
			salida.enviar("Hay un campo nulo");
		}
		
		builder.setLugar(new Pais("Colombia"));
		builder.setServicio(new Masaje("Masaje"));
		
		Reserva reserva = builder.getReserva();
		salida.enviar(reserva+"\n");
	}
	
	public static void PruebaPrototipo() {
		Anuncio ad = new Anuncio(new Cabin(20));
		
		Clonable adClon = ad.clonar();
		
		salida.enviar(ad);
		salida.enviar(adClon+"\n");
	}
	
	public static void PruebaSingleton() {
		ListaAlojamientos lista = ListaAlojamientos.getInstancia();
		lista.addAlojamiento(new Apartamento(12));
		
		salida.enviar(lista);
		
		ListaAlojamientos listaOtra = ListaAlojamientos.getInstancia();
		
		salida.enviar(listaOtra);
		listaOtra.addAlojamiento(new Cabin(20));
		
		salida.enviar(lista+"\n");
	}
	
	public static void PruebaBridge() {
		Notificacion alerta = new Alerta("Alerta");
		Notificacion promo = new Promo("Promo");
		Notificacion record = new Recordatorio("Recordatorio");
		
		Medio sms = new SMS(alerta);
		Medio email = new Correo(alerta);
		
		salida.enviar(sms.toString());
		salida.enviar(email.toString());
		
		sms.setNoti(promo);
		email.setNoti(promo);
		
		salida.enviar(sms.toString());
		salida.enviar(email.toString());
		
		sms.setNoti(record);
		email.setNoti(record);
		
		salida.enviar(sms.toString());
		salida.enviar(email.toString()+"\n");
	}
	
	public static void PruebaComposite() {
		Lugar pais = new Pais("Colombia");
		Lugar[] ciudades = {new Ciudad("Bogota"), new Ciudad("Medellin"), new Ciudad("Barranquilla")};
		
        for (Lugar ciudad : ciudades) {
            pais.add(ciudad);
        }
		
		salida.enviar(pais.getNombre()+"\n");
	}
	
	public static void PruebaDecorator() {
		Reserva reserva = new ReservaBase(new Apartamento(20), new Masaje("Servicio"), new Cultural("Experiencia"), new Pais("Brasil"));
		reserva = new DecoradorMascotas(new DecoradorLimpieza(new DecoradorTardio(reserva)));
		
		salida.enviar(reserva+"\n");
	}
	
	public static void PruebaFacade() {
		FachadaReserva fachada = new FachadaReserva();
		
		if(fachada.reservar(new ReservaBase(new Apartamento(20), new Masaje("Servicio"), new Cultural("Experiencia"), new Pais("Brasil")))) {
			salida.enviar("Reserva con éxito \n");
		}
		else {
			salida.enviar("Reserva fallida \n");
		}
	}
	
	public static void PruebaFlyweight() {
		FabricaAbstracta ciudad = new FabricaCiudad();
		FabricaAbstracta playa = new FabricaPlaya();
		
		FabricaExperiencias experiencias = new FabricaExperiencias(ciudad);
		FabricaServicios servicios = new FabricaServicios(ciudad);
		
		salida.enviar(experiencias.getExperiencia("Cultural"));
		salida.enviar(servicios.getServicio("Foto"));
		
		experiencias.setFabrica(playa);
		servicios.setFabrica(playa);
		
		salida.enviar(experiencias.getExperiencia("Entrenamiento"));
		salida.enviar(servicios.getServicio("Masaje"+"\n"));
		salida.enviar(experiencias.getExperiencia("Cultural").equals(experiencias.getExperiencia("Cultural")));
	}
	
	public static void PruebaProxy() {
		Registro registro = new RegistroUsuario();
		Registro proxyRegistro = new ProxyRegistroUsuario(registro);
		
		proxyRegistro.addUsuario(new Huesped("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
		proxyRegistro.addUsuario(new Huesped("Pedro"));
		proxyRegistro.addUsuario(new Huesped("Pepe"));
		
		salida.enviar(proxyRegistro.getUsuarios());
		salida.enviar(registro.getUsuarios()+"\n");
		
	}
	
	public static void PruebaChain() {
		Reserva r = new ReservaBase(new Apartamento(20), new Masaje("Servicio"), new Cultural("Experiencia"), new Pais("Brasil"));
		
		Handler vCliente = new VerificarCliente();
		Handler vDisponibilidad = new VerificarDisponibilidad();
		Handler vPago = new VerificarPago();
		Handler aceptar = new Aceptar();
		
		vCliente.setNext(vDisponibilidad);
		vDisponibilidad.setNext(vPago);
		vPago.setNext(aceptar);
		
		salida.enviar(vCliente.handle(r));
		
		r.getAlojamiento().cambiarDisponibilidad();
		
		salida.enviar(vCliente.handle(r)+"\n");
	}
	
	public static void PruebaObserver() {
		Alojamiento publicitado1 = new Apartamento(15);
		publicitado1.setNombre("Apto Bogota");
		Alojamiento publicitado2 = new Apartamento(20);
		publicitado2.setNombre("Apto Cartagena");
		
		Huesped suscrito1 = new Huesped("Pedro");
		Huesped suscrito2 = new Huesped("Pepe");
		
		Anuncio anuncio1= new Anuncio(publicitado1);
		Anuncio anuncio2 = new Anuncio(publicitado2);
		
		suscrito1.addFavorito(anuncio2);
		suscrito2.addFavorito(anuncio1);
		
		anuncio1.notificar();
		anuncio2.notificar();
	}

}
