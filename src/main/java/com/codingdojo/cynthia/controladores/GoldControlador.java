package com.codingdojo.cynthia.controladores;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GoldControlador {
	
	@GetMapping("/Gold")
	public String gold() {
		return "index.jsp";
	}
	
	@PostMapping("/jugar")
	public String jugar(HttpSession session,
						@RequestParam("lugar") String lugar) {
		//lugar = "granja" o "cueva" o "casa" o "casino"
		
		int gold = 0; //Comenzamos con 0 puntos
		ArrayList<String> activities = new ArrayList<String>(); //lista vacía de actividades
		
		//Revisamos si en sesión existe algo llamado gold (puntuacion)
		if(session.getAttribute("gold") == null) {
			//Si no existe el atributo, lo creamos
			session.setAttribute("gold", gold); //si no hay nada lo inicio en 0
			session.setAttribute("activities", activities);
		} else {
			//SI existe algo en sesion, nuestras variables las igualamos a lo que hay en sesión
			gold = (int) session.getAttribute("gold"); 
			activities = (ArrayList<String>) session.getAttribute("activities");
		}
		
		int min = 0; 
		int max = 0;
		
		/*CODIGO DE CADA LUGAR - cambiar min y max*/
		switch(lugar) {
			case "granja":
				min = 10;
				max = 20;
				break;
			
			case "cueva":
				min = 5;
				max = 10;
				break;
			
			case "casa":
				min = 2;
				max = 5;
				break;
			
			case "casino":
				min = -50;
				max = 50;
				break;
		
		}
		
		//Generamos num aleatorio
		int random = new Random().nextInt(max - min + 1) + min;
		gold += random;
		//actualizamos en sesión la puntuación
		session.setAttribute("gold", gold); 
		
		//Formato de Fecha
		SimpleDateFormat formato = new SimpleDateFormat("MMMM d Y h:mm");
		Date d = new Date();
		String fecha_formateada = formato.format(d);
		
		String mensaje = "";
		if(random < 0) {
			mensaje = "Entraste a: "+lugar+" y perdiste "+random+"("+fecha_formateada+")";
		} else {
			mensaje = "Entraste a: "+lugar+" y ganaste "+random+"("+fecha_formateada+")";
		}
		
		activities.add(mensaje);
		session.setAttribute("activities", activities);
		
		return "redirect:/Gold";
		
	}
	
}
