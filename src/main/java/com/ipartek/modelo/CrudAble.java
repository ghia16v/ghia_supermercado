package com.ipartek.modelo;

import java.util.ArrayList;

/**
 *  Esta interfaz tiene la habilidad de hacer todas las operaciones de CRUD
 * @author Xabier
 *
 */

public interface CrudAble <P>{ //interfaz de tipo P (clase genérica) {
ArrayList <P> getAll();  //sustituiremos esta clase genérica por una nuestra específica más adelante

P getById(int id) throws Exception;

P delete(int id) throws Exception;

P insert(P pojo) throws Exception;

P update(P pojo) throws Exception;

}
