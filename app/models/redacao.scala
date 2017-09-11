package models

/**
 * Define a classe redacao contendo os seus atributos
 */
case class Redacao () {
  var titulo 	: String = titulo
  var autor 	: String = autor
  var texto 	: String = texto

   def setTitulo (titulo: String) {
     this.titulo = titulo
   }

   def getTitulo () : String = {
     titulo
   }

   def setAutor (autor: String) {
     this.autor = autor
   }

   def getAutor () : String = {
     autor
   }

   def setTexto (texto: String) {
     this.texto = texto
   }

   def getTexto () : String = {
     texto
   }

}