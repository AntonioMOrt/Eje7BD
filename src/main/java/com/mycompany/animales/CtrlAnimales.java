/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author antonio
 */
package com.mycompany.animales;

import web.Mensajes;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


@Named
@RequestScoped
public class CtrlAnimales {
  @Inject
  private Mensajes mensajes;
  @Inject
  private DaoAnimal dao;
  private List<Animal> instancias;
  /* @PostConstruct indica que el método se ejecuta después de crear el objeto y
   * realizar todos los inject. Funciona casi como un constructor. */
  @PostConstruct
  void init() {
    try {
      instancias = dao.consulta();
    } catch (Exception ex) {
      mensajes.procesa(ex);
    }
  }
  public List<Animal> getInstancias() {
    return instancias;
  }
}
