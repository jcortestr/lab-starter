package reto5app.model.vo;


public class Requerimiento_3 {
    //Atributo
    private String abrev;
    
    public Requerimiento_3(){
        
    }
    
    public Requerimiento_3(String abrev){
        this.setAbrev(abrev);
    }
    
    public String getAbrev(){
        return this.abrev;
    }
    
    public void setAbrev(String abrev){
        this.abrev = abrev;
    }
}