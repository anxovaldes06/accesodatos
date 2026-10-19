

public class Almacen {

 private int Capacidad;
 private int Cantidad;

 public Almacen(int capacidad) {
  if (capacidad < 1) {
   capacidad = 1;
  } 
    Capacidad = capacidad;
 }

 public boolean meter(int cantidad) {
  if (cantidad < 1) {
   return false;
  }
  if (Cantidad + cantidad > Capacidad) {
   return false;
  }
  Cantidad += cantidad;
  return true;
 }

 public boolean sacar(int cantidad) {
  if (cantidad < 1) {
   return false;
  }
  if (Cantidad - cantidad < 0) {
   return false;
  }
  Cantidad -= cantidad;
  return true;
 }

 public void rellenar() {
  Cantidad = Capacidad;
 }

 public int getCantidad() {
  return Cantidad;
 }

 public void setCantidad(int Cantidad){
  if ( Cantidad <= Capacidad) 
  this.Cantidad=Cantidad; 
else
  this.Cantidad =Capacidad; // si la cantidad asignada es mayor a la capacidad , este no permite poner más y devuelve la capacidad máximas
 }

}

