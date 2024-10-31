package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.awt.geom.Arc2D;
import java.util.ArrayList;
import java.util.List;

public class Consultoria {

    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public Consultoria(){
        this.desenvolvedores = new ArrayList<>();
    }

    public Consultoria(String nome, Integer vagas) {
        this.nome = nome;
        this.vagas = vagas;
        this.desenvolvedores = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public Boolean contratar(Desenvolvedor desenvolvedor){

            if (desenvolvedores.size() < vagas){
                desenvolvedores.add(desenvolvedor);
                return true;
            }
        return false;
    }

    public Boolean contratarFullstack(DesenvolvedorWeb desenvolvedor){

        for (int i = 0; i <= desenvolvedores.size(); i++) {
            if (desenvolvedor.isFullstack()){
                desenvolvedores.add(desenvolvedor);
                return true;
            }
        }
        return false;
    }

    public Double getTotalSalarios(){
        Double soma = 0.0;

        for (Desenvolvedor dev : desenvolvedores) {
            soma += dev.calcularSalario();
        }
        
        return soma;
    }

    public Integer qtdDesenvolvedoresMobile(){
        Integer soma = 0;

        for (Desenvolvedor dev : desenvolvedores) {
            if (dev instanceof DesenvolvedorMobile){
                soma ++;
            }
        }

        return soma;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        List<Desenvolvedor> devs = new ArrayList<>();

        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            Double primeiroSalario = desenvolvedor.calcularSalario();
            if (primeiroSalario >= salario){
                devs.add(desenvolvedor);
            }
        }
        return devs;
    }

    public Desenvolvedor buscarMenorSalario(){

        if (desenvolvedores.isEmpty()){
            return null;
        }
        Desenvolvedor dev = new Desenvolvedor();
        Double menorSalario = Double.MAX_VALUE;

        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if (menorSalario > desenvolvedor.calcularSalario()){
                menorSalario = desenvolvedor.calcularSalario();
                dev = desenvolvedor;
            }
        }
        return dev;
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia){
        List<Desenvolvedor> devs = new ArrayList<>();

        if (desenvolvedores.isEmpty()){
            return null;
        }

        for (Desenvolvedor desenvolvedor : desenvolvedores) {
           if (desenvolvedor instanceof DesenvolvedorMobile){
               if (((DesenvolvedorMobile) desenvolvedor).getLinguagem().equals(tecnologia) ||
                    ((DesenvolvedorMobile) desenvolvedor).getPlataforma().equals(tecnologia)){
                   devs.add(desenvolvedor);
               }
           }
           if (desenvolvedor instanceof DesenvolvedorWeb){
               if (((DesenvolvedorWeb) desenvolvedor).getFrontend().equals(tecnologia) ||
                   ((DesenvolvedorWeb) desenvolvedor).getBackend().equals(tecnologia) ||
                   ((DesenvolvedorWeb) desenvolvedor).getSgbd().equals(tecnologia)){
                   devs.add(desenvolvedor);
               }
           }
        }

        return devs;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia){
        Double soma = 0.0;

        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if (desenvolvedor instanceof DesenvolvedorMobile){
                if (((DesenvolvedorMobile) desenvolvedor).getLinguagem().equals(tecnologia) ||
                        ((DesenvolvedorMobile) desenvolvedor).getPlataforma().equals(tecnologia)){
                     soma+= desenvolvedor.calcularSalario();
                }
            }
            if (desenvolvedor instanceof DesenvolvedorWeb){
                if (((DesenvolvedorWeb) desenvolvedor).getFrontend().equals(tecnologia) ||
                        ((DesenvolvedorWeb) desenvolvedor).getBackend().equals(tecnologia) ||
                        ((DesenvolvedorWeb) desenvolvedor).getSgbd().equals(tecnologia)){
                        soma+= desenvolvedor.calcularSalario();
                }
            }
        }

        return soma;
    }
}
