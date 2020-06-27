package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.*;

import Ubicacion.Ubicacion;
import acciones.Peticion;

public class EntornoGson {

	private Ubicacion ubicacion;
	private String bienvenida;
	private ArrayList<Peticion> finales = new ArrayList<Peticion>(4);
	private ArrayList<String> itemsList;
	private ArrayList<String> ubicacionesList;
	private ArrayList<String> npcsList;
	private ArrayList<String> placesList;

//	public static void main(String[] args) {
//		serializar();
//	}

	public void deserializar() {
		File archivoEntrada = new File("piramide.json");
		FileReader leerArchivo;
		try {
			leerArchivo = new FileReader(archivoEntrada);
			BufferedReader leerBuffer = new BufferedReader(leerArchivo);
			String json = "";
			String linea;
			while ((linea = leerBuffer.readLine()) != null) {
				json += linea;
			}
			Entorno datos = new Gson().fromJson(json, Entorno.class);
			ubicacion = datos.getUbicacion();
			bienvenida = datos.getBienvenida();
			finales = datos.getFinales();
			itemsList = datos.getItemsList();
			ubicacionesList = datos.getUbicacionesList();
			placesList = datos.getPlacesList();
			npcsList = datos.getNpcsList();
			leerBuffer.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	private static void serializar() {
//		File archivoEntrada = new File("piramide.json");
//		Entorno entorno= new Entorno();
//		entorno.generarEntornoDentroPiramide();
//		String lineaJSON = new Gson().toJson(entorno);
//		try {
//			FileWriter escribi = new FileWriter(archivoEntrada);
//			escribi.write(lineaJSON);
//			escribi.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public String getBienvenida() {
		return bienvenida;
	}

	public ArrayList<Peticion> getFinales() {
		return finales;
	}

	public ArrayList<String> getItemsList() {
		return itemsList;
	}

	public ArrayList<String> getUbicacionesList() {
		return ubicacionesList;
	}

	public ArrayList<String> getNpcsList() {
		return npcsList;
	}

	public ArrayList<String> getPlacesList() {
		return placesList;
	}

}
