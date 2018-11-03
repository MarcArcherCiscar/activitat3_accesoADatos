package com.l.marc.a3a.utilitat;

public class utilitat_alumnes {
    //Constants
    public static final String TABLA_ALUMNO="ALUMNOS";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_EDAD="edad";
    public static final String CAMPO_CICLO="ciclo";
    public static final String CAMPO_CURSO="curso";

    public final  static String crear_tabla_alumno="CREATE TABLE "+TABLA_ALUMNO+"( "+CAMPO_NOMBRE+" ID, "+CAMPO_EDAD+" INT, "+CAMPO_CICLO+" TEXT,  "+CAMPO_CURSO+" TEXT)";
}
