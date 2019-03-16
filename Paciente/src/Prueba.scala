import scala.io.StdIn._
import scala.collection.mutable.ListBuffer

class Paciente(var nombre : String = "Gonzalo",
    var primerAp : String = "De la Rosa",
    var segundoAp : String = "De la Cruz",
    var edad : Byte = 25,
    var fecha : ListBuffer[String] = ListBuffer("13-03-2019", "13-03-2019", "13-03-2019"),
    var hora : ListBuffer [String] = ListBuffer("8:00", "14:00", "20:00"),
    var nBienestar : ListBuffer [Int] = ListBuffer(1, 3, 5),
    var temperatura : ListBuffer [Double] = ListBuffer(55.5, 20, 48.4),
    var humedad : ListBuffer [Double] = ListBuffer(20, 18, 27)){
  
  var suma = 0 
  
  def promedioNivelBienestar() : Double ={
    for(i <- nBienestar){
      suma += i 
    }
    var prom = suma / nBienestar.length
    return prom
  }
  
  def temperaturaMayor() : List [String] ={
    var c = 0
    var tMayor = temperatura(0)
    temperatura.foreach(i => if(i > tMayor){
      tMayor = i
      c +=1
    })
    var mayores = List("Temperatura: " + tMayor, "Nivel de bienestar: " + nBienestar(c), "Humedad: " + humedad(c),"Fecha: " + fecha(c), "Hora: " + hora(c))  
    return mayores
    
  }
    
  
  def temperaturaMenor() : List [String] ={
    var c = 0
    var tMenor = temperatura(0)
    temperatura.foreach(i => if(i < tMenor){
      tMenor = i
      c +=1
    })
    var menores = List("Temperatura: " + tMenor, "Nivel de bienestar: " + nBienestar(c), "Humedad: " + humedad(c),"Fecha: " + fecha(c), "Hora: " + hora(c))  
    return menores
    
  }
}

object Prueba {
  def main(args: Array[String]): Unit = {
    var p1 = new Paciente
    println("Promedio de bienestar: " + p1.promedioNivelBienestar())
    println("Temperatura mayor: " + p1.temperaturaMayor())
    println("Temperatura menor: " + p1.temperaturaMenor())
  }
  
  
}