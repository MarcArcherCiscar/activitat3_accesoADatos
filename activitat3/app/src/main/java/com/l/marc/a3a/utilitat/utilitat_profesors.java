package com.l.marc.a3a.utilitat;

public class utilitat_profesors {

    public static final String TABLA_PROFESOR = "PROFESORES";
    public static final String CAMPO_NOMBRE_PROFESOR = "nombre";
    public static final String CAMPO_EDAD_PROFESOR = "edad";
    public static final String CAMPO_CICLO_PROFESOR = "ciclo";
    public static final String CAMPO_CURSO_PROFESOR = "curso";
    public static final String CAMPO_DESPACHO_PROFESOR = "despacho";

    public final  static String crear_tabla_profesor="CREATE TABLE "+TABLA_PROFESOR+"( "+CAMPO_NOMBRE_PROFESOR+" ID, "+CAMPO_EDAD_PROFESOR+" INT, "+CAMPO_CICLO_PROFESOR+" TEXT,  "+CAMPO_CURSO_PROFESOR+" TEXT,"+CAMPO_DESPACHO_PROFESOR+" TEXT )";
}
