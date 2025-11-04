package ejercicios.gestion_parking.clases;

import ejercicios.gestion_parking.exceptions.ParkingException;

import java.util.ArrayList;

public class Parking {
    ArrayList<Vehiculos> listaVehiculos;

    public Parking() {
        listaVehiculos = new ArrayList<>();
    }

    public ArrayList<Vehiculos> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(ArrayList<Vehiculos> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public void registrarVehiculo(Vehiculos vehiculo){
        listaVehiculos.add(vehiculo);
    }

    public void listarVehiculo(){
        if (listaVehiculos.isEmpty()){
            System.out.println("No hay Vehiculos que mostrar.");
        } else {
//            for( int i = 0 ; i < listaVehiculos.size(); i++){
//                System.out.println(listaVehiculos.get(i));
//            }

            for(Vehiculos item : listaVehiculos){
                System.out.println(item);
            }
        }
    }

    public Vehiculos buscarPorId (int id){

        for(Vehiculos item : listaVehiculos){
            if(item.getId() == id){
                return item;
            }
        }

        return null;
    }

    public boolean eliminarPorId (int id) throws ParkingException {

        Vehiculos vehiculo = buscarPorId(id);
        if(vehiculo != null){
            listaVehiculos.remove(vehiculo);
        } else {
            throw new ParkingException("No existe ese vehiculo!");
        }

        return true;
    }
}
