package com.codingdojo.cynthia.controladores;

import java.util.ArrayList;
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
		
		//Generamos num aleatorio
		int random = new Random().nextInt(max - min + 1) + min;
		
		/*Agregar a gold el random, guardar en sesión el nuevo gold y agregar la actividad*/
		
	}
	
}
