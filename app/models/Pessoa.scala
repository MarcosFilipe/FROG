package models

/**
 * Define a classe Pessoa contendo o atributo nome.
 */
case class Pessoa (nome: String) {
  
  /**
   * Método que retorna a quantidade de letras do atributo nome.
   */
  def tamNome = nome.length()
}