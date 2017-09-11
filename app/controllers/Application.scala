package controllers

import javax.inject.{Singleton, Inject}

import java.lang.Object

import play.api.mvc.{AbstractController, ControllerComponents, Action}

//esses dois imports são para conseguir capturar o post da redacao

// este import só é necessário quando temos Action.async
import scala.concurrent.{Future, ExecutionContext}

import models.Pessoa

/**
 * Este controlador processa as requisições vindas do browser.
 */
@Singleton
class Application @Inject() (cc: ControllerComponents) (implicit ec: ExecutionContext)  extends AbstractController(cc) {

  /**
   * O método index define um algoritmo que, quando executado, retorna
   * uma página HTML conforme definida no arquivo views/index.scala.html.
   * Conforme definido no arquivo conf/routes, o método é executado quando
   * o servidor receber uma requisição HTTP do tipo GET para a URL "/".
   */
  def index = Action {
    val pessoa = Pessoa("Fulano de Tal Síncrono")

    Ok(views.html.index("INE5646 - Aplicação Exemplo", pessoa))
  }

  /**
   * O método indexAssincrono tem o mesmo objetivo do método index. A diferença
   * é que ele deve ser usado quando o seu algoritmo demora muito tempo para
   * gerar a resposta. A thread que executa este algoritmo não deve ficar
   * bloqueada aguardando a resposta.
  */
  def indexAssincrono = Action.async {
    // supondo que demora muito tempo para instanciar uma Pessoa
    val futureDePessoa = Future {
      Pessoa("Fulano de Tal Assíncrono")
    }

    futureDePessoa.map(pessoa => Ok(views.html.index("INE5646 - Aplicação Exemplo", pessoa)))
  }

  // recebe a redação enviada 
  def redacaoSubmit = Action {
  		DynamicForm dynamicForm = formFactory.form().bindFromRequest();
  		Logger.info("Autor is: " + dynamicForm.get("autor"));
    	Logger.info("Redacao is: " + dynamicForm.get("texto-redacao"));
   		Ok("ok, I recived POST data. That's all...");

    
  }
}
