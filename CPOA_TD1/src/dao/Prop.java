package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Prop {

	Properties accesBdd = new Properties();
	File fBdd = new File("config/bdd.properties");
	{
	try { 
	FileInputStream source = new FileInputStream(fBdd);
	accesBdd.loadFromXML(source); 
	} catch (IOException ioe) {
	ioe.printStackTrace();
	}
	System.out.println(accesBdd.getProperty("login"));
	}
}

