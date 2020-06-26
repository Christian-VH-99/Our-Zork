package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.*;

import Ubicacion.Ubicacion;
import items.Item;
import jugadores.Jugador;
import jugadores.Npc;

public class EntornoGson {
//	private List<Ubicacion> ubicaciones;
//	private List<Npc> npcs;
//	private List<Item> items;
//	private List<EndGame> endGames;
	
	public static void main(String[] args) {
//		serializar();
		deserializar(); 
	}

	private static void deserializar() {
		File archivoEntrada = new File("archivoJSONN.json");
		FileReader leerArchivo;
		try {
			leerArchivo = new FileReader(archivoEntrada);
			BufferedReader leerBuffer = new BufferedReader(leerArchivo);
			String json="";
			String linea;
			while((linea=leerBuffer.readLine())!=null) {
				json+=linea;
			}
			Juego juegito= new Gson().fromJson(json, Juego.class);
			System.out.println(juegito.toString());
			leerBuffer.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void serializar() {

		File archivoEntrada = new File("archivoJSON.json");
		Jugador michael =new Jugador("Michael");
		Juego entorno= new Juego(michael);
		entorno.generarEntorno();
		String lineaJSON=new Gson().toJson(entorno);
		try {
			FileWriter escribi=new FileWriter(archivoEntrada);
			escribi.write(lineaJSON);
			escribi.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public EntornoGson(String pathArchivo) {
		
	}
	
}

