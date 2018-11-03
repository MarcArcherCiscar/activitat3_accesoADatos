package com.l.marc.a3a.utilitat;

public class utilitat_profesors {

    public static final String TABLA_PROFESOR="PROFESORES";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_EDAD="edad";
    public static final String CAMPO_CICLO="ciclo";
    public static final String CAMPO_CURSO="curso";
    public static final String CAMPO_DESPACHO="despacho";

    public final  static String crear_tabla_profesor="CREATE TABLE "+TABLA_PROFESOR+"( "+CAMPO_NOMBRE+" ID, "+CAMPO_EDAD+" INT, "+CAMPO_CICLO+" TEXT,  "+CAMPO_CURSO+" TEXT, "+CAMPO_DESPACHO+ "TEXT)";
}
