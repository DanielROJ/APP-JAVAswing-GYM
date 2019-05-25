/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * @since 10-05-2017
 * @author Daniel Rojas - danielroj
 */
public class HistoriaMedica implements Serializable {
 
    private Medico medico;
    private ArrayList<Diagnostico> diagsnostico=new ArrayList<Diagnostico>();

    public HistoriaMedica() {
    }

    
    public HistoriaMedica( Medico medico) {
        this.medico = medico;
    }
    
    private void AgregaD(Diagnostico d){
        diagsnostico.add(d);
    }
    
    public void AgregaDiagnostico(Diagnostico diagnostico){
     this.diagsnostico.add(diagnostico);
        
    }

  
    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public ArrayList<Diagnostico> getDiagsnostico() {
        return diagsnostico;
    } 
    
    public void BorrarDiagnostico(Diagnostico s){
        diagsnostico.remove(s);
        
    }
    
    public Diagnostico BuscarP(){
        System.out.println( diagsnostico.size());
       if( diagsnostico.size()==0){
           return null;
       }else{
        return diagsnostico.get(0);
                } 
    }
}
