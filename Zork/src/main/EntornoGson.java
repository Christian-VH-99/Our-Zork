package main;

import java.io.BufferedReader;
import java.io.*;
import java.util.ArrayList;

import com.google.gson.*;

import Ubicacion.Ubicacion;

public class EntornoGson {

	private Ubicacion ubicacion;
	private String bienvenida;
	private ArrayList<FinDeJuego> finales = new ArrayList<FinDeJuego>(4);
	private ArrayList<String> itemsList;
	private ArrayList<String> ubicacionesList;
	private ArrayList<String> npcsList;
	private ArrayList<String> placesList;

	public static void main(String[] args) {
		serializar();
	}

	public void deserializar(String path) {
		File archivoEntrada = new File(path);
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

	private static void serializar() {
		File archivoEntrada = new File("piramide.json");
		Entorno entorno = new Entorno();
		entorno.generarEntornoDentroPiramide();
		String lineaJSON = new Gson().toJson(entorno);
		try {
			FileWriter escribi = new FileWriter(archivoEntrada);
			escribi.write(lineaJSON);
			escribi.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public String getBienvenida() {
		return bienvenida;
	}

	public ArrayList<FinDeJuego> getFinales() {
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
