import Creacionales.Builder.*;
import Creacionales.Fabrica.*;
import Creacionales.Prototipo.*;
import Creacionales.Singleton.*;
import DeComportamiento.Cadena.*;
import DeComportamiento.Memento.AlojamientoCaretaker;
import DeComportamiento.Memento.AlojamientoMemento;
import DeComportamiento.Observador.*;
import DeComportamiento.Strategy.*;
import DeComportamiento.Visitante.*;
import DeComportamiento.Iterador.*;
import DeComportamiento.Mediador.*;
import DeComportamiento.Estado.*;
import EntradasSalidas.EntradaConsola;
import EntradasSalidas.SalidaConsola;
import Estructura.*;
import Estructurales.Bridge.*;
import Estructurales.Composite.*;
import Estructurales.Decorator.*;
import Estructurales.Facade.*;
import Estructurales.Flyweight.*;
import Estructurales.Proxy.*;

import java.util.Random;

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
			salida.enviar("Cadena: \n");
			PruebaChain();
			salida.enviar("Observer: \n");
			PruebaObserver();
			salida.enviar("Estrategia: \n");
			PruebaStrategy();
			salida.enviar("Memento: \n");
			PruebaMemento();
			salida.enviar("Iterador: \n");
			PruebaIterador();
			salida.enviar("Visitante:  \n");
			PruebaVisitante();
			salida.enviar("Mediador: \n");
			PruebaMediador();
			salida.enviar("Estado: \n");
			PruebaEstado();
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
		salida.enviar("\n");
	}
	
	public static void PruebaStrategy() {
		Alojamiento apto = new Apartamento(20);
		Alojamiento cabina = new Cabin(12);
		Alojamiento apto2 = new Apartamento(18);
		
		
		for(int i=0; i<=100; i++) {
			apto.agregarReview(new Review("",new Random().nextInt(1, 6)));
			cabina.agregarReview(new Review("",new Random().nextInt(1, 6)));
			apto2.agregarReview(new Review("",new Random().nextInt(1, 6)));
		}
		
		
		Estrategia porPrecio = new PorPrecio();
		Estrategia porReview = new PorReview();
		
		ListaAlojamientos lista = ListaAlojamientos.getInstancia();
		lista.addAlojamiento(apto);
		lista.addAlojamiento(cabina);
		lista.addAlojamiento(apto2);
		
		salida.enviar("Original: \n"+lista);
		
		lista.setSorter(porReview);
		lista.ordenar();
		
		salida.enviar("Por Reseñas: \n"+lista);
		
		lista.setSorter(porPrecio);
		lista.ordenar();
		
		salida.enviar("Por Precio: \n"+lista);
	}
	
	public static void PruebaMemento() {
		System.out.println("=== PRUEBA DEL PATRÓN MEMENTO (Airbnb - Edición de Alojamiento) ===");

        // 1. Crear el alojamiento (un Apartamento)
        Alojamiento apto = new Apartamento(120.0);
        apto.setNombre("Penthouse Vista al Mar");
        apto.setDisponible(true);

        // Mostrar estado inicial
        System.out.println("\n--- Estado Inicial del Alojamiento ---");
        imprimirEstado(apto);

        // 2. Instanciar el Caretaker
        AlojamientoCaretaker caretaker = new AlojamientoCaretaker();

        // 3. El anfitrión decide editar el alojamiento
        System.out.println("\n[Anfitrión]: Editando el alojamiento...");
        
        // Guardamos el estado actual (Memento 1 - Estado Inicial) antes de realizar el cambio
        caretaker.guardar(apto.save());

        // Realizamos el primer cambio (Cambio de Precio e Inclusión de Nombre nuevo)
        apto.setPrecio(150.0);
        apto.setNombre("Penthouse Vista al Mar (Modificado)");
        System.out.println("\n--- Después de la Edición 1 ---");
        imprimirEstado(apto);

        // Guardamos este nuevo estado (Memento 2 - Edición 1) antes de otro cambio
        caretaker.guardar(apto.save());

        // Realizamos un segundo cambio (Desactivar disponibilidad y subir precio)
        apto.setPrecio(200.0);
        apto.setDisponible(false);
        System.out.println("\n--- Después de la Edición 2 ---");
        imprimirEstado(apto);

        // 4. El anfitrión comete un error o decide arrepentirse (Deshacer / Undo)
        System.out.println("\n[Anfitrión]: Presiona 'Deshacer' (Undo)...");
        if (caretaker.puedeDeshacer()) {
            // Guardamos el estado actual para poder rehacerlo si fuera necesario, y restauramos el anterior
            AlojamientoMemento mementoAnterior = caretaker.deshacer(apto.save());
            apto.restore(mementoAnterior);
        }
        System.out.println("--- Después del 1er Deshacer (vuelve a Edición 1) ---");
        imprimirEstado(apto);

        // Deshacer otra vez (volver al estado inicial)
        System.out.println("\n[Anfitrión]: Presiona 'Deshacer' (Undo) de nuevo...");
        if (caretaker.puedeDeshacer()) {
            AlojamientoMemento mementoInicial = caretaker.deshacer(apto.save());
            apto.restore(mementoInicial);
        }
        System.out.println("--- Después del 2do Deshacer (vuelve a Estado Inicial) ---");
        imprimirEstado(apto);

        // 5. El anfitrión cambia de opinión y quiere recuperar el cambio anterior (Rehacer / Redo)
        System.out.println("\n[Anfitrión]: Presiona 'Rehacer' (Redo)...");
        if (caretaker.puedeRehacer()) {
            AlojamientoMemento mementoSiguiente = caretaker.rehacer(apto.save());
            apto.restore(mementoSiguiente);
        }
        System.out.println("--- Después de Rehacer (vuelve a Edición 1) ---");
        imprimirEstado(apto);
    }

    private static void imprimirEstado(Alojamiento a) {
        System.out.println("Nombre      : " + a.getNombre());
        // getPrecio() multiplica el precio por 1.2 en Apartamento (ver clase Apartamento)
        System.out.println("Precio Base : " + a.getPrecio()); 
        System.out.println("Disponible  : " + (a.disponible ? "Sí" : "No"));
    
	}
    
    public static void PruebaIterador() {
    	Alojamiento apto = new Apartamento(10);
		Alojamiento cabina = new Cabin(15);
		Alojamiento apto2 = new Apartamento(20);
    	ListaAlojamientos lista = ListaAlojamientos.getInstancia();
    	lista.addAlojamiento(apto);
    	lista.addAlojamiento(cabina);
    	lista.addAlojamiento(apto2);
    	
    	lista.setSorter(new PorPrecio());
    	lista.ordenar();
    	
    	IteradorAlojamientos iterador = lista.getDescendente();
    	
    	while(true) {
    		if(iterador.hasNext()) {
    			salida.enviar(iterador.getNext());
    		}
    		else {
    			iterador.reset();
    			break;
    		}
    	}
    }
    
    public static void PruebaVisitante() {
    	Alojamiento apto = new Apartamento(10);
		Alojamiento cabina = new Cabin(15);
		Alojamiento apto2 = new Apartamento(20);
		
		apto.setNombre("Apto1");
		cabina.setNombre("Cabina");
		apto2.setNombre("Apto2");
		
    	Alojamiento[] alojos = {apto, cabina, apto2};
    	
    	Visitante v = new VisitanteImpuestos();
    	
    	for(Alojamiento a: alojos) {
    		salida.enviar(a.aceptar(v));
    	}
    }
    
    public static void PruebaMediador() {
    	User huesped = new UserHuesped("Pepe");
    	User anfitrion = new UserAnfitrion();
    	Mediador mediador = new MediadorChat(anfitrion, huesped); //Una forma de asignar un mediador
    	
    	salida.enviar("Ingrese el mensaje a enviar: ");
    	huesped.enviar("Anfitrion"); //En vez de llamar al mediador directamente, se puede hacer esto
    	mediador.enviarMensaje(huesped.getNombre(), "Salir a fiesta mañana");
    	salida.enviar("\n");
    }
    
    public static void PruebaEstado() {
    	Pago pago = new Pago();
    	
    	salida.enviar(pago.ingresarMetodo());
    	salida.enviar(pago.cancelar());
    	salida.enviar(pago.pagar());
    	
    	salida.enviar(pago.pagar());
    	if(new Random().nextInt(0, 2)==1) {
    		salida.enviar(pago.cancelar());
    		return;
    	}
    	salida.enviar(pago.ingresarMetodo());
    	
    	salida.enviar(pago.cancelar());
    	salida.enviar(pago.ingresarMetodo());
    	salida.enviar(pago.pagar());
    	
    	salida.enviar(pago.cancelar());
    }

}
