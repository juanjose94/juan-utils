package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class UtilsFecha {

	private UtilsFecha() {
		throw new IllegalArgumentException("UtilFecha class");
	}
	
	private static final int SEGUNDOS = 60;

	public static Date formatearFecha(String fecha, String formato) throws Exception {
		System.out.println("Fecha antes de cambia:: " + fecha);
		System.out.println("Formato:: " + formato);
		SimpleDateFormat format = new SimpleDateFormat(formato);
		java.util.Date parsed = null;
		try {
			parsed = format.parse(fecha);
			return new Date(parsed.getTime());
		} catch (ParseException e) {
			throw new Exception(e.getMessage(), e);
		}
	}

	public static Integer horaEnSegundos() {
		Integer hora = Calendar.getInstance().get(Calendar.HOUR_OF_DAY) * SEGUNDOS * SEGUNDOS;
		Integer minutos = Calendar.getInstance().get(Calendar.MINUTE) * SEGUNDOS;
		Integer segundos = Calendar.getInstance().get(Calendar.SECOND);
		return hora + minutos + segundos;
	}

	public static Date fechaHoy() {
		java.util.Date hoy = new java.util.Date();
		return new Date(hoy.getTime());
	}

	public static String obtenerHora() {
		LocalDateTime horaLocal = LocalDateTime.now();
		String horas = agregarCero(horaLocal.getHour());
		String minutos = agregarCero(horaLocal.getMinute());
		String segundos = agregarCero(horaLocal.getSecond());
		return horas + ":" + minutos + ":" + segundos;
	}

	private static String agregarCero(Integer numero) {
		if (numero < 10) {
			return String.format("%02d", numero);
		}
		return numero.toString();
	}

}
